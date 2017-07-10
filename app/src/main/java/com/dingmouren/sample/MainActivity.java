package com.dingmouren.sample;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dingmouren.videowallpaper.VideoWallpaper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private File mFile1 ;
    private File mFile2;
    private static final String IS_VIDEO1 = "is_video1";
    private VideoWallpaper mVideoWallpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoWallpaper = new VideoWallpaper();
        initFile();
    }

    private void initFile() {
        AssetManager asset = getAssets();
        mFile1 = new File(Environment.getExternalStorageDirectory()+ "/video1.mp4");
        if (!mFile1.exists()) {
            try {
                mFile1.createNewFile();
                InputStream is = asset.open("video1.mp4");
                writeMp4ToNative(mFile1,is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mFile2 = new File(Environment.getExternalStorageDirectory()+ "/video2.mp4");
        if (!mFile2.exists()) {
            try {
                mFile2.createNewFile();
                InputStream is = asset.open("video2.mp4");
                writeMp4ToNative(mFile2,is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeMp4ToNative(File file,InputStream is) {

        try {
            FileOutputStream os = new FileOutputStream(file);
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer))!=-1){
                os.write(buffer,0,buffer.length);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setWallpaper(View view){
        if (SPUtil.get(this,IS_VIDEO1,true)){
           SPUtil.put(this,IS_VIDEO1,false);
            mVideoWallpaper.setToWallPaper(this,mFile1.getAbsolutePath());
        }else {
            SPUtil.put(this,IS_VIDEO1,true);
            mVideoWallpaper.setToWallPaper(this,mFile2.getAbsolutePath());
        }
    }

    public void setSilence(View view){
        VideoWallpaper.setVoiceSilence(this);
    }

    public void cancelSilence(View view){
        VideoWallpaper.setVoiceNormal(this);
    }

    public void toBack(View view){
        finish();
    }


}
