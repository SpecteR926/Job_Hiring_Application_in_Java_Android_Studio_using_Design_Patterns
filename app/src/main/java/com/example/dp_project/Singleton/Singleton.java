package com.example.dp_project.Singleton;

public class Singleton {
    public static Singleton instance;
    private final String email;
    private final String pass;
        private Singleton(String email,String pass) {
            this.email = email;
            this.pass = pass;
        }

        public static Singleton getInstance(String email,String pass)
        {
            if (instance == null)
            {
                instance = new Singleton(email,pass);
            }
            return instance;
        }

        public String getUseremail()
        {
            return this.email;
        }

        public String getUserpass()
        {
            return this.pass;
        }
    }
