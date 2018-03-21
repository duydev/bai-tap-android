package me.duydev.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MeowBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meow_booking);
    }

    public void booking(View view) {
        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtFromDate = (EditText) findViewById(R.id.txtFromDate);
        EditText txtToDate = (EditText) findViewById(R.id.txtToDate);

        Intent intent = new Intent(this, ListBookingActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("name", txtName.getText().toString() );
        bundle.putString("fromDate", txtFromDate.getText().toString() );
        bundle.putString("toDate", txtToDate.getText().toString() );
        intent.putExtras( bundle );
        startActivity(intent);
    }
}
