package me.duydev.baitapbai6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cau2AActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    TextView viewKQ;
    int a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_a);

        a = 0;
        b = 0;
        c = 0;
        txtA = (EditText) findViewById(R.id.txtSoA2);
        txtB = (EditText) findViewById(R.id.txtSoB2);
        txtC = (EditText) findViewById(R.id.txtSoC2);
    }

    public void send(View view) {
        try {
            a = Integer.parseInt(txtA.getText().toString());
            b = Integer.parseInt(txtB.getText().toString());
            c = Integer.parseInt(txtC.getText().toString());
        } catch (Exception e) {
            //
        }

        Intent intent = new Intent(this, Cau2BActivity.class);
        intent.putExtra("SoA", a);
        intent.putExtra("SoB", b);
        intent.putExtra("SoC", c);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result = data.getStringExtra("RESULT");
        viewKQ.setText(result);
    }
}
