package me.duydev.baitapbai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Cau3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);
    }

    public void btnClick(View view) {
        TextView tv = (TextView) findViewById(R.id.tvCau3);
        switch (view.getId()) {
            case R.id.btnDo:
                tv.setTextColor(getResources().getColor(R.color.Do));
                break;
            case R.id.btnXanh:
                tv.setTextColor(getResources().getColor(R.color.Xanh));
                break;
            default:
                tv.setTextColor(getResources().getColor(R.color.Vang));
        }
    }

}
