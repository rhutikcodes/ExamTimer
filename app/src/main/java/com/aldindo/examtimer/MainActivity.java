package com.aldindo.examtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
MediaPlayer m1;
    TextView done;
    String time;
    int timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1=MediaPlayer.create(this,R.raw.sixth);
        final TextView mnumber=findViewById(R.id.mnumber);
        time=getIntent().getStringExtra("time");
     done=findViewById(R.id.done);
        timer=Integer.parseInt(time);
        new CountDownTimer(timer*1000,1000){
            public void onTick(long millisecondsInFuture){
                mnumber.setText(""+millisecondsInFuture/1000);

            }

            public void onFinish() {
               done.setText("Done ;-)");
                m1.start();
            }
        }.start();



    }
    public void back(View view){

        Intent intent=new Intent(MainActivity.this,Main2Activity.class);

        startActivity(intent);

    }
}
