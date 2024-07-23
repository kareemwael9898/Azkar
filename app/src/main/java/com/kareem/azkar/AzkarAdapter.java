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
                Log.e("onClick", "clicked");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int currentCount = azkar.get(position).getCount();
                        Log.e("wait", "yes");
                        Log.e("wait", "count= "+ currentCount);
                        if (currentCount > 1 ){
                            azkar.get(position).setCount(currentCount - 1);

                            Snackbar snackbar = Snackbar.make(view,"يتبقي " + (currentCount - 1),Snackbar.LENGTH_LONG);
                            View snackbarView =  snackbar.getView();
                            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                            FrameLayout.LayoutParams params = ( (FrameLayout.LayoutParams) snackbarView.getLayoutParams() );
                            params.gravity = Gravity.TOP;
                            snackbarView.setLayoutParams(params);


                            snackbar.show();
                            Toast.makeText(context, "يتبقي " + (currentCount - 1), Toast.LENGTH_LONG).show();
                        }else {
                            TextView txt = (TextView) view;
                            txt.setVisibility(View.GONE);

                            Snackbar snackbar = Snackbar.make(view," إنتهيت ",Snackbar.LENGTH_LONG);
                            snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                            snackbar.show();
                            Toast.makeText(context, " إنتهيت ", Toast.LENGTH_LONG).show();
                        }
                    }
                }, 600);
            }
        });

    }

    @Override
    public int getItemCount() {
        return azkar.size();
    }

    class azkarVH extends RecyclerView.ViewHolder{

        TextView textView;
//        Button textView;

        public azkarVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}
