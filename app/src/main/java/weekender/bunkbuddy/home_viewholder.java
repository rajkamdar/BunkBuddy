package weekender.bunkbuddy;

import android.widget.TextView;

/**
 * Created by Raj Kamdar on 21-01-2017.
 */

public class home_viewholder {

    TextView home_subject_tc,home_percent_tv,home_total_tv,home_attended_tv;

    public home_viewholder(TextView home_subject_tc, TextView home_percent_tv, TextView home_total_tv, TextView home_attended_tv) {
        this.home_subject_tc = home_subject_tc;
        this.home_percent_tv = home_percent_tv;
        this.home_total_tv = home_total_tv;
        this.home_attended_tv = home_attended_tv;
    }

    public TextView getHome_subject_tc() {
        return home_subject_tc;
    }

    public void setHome_subject_tc(TextView home_subject_tc) {
        this.home_subject_tc = home_subject_tc;
    }

    public TextView getHome_percent_tv() {
        return home_percent_tv;
    }

    public void setHome_percent_tv(TextView home_percent_tv) {
        this.home_percent_tv = home_percent_tv;
    }

    public TextView getHome_total_tv() {
        return home_total_tv;
    }

    public void setHome_total_tv(TextView home_total_tv) {
        this.home_total_tv = home_total_tv;
    }

    public TextView getHome_attended_tv() {
        return home_attended_tv;
    }

    public void setHome_attended_tv(TextView home_attended_tv) {
        this.home_attended_tv = home_attended_tv;
    }
}
