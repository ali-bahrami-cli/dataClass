package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, phoneNumberEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                ContactModel contact = new ContactModel(firstName, lastName, phoneNumber);

                SharedPreferences sharedPreferences = getSharedPreferences("contacts", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();

                String contactsJson = sharedPreferences.getString("contact_list", "");
                Type type = new TypeToken<ArrayList<ContactModel>>() {}.getType();
                ArrayList<ContactModel> contactList = contactsJson.isEmpty() ? new ArrayList<>() : gson.fromJson(contactsJson, type);

                contactList.add(contact);
                String updatedJson = gson.toJson(contactList);
                editor.putString("contact_list", updatedJson);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, ContactModelActivity.class);
                startActivity(intent);
            }
        });
    }
}
