package com.company;

public class Person {
    // attributes
    public String id;
    public String name;
    public  String age;
    public  String job;
    public   String address;

    Person(String id , String name, String age,String job, String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.job=job;
        this.address=address;

    }

    public  String getUserData(){

return   id+"," + name +"," +age + ","+job+"," +address;
    }


    // methods



}
