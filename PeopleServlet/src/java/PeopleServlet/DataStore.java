/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeopleServlet;

import java.util.Map;
import java.util.HashMap;

/**
 * Creates a data store object with example data
 *      => Constructor creates example persons data
 *      => Normal getters and setter
 *
 * @author kenna
 */
public class DataStore {
    
    // Initalize variables
    private final Map<String, Person> personMap = new HashMap<>();
    
    
    // Constructor
    private DataStore(){
        personMap.put("John", new Person("John", 21, "21-03-1998") );
        personMap.put("Jane", new Person("Jane", 31, "24-11-1988") );
        personMap.put("Sarah", new Person("Sarah", 44, "18-09-1974") );
        personMap.put("Ron", new Person("Ron", 23, "06-05-2001") );
    }

    
    // Get and put person
    public void putPerson(Person person){
        personMap.put(person.getName(), person);
    }
    public Person getPerson(String name){
        return personMap.get(name);
    }
    
    
    // Singelton class
    private static DataStore instance = new DataStore();
	public static DataStore getInstance(){
		return instance;
	}
}
