package com.kareem.azkar;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.azkarVH> {

    Context context;
    ArrayList<ZekrDM> azkar;

    public AzkarAdapter(Context context, ArrayList<ZekrDM> azkar) {
        this.context = context;
        this.azkar = azkar;
    }

    @NonNull
    @Override
    public azkarVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new azkarVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull azkarVH holder, int position) {
        int textId = azkar.get(position).getTextId();
        holder.textView.setText( this.context.getResources().getString(textId) );
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = initCustomSnackbar(view);
                int currentCount = azkar.get(position).getCount();
                Log.e("onClick", "count= "+ currentCount);
                if (currentCount > 1 ){
                    azkar.get(position).setCount(currentCount - 1);
                    snackbar.setText("يتبقي " + (currentCount - 1));
                }else {
                    view.setClickable(false);
                    new Handler().postDelayed( () -> {
                        Log.e("Wait", "remove: "+position );
                        azkar.remove(position);
                        notifyDataSetChanged();
                    } ,300);
                    snackbar.setText(" إنتهيت ");
                }
                snackbar.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return azkar.size();
    }

    private Snackbar initCustomSnackbar(View view){
        Snackbar snackbar = Snackbar.make(view,"",Snackbar.LENGTH_SHORT);
        View snackbarView =  snackbar.getView();
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        FrameLayout.LayoutParams params = ( (FrameLayout.LayoutParams) snackbarView.getLayoutParams() );
        params.gravity = Gravity.TOP;
        snackbarView.setLayoutParams(params);
        return snackbar;
    }

    static class azkarVH extends RecyclerView.ViewHolder{
        TextView textView;
        public azkarVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}
