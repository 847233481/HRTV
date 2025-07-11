
package com.hrtvr.player;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.vr.sdk.widgets.video.VrVideoView;

public class VRPlayerActivity extends AppCompatActivity {
    private VrVideoView vrVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr_player);

        vrVideoView = findViewById(R.id.vr_video_view);
        try {
            Uri videoUri = Uri.parse("file:///sdcard/Movies/sample360.mp4");
            VrVideoView.Options options = new VrVideoView.Options();
            options.inputType = VrVideoView.Options.TYPE_MONO;
            vrVideoView.loadVideo(videoUri, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        vrVideoView.pauseRendering();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vrVideoView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        vrVideoView.shutdown();
        super.onDestroy();
    }
}
