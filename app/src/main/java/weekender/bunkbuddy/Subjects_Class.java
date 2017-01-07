package weekender.bunkbuddy;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class Subjects_Class {

    int Sub_ID;
    String Sub_Name;
    String Inst_Name;
    int Req_Attendance;

    public Subjects_Class(int Sub_ID,String sub_Name, String inst_Name) {
        this.Sub_ID=Sub_ID;
        Sub_Name = sub_Name;
        Inst_Name = inst_Name;
        Req_Attendance=75;
    }

    public Subjects_Class(int Sub_ID,String sub_Name, String inst_Name, int req_Attendance) {
        this.Sub_ID=Sub_ID;
        Sub_Name = sub_Name;
        Inst_Name = inst_Name;
        Req_Attendance = req_Attendance;
    }

    public int getSub_ID() {
        return Sub_ID;
    }

    public void setSub_ID(int sub_ID) {
        Sub_ID = sub_ID;
    }

    public String getSub_Name() {
        return Sub_Name;
    }

    public void setSub_Name(String sub_Name) {
        Sub_Name = sub_Name;
    }

    public String getInst_ID() {
        return Inst_Name;
    }

    public void setInst_ID(String inst_Name) {
        Inst_Name = inst_Name;
    }

    public int getReq_Attendance() {
        return Req_Attendance;
    }

    public void setReq_Attendance(int req_Attendance) {
        Req_Attendance = req_Attendance;
    }
}
