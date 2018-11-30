package team7.itu2018;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class TestResultsActivity extends AppCompatActivity {

    int[] answers = new int[27];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            answers = extras.getIntArray("answers");
        }



    }

    public void ShowAnswers(View view){
        finish();
    }

    public void endTest(View view){
        //stopTimer();
        finish();
    }

}