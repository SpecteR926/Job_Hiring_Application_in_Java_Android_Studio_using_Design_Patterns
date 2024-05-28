package com.example.dp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dp_project.Singleton.Singleton;
import com.example.dp_project.observer.Subject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db_class obj = new db_class(getApplicationContext(),"DP_DB3",null,1);
        EditText et1 = (EditText) findViewById(R.id.etloginemail);
        EditText et2 = (EditText) findViewById(R.id.etloginpass);
        Button b1 = (Button) findViewById(R.id.btnLogin);
        Button b2 = (Button) findViewById(R.id.btngotoregister);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et1.getText().toString();
                String pass = et2.getText().toString();
                int a1 = obj.getuser(email);
                int a2 = obj.getpass(pass);
                if (a1==a2)
                {
                   Singleton s1 = Singleton.getInstance(email,pass);
                   if(s1.getUseremail().equals("Admin") && s1.getUserpass().equals("Admin"))
                   {
                       Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                       Intent int1 = new Intent(getApplicationContext(),Hiring_Page.class);
                       startActivity(int1);
                   } else
                   {
                       Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                       Intent int1 = new Intent(getApplicationContext(), Subcribetous.class);
                       startActivity(int1);
                   }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid ID or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getApplicationContext(),Register.class);
                startActivity(int1);
            }
        });
    }
}