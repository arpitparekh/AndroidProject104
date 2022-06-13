package com.arpitparekh.jan12androidproject.service;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadFileService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        downloadFile();

        return super.onStartCommand(intent, flags, startId);

    }

    private void downloadFile() {

        new Thread(new Runnable() {
            @Override
            public void run() {

//                https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68

                try {

                    URL url = new URL("https://i.picsum.photos/id/72/200/300.jpg?hmac=8tyK7lgBqIQNIGPVnmsVP3SL5bYCsSDmdZtnIJNQv3o");

                    InputStream is = url.openStream();
                    DataInputStream dis = new DataInputStream(is);

                    byte arr[] = new byte[1024];

                    int size;

                    File rootFolder = Environment.getExternalStorageDirectory();

                    File file = new File(rootFolder,"image.jpg");

                    FileOutputStream fos = new FileOutputStream(file);

                    while((size=dis.read(arr))>0){
                        fos.write(arr,0,size);
                    }

                    dis.close();
                    fos.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
