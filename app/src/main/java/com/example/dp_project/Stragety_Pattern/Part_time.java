package com.example.dp_project.Stragety_Pattern;

public class Part_time implements Strategy_Interface {
    public int getsal()
    {
        return 10000;
    }
    public int add_allowances(int a1)
    {
        return a1+2000;
    }

}
