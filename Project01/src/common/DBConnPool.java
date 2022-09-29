package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {
    public Connection con;
    public Statement stmt;
    public PreparedStatement psmt;
    public ResultSet rs;

    public DBConnPool() {
        try {
            Context initCtx = new InitialContext();
            Context ctx = (Context)initCtx.lookup("java:comp/env");
            DataSource source = (DataSource)ctx.lookup("project_oracle");

            con = source.getConnection();

            System.out.println("DB 커넥션풀 연결");
        }
        catch (Exception e) {
            System.out.println("DB 연결 중 예외 발생");
            e.printStackTrace();
        }
    }

    public void close() {
        try {            
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close();  

            System.out.println("DB 커넥션풀 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}