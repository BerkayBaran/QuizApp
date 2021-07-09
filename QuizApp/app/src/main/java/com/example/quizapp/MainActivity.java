package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME= "Username";
    EditText editText_username;
    Button button_next;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_username = findViewById(R.id.editText_username);
        button_next = findViewById(R.id.button_next);

        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("username", editText_username.getText().toString());
                editor.apply();

                Intent intent=new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });






    }
}