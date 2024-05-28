package com.example.dp_project.Stragety_Pattern;
import com.example.dp_project.db_class;
public class Strategy
{

    String name;
    String ph;
    String Address;
    String city;
    int salary;
    private Strategy_Interface strat;
    db_class d1;

    public Strategy()
    {

    }
    public Strategy(String name,String ph,String add,String city,Strategy_Interface strat,db_class d1)
    {
        this.name = name;
        this.ph = ph;
        this.Address = add;
        this.city = city;
        this.strat = strat;
        this.d1 = d1;
    }
    public int getsal()
    {
       return strat.getsal();
    }
    public void getallowances(int a1)
    {
        salary = strat.add_allowances(a1);
    }

    public void insertdata()
    {
        d1.insertuser(name,ph,Address,city,salary);
    }


}
