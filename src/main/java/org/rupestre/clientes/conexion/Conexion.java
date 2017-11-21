package org.rupestre.clientes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private static Connection con = null;

	public static Connection getCoonection() {

		if (con != null) {
			return con;
		} else {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/HSBC";
				String user = "root";
				String pass = "";

				con = DriverManager.getConnection(url, user, pass);
				System.out.println(":::: Conexion exitosa");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;

		}

	}

}
