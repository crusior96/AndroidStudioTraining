package org.androidtown.sampleandroidsocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView input01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button = (Button)findViewById(R.id.button);
        input01 = (TextView)findViewById(R.id.input01);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String addr = input01.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }
    class ConnectThread extends Thread{
        String hostname;

        public ConnectThread(String addr){
            hostname = addr;
        }

        public void run(){
            try {
                int port = 11001;
                Socket sock = new Socket(hostname, port);
                ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
                outstream.writeObject("Hello AndroidTown on ANdroid");
                outstream.flush();

                ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
                String obj = (String)instream.readObject();

                Log.d("MainActivity","서버에서 받은 메세지 : " + obj);
                sock.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}