package com.example.miniprojetand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private List<Hotel> hotelList;
    private List<Hotel> filteredHotelList;

    public HotelAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
        this.filteredHotelList = hotelList; // Initially, both lists are the same
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item_hotel layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        // Get hotel data
        Hotel hotel = filteredHotelList.get(position);

        // Set text for hotel details
        holder.nameTextView.setText(hotel.getName());
        holder.locationTextView.setText(hotel.getLocation());
        holder.priceTextView.setText(hotel.getPrice());

        // Load the main image using Glide (for the URL in mainImageUrl)
        Glide.with(holder.itemView.getContext())
                .load(hotel.getMainImageUrl()) // Load the main image from Firebase URL
                .into(holder.hotelImageView);
    }

    @Override
    public int getItemCount() {
        return filteredHotelList.size();
    }

    // Filtering function for search
    public void filter(String query) {
        if (query.isEmpty()) {
            filteredHotelList = hotelList;
        } else {
            filteredHotelList.clear();
            for (Hotel hotel : hotelList) {
                if (hotel.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredHotelList.add(hotel);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImageView;  // ImageView to display the hotel image
        TextView nameTextView, locationTextView, priceTextView;

        public HotelViewHolder(View itemView) {
            super(itemView);
            hotelImageView = itemView.findViewById(R.id.hotelImageView);  // Make sure this ID matches your item layout
            nameTextView = itemView.findViewById(R.id.hotelNameTextView);  // Correct ID for name
            locationTextView = itemView.findViewById(R.id.hotelLocationTextView);  // Correct ID for location
            priceTextView = itemView.findViewById(R.id.hotelPriceTextView);  // Correct ID for price
        }
    }
}
