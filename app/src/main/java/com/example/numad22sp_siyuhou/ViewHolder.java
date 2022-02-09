package com.example.numad22sp_siyuhou;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView urlName;
    public TextView url;
    public ViewHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        urlName = itemView.findViewById(R.id.url_name);
        url = itemView.findViewById(R.id.url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onClick(position);
                    }
                }
            }
        });
    }
}
