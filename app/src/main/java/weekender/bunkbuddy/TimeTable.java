package weekender.bunkbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {
    ListView timetable_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        timetable_listView= (ListView) findViewById(R.id.timetable_listView);
        ArrayList<String> days=new ArrayList<String>();
        days.add(0,"Monday");
        days.add(1,"Tuesday");
        days.add(2,"Wednesday");
        days.add(3,"Thursday");
        days.add(4,"Friday");
        days.add(5,"Saturday");
        days.add(6,"Sunday");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        timetable_listView.setAdapter(itemsAdapter);
        timetable_listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TimeTable.this,ViewTimeTable.class));
                finish();
            }
        });
    }
}
