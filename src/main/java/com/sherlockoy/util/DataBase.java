package com.sherlockoy.util;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataBase {
	static String driverClass = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/GYManager";
	static String user = "root";
	static String password = "oyang716";
	String temp4;
	static Connection conn;

	public static void main(String[] args) {

		for (int i = 1; i <= 31; i++) {
			for (int j = 1; j <= 3; j++) {
				try {
					Class.forName(driverClass).newInstance();
					conn = (Connection) DriverManager.getConnection(url, user,
							password);
					Statement stmt = (Statement) conn.createStatement();
					String sql = "INSERT INTO `GYManager`.`Field` "
							+ "(`fieldNum`, `fieldType`, `date`) "
							+ "VALUES ('"+j+"', 'pingpong', '2014-5-"+i+"');";
					stmt.execute(sql);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
