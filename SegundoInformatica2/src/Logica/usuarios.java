package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class usuarios {
	
	
	private int id_usuarios; //Declaro el int de id
	private String nombre_completo; //Declaro el String de nombre_completo
	private String CI; //Declaro el String de la cedula de identidad
	
	/*
	 *		CONSTRUCTOR DE USUARIOS 
	 */
	
	public usuarios(String nom_comp, String ci) {
		
		nombre_completo = nom_comp;
		CI = ci;
		
	}
	
	public usuarios() {
		
		
		
	}
	
	/*
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 */

	public String getNombre() {
		
		return nombre_completo;
		
	}
	
	public void setNombre(String NOMBRE_COMPLETO) {
		
		nombre_completo = NOMBRE_COMPLETO;
		
	}
	
	public String getCI() {
		
		return CI;
		
	}
	
	public void setCI(String ci) {
		
		CI = ci;
		
	}
	
	public int getId() {
		
		return id_usuarios;
		
	}
	
	public void setId(int ID) {
		
		id_usuarios = ID;
		
	}
	
	public void EliminarUsuario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "productos" de la fila del usuario cullo nombre sea del objeto
	     String query = "DELETE FROM usuarios WHERE nombre_completo = ? LIMIT 1;";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, nombre_completo);
					
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
	
	/*
	 * 						CREO LA FUNCION BuscarProducto
	 * 
	 *  Como se puede ver, tiene dos inputs, uno que es tempNombre_completo y 
	 *  otro que es opcion, en TEMPNOMBRE_COMPLETO, se debe de poner el nombre del
	 *  usuario que el usuario desea buscar. OPCION se utiliza para indicarle
	 *  al programa si el usuario quiere hacer un select para mostrar todos
	 *  los usuario o si quiere buscar uno en específico. Se debe de insertar
	 *  1 en el caso de querer buscar un usuario especifico o 2 en el caso de 
	 *  queres buscar todos los usuarios de la base de datos.
	 *  
	 *  Esta funcion retorna un valor de tipo usuarios, para que cuando se
	 *  busque uno especifico se pueda setear el ex-objeto de usuarios con el
	 *  nuevo objeto de usuarios (tempUsuario).
	 *  
	 */
	
	
	
}