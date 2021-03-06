package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {


    // i just changed file name from database.txt to database.csv
    // because i want to write in csv file not text file
    // if you want to write in text file like the video on youtube
    // just change database.csv to database.txt
    public  static  String filename="database.csv";




    // main method
    public static void main(String[] args) {


      createNewFileWithHeaders();
        displayServices();


    }

    // methods

    public static void createNewFileWithHeaders(){
        File database=new File(filename);

        try {

            if( database.createNewFile()==true){

                try {
                    FileWriter writer=new FileWriter(filename,true);
                    writer.append("User ID"+","+"User Name"+","+"Age"+","+"Job"+","+"Address");
                    writer.append("\n");
                    writer.close();
                    System.out.println("file created succefully!");
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
            else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAddNewPerson( Scanner input){
        System.out.println("Please Enter Id  ");
        String id=input.next();
        id+= "$"+new Random().nextInt(100);
        System.out.println("please enter your name");
        String name=input.next();
        System.out.println("Please Enter your age  ");
        String age=input.next();
        System.out.println("please enter your job");
        String job=input.next();
        System.out.println("please enter your address");
        String address=input.next();
        Person person=new Person(id,name,age,job,address);

        try {
            FileWriter writer=new FileWriter(filename,true);
            writer.append(person.getUserData());
            writer.append("\n");
            writer.close();
            System.out.println("person added succefully!");
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void  deleteRecordById(ArrayList<String> arrayList,Scanner input){
        System.out.println("enter any id or word to delete a record");
        String searchKey=input.next();
        String line;
        try {

            BufferedReader reader=new BufferedReader(new FileReader(filename));
            while ((line=reader.readLine())!=null){
                if(line.contains(searchKey)){
                    System.out.println(line);
                    continue;
                }else {
                    arrayList.add(line);
                }



            }

        }catch (Exception e){

        }
        try {
            FileWriter writer=new FileWriter(filename);
            for (int i=0;i<arrayList.size();i++){
                writer.append( arrayList.get(i));
                writer.append("\n");


            }
            writer.close();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("done!");
        }}

    public static void updateRecord(ArrayList<String>arrayList,Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            System.out.println("please enter any key to update the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println("enter the text you want to change");
                    String oldValue=input.next();
                    System.out.println("enter the new text you want to change");
                    String newValue=input.next();
                    arrayList.add(line.replace(oldValue,newValue));


                }else {
                    arrayList.add(line);
                }

            }


        }catch (Exception e){
            System.out.println(e);
        }

        try {
            FileWriter writer=new FileWriter(filename);
            for(int i=0;i<arrayList.size();i++){
                writer.append(arrayList.get(i));
                writer.append("\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void getUserById(Scanner input){
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            System.out.println("please enter any key to get the record");
            String searchKey=input.next();
            String line;
            while ((line=reader.readLine())!=null){
                if(   line.contains(searchKey)){
                    System.out.println(line);

                }

            }


        }catch (Exception e){
            System.out.println(e);
        }


    }
    public static void getAllPersons(){

        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));


            String line;
            while ((line=reader.readLine())!=null){

                System.out.println(line);

            }

        }catch (Exception e){
            System.out.println(e);
        }





    }



    public static void  displayServices(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while(true){
            ArrayList<String> arrayList=new ArrayList<String>();

            System.out.println("please choose any service");
            System.out.println("===========================");
            System.out.println("press 1 to add new person");
            System.out.println("press 2 to delete  person");
            System.out.println("press 3 to update  person");
            System.out.println("press 4 to get user by Id");
            System.out.println("press 5 to get all persons ");
            System.out.println("press 0 to Exit");
            System.out.println("===========================");
            int x=  input.nextInt();
            if(x==0) break;
            else if(x==1){
                createAddNewPerson(input);
            }
            else  if(x==2){

                deleteRecordById(arrayList,input);
            }
            else  if(x==3){
                updateRecord(arrayList,input);
            }
            else if(x==4){
                getUserById(input);

            }
            else if(x==5){

            }
            else {
                System.out.println("please enter a vaild number");
            }




        }
    }





}
