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
import android.widget.Toast;

import java.util.ArrayList;

public class Subjects extends AppCompatActivity {

    ListView Subjects_ListView;
    FloatingActionButton Subjects_FAB;
    DBHelper db;
    ArrayAdapter<String> itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        Subjects_ListView= (ListView) findViewById(R.id.subjects_listview);
        Subjects_FAB= (FloatingActionButton) findViewById(R.id.subjects_fab);
        ArrayList<Subjects_Class>subjectsAL=new ArrayList<Subjects_Class>();
        final ArrayList<String> nameAL=new ArrayList<String>();
        final ArrayList<Integer>IDAL=new ArrayList<Integer>();
        db=DBHelper.getInstance(getApplicationContext());

            Cursor sub=db.getAllSubjects();
            if(sub.getCount()==0)
                Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
            else
            {
                int index=0;
                while(sub.moveToNext())
                {
                    nameAL.add(index,sub.getString(1));
                    IDAL.add(index,sub.getInt(0));
                    index++;
                }
                itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameAL);
                Subjects_ListView.setAdapter(itemsAdapter);

            }


        Subjects_ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                int sub_id=IDAL.get(position);
                                Integer deletedRows=db.deleteSubject(sub_id);
                                if(deletedRows>0)
                                {
                                    Toast.makeText(Subjects.this,"Subject Deleted",Toast.LENGTH_LONG).show();
                                    nameAL.remove(position);
                                    IDAL.remove(position);
                                    itemsAdapter.notifyDataSetChanged();
                                }

                                else
                                    Toast.makeText(Subjects.this,"Unable to Delete",Toast.LENGTH_LONG).show();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(Subjects.this);
                builder.setMessage("DID YOU WANT TO DELETE?").setPositiveButton("YES", dialogClickListener)
                        .setNegativeButton("NO", dialogClickListener).show();

                return false;
            }
        });

        Subjects_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Subjects.this,Add_Subject.class));
                finish();
            }
        });
    }
}
