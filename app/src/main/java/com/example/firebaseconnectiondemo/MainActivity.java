package com.example.firebaseconnectiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore = FirebaseFirestore.getInstance();

        User user = new User();
        user.setId(1);
        user.setName("Saicharan S");
        user.setAge(25);

        firestore.collection("User Details")
                .document(String.valueOf(user.getId())) //store data in 1 document`
                .set(user)
                .addOnSuccessListener(documentReference -> {
                    // Data added successfully
                })
                .addOnFailureListener(e -> {
                    e.printStackTrace();
                });
    }
}