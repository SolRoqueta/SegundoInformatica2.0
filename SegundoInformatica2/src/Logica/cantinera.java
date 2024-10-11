package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cantinera {

	private int idCantinera; //Declaro el int de id
	private String nombreCantinera; //Declaro el String de nombre_completo
	private String contrasenha; //Declaro el String de contraseña
	private String tipoUsuario; //Declaro el tipo de usuario
	
	public cantinera(String nombreCantinera, String contrasenha) {
		
		this.setNombreCantinera(nombreCantinera);
		this.setCont(contrasenha);
		
	}
	
	public cantinera() {
		
		
		
	}
	
	/*
	 * 
	 * 		GETS Y  SETS DE LOS ATRIBUTOS
	 * 
	 */

	public int getIdCantinera() {
		return idCantinera;
	}

	public void setIdCantinera(int idCantinera) {
		this.idCantinera = idCantinera;
	}

	public String getNombreCantinera() {
		return nombreCantinera;
	}

	public void setNombreCantinera(String nombreCantinera) {
		this.nombreCantinera = nombreCantinera;
	}

	public String getCont() {
		return contrasenha;
	}

	public void setCont(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public void AgregarCantinera() {
		
		conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuarios"
	     String query = "INSERT INTO usuarios (nombreCompleto, contrasenha, tipoUsuario) VALUES (?, ?, ?);";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombreCantinera());
					statement.setString(2, this.getCont());
					statement.setString(3, this.getTipoUsuario());
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Cantinera ingresada con exito!");
					}
				
			} catch (SQLException ex) {
				
//				ex.printStackTrace();
				System.out.println("ERROR, al agregar a la cantinera");
			
			}
		
	}

}
