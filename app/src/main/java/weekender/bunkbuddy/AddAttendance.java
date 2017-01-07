package weekender.bunkbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddAttendance extends AppCompatActivity {
    ListView add_attendance_lv;
    Intent mIntent=getIntent();
    String day=mIntent.getStringExtra("day");
    ArrayList<String> lectureAL;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);
        add_attendance_lv= (ListView) findViewById(R.id.add_attendance_lv);
        db=new DBHelper(getApplicationContext());
        lectureAL=new ArrayList<String>();
        db=new DBHelper(getApplicationContext());
        Cursor sub=db.getAllLectures(day);
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            try
            {
                while(sub.moveToNext())
                {
                    lectureAL.add(index,sub.getString(0));
                    index++;
                }
                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lectureAL);
                add_attendance_lv.setAdapter(itemsAdapter);
            }
            finally {
                if (sub != null && !sub.isClosed())
                    sub.close();
                db.close();
            }

        }

        add_attendance_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
