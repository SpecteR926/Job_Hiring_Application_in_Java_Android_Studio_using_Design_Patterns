package com.example.dp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db_class obj = new db_class(getApplicationContext(),"DP_DB3",null,1);
        EditText et1 = (EditText) findViewById(R.id.etemailsignu);
        EditText et2 = (EditText) findViewById(R.id.etpasssignu);
        Button b1 = (Button) findViewById(R.id.btnsignu);
        Button b2 = (Button) findViewById(R.id.btngotologin);
        try {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    obj.register(et1.getText().toString().trim(),et2.getText().toString().trim());
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a1 = new Intent(getApplicationContext(), Login.class);
                    startActivity(a1);
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e+"",Toast.LENGTH_SHORT).show();
        }


    }
}