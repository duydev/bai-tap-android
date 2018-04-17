package me.duydev.baitapbai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Cau1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);

        alert("Activity onCreate!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        alert("Activity onDestroy!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        alert("Activity onStart!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        alert("Activity onStop!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        alert("Activity onPause!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        alert("Activity onRestart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        alert("Activity onResume!");
    }


    private void alert(String msg) {
        Toast.makeText(Cau1Activity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
