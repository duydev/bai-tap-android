package me.duydev.baitapbai4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BaiTap7 extends AppCompatActivity {

    private String calcDisplay;
    private TextView calcView;
    private String operator;
    private float tempNumber;
    private boolean isClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap7);

        calcView = (TextView) findViewById(R.id.calcView);

        // init calculator
        initCalc();
        printDisplay();
    }

    private void initCalc() {
        calcDisplay = "0";
        tempNumber = 0;
        isClear = false;
    }

    public void btnPress(View view) {
        int display_length = calcDisplay.length();

        switch (view.getId()) {
            case R.id.calcNum0:
            case R.id.calcNum1:
            case R.id.calcNum2:
            case R.id.calcNum3:
            case R.id.calcNum4:
            case R.id.calcNum5:
            case R.id.calcNum6:
            case R.id.calcNum7:
            case R.id.calcNum8:
            case R.id.calcNum9:
            case R.id.calcDot:
                if ((view.getId() == R.id.calcDot && calcDisplay.contains(".")) || display_length > 8) {
                    // case press dot multiply or case length > 8 then stop here!!!
                    return;
                }

                if (calcDisplay.compareTo("0") == 0 || isClear) {
                    calcDisplay = "";
                    isClear = false;
                }

                calcDisplay += ((Button) view).getText().toString();
                break;
            case R.id.calcClear:
                initCalc();
                break;
            case R.id.calcDel:
                calcDisplay = calcDisplay.substring(0, display_length - 1);
                if (display_length - 1 == 0) {
                    calcDisplay = "0";
                }
                break;
            case R.id.calcPlus:
            case R.id.calcMinus:
            case R.id.calcMultiply:
            case R.id.calcDevide:
            default: // case button equal
                String currOperator = ((Button) view).getText().toString();
                float currNumber = Float.parseFloat(calcDisplay);

                if( operator != null ) {
                    switch (operator) {
                        case "+":
                            tempNumber += currNumber;
                            break;
                        case "-":
                            tempNumber -= currNumber;
                            break;
                        case "x":
                            tempNumber *= currNumber;
                            break;
                        case "/":
                            if (currNumber == 0.0) {
                                initCalc();
                                calcView.setText("Error: Cannot devide to zero.");
                                return;
                            }

                            tempNumber /= currNumber;
                            break;
                        default:
                            // nothing to do
                    }
                } else {
                    tempNumber = currNumber;
                }

                if( currOperator.compareTo("=") == 0 ) {

                    currOperator = null;
                }

                calcDisplay = String.valueOf(tempNumber);
                operator = currOperator;
                isClear = true;
                break;
        }

        printDisplay();
    }

    private void printDisplay() {
        calcView.setText(calcDisplay);
    }

}
