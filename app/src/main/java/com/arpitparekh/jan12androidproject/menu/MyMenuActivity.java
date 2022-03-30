package com.arpitparekh.jan12androidproject.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.arpitparekh.jan12androidproject.R;
import com.arpitparekh.jan12androidproject.cordinator_layout.MyCoActivity;
import com.arpitparekh.jan12androidproject.databinding.ActivityMyMenuBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyMenuActivity extends AppCompatActivity {

    private ActivityMyMenuBinding binding;
    private Button b;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        registerForContextMenu(binding.btnContext);
        registerForContextMenu(binding.btnPopUp);
        // 3 types of menu

        // option menu // actionBar
        // popup menu  // click
        // context menu  // long click

        binding.btnPopUp.setOnClickListener(view -> {

            PopupMenu pop = new PopupMenu(MyMenuActivity.this,view);

            pop.getMenuInflater().inflate(R.menu.my_menu,pop.getMenu());

            pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    itemSwitch(item);
                    return false;
                }
            });

            pop.show();

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        itemSwitch(item);

        return super.onOptionsItemSelected(item);
    }

    void checkButton(){
        if(b!=null){b.setVisibility(View.GONE);}
    }
    void checkImgae(){
        if(iv!=null){iv.setVisibility(View.GONE);}
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        itemSwitch(item);

        return super.onContextItemSelected(item);
    }

    void itemSwitch(MenuItem item){

        switch (item.getItemId()){

            case R.id.item1:
                startActivity(new Intent(this, MyCoActivity.class));
                break;
            case R.id.item2:
                Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show();
                checkButton();
                checkImgae();

                break;
            case R.id.item3:
                Snackbar.make(binding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                binding.getRoot().setBackgroundColor(Color.GREEN);
                checkButton();
                checkImgae();
                break;
            case R.id.item5:

                b= new Button(this);
                b.setText("Programmatically Add Button");
                binding.getRoot().addView(b);

                checkImgae();
                break;

            case R.id.item6:

                iv = new ImageView(this);
                iv.setBackgroundResource(R.drawable.banner);
                binding.getRoot().addView(iv);

                checkButton();

                break;
            case R.id.item7:

                System.exit(0);
                break;
        }

    }

}