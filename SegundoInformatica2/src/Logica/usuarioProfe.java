package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioProfe extends usuarios{

	private String contrasenia;
	
	public usuarioProfe(String contra) {
		
		super();
		setContrasenia(contra);
		
	}
	
	public usuarioProfe() {
			
			
			
	}

	/*
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 */
	
	public String getContrasenia() {
		
		return contrasenia;
		
	}

	public void setContrasenia(String contrasenia) {
		
		this.contrasenia = contrasenia;
		
	}
	
	public void AgregarUsuario() {
	       
	     conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuarios"
	     String query = "INSERT INTO usuarios (nombre_completo, ci, contrasenia) VALUES (?, ?, ?);";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCI());
					statement.setString(3, this.contrasenia);
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
//				ex.printStackTrace();
				System.out.println("ERROR, al agregar usuario");
			
			}
		
	}
	
	public void ModificarUsuario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuario"
	     String query = "UPDATE usuarios SET nombre_completo = ?, ci = ?, contrasenia = ?, numero_telefono = ? WHERE id_usuarios = ?";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCI());
					statement.setString(3, contrasenia);
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
	
	public usuarioP BuscarUsuario(String tempNombre_completo, int opcion) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    usuarioP tempUsuario = new usuarioP();
	    int NumeroDeProducto = 0;
	    
	    if (opcion == 1) {
			
			String query = "SELECT * FROM usuarios WHERE nombre_completo = ?";
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre_completo);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("USUARIO NO ENCONTRADO");
					
				} else {
					
					do {
						
						String nombre = resultSet.getString("nombre_completo");
						
						String ci = resultSet.getString("ci");
						
						int id = resultSet.getInt("id_usuarios");
						
						tempUsuario.setNombre(nombre);
						tempUsuario.setCI(ci);
						tempUsuario.setId(id);
						
						System.out.println("ID: " + id + ", Nombre completo: " + nombre + ", " + "CI: " + ci);
						
						return tempUsuario;
						
					} while (resultSet.next());
					
				}
				 
			} catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("Usuario no encontrado");
			
			}
	    	
	    } else {
	    	
				String query = "SELECT * FROM usuarios;";
				
				try (Connection conn = con;
					PreparedStatement preparedStatement = conn.prepareStatement(query)) {
					
					ResultSet resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
					
						String nombre = resultSet.getString("nombre_completo");
						
						String ci = resultSet.getString("ci");
						
						int id = resultSet.getInt("is_usuarios");
						
						tempUsuario.setNombre(nombre);
						tempUsuario.setCI(ci);
						tempUsuario.setId(id);
					
					NumeroDeProducto++;
					
					System.out.println(NumeroDeProducto + ". " + "ID: " + id + ", Nombre: " + nombre + ", CI: " + ci);
					System.out.println(" ");
		    	
			}
		    } catch (SQLException e) {
			
//				e.printStackTrace();
		    	System.out.println("ERROR en la busqueda de usuarios");
			
			}
				
	    }
		
		return tempUsuario;
		
	}

}
