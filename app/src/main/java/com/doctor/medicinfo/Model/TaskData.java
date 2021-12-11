package com.doctor.medicinfo.Model;

import android.widget.CheckBox;

public class TaskData {
    String Name_Patient, Stent_Due_Task, Diagnosis_Task;
    Boolean isCheck;

    public TaskData(){

    }

    public TaskData(String name_Patient, String stent_Due_Task, String diagnosis_Task, Boolean isCheck) {
        Name_Patient = name_Patient;
        Stent_Due_Task = stent_Due_Task;
        Diagnosis_Task = diagnosis_Task;
        this.isCheck = isCheck;
    }

    public String getName_Patient() {
        return Name_Patient;
    }

    public void setName_Patient(String name_Patient) {
        Name_Patient = name_Patient;
    }

    public String getStent_Due_Task() {
        return Stent_Due_Task;
    }

    public void setStent_Due_Task(String stent_Due_Task) {
        Stent_Due_Task = stent_Due_Task;
    }

    public String getDiagnosis_Task() {
        return Diagnosis_Task;
    }

    public void setDiagnosis_Task(String diagnosis_Task) {
        Diagnosis_Task = diagnosis_Task;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }
}
