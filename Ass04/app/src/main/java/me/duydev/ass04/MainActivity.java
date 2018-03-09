package me.duydev.ass04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int num_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.num_click = 0;
        this.setNumClick();
    }

    public void increaseClick(View view) {
        this.num_click++;
        this.setNumClick();
    }

    private void setNumClick() {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.format(getResources().getString(R.string.click_times), this.num_click));
    }
}
