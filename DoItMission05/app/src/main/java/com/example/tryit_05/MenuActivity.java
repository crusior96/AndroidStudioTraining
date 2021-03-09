package com.example.tryit_05;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static final int CUST = 1;
    public static final int SALE = 2;
    public static final int PROD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickCustomer(View view){
        gotoMain(CUST);
        finish();
    }

    public void onClickSales(View view){
        gotoMain(SALE);
        finish();
    }

    public void onClickProduct(View view){
        gotoMain(PROD);
        finish();
    }

    private void gotoMain(int iFromIdx){
        Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        mainIntent.putExtra("from",iFromIdx);
        startActivity(mainIntent);
    }
}
