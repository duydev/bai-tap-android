package me.duydev.baitapbai6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cau1BActivity extends AppCompatActivity {

    int a, b;
    TextView viewSoA, viewSoB, viewKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1_b);

        Intent intent = getIntent();
        a = intent.getIntExtra("SoA", 0);
        b = intent.getIntExtra("SoB", 0);
        viewSoA = (TextView) findViewById(R.id.viewSoA);
        viewSoB = (TextView) findViewById(R.id.viewSoB);
        viewKetQua = (TextView) findViewById(R.id.viewKetQua);

        viewSoA.setText(String.valueOf(a));
        viewSoB.setText(String.valueOf(b));
    }

    public void tinhToan(View view) {
        switch (view.getId()) {
            case R.id.btnTru:
                viewKetQua.setText(String.valueOf(a - b));
                break;
            case R.id.btnNhan:
                viewKetQua.setText(String.valueOf(a * b));
                break;
            case R.id.btnChia:
                if( b == 0 ) {
                    viewKetQua.setText("Error: Can not devide zero.");
                } else {
                    viewKetQua.setText(String.valueOf( (float) a / b ));
                }
                break;
            default:
                // case Cong
                viewKetQua.setText(String.valueOf(a + b));
        }
    }
}
