package me.duydev.baitapbai4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BaiTap2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap2);
    }

    public void setColor(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdoColor);

        switch ( radioGroup.getCheckedRadioButtonId() ) {
            case R.id.rdoWhite:
                editText.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.rdoBlue:
                editText.setTextColor(getResources().getColor(R.color.blue));
                break;
            default:
                // case red
                editText.setTextColor(getResources().getColor(R.color.red));

        }
    }

    public void clearColor(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setTextColor(getResources().getColor(R.color.black));
    }
}
