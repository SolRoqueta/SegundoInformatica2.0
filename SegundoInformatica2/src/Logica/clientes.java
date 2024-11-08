package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clientes {

	private String nombre_completo;
	private int saldo;
	private String numero_telefono;
	private int fk_id_usuario;
	private String AgregarClientesQuery = "INSERT INTO clientes (nombre_completo, saldo, numero_telefono, fk_id_usuario) VALUES (?, ?, ?, ?)";
	
	public clientes(String nombre_comp, int plata, String num_tel) {
		
		this.setNombre_completo(nombre_comp);
		this.setSaldo(plata);
		this.setNumero_telefono(num_tel);
		
	}
	
	public clientes() {
		
		
	}
	/*
	 * 
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 * 
	 */

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	
	public int getFkUsuario() {
		
		return fk_id_usuario;
		
	}
	
	public void setFkUsuario(int fk_id_usuario) {
		
		this.fk_id_usuario = fk_id_usuario;
		
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	
	public void agregar() {
		
		conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "clientes"
	     String query = AgregarClientesQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
	    	 		statement.setString(1, this.getNombre_completo());
	    	 		statement.setInt(2, this.getSaldo());
	    	 		statement.setString(3, this.getNumero_telefono());
	    	 		statement.setInt(4, this.getFkUsuario());
					
					int rowsInserted = statement.executeUpdate();
					
					if (rowsInserted > 0) {
						
						System.out.println("Ingresado con exito!");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("ERROR, al agregar el cliente");
			
			}
		
	}
	
}