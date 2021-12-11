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


public class FutureFragment extends Fragment {
    View FutureData;
    RecyclerView FutureRecycler;
    public DatabaseReference mFutureRef, mPatientRef, mDoctorRef;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    FirebaseAuth mUser = FirebaseAuth.getInstance();
    String currentUserID = mUser.getCurrentUser().getUid();
    String taskCheck = "Check";
    String taskUnCheck = "unchecked";
    String TAG ="";

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        FutureData = inflater.inflate(R.layout.future_fragment, container,false);

        FutureRecycler = FutureData.findViewById(R.id.ongoingTaskRecycler);
        FutureRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        mFutureRef   = db.getReference("Task").child("Future");
        mPatientRef = db.getReference("Patient");
        mDoctorRef  = db.getReference("Doctor");

        return FutureData;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<TaskData>()
                        .setQuery(mFutureRef, TaskData.class)
                        .build();


        final FirebaseRecyclerAdapter<TaskData, FutureFragment.FutureViewHolder> adapter =
                new FirebaseRecyclerAdapter<TaskData, FutureFragment.FutureViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull @NotNull FutureFragment.FutureViewHolder holder, int position, @NonNull @NotNull TaskData model) {

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
                        holder.FutureTick.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(holder.FutureTick.isChecked()){
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
                    public FutureFragment.FutureViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
                        FutureFragment.FutureViewHolder viewHolder = new FutureFragment.FutureViewHolder(view);
                        return viewHolder;
                    }
                };

        FutureRecycler.setAdapter(adapter);
        adapter.startListening();


    }

    public static class FutureViewHolder extends RecyclerView.ViewHolder{

        TextView patientID, namePatientTask, StentDueTask, DiagnosisTask;
        CheckBox FutureTick;

        public FutureViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            namePatientTask = itemView.findViewById(R.id.namePatientTask);
            patientID       = itemView.findViewById(R.id.IDPatientTask);
            StentDueTask    = itemView.findViewById(R.id.stentDuePatientTask);
            DiagnosisTask   = itemView.findViewById(R.id.diagnosisPatientTask);
            FutureTick     = itemView.findViewById(R.id.checkboxTask);


        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
