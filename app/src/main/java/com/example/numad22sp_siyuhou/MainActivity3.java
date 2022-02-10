

package com.example.numad22sp_siyuhou;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList<ItemCard> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ItemClickListener listener;

    private static final String NAME_KEY = "siyuhou.NAME_KEY";
    private static final String URL_KEY = "hou.siy@northeastern.LINK_KEY";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
    public static final int ADD_REQUEST = 1;

    // saveInstanceState 为保存数据状态
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init(savedInstanceState);
        FloatingActionButton fb = findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity3.this, InputActivity.class);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        int size = itemList == null ? 0 : itemList.size();
        outState.putInt(NUMBER_OF_ITEMS, size);

        for (int i = 0; i < size; i++) {
            outState.putString(NAME_KEY + i, itemList.get(i).getUrlName());
            outState.putString(URL_KEY + i, itemList.get(i).getUrl());
        }
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(InputActivity.EXTRA_NAME);
            String link = data.getStringExtra(InputActivity.EXTRA_URL);

            //Save user input
            itemList.add(new ItemCard(name, link));
            viewAdapter.notifyItemInserted(itemList.size()-1);
            Snackbar.make(findViewById(R.id.recycler_view), "Url saved successfully!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        } else {
            Snackbar.make(findViewById(R.id.recycler_view), "Url not saved!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }


    private void init(Bundle saveInstanceState){
        initItemData(saveInstanceState);
        createRecyclerView();
    }


    private void initItemData(Bundle saveInstanceState) {
        if(saveInstanceState != null && saveInstanceState.containsKey(NUMBER_OF_ITEMS)){
            if(itemList == null || itemList.size() == 0){
                int size = saveInstanceState.getInt(NUMBER_OF_ITEMS);
                for(int i = 0; i < size; i++){
                    String name = saveInstanceState.getString(NAME_KEY + i).trim();
                    String url = saveInstanceState.getString(URL_KEY + i).trim();
                    ItemCard itemCard = new ItemCard(name, url);
                    itemList.add(itemCard);
                }
            }
        }
    }


    private void createRecyclerView(){
        setOnClickListener();
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        viewAdapter = new ViewAdapter(itemList,listener);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    private void setOnClickListener() {
        listener = new ItemClickListener(){
            @Override
            public void onClick(int position) {
                String url = itemList.get(position).getUrl();
                Uri openedUrl = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, openedUrl);
                startActivity(intent);
            }
        };
    }
}