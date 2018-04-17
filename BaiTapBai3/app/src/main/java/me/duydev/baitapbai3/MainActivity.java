package me.duydev.baitapbai3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCau2:
                intent = new Intent(this, Cau2Activity.class);
                break;
            case R.id.btnCau3:
                intent = new Intent(this, Cau3Activity.class);
                break;
            case R.id.btnCau4:
                intent = new Intent(this, Cau4Activity.class);
                break;
            default:
                //cau 1
                intent = new Intent(this, Cau1Activity.class);
        }
        startActivity(intent);
    }

}
