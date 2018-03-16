package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String businessID;
    public  String address;
    public  String primBus;
    public  String provTerr;


    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String businessID, String address, String primBus, String provTerr){
        this.uid = uid;
        this.name = name;
        this.businessID = businessID;
        this.address = address;
        this.primBus = primBus;
        this.provTerr = provTerr;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("businessID", businessID);
        result.put("address", address);
        result.put("primarybusiness", primBus);
        result.put("province/territory", provTerr);

        return result;
    }
}
