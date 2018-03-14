package me.duydev.lab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void showMe(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String msg = editText.getText().toString();
        msg = "Xin chào, " + msg;
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
