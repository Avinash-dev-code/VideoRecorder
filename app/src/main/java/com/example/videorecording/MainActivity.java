package com.example.videorecording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button r1,p1;
    private VideoView video;
    private int activity_start_camera=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(Button)findViewById(R.id.recordbutton);
        p1=(Button)findViewById(R.id.playbutton);
        video=(VideoView)findViewById(R.id.Videoview);


        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent,
                            activity_start_camera);
                }


            }
        });





        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   video.start();
            }
        });


    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == activity_start_camera && resultCode == RESULT_OK) {
            Uri videouri = data.getData();
            video.setVideoURI(videouri);
        }
    }
}
