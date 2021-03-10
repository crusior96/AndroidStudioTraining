package org.androidtown.doitmission17;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button button;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    String TABLE_NAME = "BOOKS3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(db==null){
            db = openOrCreateDatabase("BOOKSTORE.db",MODE_PRIVATE,null);

        }
        CreateTable();

        button = (Button)findViewById(R.id.button);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = editText1.getText().toString();
                String str2 = editText2.getText().toString();
                String str3 = editText3.getText().toString();
                insertRecord(str1, str2, str3);
            }
        });
    }

    public void CreateTable(){
        if(db!=null){
            db.execSQL("create table " + TABLE_NAME + "(" + " _id integer PRIMARY KEY autoincrement, "
                    + " name text, " + " author text, " + " story text);" );
        }
    }

    private void insertRecord(String str1, String str2, String str3){
        db.execSQL("insert into BOOKS3(name, author, story) values ('" + str1
         + "'" + ", '" + str2 + "'" + ", '" + str3 + "'" + ");");
        Toast toastit = Toast.makeText(this, "데이터베이스로의 저장 완료!",Toast.LENGTH_LONG);
        toastit.show();
    }
}