package com.example.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.Model.Question;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {
    TextView textView_title_category, textView_question_number, textView_point, textView_question;
    Button button_answer_a, button_answer_b, button_answer_c, button_answer_d;
    ArrayList<Question> questions;
    int questionNumber = 0;
    int point = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        textView_title_category = findViewById(R.id.textView_title_category);
        textView_question_number = findViewById(R.id.textView_question_number);
        textView_point = findViewById(R.id.textView_point);
        textView_question = findViewById(R.id.textView_question);

        button_answer_a = findViewById(R.id.button_answer_a);
        button_answer_b = findViewById(R.id.button_answer_b);
        button_answer_c = findViewById(R.id.button_answer_c);
        button_answer_d = findViewById(R.id.button_answer_d);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            textView_title_category.setText(extras.getString("category"));
        }
        if (textView_title_category.getText().toString().equals("TEKNOLOJİ")) {
            loadTechnologyQuestions();

            textView_question.setText(questions.get(questionNumber).getQuestion());
            button_answer_a.setText(questions.get(questionNumber).getAnswer_a());
            button_answer_b.setText(questions.get(questionNumber).getAnswer_b());
            button_answer_c.setText(questions.get(questionNumber).getAnswer_c());
            button_answer_d.setText(questions.get(questionNumber).getAnswer_d());

        } else {
            loadSportQuestions();

            textView_question.setText(questions.get(questionNumber).getQuestion());
            button_answer_a.setText(questions.get(questionNumber).getAnswer_a());
            button_answer_b.setText(questions.get(questionNumber).getAnswer_b());
            button_answer_c.setText(questions.get(questionNumber).getAnswer_c());
            button_answer_d.setText(questions.get(questionNumber).getAnswer_d());
        }
        answerButtons();


    }


    public void loadTechnologyQuestions() {
        questions = new ArrayList<Question>();
        Question questionExample = new Question(1, "teknoloji", "Bir dosyayı geri dönüşüm kutusuna göndermeden silmek için kullanılan kısayol tuşu hangisidir?", "Shift+Delete", "Ctrl+Delete", "Delete", "Alt+Delete", "A");
        questions.add(questionExample);
        questionExample = new Question(2, "teknoloji", "Hangisi geri al işleminin kısayol tuşudur?", "Ctrl+E", "Shift+Z", "Shift+Yöntuşları", "Ctrl + Z", "D");
        questions.add(questionExample);
        questionExample = new Question(3, "teknoloji", "Aşağıdakilerden hangisi giriş birimidir?", "Tarayıcı", "Yazıcı", "Harddisk", "Monitör", "A");
        questions.add(questionExample);
        questionExample = new Question(4, "teknoloji", "Hangileri bilgisayar kasasında bulunur?\n" + "\n" + "I. Monitör\n" + "II. Hard disk drive\n" + "III. Hoparlör", "I. ve II.", "I. ve III.", "Sadece II.", "I., II. ve III.", "C");
        questions.add(questionExample);
        questionExample = new Question(5, "teknoloji", "Aşağıdaki açıklamalardan hangisi yanlıştır?", "Fonksiyon tuşlarının sabit bir görevleri yoktur", "Bir klasörü açmak için üzerinde farenin sağ tuşuna çift tıklanır", "Num Lock ışığı yanıyorsa rakam tuşlarını kullanabiliriz", "Klavyedeki 3. karakterleri çıkarmak için AltGr tuşu kullanılır", "B");
        questions.add(questionExample);
        questionExample = new Question(6, "teknoloji", "Bilgisayarın her türlü elektronik aksamına ne denir?", "Hardware(Donanım)", "Software(Yazılım)", "CPU(İşlemci)", "İnputUnit(Giriş Çıkış)", "A");
        questions.add(questionExample);
        questionExample = new Question(7, "teknoloji", "Bilgisayarda işlemlerin yapıldığı birim aşağıdakilerden hangisidir?", "DDR2", "CPU", "Mhz", "ROM", "B");
        questions.add(questionExample);
        questionExample = new Question(8, "teknoloji", "Birden fazla bilgisayarın telefon hattı ile iletişimini sağlayan donanım hangisidir?", "Modem", "Ethernet Kartı", "Ekran Kartı", "Tarayıcı", "A");
        questions.add(questionExample);
        questionExample = new Question(9, "teknoloji", "Açık Olan herhangi bir program nasıl kapatılır?", "CTRL+Tab", "CTRL+F4", "ALT+Tab", "ALT+F4", "D");
        questions.add(questionExample);
        questionExample = new Question(10, "teknoloji", "Aşağıdakilerden hangisi klavyeden ikinci karakterleri çıkartmamızı sağlayan tuştur?", "Ctrl", "Altgr", "Capslock", "Shift", "D");
        questions.add(questionExample);
    }

    public void loadSportQuestions() {
        questions = new ArrayList<Question>();
        Question questionExample = new Question(1, "spor", "''Degaj'' hangi spor dalıyla ilgili bir kavramdır?", "Futbol", "Badminton", "Tenis", "Yüzme", "A");
        questions.add(questionExample);
        questionExample = new Question(2, "spor", "Bir basket maçı kaç periyottan oluşur ve her periyot kaç dakikadır?", "4 periyot 10 dakika", "2 periyot 5 dakika", "4 periyot 15 dakika", "4 periyot 20 dakika", "A");
        questions.add(questionExample);
        questionExample = new Question(3, "spor", "2006 Dünya Kupası'nı hangi ülke milli takımı kazandı?", "Fransa", "İtalya", "Brezilya", "İngiltere", "B");
        questions.add(questionExample);
        questionExample = new Question(4, "spor", "2014 Fifa Dünya Kupası'na ev sahipliği yapan ülke hangisidir?", "İtalya", "Fransa", "İngiltere", "Brezilya", "D");
        questions.add(questionExample);
        questionExample = new Question(5, "spor", "Alpinizm ne demektir?", "Yüzücülük", "Koşuculuk", "Atlayıcılık", "Dağcılık", "D");
        questions.add(questionExample);
        questionExample = new Question(6, "spor", "Araba yarışlarında yarışmanın bitimini gösteren bayrak ne renktir?", "Siyah-Mavi damalı", "Turuncu-Siyah damalı", "Siyah-Beyaz damalı", "Siyah-Gri damalı", "C");
        questions.add(questionExample);
        questionExample = new Question(7, "spor", "2000 yılında UEFA şampiyonu olan takımımız hangisidir?", "Galatasaray", "Beşiktaş", "Fenerbahçe", "Trabzonspor", "A");
        questions.add(questionExample);
        questionExample = new Question(8, "spor", "2012 Dünya Salon Atletizm Şampiyonası hangi şehirde yapıldı?", "Paris", "Londra", "Lyon", "İstanbul", "D");
        questions.add(questionExample);
        questionExample = new Question(9, "spor", "2013 Dünya Akdeniz Oyunları nerede yapıldı?", "Mersin", "Antalya", "İstanbul", "Ankara", "A");
        questions.add(questionExample);
        questionExample = new Question(10, "spor", "Galatasaray'ın Süper Lig'de bulunan şampiyonluk sayısı kaçtır?", "19", "15", "22", "6", "C");
        questions.add(questionExample);
    }

    public void answerButtons() {
        button_answer_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions.get(questionNumber).getTrue_answer().equals("A")) {
                    if (questionNumber == 9) {
                        button_answer_a.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(QuestionsActivity.this, WinActivity.class);
                                startActivity(intent);
                                QuestionsActivity.this.finish();
                            }
                        }, 1000);
                    } else {
                        button_answer_a.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                trueAnswerAlertDialog();
                            }
                        }, 1000);
                    }
                } else {
                    button_answer_a.setBackgroundResource(R.color.red);
                    if (questions.get(questionNumber).getTrue_answer().equals("B")) {
                        button_answer_b.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("C")) {
                        button_answer_c.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("D")) {
                        button_answer_d.setBackgroundResource(R.color.lime_green);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionsActivity.this, LoseActivity.class);
                            intent.putExtra("question_number", String.valueOf(questionNumber));
                            intent.putExtra("point_number", textView_point.getText().toString());
                            startActivity(intent);
                            QuestionsActivity.this.finish();
                        }
                    }, 1000);

                }
            }
        });

        button_answer_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions.get(questionNumber).getTrue_answer().equals("B")) {
                    if (questionNumber == 9) {
                        button_answer_b.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(QuestionsActivity.this, WinActivity.class);
                                startActivity(intent);
                                QuestionsActivity.this.finish();
                            }
                        }, 1000);
                    } else {
                        button_answer_b.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                trueAnswerAlertDialog();
                            }
                        }, 1000);
                    }
                } else {
                    button_answer_b.setBackgroundResource(R.color.red);
                    if (questions.get(questionNumber).getTrue_answer().equals("A")) {
                        button_answer_a.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("C")) {
                        button_answer_c.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("D")) {
                        button_answer_d.setBackgroundResource(R.color.lime_green);
                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionsActivity.this, LoseActivity.class);
                            intent.putExtra("question_number", String.valueOf(questionNumber));
                            intent.putExtra("point_number", textView_point.getText().toString());
                            startActivity(intent);
                            QuestionsActivity.this.finish();
                        }
                    }, 1000);
                }
            }
        });

        button_answer_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions.get(questionNumber).getTrue_answer().equals("C")) {
                    if (questionNumber == 9) {
                        button_answer_c.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(QuestionsActivity.this, WinActivity.class);
                                startActivity(intent);
                                QuestionsActivity.this.finish();
                            }
                        }, 1000);
                    } else {
                        button_answer_c.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                trueAnswerAlertDialog();
                            }
                        }, 1000);
                    }
                } else {
                    button_answer_c.setBackgroundResource(R.color.red);
                    if (questions.get(questionNumber).getTrue_answer().equals("A")) {
                        button_answer_a.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("B")) {
                        button_answer_b.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("D")) {
                        button_answer_d.setBackgroundResource(R.color.lime_green);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionsActivity.this, LoseActivity.class);
                            intent.putExtra("question_number", String.valueOf(questionNumber));
                            intent.putExtra("point_number", textView_point.getText().toString());
                            startActivity(intent);
                            QuestionsActivity.this.finish();
                        }
                    }, 1000);
                }
            }
        });

        button_answer_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions.get(questionNumber).getTrue_answer().equals("D")) {
                    if (questionNumber == 9) {
                        button_answer_d.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(QuestionsActivity.this, WinActivity.class);
                                startActivity(intent);
                                QuestionsActivity.this.finish();
                            }
                        }, 1000);
                    } else {
                        button_answer_d.setBackgroundResource(R.color.lime_green);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                trueAnswerAlertDialog();
                            }
                        }, 1000);

                    }
                } else {
                    button_answer_d.setBackgroundResource(R.color.red);
                    if (questions.get(questionNumber).getTrue_answer().equals("A")) {
                        button_answer_a.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("B")) {
                        button_answer_b.setBackgroundResource(R.color.lime_green);
                    } else if (questions.get(questionNumber).getTrue_answer().equals("C")) {
                        button_answer_c.setBackgroundResource(R.color.lime_green);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionsActivity.this, LoseActivity.class);
                            intent.putExtra("question_number", String.valueOf(questionNumber));
                            intent.putExtra("point_number", textView_point.getText().toString());
                            startActivity(intent);
                            QuestionsActivity.this.finish();
                        }
                    }, 1000);

                }
            }
        });
    }

    public void trueAnswerAlertDialog() {
        final Dialog dialog = new Dialog(QuestionsActivity.this);
        dialog.setContentView(R.layout.dialog_true_answer);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button button_exit = dialog.findViewById(R.id.button_exit);
        Button button_next_question = dialog.findViewById(R.id.button_next_question);

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsActivity.this, CategoryActivity.class);
                startActivity(intent);
                QuestionsActivity.this.finish();
            }
        });

        button_next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionNumber++;
                int value = questionNumber + 1;
                point = point + 100;
                textView_point.setText(point + "");
                textView_question_number.setText(value + "/10");
                textView_question.setText(questions.get(questionNumber).getQuestion());
                button_answer_a.setText(questions.get(questionNumber).getAnswer_a());
                button_answer_b.setText(questions.get(questionNumber).getAnswer_b());
                button_answer_c.setText(questions.get(questionNumber).getAnswer_c());
                button_answer_d.setText(questions.get(questionNumber).getAnswer_d());

                button_answer_a.setBackgroundResource(R.color.white);
                button_answer_b.setBackgroundResource(R.color.white);
                button_answer_c.setBackgroundResource(R.color.white);
                button_answer_d.setBackgroundResource(R.color.white);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
