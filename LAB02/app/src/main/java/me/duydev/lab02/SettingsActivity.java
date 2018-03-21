package me.duydev.lab02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    private int foreColor = 0;
    private int backColor = 0;
    private float textSize = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Bundle bundle = getIntent().getExtras();

        textSize = bundle.getFloat("TextSize");

        Spinner spinner1 = (Spinner) findViewById(R.id.spin1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spin2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spin3);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                foreColor = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                backColor = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textSize = Integer.parseInt( spinner3.getSelectedItem().toString() );
                //
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onOK(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();

        bundle.putInt("ForeColor", foreColor);
        bundle.putInt("BackColor", backColor);
        bundle.putFloat("TextSize", textSize);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
