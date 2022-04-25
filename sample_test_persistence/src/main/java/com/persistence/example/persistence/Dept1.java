package com.persistence.example.persistence;

import org.springframework.stereotype.Component;

@Component
public class Dept1 extends  Department{

    @Override
    public void setName(String name){
        System.out.println("name is: " +name);
    }
    public String getName() {

        return "====================:"+this.getName();
    }



}
