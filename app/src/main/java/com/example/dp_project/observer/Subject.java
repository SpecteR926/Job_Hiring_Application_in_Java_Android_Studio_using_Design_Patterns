package com.example.dp_project.observer;

import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Stream;

public class Subject {
    Observer ob;
    String msg = "New Job Alert";
    private List<String> email1 ;
    public void s1(List<String> email)
    {
        this.email1=email;
    }
    public void update(){

        SmsManager smsManager = SmsManager.getDefault();
        for (int i = 0; i < email1.size(); i++) {
            smsManager.sendTextMessage(email1.get(i),null,msg,null,null);
        }
    }
    public String sub(String a)
    {
        return a;
    }
    public String unsub(String a)
    {
        return a;
    }
}
