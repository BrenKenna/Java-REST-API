/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeopleServlet;

/**
 *  Constructor, getters and setters for Person object
 * 
 * @author kenna
 */
public class Person {
    
    // Initialize variables
    private String name;
    private int age;
    private String dateOfBirth;
    
    /**
     * Constructor for person object used by the Data store
     * @param name
     * @param age
     * @param dateOfBirth
     */
    public Person(String name, int age, String dateOfBirth){
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
