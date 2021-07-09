package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoseActivity extends AppCompatActivity {
    TextView textView_lose;
    Button button_main_page, button_exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        textView_lose = findViewById(R.id.textView_lose);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String questionNumber=extras.getString("question_number");
            String point =extras.getString("point_number");
            textView_lose.setText("SORU : "+questionNumber+"/10 PUAN : "+point);
        }
        button_main_page=findViewById(R.id.button_main_page);
        button_exit = findViewById(R.id.button_exit);

        button_main_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoseActivity.this, CategoryActivity.class);
                startActivity(intent);
                LoseActivity.this.finish();
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}
