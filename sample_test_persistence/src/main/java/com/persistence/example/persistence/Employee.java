package com.persistence.example.persistence;

public class Employee {


    static{
        System.out.println("hello from  employee static block");
    }

    {
        System.out.println("hello from employee instance block ");
    }

    public Employee() {

        System.out.println("hello from employee constructor");
    }
}
