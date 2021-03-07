package org.androidtown.sampledelayed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button requestBtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestBtn = (Button)findViewById(R.id.requestBtn);
        textView = (TextView)findViewById(R.id.textView);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    private void request(){
        String title = "원격 요청";
        String message = "데이터를 요청하시겠습니까?";
        String titleButtonYes = "예";
        String titleButtonNo = "아니오";

        AlertDialog dialog = makeRequestDialog(title, message, titleButtonYes, titleButtonNo);
        dialog.show();

        textView.setText("원격 데이터 요청 중...");
    }

    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleButtonYes, CharSequence titleButtonNo){
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(this);
        requestDialog.setMessage(message);
        requestDialog.setPositiveButton(titleButtonYes,new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
                for(int k = 0;k<10;k++){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException ex){}
                }
                textView.setText("원격 데이터 요청 완료");
            }
        });

        requestDialog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
            }
        });

        return requestDialog.show();
    }
}