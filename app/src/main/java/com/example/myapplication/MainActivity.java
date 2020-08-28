package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btsStart, btnStop, btnBroadcast,btnProvider,btnCars ,btnMvvm,btn_login,btn_comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btsStart = (Button) findViewById(R.id.startservice);
        btnStop = (Button) findViewById(R.id.stopservice);
        btnCars=(Button) findViewById(R.id.btnCars);
        btnMvvm = (Button) findViewById(R.id.btnMvvm);
        btnBroadcast=(Button) findViewById(R.id.btn_brodast);
        btnProvider=(Button) findViewById(R.id.btnProvider);
        btn_login=(Button) findViewById(R.id.btn_login);
        btn_comprar=(Button) findViewById(R.id.btn_buying);

        btsStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnProvider.setOnClickListener(this);
        btnCars.setOnClickListener(this);
        btnMvvm.setOnClickListener(this);
        btnBroadcast.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_comprar.setOnClickListener(this);
        Intent intent=getIntent();
        String message=intent.getStringExtra("Noti");
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
           if (!task.isSuccessful()){
               return;
           }
           String token=task.getResult().getToken();
                Log.e("Token_____________________",token);
            }
        });


    }

    @Override
    public void onClick(View view) {
        if (view == btsStart) {
        startService(new Intent(this,MyService.class));
        }else if(view==btnStop){
            stopService(new Intent(this,MyService.class));
        }
        else if (view==btnProvider){
    Intent intent =new Intent(MainActivity.this,Provider.class);
    startActivity(intent);
        }else if (view==btnCars){
            Intent intent2 =new Intent(MainActivity.this,Cars.class);
            startActivity(intent2);
        }else if (view==btnMvvm){
            Intent intent3 =new Intent(MainActivity.this,Listmvvm.class);
            startActivity(intent3);
        }else if(view ==btnBroadcast){
            Intent intent3 =new Intent(MainActivity.this,Receiverb.class);
            startActivity(intent3);
        }else if(view ==btn_login){
            Intent intent3 =new Intent(MainActivity.this,Login.class);
            startActivity(intent3);
        }else if(view ==btn_comprar){
            Intent intent3 =new Intent(MainActivity.this,Comprar.class);
            startActivity(intent3);
        }
    }
}