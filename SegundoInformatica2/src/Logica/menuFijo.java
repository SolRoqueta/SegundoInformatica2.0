package Logica;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class menuFijo {

	private int id;
	private String nombre;
	private int precio;
	private int stock;
	private String descripcion;
	private FileInputStream foto;
	private FileInputStream fotoTemp;
	private BufferedImage fotoPaMostrar;
	private String AgregarMenuFijoQuery = "INSERT INTO menus_fijos (nombre, precio, descripcion, foto, stock) VALUES (?, ?, ?, ?, ?);";
	private String BuscarMenuFijoQuery = "SELECT * FROM menus_fijos WHERE nombre = ?;";
	private String BuscarMenusFijosQuery = "SELECT * FROM menus_fijos;";
	private String EliminarMenuFijoQuery = "DELETE FROM menus_fijos WHERE idmenus_fijos = ?;";
	private String ModificarMenusFijosQuery = "UPDATE menus_fijos SET nombre = ?, precio = ?, descripcion = ?, foto = ?, stock = ? WHERE idmenus_fijos = ?;";
	
	public menuFijo(String nombre, int precio, String descripcion, int stock, String fotoPath) {
		
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setDescripcion(descripcion);
		this.setStock(stock);
		try {
			
			this.foto = new FileInputStream(fotoPath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("ERROR AL AGREGAR LA FOTO");
			
		}
		
	}
	
	public menuFijo() {
		
		
		
	}
	
	/*
	 * 
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 * 
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public FileInputStream getFoto() {
		return foto;
	}

	public void setFoto(String fotoPath) {
		
		try {
			
			fotoTemp = new FileInputStream(fotoPath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		this.foto = fotoTemp;
	}

	public FileInputStream getFotoTemp() {
		return fotoTemp;
	}

	public void setFotoTemp(FileInputStream fotoTemp) {
		this.fotoTemp = fotoTemp;
	}

	public void setFotoBinary(FileInputStream input) {
		
		this.foto = input;
		
	}
	
	public BufferedImage getFotoPaMostrar() {
		return fotoPaMostrar;
	}

	public void setFotoPaMostrar(InputStream fotoPaMostrar) {
		try {
			
			this.fotoPaMostrar = ImageIO.read(fotoPaMostrar);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void agregarMenuFijo() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "menus_fijos"
	     String query = AgregarMenuFijoQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
	    	 		statement.setString(1, this.getNombre());
	    	 		statement.setInt(2, this.getPrecio());
	    	 		statement.setString(3, this.getDescripcion());
	    	 		
	    	 		try {
						
						statement.setBinaryStream(4, getFoto(), getFoto().available());
						
					} catch (IOException e) {

						e.printStackTrace();
						
					}
	    	 		
	    	 		statement.setInt(5, this.getStock());
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						
						System.out.println("Ingresado con exito!");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("ERROR, al agregar el menu fijo");
			
			}
		
	}
	
	public menuFijo buscarMenuFijo(String tempNombre) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    menuFijo tempMenu = new menuFijo();
	    int NumeroDeProducto = 0;
	    			
			String query = BuscarMenuFijoQuery;
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("MENU DIARIO NO ENCONTRADO");
					return null;
					
				} else {
					
					do {
						
						int id = resultSet.getInt("idmenus_fijos");
						
						String nombre = resultSet.getString("nombre");
						
						int precio = resultSet.getInt("precio");
						
						int stock = resultSet.getInt("stock");
						
						String descripcion = resultSet.getString("descripcion");
						
						InputStream input = resultSet.getBinaryStream("foto");
						
						tempMenu.setId(id);
						tempMenu.setNombre(nombre);
						tempMenu.setPrecio(precio);
						tempMenu.setStock(stock);
						tempMenu.setDescripcion(descripcion);
						tempMenu.setFotoPaMostrar(input);
						
						System.out.println("ID: " + id + ", Nombre: " + nombre + ", precio: " + precio + ", stock: " + stock + ", descripcion: " + descripcion + ", foto: " + input);
						
						return tempMenu;
						
					} while (resultSet.next());
					
				}
				 
			} catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("Menu diario no encontrado");
				return null;
				
			}
		
	}
	
	public String[][] buscarMenusFijos() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    menuFijo tempMenu = new menuFijo();
	    String[][] datos = new String[100][4];
	    int index = 0;
		
		String query = BuscarMenusFijosQuery;
		
		try (Connection conn = con;
			PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
			int id = resultSet.getInt("idmenus_fijos");
				
			String nombre = resultSet.getString("nombre");
				
			int precio = resultSet.getInt("precio");
				
			int stock = resultSet.getInt("stock");
				
			String descripcion = resultSet.getString("descripcion");
			
			InputStream input = resultSet.getBinaryStream("foto");
			
			tempMenu.setId(id);
			tempMenu.setNombre(nombre);
			tempMenu.setPrecio(precio);
			tempMenu.setStock(stock);
			
			datos[index][0] = String.valueOf(tempMenu.getId());
			datos[index][1] = tempMenu.getNombre();
			datos[index][2] = String.valueOf(tempMenu.getPrecio());
			datos[index][3] = String.valueOf(tempMenu.getStock());
			
			index++;
			
			System.out.println("ID: " + id + ", Nombre: " + nombre + ", precio: " + precio + ", stock: " + stock + ", descripcion: " + descripcion + ", foto: " + input);
			System.out.println(" ");
    	
	}
    } catch (SQLException e) {
	
		e.printStackTrace();
    	System.out.println("ERROR en la busqueda de productos");
	
	}
		
	return datos;
		
	}
	
	public void eliminarMenuFijo() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "menus_fijos" de la fila del prdoucto cullo nombre sea del objeto
	     String query = EliminarMenuFijoQuery; 
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setInt(1, this.getId());
					
					int rowsUpdated = statement.executeUpdate();
					
					if (rowsUpdated > 0) {
						
						System.out.println("Eliminado con exito!");
						
					} else if (rowsUpdated == 0) {
						
						System.out.println("No eliminado");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("No se a podido eliminar el menu fijo.");
			
			}
		
	}
	
	public void modificarMenuFijo() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que modifica datos en la tabla "menus_fijos"
	     String query = ModificarMenusFijosQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
	    	 	statement.setString(1, this.getNombre());
				statement.setInt(2, this.getPrecio());
				statement.setString(3, this.getDescripcion());
				
				try {
					
					statement.setBinaryStream(4, getFoto(), getFoto().available());
					
				} catch (IOException e) {

					e.printStackTrace();
					
				}
				
				statement.setInt(5, this.getStock());
				statement.setInt(6, this.getId());
					
					int rowsUpdated = statement.executeUpdate();
					
					if (rowsUpdated > 0) {
						
						System.out.println("Actualizado con exito!");
						
					} else if (rowsUpdated == 0) {
						
						System.out.println("No actualizado");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("No se a podido modificar el menu_fijo");
			
			}
		
	}

public static void main(String[] args) {
		
		int OP = 0;
		int inf = 1;
		menuFijo m = new menuFijo();
		Scanner sr = new Scanner(System.in);
		
		String tempNombre = "";
		
		while (inf == 1) {
			
			System.out.println("ELIJA UNA OPCION: ");
			System.out.println(" ");
			System.out.println("1. Agregar menu fijo");
			System.out.println("2. Modificar menu fijo");
			System.out.println("3. Buscar menu fijo");
			System.out.println("4. Buscar todos los menus fijos");
			System.out.println("5. Eliminar menu fijo");
			System.out.println("6. Salir");
			OP = sr.nextInt();
			
			sr.nextLine();
			
			switch (OP) {
				
			case 1:
				
				System.out.println("Ingrese el nombre: ");
				m.setNombre(sr.nextLine());
				
				System.out.println("Ingrese el precio: ");
				m.setPrecio(sr.nextInt());
				
				System.out.println("Ingrese el stock: ");
				m.setStock(sr.nextInt());
				
				sr.nextLine();
				
				System.out.println("Ingrese la descripcion: ");
				m.setDescripcion(sr.nextLine());
				
				System.out.println("Ingrese la foto: ");
				m.setFoto(sr.next());
				
				m.agregarMenuFijo();
				
				break;
				
			case 2:
				
				System.out.println("Ingrese el nombre del producto a modificar: ");
				tempNombre = sr.nextLine();
				
				m = m.buscarMenuFijo(tempNombre);
				
				System.out.println("Ingrese el nuevo nombre: ");
				m.setNombre(sr.nextLine());
				
				System.out.println("Ingrese el nuevo precio: ");
				m.setPrecio(sr.nextInt());
				
				System.out.println("Ingrese el nuevo stock: ");
				m.setStock(sr.nextInt());
				
				sr.nextLine();
				
				System.out.println("Ingrese la nueva descripcion: ");
				m.setDescripcion(sr.nextLine());
				
				
				System.out.println("Ingrese la nueva foto: ");
				m.setFoto(sr.next());
				
				m.modificarMenuFijo();
				
				break;
				
			case 3:
				
				System.out.println("Ingrese el nombre a buscar");
				tempNombre = sr.nextLine();
				
				m.buscarMenuFijo(tempNombre);
				
				break;
				
			case 4:
				
				m.buscarMenusFijos();
				
				break;
				
			case 5:
				
				System.out.println("Ingrese el nombre del menu diario a eliminar: ");
				tempNombre = sr.nextLine();
				
				m = m.buscarMenuFijo(tempNombre);
				m.eliminarMenuFijo();
				
				break;
			
			case 6:
				
				inf = 0;
				
				break;
				
			}
			
		}
		
	}
	
}