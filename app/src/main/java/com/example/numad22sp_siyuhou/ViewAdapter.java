package com.example.numad22sp_siyuhou;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<ItemCard> itemList;
    private ItemClickListener listener;
    public ViewAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 当RecyclerView需要我们提供类型为viewType的新ViewHolder时，会回调这个方法。
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view, listener);
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
}
