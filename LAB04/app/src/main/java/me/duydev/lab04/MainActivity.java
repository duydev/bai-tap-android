package me.duydev.lab04;

import android.app.TabActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TabActivity {

    Cursor cursorRestaurant = null;
    RestaurantAdapter restaurantAdapter = null;

    RestaurantHelper restaurantHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantHelper = new RestaurantHelper(this);

        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(onItemClickListener);

        // Get Data from DB
        cursorRestaurant = restaurantHelper.getAll();
        startManagingCursor(cursorRestaurant);
        restaurantAdapter = new RestaurantAdapter( cursorRestaurant );
        listView.setAdapter( restaurantAdapter );

        TabHost.TabSpec spec = getTabHost().newTabSpec("tag1");
        spec.setContent(R.id.listView);
        spec.setIndicator("List", getResources().getDrawable(R.drawable.ic_launcher_background));
        getTabHost().addTab(spec);

        spec = getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.layoutTable);
        spec.setIndicator("Detail", getResources().getDrawable(R.drawable.ic_launcher_background));
        getTabHost().addTab(spec);

        getTabHost().setCurrentTab(0);
    }

    @Override
    protected void onDestroy() {
        restaurantHelper.close();
        super.onDestroy();
    }

    public void save(View view) {
        Restaurant restaurant = new Restaurant();

        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtAddress = (EditText) findViewById(R.id.txtAddress);
        RadioGroup rdoType = (RadioGroup) findViewById(R.id.rdoType);

        restaurant.setName(txtName.getText().toString());
        restaurant.setAddress(txtAddress.getText().toString());
        switch (rdoType.getCheckedRadioButtonId()) {
            case R.id.rdoSitDown:
                restaurant.setType(getResources().getString(R.string.sit_down));
                break;
            case R.id.rdoDelivery:
                restaurant.setType(getResources().getString(R.string.delivery));
                break;
            default:
                // case Take out
                restaurant.setType(getResources().getString(R.string.take_out));
        }

        restaurantHelper.insert(restaurant.getName(), restaurant.getAddress(), restaurant.getType());

        cursorRestaurant.requery();

        /* For Test */
//        restaurant.printTest(this);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            cursorRestaurant.moveToPosition(i);

            EditText txtName = (EditText) findViewById(R.id.txtName);
            txtName.setText(restaurantHelper.getName(cursorRestaurant));

            EditText txtAddress = (EditText) findViewById(R.id.txtAddress);
            txtAddress.setText(restaurantHelper.getAddress(cursorRestaurant));

            RadioGroup rdoType = (RadioGroup) findViewById(R.id.rdoType);
            String type = restaurantHelper.getType(cursorRestaurant);
            if( type.equals( getResources().getString( R.string.take_out ) ) ) {
                rdoType.check(R.id.rdoTakeOut);
            } else if( type.equals( getResources().getString( R.string.sit_down ) ) ) {
                rdoType.check(R.id.rdoSitDown);
            } else {
                rdoType.check(R.id.rdoDelivery);
            }

            getTabHost().setCurrentTab(1);
        }
    };

    public class RestaurantAdapter extends CursorAdapter {

        public RestaurantAdapter(Cursor c) {
            super(MainActivity.this, c);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            View row = view;
            ((TextView)row.findViewById(R.id.rowTitle)).setText(restaurantHelper.getName(cursor));
            ((TextView)row.findViewById(R.id.rowSubtitle)).setText(restaurantHelper.getAddress(cursor));
            ImageView icon  = (ImageView) row.findViewById(R.id.rowIcon);

            String type = restaurantHelper.getType(cursor);
            switch (type) {
                case "Sit down":
                    icon.setImageResource(R.drawable.ic_launcher_background);
                    break;
                case "Delivery":
                    icon.setImageResource(R.drawable.ic_launcher_background);
                    break;
                default:
                    // case Take out
                    icon.setImageResource(R.drawable.ic_launcher_background);
            }
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.list_row, viewGroup, false);
            return row;
        }
    }
}
