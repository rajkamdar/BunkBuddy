package weekender.bunkbuddy;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class Instructors {

    int Inst_ID;
    String Inst_Name;

    public Instructors(int inst_ID, String inst_Name) {
        Inst_ID = inst_ID;
        Inst_Name = inst_Name;
    }

    public int getInst_ID() {
        return Inst_ID;
    }

    public void setInst_ID(int inst_ID) {
        Inst_ID = inst_ID;
    }

    public String getInst_Name() {
        return Inst_Name;
    }

    public void setInst_Name(String inst_Name) {
        Inst_Name = inst_Name;
    }
}
