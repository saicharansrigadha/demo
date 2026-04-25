package com.example.firebaseconnectiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import firebase.com.protolitewrapper.BuildConfig;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
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

        button.setOnClickListener(view -> {
            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
        });
        Log.d("FLAVOR", BuildConfig.FLAVOR);    }
}