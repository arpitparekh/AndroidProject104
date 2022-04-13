package com.arpitparekh.jan12androidproject.recyclerView_crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.jan12androidproject.databinding.BooksRowItemBinding;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private ArrayList<Books> list;

    BooksAdapter(ArrayList<Books> list){
        this.list = list;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // set layout for each and every item
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BooksRowItemBinding binding = BooksRowItemBinding.inflate(inflater,parent,false);
        BooksViewHolder holder = new BooksViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {

        // put data inside each and every item

        Books books = list.get(position);

        holder.binding.setObj(books);

    }

    @Override
    public int getItemCount() {

        // return total no of items

        return list.size();
    }

    public class BooksViewHolder extends RecyclerView.ViewHolder {

        BooksRowItemBinding binding;

        public BooksViewHolder(@NonNull BooksRowItemBinding binding) {
            super(binding.getRoot());  // call a parent class constructor
            this.binding = binding;
        }
    }

}
