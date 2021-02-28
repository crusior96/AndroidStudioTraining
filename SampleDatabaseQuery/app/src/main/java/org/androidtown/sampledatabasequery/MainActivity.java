package org.androidtown.sampledatabasequery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    EditText edittext1;
    EditText edittext2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    TextView status;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        edittext1 = (EditText)findViewById(R.id.edittext1);
        edittext2 = (EditText)findViewById(R.id.edittext2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        status = (TextView)findViewById(R.id.status);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = edittext1.getText().toString();
                createDatabase(databaseName);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String tableName = edittext2.getText().toString();
                createTable(tableName);
                int count = insertRecord();
                println(count + " records inserted.");
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = editText3.getText().toString().trim();
                String ageStr = editText4.getText().toString().trim();
                String mobile = editText5.getText().toString().trim();

                int age = -1;
                try{
                    age = Integer.parseInt(ageStr);
                }catch(Exception e){

                }

                insertData(name, age, mobile);
            }
        });


    }



    private void createDatabase(String databaseName){
        println("Creating database [" + databaseName + "].");
        db = openOrCreateDatabase(databaseName,MODE_PRIVATE,null);
    }

    private void createTable(String tableName){
        println("Creating table [" + tableName + "].");
        if(db==null){
            println("먼저 데이터베이스를 만드세요");
        }else{
            db.execSQL("create table " + tableName + "(" + " _id integer PRIMARY KEY autoincrement, "
            + " name text, " + " age integer, " + " phone text);");
        }
    }

    public void insertData(String name, int age, String mobile){
        if(db==null){
            println("먼저 데이터베이스를 만드세요");
        }else{
            String sql = "insert into customer(name, age, mobile) with vaules(?, ?, ?);";
            Object[] params = {name, age, mobile};
            db.execSQL(sql,params);
            println("데이터 추가함");
        }
    }

    private int insertRecord(){
        println("inserting records.");
        int count = 3;
        db.execSQL("insert into employee(name, age, phone) values ('John', 20, '010-7788-1234');");
        db.execSQL("insert into employee(name, age, phone) values ('King', 25, '010-7788-1234');");
        db.execSQL("insert into employee(name, age, phone) values ('Fal', 29, '010-7788-1234');");
        return count;
    }



    public void println(String data){
        status.append(data + "\n");
    }
}

