package team7.itu2018;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class RandomTestActivity extends AppCompatActivity {

    int questionOrder = 1;
    int seconds = 60;
    int minutes = 19;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);
    }

    public void nextQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.question);
        questionOrder++;
        String text = "Otázka "+questionOrder+"/25";
        textView.setText(text);
    }

    public void previousQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.question);
        questionOrder--;
        String text = "Otázka "+questionOrder+"/25";
        textView.setText(text);
    }

    public void startTimer(View view){
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Update timer
                seconds--;
                if (seconds == 0){
                    seconds = 60;
                    minutes--;
                }
                String text = String.valueOf(minutes)+":"+String.valueOf(seconds);
                TextView textView = (TextView) findViewById(R.id.timer);
                textView.setText(text);
            }
        }, 0, 1000);
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
