package org.androidtown.tryit_06;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final int REQUEST_CODE_CUST = 112;
    public static final int REQUEST_CODE_SELL = 113;
    public static final int REQUEST_CODE_PROD = 114;
    EditText editText1;
    EditText editText2;

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==REQUEST_CODE_CUST){
            Toast.makeText(getApplicationContext(),"고객관리 -> 로그인",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==REQUEST_CODE_SELL){
            Toast.makeText(getApplicationContext(),"매출분석 -> 로그인",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==REQUEST_CODE_PROD){
            Toast.makeText(getApplicationContext(),"상품분석 -> 로그인",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(editText1.getText().toString()!=null && editText2.getText().toString()!=null){
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
                else if(editText1.getText().toString()==null || editText2.getText().toString()==null){
                    Toast.makeText(getApplicationContext(),"하나라도 좀..",Toast.LENGTH_LONG).show();
                }
            }
        });

        Intent passedintent = getIntent();
        processIntent(passedintent);
    }

    @Override
    protected void onNewIntent(Intent intent){
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent){
        if(intent!=null){
            int iFromIdx = intent.getIntExtra("from",0);
        }
    }
}