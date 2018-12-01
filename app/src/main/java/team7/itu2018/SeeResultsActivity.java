package team7.itu2018;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class SeeResultsActivity extends AppCompatActivity {

    int quest_num = 0;
    Test_database test = new Test_database();
    int[] answers = new int[27];
    int color;
    boolean koniec;
    int prva = -1;
    int posledna = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_results);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            answers = extras.getIntArray("answers");
        }
        //back and next

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setVisibility(View.GONE);
        for(int i=0; i<27;i++){
            if(test.GetRightAnswer(i) != answers[i]){
                if(prva == -1){
                    prva = i;
                }
                posledna = i;
            }
        }

        //question
        boolean tmp = true;
        while(tmp){
            if(test.GetRightAnswer(quest_num) != answers[quest_num]){
                tmp = false;
            }
            else{
                quest_num++;
            }
        }

        if(quest_num == posledna){
            Button button = (Button)findViewById(R.id.button);
            button.setVisibility(View.GONE);
        }

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);


        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));
        color = buttona.getCurrentTextColor();
        if(answers[quest_num] == 0){
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
        else if(answers[quest_num] ==1){
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
        else if(answers[quest_num] ==2){
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
        else if(answers[quest_num] ==3){
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

    public void nextQuestion(View view){

        //question
        boolean tmp = true;
        while(tmp){
            quest_num++;
            if(test.GetRightAnswer(quest_num) != answers[quest_num]){
                tmp = false;
            }
            if(quest_num== 27){
                koniec = true;
                tmp = false;
            }
        }

        if(quest_num == posledna){
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.GONE);

        }
        else{
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.VISIBLE);
        }

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));
        if(answers[quest_num] == 0){
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
        else if(answers[quest_num] ==1){
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
        else if(answers[quest_num] ==2){
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
        else if(answers[quest_num] ==3){
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

    public void previousQuestion(View view){
        //question
        boolean tmp = true;
        while(tmp){
            quest_num--;
            if(test.GetRightAnswer(quest_num) != answers[quest_num]){
                tmp = false;
            }
            if(quest_num== 27){
                tmp = false;
            }
        }

        if(quest_num == prva){
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.GONE);
        }
        else{
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.VISIBLE);
        }
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));
        if(answers[quest_num] == 0){
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
        else if(answers[quest_num] ==1){
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
        else if(answers[quest_num] ==2){
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
        else if(answers[quest_num] ==3){
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


    public void endTest(View view){
        finish();
    }


    @Override
    public void onBackPressed(){
        finish();
    }
}
