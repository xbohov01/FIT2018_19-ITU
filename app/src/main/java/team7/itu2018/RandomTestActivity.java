package team7.itu2018;

import android.content.Intent;
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

public class RandomTestActivity extends AppCompatActivity {

    int questionOrder = 1;
    int seconds = 60;
    int minutes = 19;
    Timer timer;
    int quest_num = 0;
    Test_database test = new Test_database();
    int[] answers = new int[27];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);

        //back and next
        Button button1 = (Button)findViewById(R.id.button);
        button1.setVisibility(View.GONE);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setVisibility(View.GONE);

        Arrays.fill(answers,0);
        //question
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.GONE);

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);

        buttona.setVisibility(View.GONE);
        buttonb.setVisibility(View.GONE);
        buttonc.setVisibility(View.GONE);

        Button button4 = (Button)findViewById(R.id.but_koniec);
        button4.setVisibility(View.GONE);
    }

    public void nextQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.name_vys);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        ImageView image_test = (ImageView)findViewById(R.id.image_test);

        if(buttona.isChecked()){
            answers[quest_num] = 1;
        }
        else if(buttonb.isChecked()){
            answers[quest_num] = 2;
        }
        else if(buttonc.isChecked()){
            answers[quest_num] = 3;
        }
        else {
            answers[quest_num] = 0;
        }

        questionOrder++;
        String text = "Otázka "+questionOrder+"/27";
        textView.setText(text);

        quest_num++;
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);
        if(test.GetPicture(quest_num).equals("")){
            image_test.setVisibility(View.GONE);
        }
        else{
            int resId = getResources().getIdentifier(test.GetPicture(quest_num), "drawable", getPackageName());
            image_test.setImageResource(resId);
            image_test.setVisibility(View.VISIBLE);
        }

        if(quest_num == 26){
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.GONE);
            Button button4 = (Button)findViewById(R.id.but_koniec);
            button4.setVisibility(View.VISIBLE);
        }
        else{
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.VISIBLE);
            Button button4 = (Button)findViewById(R.id.but_koniec);
            button4.setVisibility(View.GONE);
        }
        //radio button
        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));

        if(answers[quest_num] == 0){
            buttona.setChecked(false);
            buttonb.setChecked(false);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==1){
            buttona.setChecked(true);
            buttonb.setChecked(false);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==2){
            buttona.setChecked(false);
            buttonb.setChecked(true);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==3){
            buttona.setChecked(false);
            buttonb.setChecked(false);
            buttonc.setChecked(true);
        }
    }

    public void previousQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.name_vys);
        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);
        ImageView image_test = (ImageView)findViewById(R.id.image_test);

        if(buttona.isChecked()){
            answers[quest_num] = 1;
        }
        else if(buttonb.isChecked()){
            answers[quest_num] = 2;
        }
        else if(buttonc.isChecked()){
            answers[quest_num] = 3;
        }
        else {
            answers[quest_num] = 0;
        }

        questionOrder--;
        String text = "Otázka "+questionOrder+"/27";
        textView.setText(text);

        quest_num--;
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);

        if(test.GetPicture(quest_num).equals("")){
            image_test.setVisibility(View.GONE);
        }
        else{
            int resId = getResources().getIdentifier(test.GetPicture(quest_num), "drawable", getPackageName());
            image_test.setImageResource(resId);
            image_test.setVisibility(View.VISIBLE);
        }

        if(quest_num == 0){
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.GONE);
        }
        else{
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.VISIBLE);
            Button button4 = (Button)findViewById(R.id.but_koniec);
            button4.setVisibility(View.GONE);
        }
        //radio button
        buttona.setText(test.GetAnswerA(quest_num));
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonc.setText(test.GetAnswerC(quest_num));

        if(answers[quest_num] == 0){
            buttona.setChecked(false);
            buttonb.setChecked(false);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==1){
            buttona.setChecked(true);
            buttonb.setChecked(false);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==2){
            buttona.setChecked(false);
            buttonb.setChecked(true);
            buttonc.setChecked(false);
        }
        else if(answers[quest_num] ==3){
            buttona.setChecked(false);
            buttonb.setChecked(false);
            buttonc.setChecked(true);
        }
    }

    public void startTimer(View view){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Update timer
                seconds--;
                if (seconds == 0){
                    seconds = 59;
                    minutes--;
                }
                String text = String.format("%02d:%02d",minutes,seconds);
                TextView textView = (TextView) findViewById(R.id.timer);
                textView.setText(text);
            }
        }, 0, 1000);

        ImageView image_test = (ImageView)findViewById(R.id.image_test);
        image_test.setVisibility(View.GONE);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setVisibility(View.GONE);

        Button button1 = (Button)findViewById(R.id.button);
        button1.setVisibility(View.VISIBLE);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setVisibility(View.GONE);

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setVisibility(View.VISIBLE);

        //radio button
        RadioButton buttona = (RadioButton)findViewById(R.id.buttona);
        buttona.setText(test.GetAnswerA(quest_num));
        buttona.setVisibility(View.VISIBLE);

        RadioButton buttonb = (RadioButton)findViewById(R.id.buttonb);
        buttonb.setText(test.GetAnswerB(quest_num));
        buttonb.setVisibility(View.VISIBLE);

        RadioButton buttonc = (RadioButton)findViewById(R.id.buttonc);
        buttonc.setText(test.GetAnswerB(quest_num));
        buttonc.setVisibility(View.VISIBLE);

    }

    public void stopTimer(){
        timer.cancel();
        seconds = 60;
        minutes = 20;
    }


    public void endTest(View view){
        //stopTimer();
        finish();
    }

    public void viewResults(View view){
        //stopTimer();
        Intent intent = new Intent(this, TestResultsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        //stopTimer();
        finish();
    }
}
