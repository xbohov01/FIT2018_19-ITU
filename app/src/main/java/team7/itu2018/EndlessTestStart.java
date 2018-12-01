package team7.itu2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;


public class EndlessTestStart extends AppCompatActivity {

    boolean Qtext =false;
    boolean Qtech =false;
    boolean Qznac =false;
    boolean Qkriz =false;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                this.finish();

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_endless);

    }

    public void endTest(View view){
        finish();
    }

    public void StartTest(View view){




        Intent intent = new Intent(this, EndlessTest.class);
        intent.putExtra("text",Qtext);
        intent.putExtra("tech",Qtech);
        intent.putExtra("znac",Qznac);
        intent.putExtra("kriz",Qkriz);
        startActivityForResult(intent, 5);
    }


    @Override
    public void onBackPressed(){
        finish();
    }
}
