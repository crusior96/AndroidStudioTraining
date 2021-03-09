package org.androidtown.tryit_06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static final int MENU_CODE_FROM_MAIN = 101;
    public static final int CUST_CODE_FROM_MENU = 102;
    public static final int SALE_CODE_FROM_MENU = 103;
    public static final int PROD_CODE_FROM_MENU = 104;
    public static final int MAIN_CODE_FROM_CUST = 112;
    public static final int MENU_CODE_FROM_CUST = 122;
    public static final int MAIN_CODE_FROM_SALE = 113;
    public static final int MENU_CODE_FROM_SALE = 123;
    public static final int MAIN_CODE_FROM_PROD = 114;
    public static final int MENU_CODE_FROM_PROD = 124;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==MENU_CODE_FROM_MAIN){
            Toast.makeText(getApplicationContext(),"메인 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==MENU_CODE_FROM_CUST){
            Toast.makeText(getApplicationContext(),"고객 관리 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==MAIN_CODE_FROM_CUST){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            setResult(MAIN_CODE_FROM_CUST,intent);
            finish();
        }
        else if(resultCode==MENU_CODE_FROM_SALE){
            Toast.makeText(getApplicationContext(),"매출 분석 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==MAIN_CODE_FROM_SALE){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            setResult(MAIN_CODE_FROM_SALE,intent);
            finish();
        }
        else if(resultCode==MENU_CODE_FROM_PROD){
            Toast.makeText(getApplicationContext(),"상품 분석 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode==MAIN_CODE_FROM_PROD){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            setResult(MAIN_CODE_FROM_PROD,intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Customer.class);
                startActivityForResult(intent,CUST_CODE_FROM_MENU);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Product.class);
                startActivityForResult(intent,PROD_CODE_FROM_MENU);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Sales.class);
                startActivityForResult(intent,SALE_CODE_FROM_MENU);
            }
        });
    }
}
