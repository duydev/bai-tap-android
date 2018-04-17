package me.duydev.baitapbai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Cau2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
    }

    public void setFontSize(View view) {
        TextView tv = (TextView) findViewById(R.id.tvCau2);
        if (view.getId() == R.id.btnFontSize20) {
            tv.setTextSize(20);
        } else {
            tv.setTextSize(40);
        }
    }

}
