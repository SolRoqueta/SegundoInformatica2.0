package Logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class usuarios {
	
	private int idUsuarios; //Declaro el int de id
	private String nombreUsuario; //Declaro el String de nombre_completo
	private String contrasenha; //Declaro el String de contraseña
	private String tipoUsuario; 
	private String mail;
	private Date fecha_ultimo_acceso;
	private String query;
	
	private String AgregarUsuarioQuery = "INSERT INTO usuarios (nombre, contrasenia, mail, tipo_usuario, fecha_ultimo_acceso) VALUES (?, ?, ?, ?, ?);";
	private String ModificarUsuarioQuery = "UPDATE usuarios SET nombre = ?, contrasenia = ?, mail = ?, tipo_usuario = ?, fecha_ultimo_acceso = ? WHERE id_usuario = ?;";
	private String EliminarUsuarioQuery = "DELETE FROM usuarios WHERE id_usuario = ? LIMIT 1;";
	private String BuscarUsuarioQuery = "SELECT * FROM usuarios WHERE nombre = ?;";
	private String BuscarUsuariosQuery = "SELECT * FROM usuarios ORDER BY nombre ASC;";
	private String BuscarUsuariosNombreQuery = "SELECT * FROM usuarios WHERE nombre LIKE";
	private String BuscarUsuariosMailQuery = "SELECT * FROM usuarios WHERE mail LIKE";
	private String BuscarUsuariosTipoQuery = "SELECT * FROM usuarios WHERE tipo_usuario LIKE";
	private String BuscarUsuariosFechaQuery = "SELECT * FROM usuarios WHERE fecha_ultimo_acceso LIKE";
	
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
	     String query = AgregarUsuarioQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
	    	 		fecha_ultimo_acceso = new Date(System.currentTimeMillis());
	    	 		
					statement.setString(1, this.getNombre());
					statement.setString(2, this.getCont());
					statement.setString(3, this.getMail());
					statement.setString(4, this.getTipoUsuario());
					statement.setDate(5, fecha_ultimo_acceso);
			
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("ERROR, al agregar usuario");
			
			}
		
	}
	
	public void EliminarUsuario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "productos" de la fila del usuario cullo nombre sea del objeto
	     String query = EliminarUsuarioQuery;
	     
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
	     String query = ModificarUsuarioQuery;
	     
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
				
//				ex.printStackTrace();
				System.out.println("No se a podido modificar el usuario");
			
			}
		
	}
	
	public usuarios BuscarUsuario(String tempNombre) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    usuarios tempUsuario = new usuarios();
			
			String query = BuscarUsuarioQuery;
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("USUARIO NO ENCONTRADO");
					
				} else {
					
					do {
						
						int id = resultSet.getInt("id_usuario");
						
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
			
//				e.printStackTrace();
				System.out.println("Usuario no encontrado");
			
			}
		
		return tempUsuario;
		
	}
	
	public List<Object[]> BuscarUsuarios(String atributoUsuario, int opcion) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    List<Object[]> userList = new ArrayList<>();
	    
	    switch (opcion) {
	    case 0:
	        query = BuscarUsuariosNombreQuery + " '" + atributoUsuario + "%';";
	        break;

	    case 1:
	        query = BuscarUsuariosMailQuery + " '" + atributoUsuario + "%';";
	        break;

	    case 2:
	        query = BuscarUsuariosTipoQuery + " '" + atributoUsuario + "%';";
	        break;

	    case 3:
	        query = BuscarUsuariosFechaQuery + " '" + atributoUsuario + "%';";
	        break;

	    case 4:
	        query = BuscarUsuariosQuery;
	        break;

	    default:
	        throw new IllegalArgumentException("Opción no válida: " + opcion);
	    }
		
		try (Connection conn = con;
			PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				String nombre = resultSet.getString("nombre");
				
				String mail = resultSet.getString("mail");
				
				String tipo = resultSet.getString("tipo_usuario");
				
				Date ultimoAcceso = resultSet.getDate("fecha_ultimo_acceso");
				
				userList.add(new Object[]{nombre, mail, tipo, ultimoAcceso});
					    	
			}
			
	    } catch (SQLException e) {
		
	//		e.printStackTrace();
	    	System.out.println("ERROR en la busqueda de Usuarios");
		
		}
			return userList;
	}
	
}