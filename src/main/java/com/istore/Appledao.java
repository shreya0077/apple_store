package com.istore;

import java.sql.*;
import java.util.*;

public class Appledao {
	Connection con=null;
	
	public void dbconnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apple_store","root", "7498237567");
		
	}

}
