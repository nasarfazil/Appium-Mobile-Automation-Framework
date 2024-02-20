package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AndroidDriver<AndroidElement>  driver;

	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public String Db_table_count(String sqlcount) { 
		// TODO Auto-generated method stub
		String set = null;
		try {
			String dbURL = "jdbc:mysql://root@localhost/mysql";
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con = DriverManager.getConnection(dbURL);
			  Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlcount);
				while (rs.next()) {
					 set=rs.getString(1);
				     System.out.println(set);
				     
				    	}
				    	con.close();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	    	
					return set;
	}	
}
