/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlworldapp;

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * Additional configuration:
 *  MySQL:
 *      ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
 *       FLUSH PRIVILEGES;
 * 
 *  Charsets:
 *      latin-1, utf8, utf-8, utf8mb4, utf8-mb4, utf8mb4_0900_ai_ci
 */
public class MysqlWorldApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        // Try connect to the world database
        try {

            // Establish connection
            System.out.println("Attemplting to connect MySQL server");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/world?characterEncoding=utf8",
                        "root", "Pa55w.rd1234"
            );


            // Create a statement and query
            System.out.println("\nQuerying world.country:");
            Statement stmt = con.createStatement();
            String query = "SELECT Continent, Name, Population FROM country ORDER BY Continent, Name, Population asc LIMIT 100;";
            ResultSet rs = stmt.executeQuery(query);


            // Populate output data
            // Can be function which returns arraylist from result set
            System.out.println("\nPopulating output array list from query:");
            ArrayList data = new ArrayList<String>();
            data.add("\nContinent\tCountry\tPopulation Per Million");
            String row;
            int counter = 0;
            while (rs.next()) {
                row = rs.getString(1) + "\t" + rs.getString(2)  + "\t" + (rs.getDouble(3)/1000000);
                data.add(row);
            }
            rs.close();
            con.close();


            // Print first ten rows
            System.out.println("\nDisplaying 10 row sanity check of results");
            for(int i =0; i < 9; i++) {
                System.out.println(data.get(i).toString().replace("\t", ","));
            }


            // Write results to file
            // Could be its own function data, delimiter and optional header
            System.out.println("\nWriting results to country-continet-population.tsv");
            String fileName = "country-continet-population.tsv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            for(int i = 0; i < data.size(); i++ ){
                writer.write(data.get(i).toString() + "\n");
            }
            writer.close();

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error " + e);
        }
    }
}
