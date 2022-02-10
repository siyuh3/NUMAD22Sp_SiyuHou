package com.example.numad22sp_siyuhou;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private final ArrayList<ItemCard> itemList;
    private ItemClickListener listener;
    public ViewAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }


    public ViewAdapter(ArrayList<ItemCard> itemList, ItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }


    public void setOnItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 当RecyclerView需要我们提供类型为viewType的新ViewHolder时，会回调这个方法。
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCard currentItem = itemList.get(position);
        holder.urlName.setText(currentItem.getUrlName());
        holder.url.setText(currentItem.getUrl());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView urlName;
        public TextView url;

        public ViewHolder(@NonNull View itemView) {
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
}
