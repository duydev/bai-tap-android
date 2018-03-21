package me.duydev.lab04;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by duytn on 21/03/2018.
 */

public class Restaurant {

    private String name;
    private String address;
    private String type;

    public Restaurant() {
        this.name = "";
        this.address = "";
        this.type = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String result = this.name;
        return result;
    }

    public void printTest(Context context) {
        String msg = "Name: " + this.name + "\nAddress: " + this.address + "\nType: " + this.type;
        Toast.makeText( context, msg, Toast.LENGTH_LONG ).show();
    }
}
