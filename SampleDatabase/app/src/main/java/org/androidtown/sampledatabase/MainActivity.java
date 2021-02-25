package org.androidtown.sampledatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
    EditText databaseNameInput;
    EditText editText2;
    SQLiteDatabase database;
    TextView status;
    boolean databaseCreated = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabaseBtn = (Button)findViewById(R.id.createDatabaseBtn);
        Button button = (Button)findViewById(R.id.button);
        editText2 = (EditText)findViewById(R.id.editText2);
        databaseNameInput = (EditText)findViewById(R.id.databaseNameInput);
        status = (TextView)findViewById(R.id.status);

        createDatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = databaseNameInput.getText().toString();
                openDatabase(databaseName);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = editText2.getText().toString();
                createTable(tableName);
                int count = insertRecord(tableName);
                println(count + "records inserted.");
            }
        });
    }

    public void openDatabase(String databaseName){
        println("openDatabase() 호출됨");
        database = openOrCreateDatabase(databaseName,MODE_PRIVATE,null);
        if(database!=null){
            println("데이터베이스 오픈됨.");
        }
    }

    public void createTable(String tableName){
        println("creating table [" + tableName + "]");
        if(database!=null){
            database.execSQL("create table " + tableName + "(" + "_id integer PRIMARY KEY autoincrement,"
                    + " name text, " + " age integer, " + "phone text);");
        }else{
            println("먼저 데이터베이스를 오픈하세요");
        }

    }

    private int insertRecord(String tableName){
        println("inserting records into table " + tableName + ".");
        int count = 3;
        database.execSQL("insert into employee(name, age, phone) values ('John', 20, '010-7788-1234');");
        database.execSQL("insert into employee(name, age, phone) values ('John', 20, '010-7788-1234');");
        database.execSQL("insert into employee(name, age, phone) values ('John', 20, '010-7788-1234');");
        return count;
    }

    public void println(String data){
        status.append(data + "\n");
    }
}