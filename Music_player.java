package com.example.hi.android_project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music_player extends AppCompatActivity {

    Button b1,b2,b3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        b1=(Button)findViewById(R.id.button10);    //back
        b2=(Button)findViewById(R.id.button11);    //play
        b3=(Button)findViewById(R.id.button12);    //pause
        mp=MediaPlayer.create(this,R.raw.m);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Music_player.this,Menu.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.start();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.pause();

            }
        });
    }
}
