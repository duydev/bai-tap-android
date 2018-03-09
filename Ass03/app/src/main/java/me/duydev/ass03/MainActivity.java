package me.duydev.ass03;

import android.graphics.Color;
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

    public void changeColor(View view){
        TextView textView = (TextView) findViewById(R.id.textView);
        switch ( view.getId() ) {
            case R.id.btnRed:
                textView.setTextColor(getResources().getColor(R.color.colorRed));
                break;
            case R.id.btnGreen:
                textView.setTextColor(getResources().getColor(R.color.colorGreen));
                break;
            case R.id.btnYellow:
                textView.setTextColor(getResources().getColor(R.color.colorYellow));
                break;
            default:
                // nothing to do
        }
    }

}
