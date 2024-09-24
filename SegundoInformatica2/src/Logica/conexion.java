package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexion {

	public Connection conect() {
		
		Connection conn = null;
		
		try {

			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			String url = "jdbc:mysql://localhost:3306/testproyecto?useTimezone=true&serverTimezone=UTC";

			conn = DriverManager.getConnection(url,"root","root");

			}catch(ClassNotFoundException e) {

				JOptionPane.showMessageDialog(null, "Error en la conexion con el driver");
				
			}catch(SQLException ex) {

				JOptionPane.showMessageDialog(null, "Error en la conexion con la base");

			}

			return conn;
		
	}
	
}