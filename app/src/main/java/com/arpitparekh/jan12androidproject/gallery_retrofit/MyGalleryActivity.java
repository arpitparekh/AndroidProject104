package com.arpitparekh.jan12androidproject.gallery_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.arpitparekh.jan12androidproject.databinding.ActivityMyGalleryBinding;
import com.arpitparekh.jan12androidproject.gallery_retrofit.pojo.DataItem;
import com.arpitparekh.jan12androidproject.gallery_retrofit.pojo.Gallery;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyGalleryActivity extends AppCompatActivity {

    private ActivityMyGalleryBinding binding;
    private List<DataItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewGallery.setLayoutManager(new GridLayoutManager(this,2));

        list = new ArrayList<>();

        binding.btnSend.setOnClickListener(view -> {

            String xyz = binding.edtXYZ.getText().toString();

            Call<Gallery> call = GalleryHelper.getApiObject().getImages("I4p56ZWCxy5TWSdSFEzQm47bxvhKCQuf",xyz,100);

            call.enqueue(new Callback<Gallery>() {
                @Override
                public void onResponse(Call<Gallery> call, Response<Gallery> response) {
//                    Log.i("response",response.body().toString());

                        Gallery gallery = response.body();

                        list = gallery.getData();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                GalleryAdapter adapter = new GalleryAdapter(list);
                                binding.recyclerViewGallery.setAdapter(adapter);

                            }
                        });


                }

                @Override
                public void onFailure(Call<Gallery> call, Throwable t) {

                }
            });
        });
    }
}