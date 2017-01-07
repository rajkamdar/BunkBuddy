package weekender.bunkbuddy;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class Lectures_Scheduled {

    String day;
    int Sub_ID;
    int time;

    public Lectures_Scheduled(String day, int sub_ID, int time) {
        this.day = day;
        Sub_ID = sub_ID;
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSub_ID() {
        return Sub_ID;
    }

    public void setSub_ID(int sub_ID) {
        Sub_ID = sub_ID;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
