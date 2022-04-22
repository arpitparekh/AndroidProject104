package com.arpitparekh.jan12androidproject.recyclerView_crud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.databinding.ActivityRecordsBinding;
import com.arpitparekh.jan12androidproject.databinding.BooksDialogBinding;

import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity implements BooksAdapter.OnItemClickListener{

    private ActivityRecordsBinding binding;
    private ArrayList<Books> list;
    private BooksDialogBinding binding1;
    private BooksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecordsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        // give layoutmanager to recyclerView

//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//          binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

        list.add(new Books("abc","xyz",1212));
        list.add(new Books("abc2","xyz1",12122));
        list.add(new Books("abc3","xyz2",12125));

        adapter = new BooksAdapter(list,this);

        binding.recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView view = (SearchView) item.getActionView();

        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }
        });

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

    @Override
    public void onClick(int position) {

        Books books = list.get(position);


    }

    @Override
    public void onImageClick(int position, ImageView ivMenu) {

        Books b = list.get(position);

        PopupMenu pop = new PopupMenu(this,ivMenu);

        pop.getMenuInflater().inflate(R.menu.update_delete_menu,pop.getMenu());

        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getItemId()==R.id.action_update){

                  // do update code using dialog...

                }else if(menuItem.getItemId()==R.id.action_delete){

                    // delete

                    list.remove(position);

                    adapter.notifyDataSetChanged();
                }

                return false;
            }
        });

        pop.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==101){

                Books b = (Books) data.getSerializableExtra("object");


            }

    }
}