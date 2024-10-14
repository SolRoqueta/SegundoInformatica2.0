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
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class menuDiario {

	private int idmenus_diarios;
	private String nombre;
	private int precio;
	private int stock;
	private String diaCorrespondiente;
	private String descripcion;
	private String aclaraciones;
	private FileInputStream foto;
	private String AgregarMenuDiarioQuery = "INSERT INTO menus_diarios (nombre, precio, stock, diaCorrespondiente, descripcion, aclaraciones, foto) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String ModificarMenusDiaiosQuery = "UPDATE menus_diarios SET nombre = ?, precio = ?, stock = ?, diaCorrespondiente = ?, descripcion = ?, aclaraciones = ?, foto = ? WHERE idmenus_diarios = ?";
	private String BuscarMenuDiarioQuery = "SELECT * FROM menus_diarios WHERE nombre = ?";
	private String BuscarMenusDiariosQuery = "SELECT * FROM menus_diarios";
	private FileInputStream fotoTemp;
	private BufferedImage fotoPaMostrar;
	private String EliminarMenuDiarioQuery = "DELETE FROM menus_diarios WHERE idmenus_diarios = ?";
	
	//Borrar este comentario
	
	/*
	 * 
	 * 		CONSTRUCTORES DE LA CLASE menuDiario
	 * 
	 */
	
	public menuDiario(String nombre, int precio, int stock, String diaCorrespondiente, String descripcion, String aclaraciones, String fotoPath) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.diaCorrespondiente = diaCorrespondiente;
		this.descripcion = descripcion;
		this.aclaraciones = aclaraciones;
		try {
			
			this.foto = new FileInputStream(fotoPath);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("ERROR AL AGREGAR LA FOTO");
			
		}
		
	}
	
	public menuDiario() {
		
		
		
	}
	
	/*
	 * 
	 * 		GETS Y SETS DE LOS ATRIBUTOS
	 * 
	 */
	
	public int getId() {
		
		return idmenus_diarios;
		
	}
	
	public void setId(int id) {
		
		this.idmenus_diarios = id;
		
	}

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

	public String getDiaCorrespondiente() {
		return diaCorrespondiente;
	}

	public void setDiaCorrespondiente(String diaCorrespondiente) {
		this.diaCorrespondiente = diaCorrespondiente;
	}

	public String getAclaraciones() {
		return aclaraciones;
	}

	public void setAclaraciones(String aclaraciones) {
		this.aclaraciones = aclaraciones;
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
	
	public void agregarMenuDiario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "menus_diarios"
	     String query = AgregarMenuDiarioQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, getNombre());
					statement.setInt(2, getPrecio());
					statement.setInt(3, getStock());
					statement.setString(4, getDiaCorrespondiente());
					statement.setString(5, getDescripcion());
					statement.setString(6, getAclaraciones());
					try {
						
						statement.setBinaryStream(7, getFoto(), getFoto().available());
						
					} catch (IOException e) {

//						e.printStackTrace();
						System.out.println("Error al agregar la imagen.");
						
					}
					
					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("ERROR, al agregar el menu diario");
			
			}
		
	}
	
	public void modificarMenuDiario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "productos"
	     String query = ModificarMenusDiaiosQuery;
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
	    	 	statement.setString(1, this.getNombre());
				statement.setInt(2, this.getPrecio());
				statement.setInt(3, this.getStock());
				statement.setString(4, this.getDiaCorrespondiente());
				statement.setString(5, this.getDescripcion());
				statement.setString(6, this.getAclaraciones());
				try {
					
					statement.setBinaryStream(7, getFoto(), getFoto().available());
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
				statement.setInt(8, this.getId());
				
				try {
					
					statement.setBinaryStream(7, getFoto(), getFoto().available());
					
				} catch (IOException e) {

					e.printStackTrace();
					
				}
					
					int rowsUpdated = statement.executeUpdate();
					
					if (rowsUpdated > 0) {
						
						System.out.println("Actualizado con exito!");
						
					} else if (rowsUpdated == 0) {
						
						System.out.println("No actualizado");
						
					}
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
				System.out.println("No se a podido modificar el producto");
			
			}
		
	}
	
	public void eliminarMenuDiario() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "menus_diarios" de la fila del prdoucto cullo nombre sea del objeto
	     String query = EliminarMenuDiarioQuery; 
	     
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
				System.out.println("No se a podido eliminar el prdoucto.");
			
			}
		
	}
	
	public menuDiario buscarMenuDiario(String tempNombre) {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    menuDiario tempMenu = new menuDiario();
	    String[][] dato = new String[1][4];
	    int NumeroDeProducto = 0;
	    			
			String query = BuscarMenuDiarioQuery;
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("MENU DIARIO NO ENCONTRADO");
					return null;
					
				} else {
					
					do {
						
						int id = resultSet.getInt("idmenus_diarios");
						
						String nombre = resultSet.getString("nombre");
						
						int precio = resultSet.getInt("precio");
						
						int stock = resultSet.getInt("stock");
						
						String dia = resultSet.getString("diaCorrespondiente");
						
						String descripcion = resultSet.getString("descripcion");
						
						String acla = resultSet.getString("aclaraciones");
						
						InputStream input = resultSet.getBinaryStream("foto");
						
						tempMenu.setId(id);
						tempMenu.setNombre(nombre);
						tempMenu.setPrecio(precio);
						tempMenu.setStock(stock);
						tempMenu.setDiaCorrespondiente(dia);
						tempMenu.setDescripcion(descripcion);
						tempMenu.setAclaraciones(acla);
						tempMenu.setFotoPaMostrar(input);
						
						dato[0][0] = String.valueOf(id);
						dato[0][1] = nombre;
						dato[0][2] = String.valueOf(precio);
						dato[0][3] = String.valueOf(stock);
						
						System.out.println("ID: " + id + ", Nombre: " + nombre + ", precio: " + precio + ", stock: " + stock + ", dia de la semana: " + dia + ", descripcion: " + descripcion + ", aclaraciones: " + acla + ", foto: " + input);
						
						return tempMenu;
						
					} while (resultSet.next());
					
				}
				 
			} catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("Menu diario no encontrado");
				return null;
				
			}
		
	}
			
	public String[][] buscarMenusDiarios() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    menuDiario tempMenu = new menuDiario();
	    String[][] datos = new String[100][6];
	    int index = 0;
		
		String query = BuscarMenusDiariosQuery;
		
		try (Connection conn = con;
			PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
			int id = resultSet.getInt("idmenus_diarios");
				
			String nombre = resultSet.getString("nombre");
				
			int precio = resultSet.getInt("precio");
				
			int stock = resultSet.getInt("stock");
				
			String dia = resultSet.getString("diaCorrespondiente");
				
			String descripcion = resultSet.getString("descripcion");
				
			String acla = resultSet.getString("aclaraciones");
			
			InputStream input = resultSet.getBinaryStream("foto");
			
			tempMenu.setNombre(nombre);
			tempMenu.setPrecio(precio);
			tempMenu.setStock(stock);
			tempMenu.setDiaCorrespondiente(dia);
			tempMenu.setDescripcion(descripcion);
			tempMenu.setAclaraciones(acla);
			
			datos[index][0] = tempMenu.getNombre();
			datos[index][1] = String.valueOf(tempMenu.getPrecio());
			datos[index][2] = String.valueOf(tempMenu.getStock());
			datos[index][3] = tempMenu.getDiaCorrespondiente();
			datos[index][4] = tempMenu.getDescripcion();
			datos[index][5] = tempMenu.getAclaraciones();
			
			index++;
			
			System.out.println("ID: " + id + ", Nombre: " + nombre + ", precio: " + precio + ", stock: " + stock + ", dia de la semana: " + dia + ", descripcion: " + descripcion + ", aclaraciones: " + acla + ", foto: " + input);
			System.out.println(" ");
    	
	}
    } catch (SQLException e) {
	
		e.printStackTrace();
    	System.out.println("ERROR en la busqueda de productos");
	
	}
		
	return datos;
		
	}
	
	public static void main(String[] args) {
		
		int OP = 0;
		int inf = 1;
		menuDiario m = new menuDiario();
		Scanner sr = new Scanner(System.in);
		
		String tempNombre = "";
		
		while (inf == 1) {
			
			System.out.println("ELIJA UNA OPCION: ");
			System.out.println(" ");
			System.out.println("1. Agregar menu diario");
			System.out.println("2. Modificar menu diario");
			System.out.println("3. Buscar menu diario");
			System.out.println("4. Buscar todos los menus diarios");
			System.out.println("5. Eliminar menu diario");
			System.out.println("6. Salir");
			
			try {
			OP = sr.nextInt();
			} catch (InputMismatchException e) {
				
//				e.printStackTrace();
                System.out.println("ERROR, ingrese un numero entero");
                
            }
			
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
				
				System.out.println("Ingrese el dia correspondiente: ");
				m.setDiaCorrespondiente(sr.nextLine());
				
				System.out.println("Ingrese la descripcion: ");
				m.setDescripcion(sr.nextLine());
				
				System.out.println("Ingrese las aclaraciones: ");
				m.setAclaraciones(sr.nextLine());
				
				System.out.println("Ingrese la foto: ");
				m.setFoto(sr.next());
				
				m.agregarMenuDiario();
				
				break;
				
			case 2:
				
				System.out.println("Ingrese el nombre del producto a modificar: ");
				tempNombre = sr.nextLine();
				
				m.buscarMenuDiario(tempNombre);
				
				if (m != null) {
					System.out.println(m.getId());
				}
				
				System.out.println("Ingrese el nuevo nombre: ");
				m.setNombre(sr.nextLine());
				
				System.out.println("Ingrese el nuevo precio: ");
				m.setPrecio(sr.nextInt());
				
				System.out.println("Ingrese el nuevo stock: ");
				m.setStock(sr.nextInt());
				
				sr.nextLine();
				
				System.out.println("Ingrese el nuevo dia correspondiente: ");
				m.setDiaCorrespondiente(sr.nextLine());
				
				System.out.println("Ingrese la nueva descripcion: ");
				m.setDescripcion(sr.nextLine());
				
				System.out.println("Ingrese las nuevas aclaraciones: ");
				m.setAclaraciones(sr.nextLine());
				
				System.out.println("Ingrese la nueva foto: ");
				m.setFoto(sr.next());
				
				m.modificarMenuDiario();
				
				break;
				
			case 3:
				
				System.out.println("Ingrese el nombre a buscar");
				tempNombre = sr.nextLine();
				
				m.buscarMenuDiario(tempNombre);
				
				break;
				
			case 4:
				
				m.buscarMenusDiarios();
				
				break;
				
			case 5:
				
				System.out.println("Ingrese el nombre del menu diario a eliminar: ");
				tempNombre = sr.nextLine();
				
				m.buscarMenuDiario(tempNombre);
				
				m.eliminarMenuDiario();
				
				break;
			
			case 6:
				
				inf = 0;
				
				break;
				
			}
			
		}
		
	}

}
