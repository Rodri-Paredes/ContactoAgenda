package com.example.contactoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText phoneEditText;
    private Button addContactButton;
    private ListView contactListView;

    private ArrayList<Contact> contactList;
    private ArrayAdapter<String> contactAdapter;
    private ArrayList<String> contactNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addContactButton = findViewById(R.id.addContactButton);
        contactListView = findViewById(R.id.contactListView);

        contactList = new ArrayList<>();
        contactNames = new ArrayList<>();
        contactAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactNames);
        contactListView.setAdapter(contactAdapter);

        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
    }

    private void addContact() {
        String name = nameEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if (!name.isEmpty() && !phone.isEmpty()) {
            Contact newContact = new Contact(name, phone);
            contactList.add(newContact);
            contactNames.add(newContact.getName() + " - " + newContact.getPhone());
            contactAdapter.notifyDataSetChanged();
            nameEditText.setText("");
            phoneEditText.setText("");
        }
    }
    // Contact.java
    public class Contact {
        private String name;
        private String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }

}