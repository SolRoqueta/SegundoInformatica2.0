package Logica;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class productos {
	
	compresorFoto compFoto = new compresorFoto();
	convertidorFoto convFoto = new convertidorFoto();
	
	private int idproductos; 
	private String nombre; 
	private int precio; 
	private String descripcion; 
	private InputStream is;
	private byte[] fotoComprimida;
	
	// Queries predefinidas
	private String AgregarProductoQuery = "INSERT INTO productos (nombre, descripcion, precio, foto) VALUES (?, ?, ?, ?);";
	private String ModificarProductoQuery = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, foto = ? WHERE id_producto = ?;";
	private String EliminarProductoQuery = "DELETE FROM productos WHERE nombre = ? LIMIT 1;";
	private String BuscarProductoQuery = "SELECT * FROM productos WHERE nombre = ?;";
	private String BuscarProductoIdQuery = "SELECT * FROM productos WHERE id_producto= ?;";
	private String BuscarProductosQuery = "SELECT * FROM productos;";
	
	// CONSTRUCTOR DE PRODUCTOS 
	public productos(int ID, String NOMBRE, String DESCRIPCION, int PRECIO) {
		
		this.setId(ID);
		this.setNombre(NOMBRE);
		this.setDescripcion(DESCRIPCION);
		this.setPrecio(PRECIO);
		
	}
	
	public productos() {
		
	}
	
	// GETS Y SETS DE LOS ATRIBUTOS

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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public InputStream getInputStream() {
		return is;
	}
	
	public void setInputStream(String foto, InputStream is) throws IOException {
		
		if (foto != null) {
			
			convertidorFoto cF = new convertidorFoto();
			this.is = cF.convertirFotoAInputStream(foto);
			
		} else {
			
			this.is = is;
			
		}
	
	}
	
	public byte[] getFotoComprimida() {
		return fotoComprimida;
	}
	
	public void setFotoComprimida(byte[] fotoComprimida) {
		this.fotoComprimida = fotoComprimida;
	}
	
	// METODO PARA AGREGAR UN PRODUCTO A LA BASE DE DATOS

	public void AgregarProducto() throws IOException {
	       
	     conexion cc = new conexion();
	     Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "productos"
	     String query = AgregarProductoQuery;
	     
	     byte[] fotoBytes = convFoto.convertirInputStreamABytes(is); 
	     System.out.println("Tamaño original del InputStream en bytes: " + fotoBytes.length);
	     
	     byte[] fotoComprimida = compFoto.comprimirBytes(fotoBytes);
	     System.out.println("Tamaño comprimido del InputStream en bytes: " + fotoComprimida.length);
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
	    	 		
					statement.setString(1, nombre);
					statement.setString(2, descripcion);
					statement.setInt(3, precio);
					statement.setBytes(4, fotoComprimida);

					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Ingresado con exito!");
					}
				
			} catch (SQLException ex) {
				
//				ex.printStackTrace();
				System.out.println("ERROR, al agregar producto");
			
			}
		
	}
	
	// METODO PARA MODIFICAR UN PRODUCTO EXISTENTE
	
	public void ModificarProducto() throws IOException {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que inserta los datos en la tabla "productos"
	     String query = ModificarProductoQuery;
	     
	     byte[] fotoBytes = convFoto.convertirInputStreamABytes(is); 
	     byte[] fotoComprimida = compFoto.comprimirBytes(fotoBytes);
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
	    	 		
					statement.setString(1, nombre);
					statement.setString(2, descripcion);
					statement.setInt(3, precio);
					statement.setBytes(4, fotoComprimida);
					statement.setInt(5, idproductos);

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
	
	// METODO PARA ELIMINAR UN PRODUCTO EXISTENTE
	
	public void EliminarProducto() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
			
	     //Sentencia SQL que elimina los datos en la tabla "productos" de la fila del prdoucto cullo nombre sea del objeto
	     String query = EliminarProductoQuery; 
	     
	     try (Connection connection = con;
				 PreparedStatement statement = connection.prepareStatement(query)) {
				
					statement.setString(1, nombre);
					
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
	
	
	public productos BuscarProducto(String tempNombre) throws IOException {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    productos tempProducto = new productos();
			
			String query = BuscarProductoQuery;
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				preparedStatement.setString(1, tempNombre);
				
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					
					System.out.println("PRODUCTO NO ENCONTRADO");
					
				} else {
					
					do {
		 	 			
						int id = resultSet.getInt("id_producto");
						
						String nombre = resultSet.getString("nombre");
						
						String descripcion = resultSet.getString("descripcion");
						
						int precio = resultSet.getInt("precio");
						
						byte[] fotoComprimida = resultSet.getBytes("foto");
						
						InputStream is = compFoto.descomprimirBytesAInputStream(fotoComprimida);

						tempProducto.setId(id);
						tempProducto.setDescripcion(descripcion);
						tempProducto.setNombre(nombre);
						tempProducto.setPrecio(precio);
						tempProducto.setInputStream(null, is);
						
						return tempProducto;
						
					} while (resultSet.next());
					
				}
				 
			} catch (SQLException e) {
			
//				e.printStackTrace();
				System.out.println("Producto no encontrado");
			
			}
	    	
			return tempProducto;
			
	}
	
	public List<Object[]> BuscarProductos() {
		
		conexion cc = new conexion();
	    Connection con = cc.conect();
	    List<Object[]> productList = new ArrayList<>();
		
		String query = BuscarProductosQuery;
		
		try (Connection conn = con;
			PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			
				int id = resultSet.getInt("id_producto");
				
				String nombre = resultSet.getString("nombre");
				
				String descripcion = resultSet.getString("descripcion");
				
				int precio = resultSet.getInt("precio");
				
				productList.add(new Object[]{id, nombre, precio, descripcion});
					    	
			}
			
	    } catch (SQLException e) {
		
	//		e.printStackTrace();
	    	System.out.println("ERROR en la busqueda de productos");
		
		}
			return productList;
	}
	
}
	
	// MAIN PARA TESTEAR (TEMPORAL)
