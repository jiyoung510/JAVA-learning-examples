package mvc.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() {		
		Connection conn = null;	
		try {
		Context initCtx = new InitialContext();
        Context ctx = (Context)initCtx.lookup("java:comp/env");
        DataSource source = (DataSource)ctx.lookup("market_Conn");

		conn = source.getConnection();	
		} catch(Exception e) {
			System.out.println("DB 연결 중 예외 발생");
            e.printStackTrace();
		}
		return conn;
	}	
}
