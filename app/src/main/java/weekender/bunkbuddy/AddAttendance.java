package weekender.bunkbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddAttendance extends AppCompatActivity {
    ListView add_attendance_lv;
    //Intent mIntent=getIntent();
    //String day=mIntent.getStringExtra("day");
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    Date d = new Date();
    String dayOfTheWeek = sdf.format(d);
    ArrayList<String> lectureAL;
    ArrayList<Integer> IDAL;
    ArrayAdapter<String> itemsAdapter;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);
        add_attendance_lv= (ListView) findViewById(R.id.add_attendance_lv);
        db=DBHelper.getInstance(getApplicationContext());
        lectureAL=new ArrayList<String>();
       IDAL=new ArrayList<Integer>();
        Cursor sub=db.getAllLectures(dayOfTheWeek);
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
                    IDAL.add(index,sub.getInt(1));
                    index++;
                }
                itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lectureAL);
                add_attendance_lv.setAdapter(itemsAdapter);
            }
            finally {
                if (sub != null && !sub.isClosed())
                    sub.close();
               // db.close();
            }

        }

        add_attendance_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                db.addAttendance(IDAL.get(i),"YES",dayOfTheWeek);
                                Toast.makeText(AddAttendance.this, "MARKED AS PRESENT", Toast.LENGTH_LONG).show();
                                lectureAL.remove(i);
                                IDAL.remove(i);
                                itemsAdapter.notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                Toast.makeText(AddAttendance.this, "MARKED AS ABSENT", Toast.LENGTH_LONG).show();
                                db.addAttendance(IDAL.get(i),"NO",dayOfTheWeek);
                                lectureAL.remove(i);
                                IDAL.remove(i);
                                itemsAdapter.notifyDataSetChanged();
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(AddAttendance.this);
                builder.setMessage("DID YOU ATTEND THE LECTURE?").setPositiveButton("YES", dialogClickListener)
                        .setNegativeButton("NO", dialogClickListener).show();
            }
        });
    }
}
