package org.androidtown.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView01;
    Boolean running = true;
    Integer value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        textView01 = (TextView)findViewById(R.id.textView01);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView01.setText("스레드에서 받은 값 : " + value);
            }
        });
    }

    protected void onResume(){
        super.onResume();

        running = true;
        Thread thread1 = new BackgroundThread();
        thread1.start();
    }

    protected void onPause(){
        super.onPause();

        running = false;
        value = 0;
    }

    class BackgroundThread extends Thread{
        public void run(){
            while(running){
                try{
                    Thread.sleep(1000);
                    value++;
                }catch(InterruptedException ex){
                    Log.e("SampleJavaThread","Exception in thread.",ex);
                }
            }
        }
    }
}