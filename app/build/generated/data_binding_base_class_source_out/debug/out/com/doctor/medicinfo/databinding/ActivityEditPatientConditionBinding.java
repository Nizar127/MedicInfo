// Generated by view binder compiler. Do not edit!
package com.doctor.medicinfo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.doctor.medicinfo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditPatientConditionBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView firstpatientDiagnosisView;

  @NonNull
  public final TextView firststartStentView;

  @NonNull
  public final TextView firststentDueView;

  @NonNull
  public final EditText patientDiagnosisView;

  @NonNull
  public final EditText patientNameView;

  @NonNull
  public final Button statusRemarksBtn;

  @NonNull
  public final EditText stentDueView;

  @NonNull
  public final EditText typeStentView;

  @NonNull
  public final Button updateBtnCond;

  private ActivityEditPatientConditionBinding(@NonNull LinearLayout rootView,
      @NonNull TextView firstpatientDiagnosisView, @NonNull TextView firststartStentView,
      @NonNull TextView firststentDueView, @NonNull EditText patientDiagnosisView,
      @NonNull EditText patientNameView, @NonNull Button statusRemarksBtn,
      @NonNull EditText stentDueView, @NonNull EditText typeStentView,
      @NonNull Button updateBtnCond) {
    this.rootView = rootView;
    this.firstpatientDiagnosisView = firstpatientDiagnosisView;
    this.firststartStentView = firststartStentView;
    this.firststentDueView = firststentDueView;
    this.patientDiagnosisView = patientDiagnosisView;
    this.patientNameView = patientNameView;
    this.statusRemarksBtn = statusRemarksBtn;
    this.stentDueView = stentDueView;
    this.typeStentView = typeStentView;
    this.updateBtnCond = updateBtnCond;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditPatientConditionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditPatientConditionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_patient_condition, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditPatientConditionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.firstpatientDiagnosisView;
      TextView firstpatientDiagnosisView = rootView.findViewById(id);
      if (firstpatientDiagnosisView == null) {
        break missingId;
      }

      id = R.id.firststartStentView;
      TextView firststartStentView = rootView.findViewById(id);
      if (firststartStentView == null) {
        break missingId;
      }

      id = R.id.firststentDueView;
      TextView firststentDueView = rootView.findViewById(id);
      if (firststentDueView == null) {
        break missingId;
      }

      id = R.id.patientDiagnosisView;
      EditText patientDiagnosisView = rootView.findViewById(id);
      if (patientDiagnosisView == null) {
        break missingId;
      }

      id = R.id.patientNameView;
      EditText patientNameView = rootView.findViewById(id);
      if (patientNameView == null) {
        break missingId;
      }

      id = R.id.statusRemarksBtn;
      Button statusRemarksBtn = rootView.findViewById(id);
      if (statusRemarksBtn == null) {
        break missingId;
      }

      id = R.id.stentDueView;
      EditText stentDueView = rootView.findViewById(id);
      if (stentDueView == null) {
        break missingId;
      }

      id = R.id.typeStentView;
      EditText typeStentView = rootView.findViewById(id);
      if (typeStentView == null) {
        break missingId;
      }

      id = R.id.updateBtnCond;
      Button updateBtnCond = rootView.findViewById(id);
      if (updateBtnCond == null) {
        break missingId;
      }

      return new ActivityEditPatientConditionBinding((LinearLayout) rootView,
          firstpatientDiagnosisView, firststartStentView, firststentDueView, patientDiagnosisView,
          patientNameView, statusRemarksBtn, stentDueView, typeStentView, updateBtnCond);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}