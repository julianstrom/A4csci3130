package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, businessIDField, primBusField, addressField, provTerrField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name2);
        businessIDField = (EditText) findViewById(R.id.businessID2);
        primBusField = (EditText) findViewById(R.id.primBus3);
        addressField = (EditText) findViewById(R.id.address4);
        provTerrField = (EditText) findViewById(R.id.primBus3);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String busID = businessIDField.getText().toString();
        String primBus = primBusField.getText().toString();
        String address = addressField.getText().toString();
        String provTerr = provTerrField.getText().toString();
        Contact person = new Contact(personID, name, busID, primBus, address, provTerr);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
