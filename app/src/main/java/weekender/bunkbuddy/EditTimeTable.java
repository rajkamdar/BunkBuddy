package weekender.bunkbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditTimeTable extends AppCompatActivity {
    EditText etTime;
    Spinner spinnerSubject;
    Button edit_tt_btn;
    DBHelper db;
    String day;
    ArrayList<String> subName=new ArrayList<String>();
    ArrayList<Subjects_Class> subClassList=new ArrayList<Subjects_Class>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time_table);
        Intent newIntent=getIntent();
        day=newIntent.getStringExtra("day");
        etTime= (EditText) findViewById(R.id.edit_tt_et);
        spinnerSubject= (Spinner) findViewById(R.id.edit_tt_spinner);
        edit_tt_btn= (Button) findViewById(R.id.edit_tt_btn_add);
        db=new DBHelper(getApplicationContext());

        Cursor sub=db.getAllSubjects();
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            while(sub.moveToNext())
            {
                subName.add(index,sub.getString(1));
                index++;
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subName);
            spinnerSubject.setAdapter(itemsAdapter);
        }


        Cursor sub2=db.getAllSubjects();
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            while(sub2.moveToNext())
            {
                subClassList.add(index,new Subjects_Class(sub2.getInt(0),sub2.getString(1),sub2.getString(2),sub2.getInt(3)));
                index++;
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subName);
            spinnerSubject.setAdapter(itemsAdapter);
        }


        edit_tt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //STATIC
                boolean result=db.addLecture(day,subClassList.get(0).getSub_ID(),Integer.parseInt(etTime.getText()+""));
                if(result)
                    Snackbar.make(view, "Added", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                else
                    Snackbar.make(view, "Error", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }
}
