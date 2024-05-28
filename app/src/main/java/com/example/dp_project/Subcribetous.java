package com.example.dp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dp_project.Singleton.Singleton;
import com.example.dp_project.observer.Observer;
import com.example.dp_project.observer.Subject;

public class Subcribetous extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcribetous);
        if(Singleton.instance != null);
        {
            db_class obj = new db_class(getApplicationContext(),"DP_DB3",null,1);
            Subject s1 = new Subject();
            EditText et1 = (EditText) findViewById(R.id.etsubemail);
            Button b1 = (Button) findViewById(R.id.btnsub);
            Button b2 = (Button) findViewById(R.id.btnunsub);
            Button btn2  = (Button) findViewById(R.id.btnlogoutsub);
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
                    Observer o = new Observer(et1.getText().toString());
                    obj.sub(s1.sub(o.email));
                    Toast.makeText(getApplicationContext(), "Subscribed to Job Postings ", Toast.LENGTH_SHORT).show();
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Observer o = new Observer(et1.getText().toString());
                    obj.unsub(s1.unsub(o.email));
                    Toast.makeText(getApplicationContext(), "Unsubscribed from Job Postings ", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}