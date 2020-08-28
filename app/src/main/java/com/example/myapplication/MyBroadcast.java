package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.net.ConnectivityManagerCompat;

public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       /* if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }*/
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean connection=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            );
            if (connection){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Connection", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
