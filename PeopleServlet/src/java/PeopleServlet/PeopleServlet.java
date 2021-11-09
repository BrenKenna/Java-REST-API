/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeopleServlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject ;


/**
 *
 * @author kenna
 */
public class PeopleServlet extends HttpServlet {
    
    
    // Get requests
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // Parse get request and query data store
        String requestUrl = request.getRequestURI();
        String[] url = requestUrl.split("/");
        String name = url[url.length-1];
        Person person = DataStore.getInstance().getPerson(name);
        
        // Seralize to JSON if not null
        if (person != null) {
        
            // JSON string
            String json = "{\n";
            json += "\t\"name\":" + JSONObject.quote(person.getName()) + ",\n";
            json += "\t\"birthDate\":" + JSONObject.quote(person.getDateOfBirth()) + ",\n";
            json += "\t\"age\":" + person.getAge() + "\n";
            json += "}";
            response.getOutputStream().println(json);
        } else {
            
            // Otherwise set empty query response
            response.getOutputStream().println("Request URI = " + requestUrl + ", Name = " + name);
        }
    }
    
}
