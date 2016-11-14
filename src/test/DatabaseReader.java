package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseReader {

	String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_88e5af57953a23a?user=be02def29b991d&password=b0683862";
	String USER = "be02def29b991d";
	String PASS = "b0683862";
	HashMap<String, String> kwMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		new DatabaseReader();
	}
	
	public DatabaseReader() {

		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to " + DB_URL + "...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT KEYWORD, DESCRIPTION FROM KW_DESCRIPTION";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         String keyword = rs.getString("KEYWORD");
		         String description = rs.getString("DESCRIPTION");

		         kwMap.put(keyword, description);
//		         System.out.println("Keyword: " + keyword);
//		         System.out.println("Description: " + description);
		        
		      }
		      //STEP 6: Clean-up environments
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
	}

	public HashMap<String, String> getKwMap() {
		return kwMap;
	}

	public void setKwMap(HashMap<String, String> kwMap) {
		this.kwMap = kwMap;
	}
}
