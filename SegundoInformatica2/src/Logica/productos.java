package Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class productos {
	
	
	private int idproductos; //Declaro el int de id
	private String nombre; //Declaro el String de nombre
	private String descripcion; //Declaro el String de descripcion
	private String precio; //Declaro el String de precio
	private String foto; //Declaro el String de foto
	
	/*
	 *		CONSTRUCTOR DE PRODUCTOS 
	 */
	
	productos(int ID, String NOMBRE, String DESCRIPCION, String PRECIO, String FOTO) {
		
		this.setId(ID);
		this.setNombre(NOMBRE);
		this.setDescripcion(DESCRIPCION);
		this.setPrecio(PRECIO);
		this.setFoto(FOTO);
		
	}
	
	productos() {
		
		
		
	}
	
	/*
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 */

	public int getId() {
		return idproductos;
	}

	public void setId(int id) {
		this.idproductos = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/*
	 * 		FUNCION QUE AGREGA EL PRODUCTO A LA BASE DE DATOS
	 */

	public void AgregarProducto() {
	       
	     conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "productos"
	     String query = "INSERT INTO productos (nombre, descripcion, precio, foto) VALUES (?, ?, ?, ?);";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, nombre);
					statement.setString(2, descripcion);
					statement.setString(3, precio);
					statement.setString(4, foto);
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
			
			}
		
	}
	
	public void ModificarProducto() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "productos"
	     String query = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, foto = ? WHERE nombre = ?";
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, nombre);
					statement.setString(2, descripcion);
					statement.setString(3, precio);
					statement.setString(4, foto);
					statement.setString(5, nombre);
					
					int rowsUpdated = statement.executeUpdate();
					if (rowsUpdated > 0) {
						System.out.println("Actualizado con exito!");
					} else if (rowsUpdated == 0) {
						
						System.out.println("No actualizado");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
			
			}
		
	}
	
	public void EliminarProducto() {
		
		
		
	}
	
public static void main(String[] args) {
		
		productos p = new productos();
	
		Scanner sr = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del producto: ");
		
		p.setNombre(sr.nextLine());
		
		System.out.println("Ingrese la descripcion del producto: ");
		
		p.setDescripcion(sr.nextLine());
		
		System.out.println("Ingrese el precio para el producto: ");
		
		p.setPrecio(sr.nextLine());
		
		System.out.println("Ingrese la ruta de la foto: ");
		
		p.setFoto(sr.nextLine());
		
		p.AgregarProducto();
		
		System.out.println("Ingrese el nuevo precio: ");
		
		p.setPrecio(sr.nextLine());
		
		p.ModificarProducto();
		
	}
	
}
