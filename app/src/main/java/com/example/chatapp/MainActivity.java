package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatapp.adapter.UserAdapter;
import com.example.chatapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<User> userList = new ArrayList<>();
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
          initLoad();

        adapter = new UserAdapter(userList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });




    }

    private void removeItem(int position) {
        //delete
        userList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    private void initLoad() {

        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("name","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));
        userList.add(new User("hello","2",R.mipmap.ic_launcher));




    }




}