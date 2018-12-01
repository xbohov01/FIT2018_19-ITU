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
        CheckBox chtext = (CheckBox)findViewById(R.id.checkBox);
        CheckBox chtech = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox chznac = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox chkriz = (CheckBox)findViewById(R.id.checkBox4);

        if(chtext.isChecked()){
            Qtext = true;
        }
        if(chtech.isChecked()){
            Qtech =true;
        }
        if(chznac.isChecked()){
            Qznac =true;
        }
        if(chkriz.isChecked()){
            Qkriz =true;
        }




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
