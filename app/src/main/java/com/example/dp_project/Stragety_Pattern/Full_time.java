package com.example.dp_project.Stragety_Pattern;

public class Full_time implements Strategy_Interface {

    public int getsal()
    {
        return 20000;
    }
    public int add_allowances(int a1)
    {
        return a1+5000;
    }
}
