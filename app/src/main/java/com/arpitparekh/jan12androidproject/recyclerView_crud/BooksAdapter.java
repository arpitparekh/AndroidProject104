package com.arpitparekh.jan12androidproject.recyclerView_crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.jan12androidproject.databinding.BooksRowItemBinding;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> implements Filterable {

    private ArrayList<Books> list;
    ArrayList<Books> newList;
    private OnItemClickListener listener;
    ArrayList<Books> filterList = new ArrayList<>();  // empty list
    Context context;

    BooksAdapter(ArrayList<Books> list,OnItemClickListener listener){
        this.list = list;
        newList = list;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {


                if(charSequence.toString().isEmpty()){

                    filterList = newList;

                }else{

                    filterList = new ArrayList<>();

                    for(int i=0;i<newList.size();i++){

                        Books b = newList.get(i);

                        if(b.title.toLowerCase().contains(charSequence.toString().toLowerCase())){

                            filterList.add(b);
                        }

                    }

                }

                FilterResults results = new FilterResults();
                results.values = filterList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                list = (ArrayList<Books>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    interface OnItemClickListener{
        void onClick(int position);  // abstract method
        void onImageClick(int position, ImageView ivMenu);
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // set layout for each and every item
        context = parent.getContext();
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

        holder.itemView.setOnClickListener(view -> {

            listener.onClick(position);

        });

        holder.binding.ivMenu.setOnClickListener(view -> {

            listener.onImageClick(position,holder.binding.ivMenu);

        });

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
