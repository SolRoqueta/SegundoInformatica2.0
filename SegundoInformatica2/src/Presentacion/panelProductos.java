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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class panelProductos extends JFrame {
	
	public productos producto = new productos();
	convertidorFoto convFoto = new convertidorFoto();
	
	private DefaultTableModel modeloTabla;
	private JTable tablaProductos;

	private String nombre;
	private int filaSeleccionada;
	private int opcion;
	
	//Constructor
	public panelProductos() {
		    
	    presentacionProductos();
	}
	    
	// Se encarga de mostrar todos los productos en la tabla
	public void mostrarProductosTabla() {
			  
	        List<Object[]> infoProducto = producto.BuscarProductos();

	        modeloTabla.setRowCount(0);

	        for (Object[] fila : infoProducto) {
	            modeloTabla.addRow(fila);
	        }
	    
	}
	
	// Se encarga de mostrar todos los productos en la tabla
	public void mostrarProductosNombreTabla(String nombreProducto) {
			 
			List<Object[]> listaProductosNombre = producto.BuscarProductosNombre(nombreProducto);

	        modeloTabla.setRowCount(0);

	        for (Object[] fila : listaProductosNombre) {
	            modeloTabla.addRow(fila);
	        }
	    
	}
	
	public void mostrarProductosPrecioTabla(String precioProducto) {

		List<Object[]> listaProductosPrecio = producto.BuscarProductosPrecio(precioProducto);

        modeloTabla.setRowCount(0);
        
        for (Object[] fila : listaProductosPrecio) {
            modeloTabla.addRow(fila);
        }
    
}
	
	
	//Metodo presentacion
	public void presentacionProductos() {
		
		 // Configurar la ventana
        setTitle("Panel Productos");
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
	    
	    JLabel lblFiltro = new JLabel("Filtro: Nombre");
	    lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblFiltro.setForeground(new Color(255, 255, 255));
	    lblFiltro.setBounds(438, 121, 124, 14);
	    panel.add(lblFiltro);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Buscar Producto");
        buscarProductoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buscarProductoLabel.setForeground(new Color(255, 255, 255));
        buscarProductoLabel.setBounds(97, 116, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(97, 142, 309, 30);
        panel.add(buscarProductoField);
        
        String[] opcionesBuscar = {"Nombre", "Precio"};
        
        JComboBox chcbxOpcionesBuscar = new JComboBox();
        chcbxOpcionesBuscar.setBounds(438, 142, 121, 30);
        chcbxOpcionesBuscar.addItem(opcionesBuscar[0]);
        chcbxOpcionesBuscar.addItem(opcionesBuscar[1]);
        panel.add(chcbxOpcionesBuscar);

        //Creacion tabla
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Precio", "Descripcion"}, 0);
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
	    
	    JButton btnAplicarFiltro = new JButton("Aplicar");
	    btnAplicarFiltro.setBounds(574, 142, 121, 30);
	    panel.add(btnAplicarFiltro);
	    
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
	    
	    // Btn Aplicar Filtro
	    btnAplicarFiltro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		  opcion = chcbxOpcionesBuscar.getSelectedIndex();
	    		  
	    		  if (opcion == 0) {
	    			  lblFiltro.setText("Filtro: Nombre");
	    		  } else {
	    			  lblFiltro.setText("Filtro: Precio");
	    		  }
	    			
	    	}
	    });
    
	    //Btn Agregar Producto
	    btnAgregar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	
	    		
				agregarProductos ventanaAgregar = new agregarProductos();
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
	  		    	nombre = tablaProductos.getValueAt(filaSeleccionada, 0).toString(); // Columna 1: Nombre
	  		    	
	  		        try {
	  		        	
						producto = producto.BuscarProducto(nombre);
						
					} catch (IOException e1) {
//						e1.printStackTrace();
					}
	  		    
	  		        try {
					
					  modificarProductos ventanaModificar = new modificarProductos(nombre);
					  ventanaModificar.setVisible(true);
					  panelProductos.this.dispose();
					  
					} catch (IOException e1) {
//						e1.printStackTrace();
					}
				
	  		    }
	    	}
	    	});
	    
	    //Btn Eliminar
	    btnEliminar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		filaSeleccionada = tablaProductos.getSelectedRow();
	
	  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
	  		    	
	  		    	nombre = tablaProductos.getValueAt(filaSeleccionada, 0).toString(); // Columna 1: Nombre
	  		        
	  		    } else {
	  		        System.out.println("No hay ninguna fila seleccionada.");
	  		    }
	    		
	    		try {
	    			
					producto = producto.BuscarProducto(nombre);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		
	    		 int option = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres eliminar el producto " + nombre + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
	             
	             // Comprobar la respuesta
	             if (option == JOptionPane.YES_OPTION) {
	            	producto.EliminarProducto();
	 	    		modeloTabla.removeRow(filaSeleccionada);
	 	    		JOptionPane.showMessageDialog(panel, "Producto eliminado");
	             } else {
	            	 JOptionPane.showMessageDialog(panel, "Producto no eliminado");
	             }
	             
	    	}	
	    });
	    
	    buscarProductoField.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		
        		if (buscarProductoField.getText().equals("")) {
        			mostrarProductosTabla();
        		} else {
        			
        			if (opcion == 0) {
    					
    					String nombreProducto = buscarProductoField.getText();
    	        		mostrarProductosNombreTabla(nombreProducto);
    					
    				} else if (opcion == 1) {
            			
                			String precioProducto = buscarProductoField.getText();
                			mostrarProductosPrecioTabla(precioProducto);
                		}
    	        		
    				}
        		}
    
        });
	    
    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
  
		
	}
}
