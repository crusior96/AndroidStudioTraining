package org.androidtown.samplevideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    static final String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    private VideoView videoView;
    Button volumeBtn;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volumeBtn = (Button)findViewById(R.id.volumeBtn);
        startBtn = (Button)findViewById(R.id.startBtn);
        volumeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
                int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume,
                         AudioManager.FLAG_SHOW_UI);
            }
        });

        videoView =(VideoView)findViewById(R.id.videoView);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse(VIDEO_URL));
        videoView.requestFocus();
    }
}