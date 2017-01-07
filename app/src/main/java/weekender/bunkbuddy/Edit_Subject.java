package weekender.bunkbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Edit_Subject extends AppCompatActivity {
    EditText etName,etPercent,etInstName;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__subject);
        etName= (EditText) findViewById(R.id.edit_sub_et_name);
        etPercent= (EditText) findViewById(R.id.edit_sub_at_attendance);
        etInstName= (EditText) findViewById(R.id.edit_sub_et_inst);
        btnEdit= (Button) findViewById(R.id.edit_sub_btn_add);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
