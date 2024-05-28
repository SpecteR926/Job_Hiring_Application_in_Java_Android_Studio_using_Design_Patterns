package com.example.dp_project.Builder;

public class Director {

    public Job createinternship()
    {
        Builder j1 = new Internship_Builder();
    return j1.name().type().skill().build();

    }
    public Job createjob()
    {
        Builder j1 = new Job_Builder();
        return j1.name().type().skill().build();

    }

}
