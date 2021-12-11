package com.doctor.medicinfo.Model;

public class DoctorData {
    String doctor_name, doctor_ID, doctor_level, doctor_phoneNum, taskname, taskdesc, taskdate;

    public DoctorData(){

    }
    public DoctorData(String doctor_name, String doctor_ID, String doctor_level, String doctor_phoneNum, String taskname, String taskdesc, String taskdate) {
        this.doctor_name = doctor_name;
        this.doctor_ID = doctor_ID;
        this.doctor_level = doctor_level;
        this.doctor_phoneNum = doctor_phoneNum;
        this.taskname = taskname;
        this.taskdesc = taskdesc;
        this.taskdate = taskdate;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_ID() {
        return doctor_ID;
    }

    public void setDoctor_ID(String doctor_ID) {
        this.doctor_ID = doctor_ID;
    }

    public String getDoctor_level() {
        return doctor_level;
    }

    public void setDoctor_level(String doctor_level) {
        this.doctor_level = doctor_level;
    }

    public String getDoctor_phoneNum() {
        return doctor_phoneNum;
    }

    public void setDoctor_phoneNum(String doctor_phoneNum) {
        this.doctor_phoneNum = doctor_phoneNum;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdesc() {
        return taskdesc;
    }

    public void setTaskdesc(String taskdesc) {
        this.taskdesc = taskdesc;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }
}
