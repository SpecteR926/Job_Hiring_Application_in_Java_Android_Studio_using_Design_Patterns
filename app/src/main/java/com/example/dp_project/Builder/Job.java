package com.example.dp_project.Builder;

public class Job  {

    String jobname;
    String jobtype;
    String jobskill;

    Job(String jobname,String jobtype,String jobskill) {
        this.jobname=jobname;
        this.jobtype=jobtype;
        this.jobskill=jobskill;

    }
    public String getJobname()
    {
        return jobname;
    }
    public String getjobtype()
    {
        return jobtype;
    }
    public String getjobskill()
    {
        return jobskill;
    }

}