package me.duydev.baitapbai6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cau1AActivity extends AppCompatActivity {

    int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_a);
    }

    public void openActivityB(View view) {
        EditText txtSoA = (EditText) findViewById(R.id.txtSoA);
        EditText txtSoB = (EditText) findViewById(R.id.txtSoB);
        try {
            a = Integer.parseInt(txtSoA.getText().toString());
            b = Integer.parseInt(txtSoB.getText().toString());
        } catch (Exception e) {
            a = 0;
            b = 0;
        }
        Intent intent = new Intent(this, Cau1BActivity.class);
        intent.putExtra("SoA", a);
        intent.putExtra("SoB", b);
        startActivity(intent);
    }
}
