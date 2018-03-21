package me.duydev.lab04;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Restaurant> restaurantList = new ArrayList<Restaurant>();
    private RestaurantAdapter restaurantArrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        restaurantArrayAdapter = new RestaurantAdapter();
        listView.setAdapter( restaurantArrayAdapter );
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

        restaurantArrayAdapter.add( restaurant );

        /* For Test */
        restaurant.printTest(this);
    }

    public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

        public RestaurantAdapter() {
            super(MainActivity.this, android.R.layout.simple_list_item_1, restaurantList );
        }

        public RestaurantAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View row = convertView;
            if( row == null ) {
                LayoutInflater layoutInflater = getLayoutInflater();
                row = layoutInflater.inflate(R.layout.list_row, null);
            }

            Restaurant restaurant = restaurantList.get(position);

            TextView title = (TextView) row.findViewById(R.id.rowTitle);
            title.setText(restaurant.getName());

            TextView subtitle = (TextView) row.findViewById(R.id.rowTitle);
            subtitle.setText(restaurant.getAddress());

            ImageView icon = (ImageView) row.findViewById(R.id.rowIcon);
            String type = restaurant.getType();
            if( type.equals( getResources().getString( R.string.take_out ) ) ) {
                icon.setImageResource(R.drawable.ic_launcher_background);
            } else if( type.equals( getResources().getString( R.string.sit_down ) ) ) {
                icon.setImageResource(R.drawable.ic_launcher_background);
            } else {
                icon.setImageResource(R.drawable.ic_launcher_background);
            }

            return row;
        }
    }
}
