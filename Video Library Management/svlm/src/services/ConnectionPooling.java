package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class ConnectionPooling {
	
    private Hashtable<Connection,Boolean> connections = new Hashtable<Connection,Boolean>();  

    private Properties props;
	
	
	
    public ConnectionPooling(String driverClassName, String dbURL,String user, String password, int initialConnections)   
    	    throws SQLException, ClassNotFoundException {  
    	        props = new Properties();  
    	        props.put("connection.driver", driverClassName);  
    	        props.put("connection.url", dbURL);  
    	        props.put("user", user);  
    	        props.put("password", password);  
    	        initializePool(props, initialConnections);  
    	    }  
	
	
	
    
    public Connection getConnection() throws SQLException {  
        Connection con = null;  
        Enumeration cons = connections.keys();  
        synchronized (connections) {  
            while (cons.hasMoreElements()) {  
                con = (Connection) cons.nextElement();  
                Boolean b = connections.get(con);  
                  
                if (b == Boolean.FALSE) {  
                    try {  
                        con.setAutoCommit(con.getAutoCommit());     
                    } catch (SQLException sqle) {  
                        connections.remove(con);  
                        con = getNewConnection();  
                    }  
                    connections.put(con, Boolean.TRUE);  
                    return con;  
                }  
            }  
        }  
        con = getNewConnection();  
        connections.put(con, Boolean.TRUE);  
        return con;  
    }  
      
    public void returnConnection(Connection returned) {  
        if (connections.containsKey(returned)) {  
            connections.put(returned, Boolean.FALSE);         
        }  
    }  
      
    private void initializePool(Properties props, int initialConnections)  
    throws SQLException, ClassNotFoundException {  
        Class.forName(props.getProperty("connection.driver"));  
          
        for (int i = 0; i < initialConnections; i++) {  
            Connection con = getNewConnection();  
            connections.put(con, Boolean.FALSE);  
        }  
    }  
      
    private Connection getNewConnection() throws SQLException {  
        return DriverManager.getConnection(props.getProperty("connection.url"), props);     
    }  
}  
    
    
    
    
    
    /*
	
	public Connection getConnection() 
	{
		Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/svlm1","root","root");
			} catch (InstantiationException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} 
			
			catch (IllegalAccessException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			} catch (ClassNotFoundException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			catch (SQLException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			return connection;
	}
	
	
	public void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void commitOperation(Connection connection)
	{
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void rollBackOperation(Connection connection)
	{
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*/
	

