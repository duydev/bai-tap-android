package me.duydev.baitapbai6;

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

    public void openActivity(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnCau2:
                intent = new Intent(this, Cau2AActivity.class);
                break;
            default:
                // cau 1
                intent = new Intent(this, Cau1AActivity.class);
        }
        startActivity(intent);
    }

}
