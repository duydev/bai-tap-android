package me.duydev.lab04;

import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public void insert(String name, String address, String type ){
        database.getReference("items").setValue(});
    }


}
