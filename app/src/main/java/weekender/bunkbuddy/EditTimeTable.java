package weekender.bunkbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditTimeTable extends AppCompatActivity {
    EditText etTime;
    Spinner spinnerSubject;
    Button edit_tt_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time_table);
        etTime= (EditText) findViewById(R.id.edit_tt_et);
        spinnerSubject= (Spinner) findViewById(R.id.edit_tt_spinner);
        edit_tt_btn= (Button) findViewById(R.id.edit_tt_btn_add);

        edit_tt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
