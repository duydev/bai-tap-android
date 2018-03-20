package me.duydev.baitapbai4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BaiTap3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap3);
    }

    public void setColor(View view) {
        TextView textView = (TextView) findViewById(R.id.textView2);

        switch (view.getId()) {
            case R.id.btnGreen:
                textView.setTextColor(getResources().getColor(R.color.green));
                break;
            case R.id.btnBlue:
                textView.setTextColor(getResources().getColor(R.color.blue));
                break;
            default:
                // case red
                textView.setTextColor(getResources().getColor(R.color.red));

        }
    }

    public void clearColor(View view) {
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setTextColor(getResources().getColor(R.color.black));
    }

}
