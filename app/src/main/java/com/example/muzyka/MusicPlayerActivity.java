package com.example.muzyka;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MusicPlayerActivity extends AppCompatActivity {

    private Button play;
    private Button next;
    private Button back;
    private Button stop;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        play = findViewById(R.id.PLAY);
        next = findViewById(R.id.NEXT);
        back = findViewById(R.id.BACK);
        stop = findViewById(R.id.STOP);
        seekBar = findViewById(R.id.seekBar);

        //ten kod startuje piosenke
        //mediaPlayer = mediaPlayer.create(this,R.raw.suno);

        //mediaPlayer będzie obsługiwał piosenki pobrane z MainActivity.java
        //mediaPlayer.start();

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });


        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String getSongPath(String songName) {

        songName = getIntent().getStringExtra("songName");



        return songName;
    }
}