package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private  static final String KEY_QUESTION = "Question";
    private  static final String KEY_ANSWER = "Answer";
    private static  final String SHOW_ANSWER="ANSWE_SHOW";

    private TextView txtquestion;
    private TextView txtAnswer;
    private Button btnshowanswer;
    private Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);


        int key_question = getIntent().getIntExtra(KEY_QUESTION, 0);
        boolean value_answer = getIntent().getBooleanExtra(KEY_ANSWER, false);

        txtquestion = findViewById(R.id.txtpregunta);
        txtAnswer = findViewById(R.id.txtshowAnswer);
        btnshowanswer = findViewById(R.id.btnShowAnswer);
        btnback =  findViewById(R.id.btnBack);
        txtquestion.setText(key_question);


        btnback.setOnClickListener(view -> {
            finish();

        });

        btnshowanswer.setOnClickListener(view -> {
          if (value_answer){
              txtAnswer.setText(R.string.true_msg);
          }
          else{
              txtAnswer.setText(R.string.false_nsg);
          }
        });

    }
}