package me.duydev.ass02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setFontSize20(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTextSize(20);
    }

    public void setFontSize40(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTextSize(40);
    }

}
