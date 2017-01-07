package weekender.bunkbuddy;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Add_Subject extends AppCompatActivity {
    EditText etName,etPercent,etInstName;
    Button btnAdd;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);
        etName= (EditText) findViewById(R.id.add_sub_et_name);
        etInstName= (EditText) findViewById(R.id.add_sub_et_inst);
        etPercent= (EditText) findViewById(R.id.add_sub_at_attendance);
        btnAdd= (Button) findViewById(R.id.add_sub_btn_add);
        db=DBHelper.getInstance(getApplicationContext());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=db.addSubject(etName.getText()+"",etInstName.getText()+"",etPercent.getText()+"");
                if(result)
                    Snackbar.make(view, "Added", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                else
                    Snackbar.make(view, "Error", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

    }
}
