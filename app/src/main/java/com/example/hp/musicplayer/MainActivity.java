package com.example.hp.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer= MediaPlayer.create(this,R.raw.testaudio);

        //get context from Audio service

        audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int myMaxVolume =audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        //Set context to seekbar - volumeRocker

        SeekBar volumeRocker =findViewById(R.id.seekBar);
        volumeRocker.setMax(myMaxVolume);
        volumeRocker.setProgress(myCurrentVolume);

        //set a listener on VolumeRocker

        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager .STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void playMe(View view) {
        mediaPlayer.start();
    }

    public void pauseMe(View view) {
        mediaPlayer.pause();
    }
}
