package com.thannasorn.assign05_6206021611125;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImageSwitcher extends AppCompatActivity implements View.OnClickListener{
    private android.widget.ImageSwitcher switcher;
    private Button btnPrevious, btnNext;
    private static final int [] IMAGES = {
            R.drawable.arsenal_logo, R.drawable.chelsea_logo,
            R.drawable.leicester_logo, R.drawable.liverpool_logo,
            R.drawable.manchester_city_logo,R.drawable.manchester_united_logo
    };
    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        switcher = (android.widget.ImageSwitcher) findViewById(R.id.imageSwitcher);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener( this);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView( getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams( new android.widget.ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnNext) {
            if (mPosition < IMAGES.length-1) {
                mPosition = mPosition+1;
                // switcher.setImageResource(IMAGES[mPosition]); แสดงพื้นหลังที่กำหนด
                switcher.setBackgroundResource(IMAGES[mPosition]);
                Toast.makeText(ImageSwitcher.this, "Position : "+ mPosition,

                        Toast.LENGTH_SHORT).show();

            }
        }
        else if (id == R.id.btnPrevious) {
            if (mPosition > 0) {
                mPosition = mPosition-1;
                switcher.setBackgroundResource(IMAGES[mPosition]);
                Toast.makeText(ImageSwitcher.this, "Position : "+ mPosition,

                        Toast.LENGTH_SHORT).show();

            }
        }
    }
}