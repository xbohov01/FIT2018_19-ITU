package team7.itu2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.mainMenuToolbar);
        setSupportActionBar(myToolbar);
    }

    //Called when user selects random test button
    public void randomTestButton(View view){
        //Intent to do whatevs
        Intent intent = new Intent(this, RandomTestActivity.class);
        //Add additional data if needed
        startActivity(intent);
    }

    public void testSelectButton(View view){
        Intent intent = new Intent(this, TestSelection.class);
        startActivity(intent);
    }

    public void endlessTestButton(View view){
        Intent intent = new Intent(this, EndlessTestStart.class);
        startActivity(intent);
    }

    public void achievementsButton(View view){
        Intent intent = new Intent(this, AchievementsActivity.class);
        startActivity(intent);
    }

    public void settingsButton(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void myResultsButton(View view){
        Intent intent = new Intent(this, MyResults.class);
        startActivity(intent);
    }
}
