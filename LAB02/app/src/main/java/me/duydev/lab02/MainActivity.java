package me.duydev.lab02;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private int foreColor = 0;
    private int backColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        switch (item.getItemId()) {
            case R.id.clear:
                builder.setTitle(R.string.thong_bao);
                builder.setMessage(R.string.clear_message);
                builder.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = (EditText) findViewById(R.id.editText);
                        editText.setText("");
                    }
                });
                builder.show();
                break;
            case R.id.settings:
                final int result = 1;
                EditText editText = (EditText) findViewById(R.id.editText);
                Bundle bundle = new Bundle();
                bundle.putFloat( "TextSize", editText.getTextSize() );
                Intent intent = new Intent(this, SettingsActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, result);
                break;
            case R.id.exit:
                builder.setTitle(R.string.thong_bao);
                builder.setMessage(R.string.exit_message);
                builder.setNeutralButton(R.string.Ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // nothing to do
                    }
                });
                builder.show();
                break;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        foreColor = bundle.getInt("ForeColor");
        backColor = bundle.getInt("BackColor");
        float textSize = bundle.getFloat("TextSize");

        String colorArr[] = getResources().getStringArray(R.array.color_name_array);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setTextColor(Color.parseColor( colorArr[foreColor] ));
        editText.setBackgroundColor(Color.parseColor( colorArr[backColor] ));
        editText.setTextSize( textSize );
    }
}
