package com.doctor.medicinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.doctor.medicinfo.Patient_condition.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class AddPatient extends AppCompatActivity {

    EditText namePatient, ICPatient, diagnosePatient, date_stent, typeStent, stentSite, ROS, COS, stentDue;
    int T1Hour, T1Minute, T2Hour, T2Minute;
    TextView setTimeBtn, getTimeBtn;
    Button addPatient;
    ImageView backBtn;
    String UserID, PatientID;
    String namePatientTxt, ICPatientTxt, diagnosePatientTxt, date_stentTxt, typeStentTxt, stentSiteTxt, ROSTxt, COSTxt, stentDueTxt;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    DatabaseReference medRef;
    String saveCurrentDate, saveCurrentTime, productRandomKey;
    TimePickerDialog timePickerDialog;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        backBtn = findViewById(R.id.backhomebtn);
        date_stent = findViewById(R.id.dateStent);
        stentDue = findViewById(R.id.stentDue);
        namePatient = findViewById(R.id.edittextName);
        ICPatient = findViewById(R.id.Ic_Num);
        diagnosePatient = findViewById(R.id.diagnoseMed);
        typeStent = findViewById(R.id.typestentName);
        stentSite = findViewById(R.id.stentSiteType);
        ROS = findViewById(R.id.removalStent);
        COS = findViewById(R.id.changeStent);
        addPatient = findViewById(R.id.addPatientDataBtn);

        UserID = fAuth.getCurrentUser().getUid();
        medRef = FirebaseDatabase.getInstance().getReference("PatientData");

        //add data into firebase
        addPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        date_stent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeDialog(date_stent);
            }
        });

        stentDue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeStentDue(stentDue);
            }
        });

//        //timepicker
//        date_stent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimePickerDialog timePickerDialogDateStart = new TimePickerDialog(AddPatient.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        T1Hour = hourOfDay;
//                        T1Minute = minute;
//
//                        Calendar calendar = Calendar.getInstance();
//                        calendar.set(0,0,0,T1Hour,T1Minute);
//                        date_stent.setText(DateFormat.format("hh:mm aa", calendar));
//                        EditText editText = date_stent.getText().append();
//                    }
//                  }, 12, 0, false
//                );
//                timePickerDialogDateStart.updateTime(T1Hour,T1Minute);
//                timePickerDialogDateStart.show();
//            }
//        });
//        //set transparent background
//        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        //displayed previous selected time
//        timePickerDialog.updateTime(T1Hour,T1Minute);
//        timePickerDialog.show();



        //back btn
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void validateData() {

        namePatientTxt = namePatient.getText().toString().trim();
        ICPatientTxt = ICPatient.getText().toString().trim();
        diagnosePatientTxt = diagnosePatient.getText().toString().trim();
        date_stentTxt = date_stent.getText().toString().trim();
        typeStentTxt = typeStent.getText().toString().trim();
        stentSiteTxt = stentSite.getText().toString().trim();
        ROSTxt = ROS.getText().toString().trim();
        COSTxt = COS.getText().toString().trim();
        stentDueTxt= stentDue.getText().toString().trim();

        if (TextUtils.isEmpty(namePatientTxt)) {
            Toast.makeText(this, "Patient name is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(ICPatientTxt)) {
            Toast.makeText(this, "IC of the patient is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(diagnosePatientTxt)) {
            Toast.makeText(this, "Patient Diagnosis is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(date_stentTxt)) {
            Toast.makeText(this, "Date of patient information inserted is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(typeStentTxt)) {
            Toast.makeText(this, " Type of stent is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(stentSiteTxt)) {
            Toast.makeText(this, "Description is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(ROSTxt)) {
            Toast.makeText(this, "Number of dose is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(COSTxt)) {
            Toast.makeText(this, "Number of dose is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(stentDueTxt)) {
            Toast.makeText(this, "Description is required", Toast.LENGTH_SHORT).show();
        }
        else {
            StoreOrderInformation(namePatientTxt, ICPatientTxt, diagnosePatientTxt, date_stentTxt, typeStentTxt, stentSiteTxt, ROSTxt, COSTxt, stentDueTxt);
        }
    }

    private void StoreOrderInformation(String namePatientTxt, String icPatientTxt, String diagnosePatientTxt, String date_stentTxt, String typeStentTxt, String stentSiteTxt, String rosTxt, String cosTxt, String stentDueTxt) {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        //To create a unique product random key, so that it doesn't overwrite other product
        PatientID = saveCurrentDate + saveCurrentTime;

        HashMap<String, Object> medicMap = new HashMap<>();
        medicMap.put("patient_ID",PatientID);
        medicMap.put("patient_name",namePatientTxt);
        medicMap.put("patient_IC", ICPatientTxt);
        medicMap.put("diagnosis", diagnosePatientTxt);
        medicMap.put("date_added",date_stentTxt);
        medicMap.put("stent_type",typeStentTxt);
        medicMap.put("Stent_Site", stentSiteTxt);
        medicMap.put("ROS", ROSTxt);
        medicMap.put("COS",COSTxt);
        medicMap.put("stent_due_date",stentDueTxt);


        String addData = medRef.push().getKey();
        Log.d(TAG, "saveData: "+addData);

        medRef.child(addData).updateChildren(medicMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(AddPatient.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                    // loadingBar.dismiss();
                    Toast.makeText(AddPatient.this, "Patient Data is added successfully..", Toast.LENGTH_SHORT).show();
                }else{
                    String message = task.getException().toString();
                    Toast.makeText(AddPatient.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void dateTimeStentDue(EditText stentDue) {

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                        stentDue.setText(simpleDateFormat.format(calendar));
                    }

                };
                new TimePickerDialog(AddPatient.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();

            }

        };

        new DatePickerDialog(AddPatient.this, dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void dateTimeDialog(EditText date_stent) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                        date_stent.setText(simpleDateFormat.format(calendar));
                    }

                };
                new TimePickerDialog(AddPatient.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();

            }

        };

        new DatePickerDialog(AddPatient.this, dateSetListener,calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}