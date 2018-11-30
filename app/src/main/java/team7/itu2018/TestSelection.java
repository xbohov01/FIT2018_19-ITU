package team7.itu2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selection);
    }

    public void testSelectButton(View view){
        Intent intent = new Intent(this, RandomTestActivity.class);
        startActivity(intent);
    }
}
