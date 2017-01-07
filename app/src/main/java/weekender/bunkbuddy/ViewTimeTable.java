package weekender.bunkbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewTimeTable extends AppCompatActivity {
    TextView view_timetable_tv;
    ListView view_timetable_lv;
    FloatingActionButton view_timetable_fab;
    ArrayList<String> lectureAL;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);
        Intent mIntent=getIntent();
        final String day=mIntent.getStringExtra("Day");
        view_timetable_tv= (TextView) findViewById(R.id.view_timetable_tv);
        view_timetable_lv= (ListView) findViewById(R.id.view_timetable_lv);
        view_timetable_fab= (FloatingActionButton) findViewById(R.id.view_timetable_fab);
        view_timetable_tv.setText(day);
        lectureAL=new ArrayList<String>();
        db=DBHelper.getInstance(getApplicationContext());
        Cursor sub=db.getAllLectures(day);
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            while(sub.moveToNext())
            {
                lectureAL.add(index,sub.getString(0));
                index++;
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lectureAL);
            view_timetable_lv.setAdapter(itemsAdapter);

        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lectureAL);

        view_timetable_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent=new Intent(ViewTimeTable.this,EditTimeTable.class);
                newIntent.putExtra("day",day);
                startActivity(newIntent);
                finish();
            }
        });

        db.closeDB();
    }
}