//	public static void main(String[] args) throws IOException {
//	
//		productos p = new productos();
//		Scanner sr = new Scanner(System.in);
//		
//		int OP;
//		int inf = 1;
//		
//		while (inf == 1) {
//				
//				System.out.println("TEST DE PRUEBA DE FUNCIONES DE AGREGADO, MODIFICACION Y ELIMINACION");
//				System.out.println(" ");
//				System.out.println("1. AGREGAR PRODUCTO");
//				System.out.println("2. MODIFICAR PRODUCTO");
//				System.out.println("3. ELIMINAR PRODUCTO");
//				System.out.println("4. MOSTRAR LOS PRODUCTOS");
//				System.out.println("5. Salir");
//				
//				OP = sr.nextInt();
//				
//				sr.nextLine();
//				
//				switch (OP) {
//				
//				case 1:
//					
//					System.out.println("Ingrese el nombre del producto: ");
//					
//					p.setNombre(sr.nextLine());
//					
//					System.out.println("Ingrese la descripcion del producto: ");
//					
//					p.setDescripcion(sr.nextLine());
//					
//					System.out.println("Ingrese el precio para el producto: ");
//					
//					p.setPrecio(sr.nextInt());
//					
//					sr.nextLine();
//					
//					System.out.println("Ingrese la ruta de la foto: ");
//					
//	//				p.setFoto(sr.nextLine());
//	//				
//					p.AgregarProducto();
//					
//					break;
//				
//				case 2:
//					
//					p.BuscarProductos();
//					
//					System.out.println("Ingrese el nombre del producto a modificar: ");
//					
//					p = p.BuscarProducto(sr.nextLine());
//					
//					System.out.println("Ingrese el nuveo nombre del producto: ");
//					
//					p.setNombre(sr.nextLine());
//					
//					System.out.println("Ingrese la nueva descripcion del producto: ");
//					
//					p.setDescripcion(sr.nextLine());
//					
//					System.out.println("Ingrese el nuevo precio para el producto: ");
//					
//					p.setPrecio(sr.nextInt());
//					
//					sr.nextLine();
//					
//					System.out.println("Ingrese la nueva ruta de la foto: ");
//					
//	//				p.setFoto(sr.nextLine());
//					
//					p.ModificarProducto();
//					
//					break;
//					
//				case 3:
//					
//					p.BuscarProductos();
//					
//					System.out.println("Ingrese el nombre del producto a eliminar: ");
//					
//					p = p.BuscarProducto(sr.nextLine());
//					
//					p.EliminarProducto();
//					
//					break;
//					
//				case 4:
//					
//					p.BuscarProductos();
//					
//					break;
//					
//				case 5:
//					
//					inf = 0;
//					
//					break;
//					
//				}
//				
//		}
//		
//		sr.close();
//			
//		}
//	
//}
