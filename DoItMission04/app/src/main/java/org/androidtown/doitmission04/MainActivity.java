package org.androidtown.doitmission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    EditText editText1;
    EditText editText2;
    String pretext;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText1.getText().toString();
                Toast.makeText(getApplicationContext(),input,Toast.LENGTH_LONG).show();
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = editText1.getText().toString();
                editText2.setText(input.length() + " / 80 글자 수");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}