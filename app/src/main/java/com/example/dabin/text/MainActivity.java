package com.example.dabin.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;

    private PublishDialog mPublishDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPublishDialog==null){
                    mPublishDialog=new PublishDialog(MainActivity.this);
                    mPublishDialog.setVedioClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "显示视频", Toast.LENGTH_SHORT).show();
                        }
                    });


                mPublishDialog.setDanpinClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "显示单品", Toast.LENGTH_SHORT).show();
                    }
                });
                mPublishDialog.setPhotoClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "显示照片", Toast.LENGTH_SHORT).show();
                    }
                });
                }
                mPublishDialog.show();

            }
        });
    }
}
