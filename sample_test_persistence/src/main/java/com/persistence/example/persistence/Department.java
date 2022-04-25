package com.persistence.example.persistence;

abstract public class Department {


    private String name;

    public String getName() {
        return "====================:"+name;
    }

    public abstract void setName(String name);

}
