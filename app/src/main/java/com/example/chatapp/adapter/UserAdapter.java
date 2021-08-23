package com.example.chatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewAdapter> {
    private final List<User> userList;
    final Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new MyViewAdapter(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewAdapter holder, int position) {
        holder.textView.setText(userList.get(position).getName());
        holder.textView2.setText(userList.get(position).getAge());
        holder.imageView.setImageResource(userList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewAdapter extends RecyclerView.ViewHolder {
        ImageView imageView, delete;
        TextView textView, textView2;
        public MyViewAdapter(@NonNull View itemView, final OnItemClickListener listener ) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
            delete = itemView.findViewById(R.id.imageView2);


            delete.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onDeleteClick(position);

                }
            });
        }
    }
}
