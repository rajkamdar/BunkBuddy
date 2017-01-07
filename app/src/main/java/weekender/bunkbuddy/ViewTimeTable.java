package weekender.bunkbuddy;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ViewTimeTable extends AppCompatActivity {
    TextView view_timetable_tv;
    ListView view_timetable_lv;
    FloatingActionButton view_timetable_fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);
        view_timetable_tv= (TextView) findViewById(R.id.view_timetable_tv);
        view_timetable_lv= (ListView) findViewById(R.id.view_timetable_lv);
        view_timetable_fab= (FloatingActionButton) findViewById(R.id.view_timetable_fab);

        view_timetable_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
