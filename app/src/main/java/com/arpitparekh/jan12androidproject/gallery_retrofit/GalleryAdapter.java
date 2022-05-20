package com.arpitparekh.jan12androidproject.gallery_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.jan12androidproject.databinding.GalleryRowItemBinding;
import com.arpitparekh.jan12androidproject.gallery_retrofit.pojo.DataItem;
import com.arpitparekh.jan12androidproject.gallery_retrofit.pojo.Gallery;
import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    List<DataItem> list;
    Context context;

    GalleryAdapter(List<DataItem> list){
        this.list = list;
    }

    @NonNull
    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        GalleryRowItemBinding binding = GalleryRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new GalleryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryViewHolder holder, int position) {
        DataItem data = list.get(position);

        Glide.with(context).load(data.getPath()).into(holder.binding.ivGallery);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        GalleryRowItemBinding binding;
        public GalleryViewHolder(@NonNull GalleryRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
