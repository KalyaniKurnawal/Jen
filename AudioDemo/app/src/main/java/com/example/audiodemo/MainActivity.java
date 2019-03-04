package com.example.audiodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.View;


public class MainActivity extends AppCompatActivity implements OnPreparedListener {
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startButton:
                doPlayAudio();
                break;
            case R.id.stopButton:
                doStopAudio();
                break;
        }
    }
    private void doPlayAudio() {
        mp = MediaPlayer.create(this, R.raw.audio_file);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.start();
    }
    private void doStopAudio() {
        if (mp != null) {
            mp.stop();
        }
    }
    // The onPrepared callback is for you to implement
    // as part of the OnPreparedListener interface
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp != null) {
            mp.release();
        }
    }
}




