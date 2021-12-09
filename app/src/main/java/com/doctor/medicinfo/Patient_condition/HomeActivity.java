package com.doctor.medicinfo.Patient_condition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.doctor.medicinfo.Adapter.PatientDataAdapter;
import com.doctor.medicinfo.AddPatient;
import com.doctor.medicinfo.Model.PatientData;
import com.doctor.medicinfo.ProfileActivity;
import com.doctor.medicinfo.R;
import com.doctor.medicinfo.TaskActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import static android.content.ContentValues.TAG;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomtabmenu;
    RecyclerView thishomerecycler;
    //MedAdapter myadapter;
    PatientDataAdapter adapter;
    DatabaseReference mBase;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    String UserID;
    Query query;
    FloatingActionButton fab;
    CalendarView calendar;
    RadioButton rd = new RadioButton(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        calendar = findViewById(R.id.calendarView);
        thishomerecycler = findViewById(R.id.homeRecycler);
        calendar.getDate();

        fab = findViewById(R.id.addPatient);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddPatient.class);
                startActivity(intent);
            }
        });
        UserID = fAuth.getCurrentUser().getUid();
        Log.d(TAG, "UserID: "+UserID);

        try{
            thishomerecycler.setLayoutManager(new LinearLayoutManager(this));

            mBase = FirebaseDatabase.getInstance().getReference("Medicine");
            query = mBase.orderByChild("medicineID").equalTo(UserID);
            Log.d(TAG, "mBase: "+mBase);
            FirebaseRecyclerOptions<PatientData> options = new FirebaseRecyclerOptions.Builder<PatientData>()
                    .setQuery(query, PatientData.class)
                    .build();
            adapter = new PatientDataAdapter(options);
            thishomerecycler.setAdapter(adapter);

//            FirebaseRecyclerOptions<MedicineLibrary> options = new FirebaseRecyclerOptions.Builder<MedicineLibrary>()
//                    .setQuery(query,MedicineLibrary.class)
//                    .build();
//            myadapter = new MedAdapter(options);
//            thishomerecycler.setAdapter(myadapter);

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_SHORT).show();
        }


        bottomtabmenu = findViewById(R.id.bottom_navigation);
        bottomtabmenu.setSelectedItemId(R.id.patientCond);

        bottomtabmenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.task:
                        startActivity(new Intent(getApplicationContext(), TaskActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profileID:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.patientCond:
                        return true;
                }
                return false;
            }
        });
    }

    //check data using calendar data
    //month, day, week

    public void onRadioButtonClicked(View view) {
        // Is the view now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which RadioButton was clicked
        switch(view.getId()) {
            case R.id.monthData:
                if (checked){
                    rd.setChecked(true);
                    //rd.setTextColor();
                }
                // Do your coding
                // Do your coding

                break;
            case R.id.weekData:
                if(checked){

                }
            case R.id.dayData:
                if(checked){

                }
            // Perform your logic
        }
    }


}