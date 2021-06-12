package com.example.offloading;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity extends AppCompatActivity {

    String videoURL;
    PlayerView playerView;
    SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindo = 0;
    private long playbackPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoURL=getIntent().getStringExtra("url");
        playerView = findViewById(R.id.video_view);
    }


    public void initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(MainActivity.this);
        playerView.setPlayer((Player) player);
        Uri uri = Uri.parse(videoURL);
        DataSource.Factory df = new DefaultDataSourceFactory(MainActivity.this, "exoplayer code");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(df).createMediaSource(uri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindo, playbackPosition);
        player.prepare((MediaSource) mediaSource, false, false);
    }

    @SuppressLint("RestrictedApi")
    public void releaseVideo() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindo = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            initVideo();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}