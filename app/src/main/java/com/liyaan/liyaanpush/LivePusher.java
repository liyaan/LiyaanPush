package com.liyaan.liyaanpush;

import android.app.Activity;
import android.view.SurfaceHolder;

import com.liyaan.liyaanpush.meida.AudioChannel;
import com.liyaan.liyaanpush.meida.VideoChannel;

public class LivePusher {
    private AudioChannel audioChannel;
    private VideoChannel videoChannel;
    static {
        System.loadLibrary("liyaanpush");
    }

    public LivePusher(Activity activity, int width, int height, int bitrate,
                      int fps, int cameraId) {
        native_init();
        videoChannel = new VideoChannel(this, activity, width, height, bitrate, fps, cameraId);
        audioChannel = new AudioChannel(this);


    }
    public void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        videoChannel.setPreviewDisplay(surfaceHolder);
    }
    public void switchCamera() {
        videoChannel.switchCamera();
    }

    public native void native_init();
    public native void native_setVideoEncInfo(int width,int height,int fps,int bitrate);
}
