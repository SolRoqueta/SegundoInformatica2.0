package Presentacion;

import Logica.convertidorFoto;
import Logica.productos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.util.List;

public class panelProductos extends JFrame {
	
	public productos producto = new productos();

	private agregarProductos ventanaAgregar;
	private modificarProductos ventanaModificar;
	private DefaultTableModel modeloTabla;
	private JTable tablaProductos;

	private String nombre;
	private int precio;
	private String descripcion;
	private InputStream is;
	private ImageIcon fotoIcon;
	
	private int filaSeleccionada;
	
	//Constructor
	public panelProductos() {
		    
	    presentacionProductos();
	}

	 
	 //Setters y Getters
	 
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

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
	// Se encarga de mostrar todos los productos en la tabla
	public void mostrarProductosTabla() {
			  
	        List<Object[]> infoProducto = producto.BuscarProductos();

	        modeloTabla.setRowCount(0);

	        for (Object[] row : infoProducto) {
	            modeloTabla.addRow(row);
	        }
	    
	}
	
	

	//Metodo presentacion
	public void presentacionProductos() {
		
		  // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("PANEL", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
        titulo.setBounds(293, 21, 198, 60);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        JSeparator separator = new JSeparator();
	    separator.setBackground(new Color(210, 210, 210));
	    separator.setBounds(330, 72, 124, 2);
	    panel.add(separator);
	    
	    JLabel lblProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
	    lblProductos.setForeground(new Color(210, 210, 210));
	    lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblProductos.setBackground(Color.GRAY);
	    lblProductos.setBounds(293, 61, 198, 60);
	    panel.add(lblProductos);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Buscar Producto");
        buscarProductoLabel.setForeground(new Color(255, 255, 255));
        buscarProductoLabel.setBounds(177, 117, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(177, 142, 293, 30);
        panel.add(buscarProductoField);
        
        //Creacion tabla
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Precio", "Descripcion"}, 0);
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        
        tablaProductos.setRowSelectionAllowed(true);  // Permite la selección de filas
        tablaProductos.setColumnSelectionAllowed(false); // Desactiva la selección de columnas
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección de una sola fila a la vez (opcional)
	    
	    JScrollPane scrollPane = new JScrollPane(tablaProductos);
	    scrollPane.setBounds(39, 196, 705, 365);
	    panel.add(scrollPane);
	    
	    mostrarProductosTabla();
	    
        //Botones
        
	    JButton btnVolver = new JButton("←");
	    btnVolver.setBounds(10, 11, 50, 15);
	    panel.add(btnVolver);
	    
	    JButton btnBuscar = new JButton("Buscar");
	    btnBuscar.setBounds(480, 142, 89, 30);
	    panel.add(btnBuscar);
	    
	    JButton btnAgregar = new JButton("Agregar"); 
	    btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnAgregar.setBounds(86, 588, 145, 40);
	    panel.add(btnAgregar);
	   
	    JButton btnModificar = new JButton("Modificar");
	    btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnModificar.setBounds(318, 588, 145, 40);
	    btnModificar.setEnabled(false);
	    panel.add(btnModificar);
    
	    JButton btnEliminar = new JButton("Eliminar");
	    btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnEliminar.setBounds(550, 588, 145, 40);
	    btnEliminar.setEnabled(false);
	    panel.add(btnEliminar);
    
	    
	    // Mouse Listener
	    
	    tablaProductos.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 1) { 
	                int selectedRow = tablaProductos.rowAtPoint(e.getPoint());
	                if (selectedRow != -1) {
	                    btnEliminar.setEnabled(true);
	                    btnModificar.setEnabled(true);
	                }
	            }
	        }
	    });

	    
	    // Action Listeners Botones
	    
	    // Btn Volver
	    btnVolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		menuPrincipal MenuPrincipal = new menuPrincipal();
	    		MenuPrincipal.setVisible(true);
	    		panelProductos.this.dispose();
	    	}
	    });
    
	    //Btn Agregar Producto
	    btnAgregar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	
				ventanaAgregar = new agregarProductos();
				ventanaAgregar.setVisible(true);
				panelProductos.this.dispose();	
			}
	    });
    
	    //Btn Modificar
	    btnModificar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		filaSeleccionada = tablaProductos.getSelectedRow();
	    		productos producto = new productos();
	    		
	  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
	  		    	
	  		        // Obtenemos los valores de cada columna
	  		    	nombre = tablaProductos.getValueAt(filaSeleccionada, 1).toString(); // Columna 1: Nombre
	  		    	convertidorFoto cF = new convertidorFoto();
	  		    	
	  		        try {
						producto = producto.BuscarProducto(nombre);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	  		    
				try {
					
					  modificarProductos ventanaModificar = new modificarProductos(nombre, producto.getPrecio(), producto.getDescripcion(), producto.getInputStream());
					  ventanaModificar.setVisible(true);
					  panelProductos.this.dispose();
					  
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
	  		    }
	    	}
	    	});
	    
	    //Btn Eliminar
	    btnEliminar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		filaSeleccionada = tablaProductos.getSelectedRow();
	
	  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
	  		        // Obtenemos los valores de cada columna
	  		    	nombre = tablaProductos.getValueAt(filaSeleccionada, 1).toString(); // Columna 1: Nombre
	  		        
	  		    } else {
	  		        System.out.println("No hay ninguna fila seleccionada.");
	  		    }
	    		
	    		try {
					producto = producto.BuscarProducto(nombre);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		producto.EliminarProducto();
	    		modeloTabla.removeRow(filaSeleccionada);
	    		
	    	}	
	    });
    
    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
		
	}
    
}
