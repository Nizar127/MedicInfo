package com.doctor.medicinfo.Model;

public class PatientData {
    String patient_ID, patient_name, patient_IC, diagnosis, date_added, stent_type, stent_site, ROS, COS, stent_due_date;


    public PatientData() {

    }

    public PatientData(String patient_ID, String patient_name, String patient_IC, String diagnosis, String date_added, String stent_type, String stent_site, String ROS, String COS, String stent_due_date) {
        this.patient_ID = patient_ID;
        this.patient_name = patient_name;
        this.patient_IC = patient_IC;
        this.diagnosis = diagnosis;
        this.date_added = date_added;
        this.stent_type = stent_type;
        this.stent_site = stent_site;
        this.ROS = ROS;
        this.COS = COS;
        this.stent_due_date = stent_due_date;
    }

    public String getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_IC() {
        return patient_IC;
    }

    public void setPatient_IC(String patient_IC) {
        this.patient_IC = patient_IC;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getStent_type() {
        return stent_type;
    }

    public void setStent_type(String stent_type) {
        this.stent_type = stent_type;
    }

    public String getStent_site() {
        return stent_site;
    }

    public void setStent_site(String stent_site) {
        this.stent_site = stent_site;
    }

    public String getROS() {
        return ROS;
    }

    public void setROS(String ROS) {
        this.ROS = ROS;
    }

    public String getCOS() {
        return COS;
    }

    public void setCOS(String COS) {
        this.COS = COS;
    }

    public String getStent_due_date() {
        return stent_due_date;
    }

    public void setStent_due_date(String stent_due_date) {
        this.stent_due_date = stent_due_date;
    }
}
