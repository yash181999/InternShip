package com.welcomescreen.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

         videoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.backvideo);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener ( new MediaPlayer.OnPreparedListener () {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping ( true );

                if(mp.getCurrentPosition ()!=0) {
                    mp.seekTo ( mp.getCurrentPosition () );
                    mp.start ();
                }
            }
        } );
    }

    @Override
    protected void onRestart() {
        videoView.start ();
        super.onRestart ();
    }

    @Override
    protected void onResume() {
        videoView.resume ();
        super.onResume();
        // to restart the video after coming from other activity like Sing up



    }

    @Override
    protected void onPause() {
        videoView.suspend ();
        super.onPause ();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback ();
        super.onDestroy ();
    }
}
