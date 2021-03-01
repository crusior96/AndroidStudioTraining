package org.androidtown.samplethread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressHandler handler;
    ProgressBar bar;
    TextView textView01;
    boolean isRunning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.bar);
        textView01 = (TextView)findViewById(R.id.textView01);
        handler = new ProgressHandler();
    }

    public void onStart(){
        super.onStart();

        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                try{
                    for(int i = 0;i<20&&isRunning;i++){
                        Thread.sleep(1000);
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                }catch (Exception ex){
                    Log.e("MainActivity","Exception in processing message.",ex);
                }
            }
        });
        isRunning = true;
        thread1.start();
    }

    public void onStop(){
        super.onStop();
        isRunning = false;
    }

    public class ProgressHandler extends Handler {
        public void handleMessage(Message msg){
            bar.incrementProgressBy(5);
            if(bar.getProgress() == bar.getMax()){
                textView01.setText("Done");
            }else{
                textView01.setText("Working ..." + bar.getProgress());
            }
        }
    }
}