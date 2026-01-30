package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    private static final String URL = "jdbc:postgresql://localhost:2010/postgres";
    private static final String NAME = "postgres";
    private static final String PASSWORD = "root";
    public static Connection getConnection() throws SQLException {
    	return DriverManager.getConnection(URL,NAME,PASSWORD);
    }
}
