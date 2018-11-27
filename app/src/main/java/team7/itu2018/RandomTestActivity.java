package team7.itu2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RandomTestActivity extends AppCompatActivity {

    int questionOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);
    }

    public void nextQuestion(View view){
        TextView textView = (TextView)findViewById(R.id.question);
        questionOrder++;
        textView.setText(String.format("Otázka %s/25"));
    }
}
