package com.arpitparekh.jan12androidproject.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.arpitparekh.jan12androidproject.databinding.ActivityPlaySongBinding;

public class PlaySongActivity extends AppCompatActivity {

    private ActivityPlaySongBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaySongBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPlaySong.setOnClickListener(view -> {

            Intent i = new Intent(this,SongService.class);
            startService(i);

        });

        binding.btnDownloadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(PlaySongActivity.this,DownloadFileService.class);
                startService(i);
            }
        });

    }
}