package weekender.bunkbuddy;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class Subjects_Class {

    int Sub_ID;
    String Sub_Name;
    int Inst_ID;
    int Req_Attendance;

    public Subjects_Class(String sub_Name, int inst_ID) {
        Sub_Name = sub_Name;
        Inst_ID = inst_ID;
        Req_Attendance=75;
    }

    public Subjects_Class(String sub_Name, int inst_ID, int req_Attendance) {
        Sub_Name = sub_Name;
        Inst_ID = inst_ID;
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

    public int getInst_ID() {
        return Inst_ID;
    }

    public void setInst_ID(int inst_ID) {
        Inst_ID = inst_ID;
    }

    public int getReq_Attendance() {
        return Req_Attendance;
    }

    public void setReq_Attendance(int req_Attendance) {
        Req_Attendance = req_Attendance;
    }
}
