package team7.itu2018;

import android.content.Intent;
import android.graphics.Color;
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
    int body = 0;
    int spravne_odpovede = 0;
    int nespravne_odpovede = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            answers = extras.getIntArray("answers");
        }
        Test_database test = new Test_database();

        for(int i = 0; i<27; i++){
            if(test.GetRightAnswer(i) == answers[i]){
                spravne_odpovede++;
                body = body + test.GetPoints(i);
            }
            else{
                nespravne_odpovede++;
            }
        }

        TextView so = (TextView)findViewById(R.id.textView2);
        String text = "Počet správnych odpovedí: "+ spravne_odpovede;
        so.setText(text);

        TextView no = (TextView)findViewById(R.id.textView3);
        text = "Počet nesprávnych odpovedí: "+ nespravne_odpovede;
        no.setText(text);

        TextView pb = (TextView)findViewById(R.id.textView4);
        text = "Počet bodov: "+ body;
        pb.setText(text);

        if(body>=55){
            TextView hlaska = (TextView)findViewById(R.id.textView5);
            text = "Testom si prešiel! Super";
            hlaska.setText(text);
        }
        else{
            TextView hlaska = (TextView)findViewById(R.id.textView5);
            text = "Testom si neprešiel! Skús znovu!";
            hlaska.setText(text);
            hlaska.setTextColor(Color.RED);
        }

        if (nespravne_odpovede == 0){
            Button but = (Button)findViewById(R.id.button5);
            but.setVisibility(View.GONE);
        }

    }

    public void showAnswers(View view){
        Intent intent = new Intent(this, SeeResultsActivity.class);
        intent.putExtra("answers",answers);
        startActivity(intent);
    }

    public void endTest(View view){
        //stopTimer();
        setResult(RESULT_OK, null);
        finish();
    }

}