package weekender.bunkbuddy;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class Lectures_Conducted {

    int LC_ID;
    int Sub_ID;
    String attended;

    public Lectures_Conducted(int LC_ID, int sub_ID, String attended) {
        this.LC_ID = LC_ID;
        Sub_ID = sub_ID;
        this.attended = attended;
    }

    public int getLC_ID() {
        return LC_ID;
    }

    public void setLC_ID(int LC_ID) {
        this.LC_ID = LC_ID;
    }

    public int getSub_ID() {
        return Sub_ID;
    }

    public void setSub_ID(int sub_ID) {
        Sub_ID = sub_ID;
    }

    public String getAttended() {
        return attended;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }
}
