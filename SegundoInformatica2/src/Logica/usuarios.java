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
	private String tipoUsuario; 
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
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsu) {
		tipoUsuario = tipoUsu;
	}
	
	public void AgregarUsuario() {
	       
	     conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "usuarios"
	     String query = "INSERT INTO usuarios (nombre, contrasenha, mail, tipo_usuario) VALUES (?, ?, ?, ?);";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCont());
					statement.setString(3, this.getMail());
					statement.setString(4, this.getTipoUsuario());
			
					
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
	     String query = "DELETE FROM usuarios WHERE id_usuarios = ? LIMIT 1;";
	     
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
					statement.setString(4, this.getTipoUsuario());
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
	
	public usuarios BuscarUsuario(String tempNombre) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    usuarios tempUsuario = new usuarios();
			
			String query = "SELECT * FROM usuarios WHERE nombre = ?";
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("USUARIO NO ENCONTRADO");
					
				} else {
					
					do {
						
						int id = resultSet.getInt("idusuarios");
						
						String nombre = resultSet.getString("nombre");
						
						String tipo = resultSet.getString("tipo_usuario");
						
						tempUsuario.setId(id);
						tempUsuario.setNombre(nombre);
						tempUsuario.setTipoUsuario(tipo);
		
						
						System.out.println("ID: " + id + ", Nombre: " + nombre + ", tipo usuario" + tipo);
						
						return tempUsuario;
						
					} while (resultSet.next());
					
				}
				 
			} catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("Usuario no encontrado");
			
			}
		
		return tempUsuario;
		
	}
	
	public String[][] BuscarUsuarios() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    String[][] datos = new String[100][3];
	    int index = 0;
		
		String query = "SELECT * FROM usuarios;";
		
		try (Connection conn = con;
			PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
			int id = resultSet.getInt("idusuarios");
			String tempId = String.valueOf(id);
			
			String nombre = resultSet.getString("nombre");
			
			String tipo = resultSet.getString("tipo_usuario");
			
			datos[index][0] = tempId;
            datos[index][1] = nombre;
            datos[index][2] = tipo;
			
			index++;
			
			System.out.println("ID: " + tempId + ", Nombre: " + nombre + ", Tipo usuario: " + tipo);
			System.out.println(" ");
    	
	}
    } catch (SQLException e) {
	
//		e.printStackTrace();
    	System.out.println("ERROR en la busqueda de usuarios");
	
	}
		
	return datos;
		
}

	
}