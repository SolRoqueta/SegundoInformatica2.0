package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class usuarios {
	
	private int idUsuarios; //Declaro el int de id
	private String nombreUsuario; //Declaro el String de nombre_completo
	private String contrasenha; //Declaro el String de contraseña
	private int tipoUsuario; 
	private String mail;
	

	 // CONSTRUCTOR DE USUARIOS 
	
	public usuarios(String nombUsu, String cont) {
		
		nombreUsuario = nombUsu;
		contrasenha = cont;

	}
	
	public usuarios() {
		
	}
	
	 // GETS Y SETS DE LOS ATRIBUTOS
	
	public int getId() {
		return idUsuarios;
	}
	
	public void setId(int ID) {
		idUsuarios = ID;
	}

	public String getNombre() {
		return nombreUsuario;
	}
	
	public void setNombre(String NOMBRE_USUARIO) {
		nombreUsuario = NOMBRE_USUARIO;
	}
	
	public String getCont() {
		return contrasenha;
	}
	
	public void setCont(String cont) {
		contrasenha = cont;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String email) {
		mail = email;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsu) {
		tipoUsuario = tipoUsu;
	}
	
	public void AgregarUsuario() {
	       
	     conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuarios"
	     String query = "INSERT INTO usuarios (nombreCompleto, contrasenha, tipoUsuario, mail) VALUES (?, ?, ?, ?);";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCont());
					statement.setInt(3, this.getTipoUsuario());
					statement.setString(4, this.getMail());
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
//				ex.printStackTrace();
				System.out.println("ERROR, al agregar usuario");
			
			}
		
	}
	
	public void EliminarUsuario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "productos" de la fila del usuario cullo nombre sea del objeto
	     String query = "DELETE FROM usuarios WHERE idUsuarios = ? LIMIT 1;";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setInt(1, idUsuarios);
					
					int rowsUpdated = statement.executeUpdate();
					if (rowsUpdated > 0) {
						System.out.println("Eliminado con exito!");
					} else if (rowsUpdated == 0) {
						
						System.out.println("No eliminado");
						
					}
				
			} catch (SQLException ex) {
				
//				ex.printStackTrace();
				System.out.println("No se a podido eliminar el usuario.");
			
			}
		
	}
	
	public void ModificarUsuario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuario"
	     String query = "UPDATE usuarios SET nombreCompleto = ?, contrasenha = ?, mail = ?, tipoUsuario = ? WHERE idUsuarios = ?";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCont());
					statement.setString(3, this.getMail());
					statement.setInt(4, this.getTipoUsuario());
					statement.setInt(5, this.getId());
					
					int rowsUpdated = statement.executeUpdate();
					if (rowsUpdated > 0) {
						System.out.println("Actualizado con exito!");
					} else if (rowsUpdated == 0) {
						
						System.out.println("No actualizado");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("No se a podido modificar el usuario");
			
			}
		
	}

	
}