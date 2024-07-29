package com.kareem.azkar;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.azkarVH> {

    Context context;    // Context to access resources and activities
    ArrayList<ZekrDM> azkar;    // List of ZekrDM items (Azkar) to be displayed
    MediaPlayer mediaPlayer;    // MediaPlayer instance for playing sound effects

    // Constructor to initialize the adapter with context and data
    public AzkarAdapter(Context context, ArrayList<ZekrDM> azkar) {
        this.context = context;
        this.azkar = azkar;
        mediaPlayer = MediaPlayer.create(context, R.raw.click); // Initialize MediaPlayer with click sound
    }

    @NonNull
    @Override
    public azkarVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item view layout and create a ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new azkarVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull azkarVH holder, int position) {
        // Get the text resource ID and set it on the holder TextView
        int textId = azkar.get(position).getTextId();
        holder.textView.setText(this.context.getResources().getString(textId));
        // Handle click event on the text view
        holder.textView.setOnClickListener(view -> {
            Snackbar snackbar = initCustomSnackbar(view);   // Initialize custom Snackbar
            int currentCount = azkar.get(position).getCount();  // Get current count
            Log.e("onClick", "count= " + currentCount);
            if (currentCount > 1) {
                // Decrement the count and set the Snackbar text
                azkar.get(position).setCount(currentCount - 1);
                snackbar.setText("يتبقي " + (currentCount - 1));
            } else {
                // Play sound, remove item, and update Snackbar text
                mediaPlayer.start();
                view.setClickable(false);
                azkar.remove(position);
                new Handler().postDelayed(() -> {   // Delay for smooth removal and show the ripple effect
                    Log.e("Wait", "remove: " + position);
                    notifyDataSetChanged();
                }, 50);
                snackbar.setText(" إنتهيت ");
            }
            snackbar.show();    // Show the Snackbar
            // Finish the activity if the list is empty and release MediaPlayer
            if (azkar.isEmpty()) {
                mediaPlayer.release();
                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return azkar.size();
    }

    // Method to initialize a custom Snackbar with specific layout parameters
    private Snackbar initCustomSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT); // Create a Snackbar with no text
        // Get the Snackbar view and TextView
        View snackbarView = snackbar.getView();
        TextView snackbrTextView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);

        snackbrTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);   // Align the text to center
        // Get layout parameters
        FrameLayout.LayoutParams params = ((FrameLayout.LayoutParams) snackbarView.getLayoutParams());
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;   // Set Snackbar position to top center
        snackbarView.setLayoutParams(params);   // Apply layout parameters
        return snackbar;
    }

    // ViewHolder class to hold the view for each item in the RecyclerView
    static class azkarVH extends RecyclerView.ViewHolder {
        TextView textView;

        public azkarVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}
