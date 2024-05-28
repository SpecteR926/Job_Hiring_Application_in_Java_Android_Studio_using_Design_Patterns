package com.example.dp_project.Builder;

public class Job_Builder implements Builder {
    String jobname;
    String jobtype;
    String jobskill;

    public Builder name()
    {
        this.jobname="Mobile APP Developer";
        return this;
    }
    public Builder type()
    {
        this.jobtype="Full Time";
        return this;
    }
    public Builder skill()
    {
        this.jobskill="Andriod Studio, Java";
        return this;
    }
    public Job build() {
        return new Job(jobname,jobtype,jobskill);
    }
}
