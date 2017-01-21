package weekender.bunkbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    ArrayAdapter<String> itemsAdapter;
    ArrayList<Integer> IDAL;
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
        IDAL=new ArrayList<Integer>();
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
                IDAL.add(index,sub.getInt(2));
                index++;
            }
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lectureAL);
            view_timetable_lv.setAdapter(itemsAdapter);

        }

        view_timetable_lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                int ls_id=IDAL.get(position);
                                Integer deletedRows=db.deleteLecture(ls_id);
                                if(deletedRows>0)
                                {
                                    Toast.makeText(ViewTimeTable.this,"Lecture Deleted",Toast.LENGTH_LONG).show();
                                    lectureAL.remove(position);
                                    IDAL.remove(position);
                                    itemsAdapter.notifyDataSetChanged();
                                }

                                else
                                    Toast.makeText(ViewTimeTable.this,"Unable to Delete",Toast.LENGTH_LONG).show();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(ViewTimeTable.this);
                builder.setMessage("DID YOU WANT TO DELETE?").setPositiveButton("YES", dialogClickListener)
                        .setNegativeButton("NO", dialogClickListener).show();

                return false;
            }
        });

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
