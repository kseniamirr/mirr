package com.mirr.tickets.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnector {
    public static void main(String[] args) {

        try {
            //Get a connection to database
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hometask", "root", "Parol555");

            //Create a statement
            Statement myStmt = myConnection.createStatement();

            //Execute SQL query
            ResultSet myRs =myStmt.executeQuery("select * from user_table");

            //process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + myRs.getString("last_name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
