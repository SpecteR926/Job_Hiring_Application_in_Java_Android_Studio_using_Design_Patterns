package com.example.dp_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dp_project.Singleton.Singleton;
import com.example.dp_project.Stragety_Pattern.Full_time;
import com.example.dp_project.Stragety_Pattern.Part_time;
import com.example.dp_project.Stragety_Pattern.Strategy;


public class Hiring_Page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring_page);
        if (Singleton.instance != null);
        {
            try {

                db_class obj = new db_class(getApplicationContext(),"DP_DB3",null,1);
                String[] user = {"Part-Time", "Full-Time"};
                Button b1 = (Button) findViewById(R.id.btnhire);
                Button b2 = (Button) findViewById(R.id.btncreatejob);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int1 = new Intent(getApplicationContext(),Choose_job_type.class);
                        startActivity(int1);
                    }
                });
                EditText et1 = (EditText) findViewById(R.id.etname);
                EditText et2 = (EditText) findViewById(R.id.etadd);
                Button btn2  = (Button) findViewById(R.id.btnlogouthiring);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Singleton.instance=null;
                        Intent a1 = new Intent(getApplicationContext(), Login.class);
                        startActivity(a1);
                    }
                });
                EditText et3 = (EditText) findViewById(R.id.etcity);
                EditText et4 = (EditText) findViewById(R.id.etnum);
                Spinner spdept = (Spinner) findViewById(R.id.spinner);
                ArrayAdapter<String> spn = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,user);
                spdept.setAdapter(spn);

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String d1 = et1.getText().toString().trim();
                        String d2 = et2.getText().toString().trim();
                        String d3 = et3.getText().toString().trim();
                        String d4 = et4.getText().toString().trim();
                        String selectedValue = spdept.getSelectedItem().toString().trim();
                        if (selectedValue.equals("Part-Time")) {
                            Toast.makeText(getApplicationContext(), selectedValue, Toast.LENGTH_SHORT).show();
                            Strategy s1 = new  Strategy(d1, d4, d2, d3, new Part_time() ,obj);
                            int sal = s1.getsal();
                            s1.getallowances(sal);
                            s1.insertdata();

                        } else if (selectedValue.equals("Full-Time")) {
                            Toast.makeText(getApplicationContext(), selectedValue, Toast.LENGTH_SHORT).show();
                            Strategy s1 = new  Strategy(d1, d4, d2, d3, new Full_time() ,obj);
                            int sal = s1.getsal();
                            s1.getallowances(sal);
                            s1.insertdata();
                        } else
                        {
                            Toast.makeText(getApplicationContext(), "Unknown user type", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            catch(Exception e)
            {
                Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_SHORT).show();
            }
        }


    }

}