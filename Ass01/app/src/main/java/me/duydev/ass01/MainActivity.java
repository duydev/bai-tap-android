package me.duydev.ass01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Activity được khởi tạo. onCreate ", Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "Activity bắt đầu chạy. onStart" , Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "Activity bị tạm ngưng. onPause" , Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "Activity bị dừng. onStop" , Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Activity bắt đầu chạy. onStart" , Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Activity bắt đầu chạy lại sau tạm ng.ưng onResume" , Toast.LENGTH_SHORT ).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Activity bắt đầu chạy lại sau khi dừng. onRestart" , Toast.LENGTH_SHORT ).show();
    }
}
