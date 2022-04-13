package com.arpitparekh.jan12androidproject.recyclerView_crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityRecordsBinding;
import com.arpitparekh.jan12androidproject.databinding.BooksDialogBinding;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    private ActivityRecordsBinding binding;
    private ArrayList<Books> list;
    private BooksDialogBinding binding1;
    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecordsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // give layoutmanager to recyclerView

//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//          binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
          binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

        list = new ArrayList<>();

        adapter = new BooksAdapter(list);

        binding.recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        binding1 = BooksDialogBinding.inflate(getLayoutInflater());

        if(item.getItemId()==R.id.action_add){

            // show dialog to add data

            new AlertDialog.Builder(this)
                    .setTitle("Add Data")
                    .setView(binding1.getRoot())
                    .setPositiveButton("Add",(dialogInterface, i) -> {

                        String title = binding1.edtTitle.getText().toString();
                        String des = binding1.edtDes.getText().toString();
                        String price = binding1.edtPrice.getText().toString();

                        Books books = new Books(title,des,Integer.parseInt(price));

                        list.add(books);

                        adapter.notifyDataSetChanged();


                    }).create().show();

        }

        return super.onOptionsItemSelected(item);
    }
}