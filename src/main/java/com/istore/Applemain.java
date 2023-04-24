package com.istore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;

public class Applemain {

	public static void main(String[] args) throws Exception
	{ 
		// TODO Auto-generated method stub
		System.out.println("\t\t\t******** Welcome to Apple Store********");
		
		Connection con=null;
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apple_store","root","7498237567");
			  
			  String selectQuery ="SELECT * FROM products";
			  Statement selectStatement = con.createStatement();
			  ResultSet rs = selectStatement.executeQuery(selectQuery);
			  System.out.println("Available products:");
			  while (rs.next()) {
				  System.out.println("product ID: " + rs.getInt("id"));
				  System.out.println("Name: " + rs.getString("name"));
				  System.out.println("Price: " + rs.getFloat("price"));
				  System.out.println("Description: " + rs.getString("description"));
			  }
			  
			  Scanner scanner = new Scanner(System.in);
			  System.out.println("Enter the product name:");
			  String productName = scanner.next();
			  System.out.println("Enter the cost you wish to order: ");
			  int cost = scanner.nextInt();
			  System.out.println("Enter your name: ");
			  String customerName = scanner.next();
			  System.out.println("Enter your email:");
			  String customerEmail = scanner.next();
			  
			  String insertQuery = "INSERT INTO orders (product_name, cost, customer_name, customer_email)  VALUES (?, ?, ?, ?)";
			  PreparedStatement insertStatement = con.prepareStatement(insertQuery);
			  insertStatement.setString(1, productName);
			  insertStatement.setInt(2, cost);
			  insertStatement.setString(3, customerName);
			  insertStatement.setString(4, customerEmail);
			  int rowsInserted = insertStatement.executeUpdate();
			  if (rowsInserted > 0) {
				   System.out.println("Order Placed succesfully.");
			  }
			  
			  con.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
