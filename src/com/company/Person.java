package com.company;

public class Person {
    // attributes
    private String id;
    private String name;
    private  String age;
    private  String job;
    private  String address;

    Person(String id , String name, String age,String job, String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.job=job;
        this.address=address;

    }

    public  String getUserData(){
return  "User Id : " +id+ " User name : " + name +" Age : "+ age + " Job :"+ job+ " address : " +address;
    }


    // methods



}
