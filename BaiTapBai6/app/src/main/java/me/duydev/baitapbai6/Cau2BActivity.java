package me.duydev.baitapbai6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cau2BActivity extends AppCompatActivity {

    int a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2_b);

        Intent intent = getIntent();
        a = intent.getIntExtra("SoA", 0);
        b = intent.getIntExtra("SoB", 0);
        c = intent.getIntExtra("SoC", 0);
    }

    public void calc(View view) {
        String result;
        switch (view.getId()) {
            case R.id.btnSNN:
                int min = a;
                if (b < min) {
                    min = b;
                }
                if (c < min) {
                    min = c;
                }
                result = String.valueOf(min);
                break;
            case R.id.btnGPT:
                int delta = b * b - (4 * a * c);
                double rDelta = Math.sqrt(delta);
                if (delta > 0) {
                    double x1 = -b + rDelta / 2 * a;
                    double x2 = -b + rDelta / 2 * a;
                    result = "X1= " + x1 + " x2= " + x2;
                } else if (delta == 0) {
                    double x = -b / 2 * a;
                    result = "X= " + x;
                } else {
                    result = "Vô nghiệm.";
                }
                break;
            default:
                // case tim sln
                int max = a;
                if (b > max) {
                    max = b;
                }
                if (c > max) {
                    max = c;
                }
                result = String.valueOf(max);
        }
        Intent intent = new Intent(this, Cau2AActivity.class);
        intent.putExtra("RESULT", result);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
