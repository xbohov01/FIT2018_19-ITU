package team7.itu2018;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class EndlessTest extends AppCompatActivity {
    boolean Qtext =false;
    boolean Qtech =false;
    boolean Qznac =false;
    boolean Qkriz =false;
    Test_database test = new Test_database();
    int quest_num = 0;
    int questionOrder = 1;
    int color;
    int body = 0;
    int answer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless_test);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Qkriz = extras.getBoolean("kriz");
            Qtext = extras.getBoolean("text");
            Qtech = extras.getBoolean("tech");
            Qznac = extras.getBoolean("znac");
        }
        //back and next
        ImageButton button1 = (ImageButton)findViewById(R.id.button);
        button1.setVisibility(View.GONE);

        //question
        boolean tmp = true;
        while(tmp){
            if(quest_num >= 27) {
                quest_num = 0;
            }
            if(Qtext && (test.GetQType(quest_num)==1)) {
                tmp = false;
            }
            else if(Qtech && (test.GetQType(quest_num)==2)) {
                tmp = false;
            }
            else if(Qznac && (test.GetQType(quest_num)==3)) {
                tmp = false;
            }
            else if(Qkriz && (test.GetQType(quest_num)==4)) {
                tmp = false;
            }
            quest_num++;
        }

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));
        color = buttona.getCurrentTextColor();

        ImageView image_test = (ImageView)findViewById(R.id.image_test);

        if(test.GetPicture(quest_num).equals("")){
            image_test.setVisibility(View.GONE);
        }
        else{
            int resId = getResources().getIdentifier(test.GetPicture(quest_num), "drawable", getPackageName());
            image_test.setImageResource(resId);
            image_test.setVisibility(View.VISIBLE);
        }

    }

    public void nextQuestion(View view){
        quest_num++;

        //question
        boolean tmp = true;
        while(tmp){
            if(quest_num >= 27) {
                quest_num = 0;
            }
            if(Qtext && (test.GetQType(quest_num)==1)) {
                tmp = false;
            }
            else if(Qtech && (test.GetQType(quest_num)==2)) {
                tmp = false;
            }
            else if(Qznac && (test.GetQType(quest_num)==3)) {
                tmp = false;
            }
            else if(Qkriz && (test.GetQType(quest_num)==4)) {
                tmp = false;
            }
            quest_num++;
        }

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));
        buttona.setChecked(false);
        buttona.setTextColor(color);
        buttonb.setChecked(false);
        buttonb.setTextColor(color);
        buttonc.setChecked(false);
        buttonc.setTextColor(color);

        ImageView image_test = (ImageView)findViewById(R.id.image_test);

        if(test.GetPicture(quest_num).equals("")){
            image_test.setVisibility(View.GONE);
        }
        else{
            int resId = getResources().getIdentifier(test.GetPicture(quest_num), "drawable", getPackageName());
            image_test.setImageResource(resId);
            image_test.setVisibility(View.VISIBLE);
        }

        questionOrder++;

        TextView otazka = (TextView)findViewById(R.id.name_vys);
        String text = "Otázka "+questionOrder + " Body " + body;
        otazka.setText(text);

        ImageButton button1 = (ImageButton)findViewById(R.id.button);
        button1.setVisibility(View.GONE);
        ImageButton button6 = (ImageButton)findViewById(R.id.button6);
        button6.setVisibility(View.VISIBLE);

    }

    public void MakeResult(View view){
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        if(buttona.isChecked()){
            answer = 1;
        }
        else if(buttonb.isChecked()){
            answer = 2;
        }
        else if(buttonc.isChecked()){
            answer = 3;
        }
        else {
            answer = 0;
        }

        if(answer == test.GetRightAnswer(quest_num)) {
            body = body + test.GetPoints(quest_num);
            if(answer == 1) {
                buttona.setTextColor(Color.GREEN);

            }
            else if(answer == 2) {
                buttonb.setTextColor(Color.GREEN);

            }
            else if(answer == 3) {
                buttonc.setTextColor(Color.GREEN);

            }

        }
        else {
            if(answer == 0){
                if(test.GetRightAnswer(quest_num) == 1){
                    buttona.setChecked(false);
                    buttona.setTextColor(Color.GREEN);
                    buttonb.setChecked(false);
                    buttonb.setTextColor(color);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(color);
                }
                else if(test.GetRightAnswer(quest_num) == 2){
                    buttona.setChecked(false);
                    buttona.setTextColor(color);
                    buttonb.setChecked(false);
                    buttonb.setTextColor(Color.GREEN);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(color);
                }
                else if(test.GetRightAnswer(quest_num) == 3){
                    buttona.setChecked(false);
                    buttona.setTextColor(color);
                    buttonb.setChecked(false);
                    buttonb.setTextColor(color);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(Color.GREEN);
                }


            }
            else if(answer ==1){
                buttona.setChecked(true);
                buttona.setTextColor(Color.RED);
                if(test.GetRightAnswer(quest_num) == 2){
                    buttonb.setChecked(false);
                    buttonb.setTextColor(Color.GREEN);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(color);
                }
                else{
                    buttonb.setChecked(false);
                    buttonb.setTextColor(color);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(Color.GREEN);
                }

            }
            else if(answer ==2){
                buttonb.setChecked(true);
                buttonb.setTextColor(Color.RED);
                if(test.GetRightAnswer(quest_num) == 1){
                    buttona.setChecked(false);
                    buttona.setTextColor(Color.GREEN);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(color);
                }
                else{
                    buttona.setChecked(false);
                    buttona.setTextColor(color);
                    buttonc.setChecked(false);
                    buttonc.setTextColor(Color.GREEN);
                }
            }
            else if(answer ==3){
                buttonc.setChecked(true);
                buttonc.setTextColor(Color.RED);
                if(test.GetRightAnswer(quest_num) == 2){
                    buttonb.setChecked(false);
                    buttonb.setTextColor(Color.GREEN);
                    buttona.setChecked(false);
                    buttona.setTextColor(color);
                }
                else{
                    buttonb.setChecked(false);
                    buttonb.setTextColor(color);
                    buttona.setChecked(false);
                    buttona.setTextColor(Color.GREEN);
                }
            }
        }

        ImageButton button1 = (ImageButton)findViewById(R.id.button);
        button1.setVisibility(View.VISIBLE);
        ImageButton button6 = (ImageButton)findViewById(R.id.button6);
        button6.setVisibility(View.GONE);

    }


    public void endTest(View view){
        setResult(RESULT_OK, null);
        finish();
    }

    @Override
    public void onBackPressed(){
        //stopTimer();
        finish();
    }
}

