package team7.itu2018;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class RandomTestActivity extends AppCompatActivity {

    int questionOrder = 1;
    int seconds = 60;
    int minutes = 19;
    Timer timer;
    int quest_num = 0;
    Test_database test = new Test_database();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);

        Button button1 = (Button)findViewById(R.id.button);
        button1.setVisibility(View.GONE);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setVisibility(View.GONE);

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.GONE);

    }

    public void nextQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.question);
        questionOrder++;
        String text = "Otázka "+questionOrder+"/27";
        textView.setText(text);

        quest_num++;
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);

        if(quest_num == 26){
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.GONE);
        }
        else{
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.VISIBLE);
        }
    }

    public void previousQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.question);
        questionOrder--;
        String text = "Otázka "+questionOrder+"/25";
        textView.setText(text);

        quest_num--;
        TextView question = (TextView)findViewById(R.id.question_text);
        question.setText(test.GetQuestion(quest_num));
        question.setVisibility(View.VISIBLE);


        if(quest_num == 0){
            Button button_next = (Button)findViewById(R.id.button2);
            button_next.setVisibility(View.GONE);
        }
        else{
            Button button_next = (Button)findViewById(R.id.button);
            button_next.setVisibility(View.VISIBLE);
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

         Button button3 = (Button)findViewById(R.id.button3);
         button3.setVisibility(View.GONE);

        Button button1 = (Button)findViewById(R.id.button);
        button1.setVisibility(View.VISIBLE);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setVisibility(View.VISIBLE);

        TextView question = (TextView)findViewById(R.id.question_text);
        question.setVisibility(View.VISIBLE);
    }

    public void stopTimer(){
        timer.cancel();
        seconds = 60;
        minutes = 20;
    }

    public void setPoints (View view, String pointsText){
        TextView textView = (TextView) findViewById(R.id.points);
        textView.setText(pointsText);
    }

    public void endTest(View view){
        stopTimer();
        finish();
    }

    @Override
    public void onBackPressed(){
        stopTimer();
        finish();
    }
}
