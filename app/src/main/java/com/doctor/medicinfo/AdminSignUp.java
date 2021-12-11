package com.doctor.medicinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

//import static androidx.constraintlayout.motion.widget.MotionScene.TAG;

public class AdminSignUp extends AppCompatActivity {

    Button adminSignUpButton;
    EditText MSignUpusername, MSignUpPass, MSignUpEmail;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView loginAdmin;
    CheckBox showpass;
    DatabaseReference mBase;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    ProgressBar progress_Bar;
    String username, email, password, productRandomKey, saveCurrentDate,saveCurrentTime, USERID;
    String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        MSignUpPass = findViewById(R.id.adminsignup_password_input);
        MSignUpEmail = findViewById(R.id.adminsignup_email_input);
        MSignUpusername = findViewById(R.id.adminsignup_username_input);
        loginAdmin = findViewById(R.id.Adminloginsystem);
        mBase = FirebaseDatabase.getInstance().getReference().child("Doctor");


        //final FirebaseAuth fAuth = FirebaseAuth.getInstance();
        //progressBar = findViewById(R.id.progressBar);

        adminSignUpButton = findViewById(R.id.admin_signup);

        adminSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
        //show password
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    MSignUpPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    MSignUpPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



    }

    private void SignUp() {
        username = MSignUpusername.getText().toString().trim();
        email = MSignUpusername.getText().toString().trim();
        password = MSignUpPass.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Username required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password Required", Toast.LENGTH_SHORT).show();
        }

        else if(password.length() <6){
            Toast.makeText(this,"Password need to be longer", Toast.LENGTH_SHORT).show();

        } else{
            storeData();
        }
    }

    private void storeData() {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        //To create a unique product random key, so that it doesn't overwrite other product
        productRandomKey = saveCurrentDate + saveCurrentTime;



        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("Username",username);
        userMap.put("Email", email);
        //userMap.put("Password", password);

        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                USERID = fAuth.getCurrentUser().getUid();
                Log.d(TAG, "Get Data:" + USERID);

                Toast.makeText(AdminSignUp.this,"User Created", Toast.LENGTH_SHORT).show();


                //save to firebase
                mBase.child(USERID).updateChildren(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(AdminSignUp.this, AdminAuthenticationActivity.class);
                            startActivity(intent);
                            finish();
                            //loadingBar.dismiss();
                            Toast.makeText(AdminSignUp.this,"User is added successfully..", Toast.LENGTH_SHORT ).show();
                        }else{
                            String message = task.getException().toString();
                            Toast.makeText(AdminSignUp.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}