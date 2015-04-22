package com.example.ronald.footmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.parse.*;
import com.parse.entity.mime.content.StringBody;

public class MainActivity extends Activity {

    private RadioGroup collegeGroup;
    private RadioButton ZhengyutongButton, CaijiyouButton, LvzhiheButton, ShaobangButton,
                        ManzhenButton, ZhenxiButton, CaoguangbiaoButton, Dongyabutton;
    private Button nextButton;
    private String currentUserId;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collegeGroup = (RadioGroup)findViewById(R.id.collegeGroup);
        ZhengyutongButton = (RadioButton)findViewById(R.id.ZhengyutongButton);
        CaijiyouButton = (RadioButton)findViewById(R.id.CaijiyouButton);
        LvzhiheButton = (RadioButton)findViewById(R.id.LvzhiheButton);
        ShaobangButton = (RadioButton)findViewById(R.id.ShaobangButton);
        ManzhenButton = (RadioButton)findViewById(R.id.ManzhenButton);
        ZhenxiButton = (RadioButton)findViewById(R.id.ZhenxiButton);
        CaoguangbiaoButton = (RadioButton)findViewById(R.id.CaoguangbiaoButton);
        Dongyabutton = (RadioButton)findViewById(R.id.DongyaButton);
        nextButton = (Button)findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = collegeGroup.getCheckedRadioButtonId();

                currentUserId = ParseUser.getCurrentUser().getObjectId();
                ParseObject message = new ParseObject("Match");

                //ParseObject matchInfo = new ParseObject("test");

                if(selectedId == ZhengyutongButton.getId()){

                    message.put("userId",currentUserId);
                    message.put("placeSelected","Zhengyutong");
                    message.saveInBackground();
                    Toast.makeText(getApplicationContext(), "已选择郑裕彤书院",Toast.LENGTH_SHORT).show();

                } else if(selectedId == CaijiyouButton.getId()){
                    message.put("userId",currentUserId);
                    message.put("placeSelected","Caijiyou");
                    message.saveInBackground();
                    Toast.makeText(getApplicationContext(), "已选择菜基友书院。",Toast.LENGTH_SHORT).show();
                } else if(selectedId == LvzhiheButton.getId()){
                    message.put("userId",currentUserId);
                    message.put("placeSelected","Lvzhihe");
                    message.saveInBackground();
                    Toast.makeText(getApplicationContext(), "已选择吕志和书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                } else if(selectedId == ShaobangButton.getId()){
                    message.put("userId",currentUserId);
                    message.put("placeSelected","Shaobang");
                    message.saveInBackground();
                    Toast.makeText(getApplicationContext(), "已选择绍帮书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                } else if(selectedId == ManzhenButton.getId()){
                    Toast.makeText(getApplicationContext(), "已选择满珍书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                } else if(selectedId == ZhenxiButton.getId()){
                    Toast.makeText(getApplicationContext(), "已选择珍禧书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                } else if(selectedId == CaoguangbiaoButton.getId()){
                    Toast.makeText(getApplicationContext(), "已选择曹光彪书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                } else {
                    Toast.makeText(getApplicationContext(), "已选择东亚书院。",Toast.LENGTH_SHORT).show();
                    // Insert the information
                }



                Intent nextPage = new Intent(MainActivity.this, SelectTimeActivity.class);
                startActivity(nextPage);
            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
