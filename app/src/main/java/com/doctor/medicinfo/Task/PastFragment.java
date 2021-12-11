package com.doctor.medicinfo.Task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doctor.medicinfo.Model.TaskData;
import com.doctor.medicinfo.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class PastFragment extends Fragment {

    View PastData;
    RecyclerView PastRecycler;
    public DatabaseReference mPastRef, mPatientRef, mDoctorRef;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    FirebaseAuth mUser = FirebaseAuth.getInstance();
    String currentUserID = mUser.getCurrentUser().getUid();
    String taskCheck = "Check";
    String taskUnCheck = "unchecked";
    String TAG ="";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        PastData = inflater.inflate(R.layout.past_fragment, container,false);

        PastRecycler = PastData.findViewById(R.id.pastTaskRecycler);
        PastRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        mPastRef   = db.getReference("Task").child("Past");
        mPatientRef = db.getReference("Patient");
        mDoctorRef  = db.getReference("Doctor");

        return PastData;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<TaskData>()
                        .setQuery(mPastRef, TaskData.class)
                        .build();


        final FirebaseRecyclerAdapter<TaskData, PastFragment.PastViewHolder> adapter =
                new FirebaseRecyclerAdapter<TaskData, PastFragment.PastViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull @NotNull PastFragment.PastViewHolder holder, int position, @NonNull @NotNull TaskData model) {

                        mPatientRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                if(snapshot.hasChild("patient_name")){
                                    String patientName      = snapshot.child("patient_name").getValue().toString();
                                    String stentDue         = snapshot.child("stent_due_date").getValue().toString();
                                    String diagnosisPatient = snapshot.child("diagnosis").getValue().toString();
                                    String patientNameID        = snapshot.child("patient_ID").getValue().toString();

                                    holder.namePatientTask.setText(patientName);
                                    holder.DiagnosisTask.setText(diagnosisPatient);
                                    holder.StentDueTask.setText(stentDue);
                                    holder.patientID.setText(patientNameID);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }
                        });


                        //this is for checkbox purposes
                        holder.PastTick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(holder.PastTick.isChecked()){
                                    HashMap<String, Object> userMap = new HashMap<>();
                                    userMap.put("status",taskCheck);
                                    // mGoingRef.setValue(taskCheck);
                                }else{
                                    HashMap<String, Object> userMap = new HashMap<>();
                                    userMap.put("status",taskUnCheck);
                                }
                            }
                        });

                        String patientID = getRef(position).getKey();

                        mPatientRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                            }

                            @Override
                            public void onCancelled(@NonNull @NotNull DatabaseError error) {

                            }
                        });


                    }



                    @NonNull
                    @NotNull
                    @Override
                    public PastFragment.PastViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
                        PastFragment.PastViewHolder viewHolder = new PastFragment.PastViewHolder(view);
                        return viewHolder;
                    }
                };

        PastRecycler.setAdapter(adapter);
        adapter.startListening();


    }

    public static class PastViewHolder extends RecyclerView.ViewHolder{

        TextView patientID, namePatientTask, StentDueTask, DiagnosisTask;
        CheckBox PastTick;

        public PastViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            namePatientTask = itemView.findViewById(R.id.namePatientTask);
            patientID       = itemView.findViewById(R.id.IDPatientTask);
            StentDueTask    = itemView.findViewById(R.id.stentDuePatientTask);
            DiagnosisTask   = itemView.findViewById(R.id.diagnosisPatientTask);
            PastTick        = itemView.findViewById(R.id.checkboxTask);


        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
