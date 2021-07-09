package com.example.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    TextView textView_welcome_username;
    Button button_technology,  button_sport, button_exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        textView_welcome_username = findViewById(R.id.textView_welcome_username);
        button_technology = findViewById(R.id.button_technology);
        button_sport = findViewById(R.id.button_sport);
        button_exit = findViewById(R.id.button_exit);

        SharedPreferences prefs = getSharedPreferences("Username", MODE_PRIVATE);
        String username = prefs.getString("username", "");
        textView_welcome_username.setText("Hoşgeldin, "+username);

        button_technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, QuestionsActivity.class);
                intent.putExtra("category","TEKNOLOJİ");
                startActivity(intent);
                CategoryActivity.this.finish();
            }
        });

        button_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoryActivity.this, QuestionsActivity.class);
                intent.putExtra("category","SPOR");
                startActivity(intent);
                CategoryActivity.this.finish();
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitAlertDialog();
            }
        });




    }

    public void exitAlertDialog()  {
        final Dialog dialog = new Dialog(CategoryActivity.this);
        dialog.setContentView(R.layout.dialog_exit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button button_yes = dialog.findViewById(R.id.button_yes);
        Button button_no = dialog.findViewById(R.id.button_no);

        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   finishAffinity();
            }
        });

        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }


}
