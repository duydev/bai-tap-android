package me.duydev.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Console;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
    }

    public void calc(View view) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        Spinner operator = (Spinner) findViewById(R.id.operator);
        TextView result = (TextView) findViewById(R.id.result);

        if( num1.getText().length() == 0 || num2.getText().length() == 0 ) {
            result.setText(R.string.please_enter_blank_fields);
            return;
        }

        float a = Float.parseFloat(num1.getText().toString());
        float b = Float.parseFloat(num2.getText().toString());

        switch (operator.getSelectedItem().toString()) {
            case "Cộng":
                result.setText(String.valueOf(a + b));
                break;
            case "Trừ":
                result.setText(String.valueOf(a - b));
                break;
            case "Nhân":
                result.setText(String.valueOf(a * b));
                break;
            case "Chia":
                if (b == 0.0) {
                    result.setText(R.string.cannot_devide_zero);
                } else {
                    result.setText(String.valueOf(a / b));
                }
                break;
        }
    }
}
