package com.example.miniprojetand;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

///import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HotelDetailActivity extends AppCompatActivity {

    private ImageView hotelImageView;
    private TextView hotelNameTextView, hotelLocationTextView, hotelDescriptionTextView;
    private TextView hotelContactTextView, hotelPriceTextView;
    private Button reserveButton;

    private DatabaseReference hotelRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        hotelImageView = findViewById(R.id.hotelImageView);
        hotelNameTextView = findViewById(R.id.hotelNameTextView);
        hotelLocationTextView = findViewById(R.id.hotelLocationTextView);
        hotelDescriptionTextView = findViewById(R.id.hotelDescriptionTextView);
        hotelContactTextView = findViewById(R.id.hotelContactTextView);
        hotelPriceTextView = findViewById(R.id.hotelPriceTextView);
        reserveButton = findViewById(R.id.reserveButton);

        String hotelId = getIntent().getStringExtra("hotelId"); // Passed from previous activity
        hotelRef = FirebaseDatabase.getInstance().getReference("hotels").child(hotelId);

        loadHotelDetails();
    }

    private void loadHotelDetails() {
        hotelRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue(String.class);
                String location = snapshot.child("location").getValue(String.class);
                String description = snapshot.child("description").getValue(String.class);
                String contact = snapshot.child("contact").getValue(String.class);
                String price = snapshot.child("price").getValue(String.class);
                String imageUrl = snapshot.child("photos").child("0").getValue(String.class);

                hotelNameTextView.setText(name);
                hotelLocationTextView.setText(location);
                hotelDescriptionTextView.setText(description);
                hotelContactTextView.setText(contact);
                hotelPriceTextView.setText(price + " DT");

                // Load image with Glide
                //Glide.with(HotelDetailActivity.this).load(imageUrl).into(hotelImageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }
}