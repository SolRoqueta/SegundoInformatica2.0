package Logica;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class menus {
		
	compresorFoto compFoto = new compresorFoto();
	convertidorFoto convFoto = new convertidorFoto();	
		
	private int idMenu; //Declaro el int de id
	private String nombre; //Declaro el String de nombre_completo
	private String descripcion; //Declaro el String de contraseña
	private int precio;
	private int stock;
	private boolean diario;
	private String diaCorrespondiente;
	private InputStream is;
	private byte[] fotoComprimida;
	private String query;
	
	private String AgregarMenuQuery = "INSERT INTO menus (nombre, precio, descripcion, foto, stock, diario, dia_correspondiente) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String ModificarMenuQuery = "UPDATE menus SET nombre = ?, precio = ?, descripcion = ?, foto = ?, stock = ?, diario = ?, dia_correspondiente = ? WHERE id_menu = ?;";
	private String EliminarMenuQuery = "DELETE FROM menus WHERE id_menu = ? LIMIT 1;";
	private String BuscarMenuQuery = "SELECT * FROM menus WHERE nombre = ?;";
	private String BuscarMenusQuery = "SELECT * FROM menus ORDER BY nombre ASC;";
	private String BuscarMenusNombreQuery = "SELECT * FROM menus WHERE nombre LIKE";
	private String BuscarMenusPrecioQuery = "SELECT * FROM menus WHERE precio LIKE";
	private String BuscarMenusStockQuery = "SELECT * FROM menus WHERE stock LIKE";
	private String BuscarMenusDiaQuery = "SELECT * FROM menus WHERE dia_correspondiente LIKE";
	
//	  CONSTRUCTOR DE USUARIOS 
	
	public menus(String idMenu, String nombre, int precio, String descripcion, byte[] foto, int stock, boolean diario, String diaCorrespondiente ) {
		
	}
	
	public menus() {
		
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public boolean isDiario() {
		return diario;
	}

	public void setDiario(boolean diario) {
		this.diario = diario;
	}

	public String getDiaCorrespondiente() {
		return diaCorrespondiente;
	}

	public void setDiaCorrespondiente(String diaCorrespondiente) {
		this.diaCorrespondiente = diaCorrespondiente;
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

		public void AgregarMenu() throws IOException {
		       
		     conexion cc = new conexion();
		     Connection con = cc.conect();
				
		     //Sentencia SQL que inserta los datos en la tabla "productos"
		     String query = AgregarMenuQuery;
		     
		     byte[] fotoBytes = convFoto.convertirInputStreamABytes(is); 
//		     System.out.println("Tamaño original del InputStream en bytes: " + fotoBytes.length);
		     
		     byte[] fotoComprimida = compFoto.comprimirBytes(fotoBytes);
//		     System.out.println("Tamaño comprimido del InputStream en bytes: " + fotoComprimida.length);
		     
		     try (Connection connection = con;
					 PreparedStatement statement = connection.prepareStatement(query)) {
		    	 		
						statement.setString(1, nombre);
						statement.setInt(2, precio);
						statement.setString(3, descripcion);
						statement.setBytes(4, fotoComprimida);
						statement.setInt(5, stock);
						statement.setBoolean(6, diario);
						statement.setString(7, diaCorrespondiente);

						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) {
						}
					
				} catch (SQLException ex) {
					
					ex.printStackTrace();

				
				}
			
		}
		
		public void ModificarMenu() throws IOException {
			
			conexion cc = new conexion();
		    Connection con = cc.conect();
				
		     //Sentencia SQL que inserta los datos en la tabla "productos"
		     String query = ModificarMenuQuery;
		     
		     byte[] fotoBytes = convFoto.convertirInputStreamABytes(is); 
		     byte[] fotoComprimida = compFoto.comprimirBytes(fotoBytes);
		     
		     try (Connection connection = con;
					 PreparedStatement statement = connection.prepareStatement(query)) {
		    	 		
			    	 	statement.setString(1, nombre);
						statement.setInt(2, precio);
						statement.setString(3, descripcion);
						statement.setBytes(4, fotoComprimida);
						statement.setInt(5, stock);
						statement.setBoolean(6, diario);
						statement.setString(7, diaCorrespondiente);
						statement.setInt(8, idMenu);
						
						int rowsUpdated = statement.executeUpdate();
						
//						if (rowsUpdated > 0) {
//							
//							System.out.println("Actualizado con exito!");
//							
//						} else if (rowsUpdated == 0) {
//							
//							System.out.println("No actualizado");
//							
//						}
					
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				
				}
			
		}
		
		public void EliminarMenu() {
			
			conexion cc = new conexion();
		    Connection con = cc.conect();
				
		     //Sentencia SQL que elimina los datos en la tabla "productos" de la fila del prdoucto cullo nombre sea del objeto
		     String query = EliminarMenuQuery; 
		     
		     try (Connection connection = con;
					 PreparedStatement statement = connection.prepareStatement(query)) {
					
		    	 		statement.setInt(1, idMenu);
						
						int rowsUpdated = statement.executeUpdate();
						
//						if (rowsUpdated > 0) {
//							System.out.println("Eliminado con exito!");
//						} else if (rowsUpdated == 0) {
//							
//							System.out.println("No eliminado");
//							
//						}
					
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				
				}
			
		}
		
		public menus BuscarMenu(String tempNombre) throws IOException {
			
			conexion cc = new conexion();
		    Connection con = cc.conect();
		    menus tempMenu = new menus();
				
				String query = BuscarMenuQuery;
				
				try (Connection conn = con;
					PreparedStatement preparedStatement = conn.prepareStatement(query)) {
					
					preparedStatement.setString(1, tempNombre);
					
					ResultSet resultSet = preparedStatement.executeQuery();
									
					if (!resultSet.next()) {
						
						System.out.println("MENU NO ENCONTRADO");
						
					} else {
						
						do {
							
							int id = resultSet.getInt("id_menu");
							String nombre = resultSet.getString("nombre");
							int precio = resultSet.getInt("precio");
							String descripcion = resultSet.getString("descripcion");
							byte[] fotoComprimida = resultSet.getBytes("foto");
							InputStream is = compFoto.descomprimirBytesAInputStream(fotoComprimida);
							int stock = resultSet.getInt("stock");
							boolean diario = resultSet.getBoolean("diario");
							String diaCorrespondiente = resultSet.getString("dia_correspondiente");
							
							tempMenu.setNombre(nombre);
							tempMenu.setPrecio(precio);
							tempMenu.setDescripcion(descripcion);
							tempMenu.setInputStream(null, is);
							tempMenu.setStock(stock);
							tempMenu.setDiario(diario);
							tempMenu.setDiaCorrespondiente(diaCorrespondiente);
							
							tempMenu.setIdMenu(id);
							
							return tempMenu;
							
						} while (resultSet.next());
						
					}
					 
				} catch (SQLException e) {
				
					e.printStackTrace();
				
				}
			
			return tempMenu;
			
		}
		
		public List<Object[]> BuscarMenus(String atributoMenu, int opcion) {
			
			conexion cc = new conexion();
		    Connection con = cc.conect();
		    List<Object[]> menuList = new ArrayList<>();
		    
		    switch (opcion) {
		    case 0:
		        query = BuscarMenusNombreQuery + " '" + atributoMenu + "%';";
		        break;

		    case 1:
		        query = BuscarMenusPrecioQuery + " '" + atributoMenu + "%';";
		        break;

		    case 2:
		        query = BuscarMenusStockQuery + " '" + atributoMenu + "%';";
		        break;

		    case 3:
		        query = BuscarMenusDiaQuery + " '" + atributoMenu + "%';";
		        break;

		    case 4:
		        query = BuscarMenusQuery;
		        break;

		    default:
		        throw new IllegalArgumentException("Opción no válida: " + opcion);
		    }
			
			try (Connection conn = con;
				PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					String nombre = resultSet.getString("nombre");
					
					int precio = resultSet.getInt("precio");
					
					String descripcion = resultSet.getString("descripcion");
					
					int stock = resultSet.getInt("stock");
					
					String dia = resultSet.getString("dia_correspondiente");
					
					menuList.add(new Object[]{nombre, precio, stock, descripcion, dia});
						    	
				}
				
		    } catch (SQLException e) {
			
				e.printStackTrace();
			
			}
				return menuList;
		}
		
	
	
}
