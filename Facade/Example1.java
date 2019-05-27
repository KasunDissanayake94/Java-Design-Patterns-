/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.facade;

interface Attend{
    void attending();
}
class Student implements Attend{
    @Override
    public void attending(){
        System.out.println("I am attending school...");
    }
    public void studying(){
        System.out.println("I am studying....");
    }
    
}
class Teacher implements Attend{
    @Override
    public void attending(){
        System.out.println("I am attending school...");
    }
    public void teaching(){
        System.out.println("I am teaching...");
    }
}

//Facade Class start here
class Facade{
    
    Student student;
    Teacher teacher;
    
    public Facade(){
        student = new Student();
        teacher = new Teacher();
    }
    
    public void teaching(){
        teacher.attending();
        teacher.teaching();
    }
    public void studying(){
        student.attending();
        student.studying();
    }
    
}

/**
 *
 * @author Kasun Dissanayake
 */
public class Example1 {
   
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.teaching();
        facade.studying();
    }
}
