package com.example.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactModelActivity extends AppCompatActivity {

    private LinearLayout contactsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_model);

        contactsContainer = findViewById(R.id.contactsContainer);

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> finish());

        SharedPreferences sharedPreferences = getSharedPreferences("contacts", MODE_PRIVATE);
        String contactsJson = sharedPreferences.getString("contact_list", "");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ContactModel>>() {}.getType();
        ArrayList<ContactModel> contactList = contactsJson.isEmpty() ? new ArrayList<>() : gson.fromJson(contactsJson, type);

        for (ContactModel contact : contactList) {
            TextView contactView = new TextView(this);
            contactView.setText("Name: " + contact.getFirstName() + "\n"
                    + "Last Name: " + contact.getLastName() + "\n"
                    + "Phone: " + contact.getPhoneNumber() + "\n------------------");
            contactView.setPadding(16, 16, 16, 16);
            contactsContainer.addView(contactView);
        }
    }
}
