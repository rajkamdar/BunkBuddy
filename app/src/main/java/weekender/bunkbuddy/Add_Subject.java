package weekender.bunkbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Add_Subject extends AppCompatActivity {
    EditText etName,etPercent,etInstName;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);
        etName= (EditText) findViewById(R.id.add_sub_et_name);
        etInstName= (EditText) findViewById(R.id.add_sub_et_inst);
        etPercent= (EditText) findViewById(R.id.add_sub_at_attendance);
        btnAdd= (Button) findViewById(R.id.add_sub_btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
