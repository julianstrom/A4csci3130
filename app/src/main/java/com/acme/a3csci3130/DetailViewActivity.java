package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DetailViewActivity extends Activity {

    private EditText nameField, businessIDField, primBusField, addressField, provTerrField;
    Contact receivedPersonInfo;

    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");



        nameField = (EditText) findViewById(R.id.name2);
        businessIDField = (EditText) findViewById(R.id.businessID2);
        primBusField = (EditText) findViewById(R.id.primBus3);
        addressField = (EditText)findViewById(R.id.address4);
        provTerrField = (EditText) findViewById(R.id.provTerr2);


        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            businessIDField.setText(receivedPersonInfo.businessID);
            primBusField.setText(receivedPersonInfo.primBus);
            addressField.setText(receivedPersonInfo.address);
            provTerrField.setText(receivedPersonInfo.provTerr);

        }
    }




    public void updateContact(View v){

        //retrieves new values for each field
        String name =  nameField.getText().toString();
        String businessID = businessIDField.getText().toString();
        String primBus = primBusField.getText().toString();
        String address = addressField.getText().toString();
        String provTerr = provTerrField.getText().toString();



        Contact newbusiness = new Contact(receivedPersonInfo.uid, name, businessID, primBus, address, provTerr);

        //Update
        appState.firebaseReference.child(receivedPersonInfo.uid).child(receivedPersonInfo.uid).setValue(newbusiness);

    }

    public void eraseContact(View v)
    {
        //removes current user that is selected
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();

        finish();
    }
}
