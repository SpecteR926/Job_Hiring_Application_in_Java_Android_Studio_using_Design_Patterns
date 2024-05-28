package com.example.dp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dp_project.Singleton.Singleton;

public class Choose_job_type extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Singleton.instance != null);
        {
            setContentView(R.layout.activity_choose_job_type);
            Button b1 = (Button) findViewById(R.id.btnchooseintern);
            Button b2 = (Button) findViewById(R.id.btnchoosejob);
            Button btn2  = (Button) findViewById(R.id.btntologout);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Singleton.instance=null;
                    Intent a1 = new Intent(getApplicationContext(), Login.class);
                    startActivity(a1);
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(getApplicationContext(),createinternship.class);
                    startActivity(a);
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(getApplicationContext(),CreateJob.class);
                    startActivity(a);
                }
            });
        }
    }
}