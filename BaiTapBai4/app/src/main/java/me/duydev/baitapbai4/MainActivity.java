package me.duydev.baitapbai4;

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

    public void switchActivity(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnBai1:
                intent = new Intent(this, BaiTap1.class);
                break;
            case R.id.btnBai2:
                intent = new Intent(this, BaiTap2.class);
                break;
            case R.id.btnBai3:
                intent = new Intent(this, BaiTap3.class);
                break;
            case R.id.btnBai4:
                intent = new Intent(this, BaiTap4.class);
                break;
            case R.id.btnBai5:
                intent = new Intent(this, BaiTap5.class);
                break;
            case R.id.btnBai6:
                intent = new Intent(this, BaiTap6.class);
                break;
            case R.id.btnBai7:
                intent = new Intent(this, BaiTap7.class);
                break;
            default:
                // do nothing
        }
        if( intent != null ) {
            startActivity(intent);
        }
    }

}
