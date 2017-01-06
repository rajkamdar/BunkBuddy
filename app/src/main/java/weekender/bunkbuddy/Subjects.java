package weekender.bunkbuddy;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Subjects extends AppCompatActivity {

    ListView Subjects_ListView;
    FloatingActionButton Subjects_FAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        Subjects_ListView= (ListView) findViewById(R.id.subjects_listview);
        Subjects_FAB= (FloatingActionButton) findViewById(R.id.subjects_fab);

        Subjects_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Subjects.this,Add_Subject.class));
                finish();
            }
        });
    }
}
