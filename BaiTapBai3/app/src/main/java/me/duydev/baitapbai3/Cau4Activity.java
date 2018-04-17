package me.duydev.baitapbai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cau4Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button btn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);
        init();
    }

    private void init() {
        tv = (TextView) findViewById(R.id.tvCau4);
        btn = (Button) findViewById(R.id.btnTangSo);
        count = 0;
        btn.setOnClickListener(this);
        print();
    }

    private void print() {
        tv.setText(String.format("Số lần click: %d", count));
    }

    @Override
    public void onClick(View v) {
        count++;
        print();
    }
}
