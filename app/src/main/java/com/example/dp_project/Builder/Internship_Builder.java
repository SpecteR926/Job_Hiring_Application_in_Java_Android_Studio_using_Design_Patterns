package com.example.dp_project.Builder;

public class Internship_Builder implements Builder {

    String jobname;
    String jobtype;
    String jobskill;



    public Builder name()
    {
        this.jobname="Web App InternShip";
        return this;
    }
    public Builder type()
    {
        this.jobtype="Part time";
        return this;
    }
    public Builder skill()
    {
        this.jobskill="none";
        return this;
    }
    public Job build() {
        return new Job(jobname,jobtype,jobskill);
    }
}


