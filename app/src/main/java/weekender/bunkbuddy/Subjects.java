package weekender.bunkbuddy;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Subjects extends AppCompatActivity {

    ListView Subjects_ListView;
    FloatingActionButton Subjects_FAB;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        Subjects_ListView= (ListView) findViewById(R.id.subjects_listview);
        Subjects_FAB= (FloatingActionButton) findViewById(R.id.subjects_fab);
        ArrayList<Subjects_Class>subjectsAL=new ArrayList<Subjects_Class>();
        ArrayList<String> nameAL=new ArrayList<String>();
        db=new DBHelper(getApplicationContext());
        Cursor sub=db.getAllSubjects();
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            while(sub.moveToNext())
            {
                nameAL.add(index,sub.getString(1));
                index++;
            }
            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameAL);
            Subjects_ListView.setAdapter(itemsAdapter);

        }
        Subjects_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Subjects.this,Add_Subject.class));
                finish();
            }
        });
    }
}
