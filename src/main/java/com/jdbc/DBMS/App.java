package com.jdbc.DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        Connection connect = new PostgresqlConnetion("localhost","jdbctest","jdbctest","5432","dbtest").Connect();
    }
    public interface Iconnection{
    	public Connection Connect();
    }
    public static class PostgresqlConnetion implements Iconnection{
        private final String url;
        private final String username;
        private final String passwd;
        private final String port;
        private final String dbname;
		public PostgresqlConnetion(String url, String username, String passwd, String port, String dbname) {
			super();
			this.url = url;
			this.username = username;
			this.passwd = passwd;
			this.port = port;
			this.dbname = dbname;
		}
		public Connection Connect() {
			try {
				Class.forName("org.postgresql.Driver");
				Connection con=DriverManager.getConnection(String.format(
						"jdbc:postgresql://%S:%S/%S", url, port, dbname),
						username, passwd);
					
				return con;
			} catch (ClassNotFoundException e) {
				throw new UnsupportedOperationException(e);
			
			} catch (SQLException e) {
				throw new UnsupportedOperationException(e);
			}
			
			
			
		}
        
        
    		
		}

}

