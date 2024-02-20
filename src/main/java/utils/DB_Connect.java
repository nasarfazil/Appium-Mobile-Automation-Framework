package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DB_Connect {

	public synchronized HashMap<String, String> getSqlResultInMap(String sql){ 
		HashMap<String, String> data_map=new HashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://root@localhost/mysql");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			java.sql.ResultSetMetaData md= rs.getMetaData();
			while(rs.next()) {
				for(int i=1;i<=md.getColumnCount();i++) {
					data_map.put(md.getColumnName(i), rs.getString(i));
				}
			}
			System.out.println("data_map");
			con.close();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return data_map;
	}
}