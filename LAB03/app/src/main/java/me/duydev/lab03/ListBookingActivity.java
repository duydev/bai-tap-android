package me.duydev.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_booking);

        Bundle bundle = getIntent().getExtras();

        TextView viewName = (TextView) findViewById(R.id.viewName);
        viewName.setText( bundle.getString("name") );

        TextView viewFromDate = (TextView) findViewById(R.id.viewFromDate);
        viewFromDate.setText( bundle.getString("fromDate") );

        TextView viewToDate = (TextView) findViewById(R.id.viewToDate);
        viewToDate.setText( bundle.getString("toDate") );

    }
}
