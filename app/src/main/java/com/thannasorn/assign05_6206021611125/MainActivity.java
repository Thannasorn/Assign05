package com.thannasorn.assign05_6206021611125;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnText, btnImage, btnAdapter, btnStack, btnScroll, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnText = (Button) findViewById(R.id.btnText);
        btnImage = (Button) findViewById(R.id.btnImage);
        btnAdapter = (Button) findViewById(R.id.btnAdapter);
        btnStack = (Button) findViewById(R.id.btnStack);
        btnScroll = (Button) findViewById(R.id.btnScroll);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnText.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnAdapter.setOnClickListener(this);
        btnStack.setOnClickListener(this);
        btnScroll.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btnText){
            Intent launchText = new Intent(MainActivity.this, TextSwitcher.class);
            startActivity(launchText);
        }
        else if(id == R.id.btnImage){
            Intent launchImage = new Intent(MainActivity.this, ImageSwitcher.class);
            startActivity(launchImage);
        }
        else if(id == R.id.btnAdapter){
            Intent launchAdapter = new Intent(MainActivity.this, AdapterView.class);
            startActivity(launchAdapter);
        }
        else if(id == R.id.btnStack){
            Intent launchStack = new Intent(MainActivity.this, Stack.class);
            startActivity(launchStack);
        }
        else if(id == R.id.btnScroll){
            Intent launchScroll = new Intent(MainActivity.this, Scroll.class);
            startActivity(launchScroll);
        }
        else if (id == R.id.btnExit){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to leave ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
    }
}