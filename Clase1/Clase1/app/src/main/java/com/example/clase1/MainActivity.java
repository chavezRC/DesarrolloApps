package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnTrue;
    private  Button btnFalse;
    private  Button btnNext;
    private  Button btnAnswer;
    private TextView txtQuestion;
    private Questions[] listQuestion = new Questions[]{
        new Questions(R.string.Question_text1,true),
        new Questions(R.string.Question_text2,true),
        new Questions(R.string.Question_text3,true),
        new Questions(R.string.Question_text4, true),
        new Questions(R.string.Question_text5,true)

    };
    private int currentIndex=0;
    private static final int REQUEST_CODE=2;
    private static final String KEY_INDEX = "index" ;
    private  static final String KEY_QUESTION = "Question";
    private  static final String KEY_ANSWER = "Answer";


    @Override
    protected void onCreate(Bundle savedInstanceState) {



            super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            currentIndex =savedInstanceState.getInt(KEY_INDEX,0);
        }

        btnTrue=findViewById(R.id.btnTrue);
        btnTrue=findViewById(R.id.btnFalse);
        btnNext=findViewById(R.id.btnNext);
        btnAnswer=findViewById(R.id.btnShowAnswer);

        txtQuestion=findViewById(R.id.txtQuestion);
        txtQuestion.setText(listQuestion[currentIndex].getTxtResId());



        btnAnswer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
            intent.putExtra(KEY_QUESTION, listQuestion[currentIndex].getTxtResId());
            intent.putExtra(KEY_ANSWER, listQuestion[currentIndex].getTxtResId());
            startActivityForResult(intent, REQUEST_CODE);

            //startActivity(intent);
        });




        btnTrue.setOnClickListener(view -> {
            chkanswer(true);

        });

        btnFalse.setOnClickListener(view -> {
            chkanswer(false);

        });

        btnNext.setOnClickListener(view -> {
            currentIndex= (currentIndex + 1) % listQuestion.length;
            int question = listQuestion[currentIndex].getTxtResId();
            txtQuestion.setText(question);
        });
    }
    protected void onSaveInstantState(Bundle savedState){
        super.onSaveInstanceState(savedState);
        savedState.putInt(KEY_INDEX, currentIndex);


    }
    private  void updateQuestion(){
        int question =listQuestion[currentIndex].getTxtResId();
        txtQuestion.setText(question);

    }

    private  void  chkanswer (boolean userPresTrue){
        boolean answer = listQuestion[currentIndex].isAnswer();
        int msgRid=0;
        if (userPresTrue==answer){
            msgRid=R.string.true_msg;
        }
        else{
            msgRid=R.string.false_nsg;
        }
        Toast.makeText(this, msgRid, Toast.LENGTH_SHORT).show();


    }
}