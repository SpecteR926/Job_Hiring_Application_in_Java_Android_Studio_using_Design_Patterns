package com.example.dp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dp_project.Builder.Director;
import com.example.dp_project.Builder.Job;
import com.example.dp_project.Singleton.Singleton;
import com.example.dp_project.observer.Subject;

public class createinternship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createinternship);
        if(Singleton.instance != null);
        {
            db_class obj = new db_class(getApplicationContext(),"DP_DB3",null,1);
            Button btn1  = (Button) findViewById(R.id.btnjobi);
            Button btn2  = (Button) findViewById(R.id.btnjob2i);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Singleton.instance=null;
                    Intent a1 = new Intent(getApplicationContext(), Login.class);
                    startActivity(a1);
                }
            });


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Director d1 = new Director();
                    Job j =  d1.createinternship();
                    String x = j.getJobname();
                    String y = j.getjobtype();
                    String z = j.getjobskill();
                    obj.insertjobs(x,y,z);
                    Subject s1 = new Subject();
                    s1.s1(obj.getData());
                    s1.update();
                }
            });

        }
    }
}