package com.doctor.medicinfo.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doctor.medicinfo.Edit_patient_condition;
import com.doctor.medicinfo.Model.PatientData;
import com.doctor.medicinfo.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class PatientDataAdapter extends FirebaseRecyclerAdapter<PatientData, PatientDataAdapter.PatientViewHolder>{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PatientDataAdapter(@NonNull @NotNull FirebaseRecyclerOptions<PatientData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull PatientViewHolder holder, int position, @NonNull @NotNull PatientData model) {
            holder.patientName.setText(model.getPatient_name());
            holder.patientDiagnosis.setText(model.getDiagnosis());
            holder.typeStent.setText(model.getStent_type());
            holder.stentDue.setText(model.getStent_due_date());
            holder.statusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),Edit_patient_condition.class);
                    v.getContext().startActivity(intent);
                }
            });

    }

    @NonNull
    @NotNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_condition_ui,parent,false);
        return new PatientViewHolder(view);
    }

    class PatientViewHolder extends RecyclerView.ViewHolder{

        TextView patientName,typeStent,patientDiagnosis,stentDue;
        Button updateBtn, statusBtn;

        public PatientViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            patientName      = itemView.findViewById(R.id.patientNameView);
            typeStent        = itemView.findViewById(R.id.typeStentView);
            patientDiagnosis = itemView.findViewById(R.id.patientDiagnosisView);
            stentDue         = itemView.findViewById(R.id.stentDueView);
            updateBtn        = itemView.findViewById(R.id.updateBtnCond);
            statusBtn        = itemView.findViewById(R.id.statusRemarksBtn);

        }
    }
}
