package spring.db.webtest;

import java.sql.*;

public class DBOpen {
	
	public static Connection open() {
		Connection con = null;
		
		try {
			Class.forName(Constance.DRIVER);
			con = DriverManager.getConnection(Constance.URL, Constance.USER, Constance.PASSWD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;		
	}



}
