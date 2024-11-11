package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Pproductos extends JFrame {
	
	public productos producto = new productos();

	private agregarProductos ventanaAgregar;
	private modificarProductos ventanaModificar;
	private DefaultTableModel modeloTabla;
	private JTable tablaProductos;
	
	// Declaracion de atributos de Productos
	private String nombre;
	private String precio;
	private String descripcion;
	
	public Pproductos() {
		
		presentacionProductos();
		
	}
	
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
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Buscar Producto");
        buscarProductoLabel.setForeground(new Color(255, 255, 255));
        buscarProductoLabel.setBounds(177, 117, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(177, 142, 293, 30);
        panel.add(buscarProductoField);
	    
	    // Agregar el panel a la ventana
	    getContentPane().add(panel);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBackground(new Color(210, 210, 210));
	    separator.setBounds(330, 72, 124, 2);
	    panel.add(separator);
	    
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
	    
	    // Get the product data from the logic class
        List<Object[]> infoProducto = producto.BuscarProductos();

        // Clear existing rows
        modeloTabla.setRowCount(0);

        // Add each product as a row in the table model
        for (Object[] row : infoProducto) {
            modeloTabla.addRow(row);
        }
    
    JButton btnVolver = new JButton("←");
    btnVolver.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		menuPrincipal MenuPrincipal = new menuPrincipal();
    		MenuPrincipal.setVisible(true);
    		Pproductos.this.dispose();
    	}
    });
    btnVolver.setBounds(10, 11, 50, 15);
    panel.add(btnVolver);
    
    JButton btnBuscar = new JButton("Buscar");
    btnBuscar.setBounds(480, 142, 89, 30);
    panel.add(btnBuscar);
    
    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		ventanaAgregar = new agregarProductos();
    		ventanaAgregar.setVisible(true);
    		Pproductos.this.dispose();	
    		
    	}
    });
    btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    btnAgregar.setBounds(86, 588, 145, 40);
    panel.add(btnAgregar);
    
    JButton btnModificar = new JButton("Modificar");
    btnModificar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int filaSeleccionada = tablaProductos.getSelectedRow();

  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
  		        // Obtenemos los valores de cada columna
  		        setNombre(tablaProductos.getValueAt(filaSeleccionada, 1).toString()); // Columna 1: Nombre
  		        setPrecio(tablaProductos.getValueAt(filaSeleccionada, 2).toString()); // Columna 2: Precio
  		        setDescripcion(tablaProductos.getValueAt(filaSeleccionada, 3).toString()); // Columna 3: Descripción

  		        
  		    } else {
  		        System.out.println("No hay ninguna fila seleccionada.");
  		    }
  		    
    		ventanaModificar = new modificarProductos(nombre, precio, descripcion, Pproductos.this);
    		ventanaModificar.setVisible(true);
    		Pproductos.this.dispose();
    	}	
    });
    
    btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    btnModificar.setBounds(318, 588, 145, 40);
    panel.add(btnModificar);
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int filaSeleccionada = tablaProductos.getSelectedRow();

  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
  		        // Obtenemos los valores de cada columna
  		    	nombre = tablaProductos.getValueAt(filaSeleccionada, 1).toString(); // Columna 1: Nombre
  		        
  		    } else {
  		        System.out.println("No hay ninguna fila seleccionada.");
  		    }
    		
    		producto = producto.BuscarProducto(nombre);
    		producto.EliminarProducto();
    		modeloTabla.removeRow(filaSeleccionada);
    		
    	}	
    });

    btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    btnEliminar.setBounds(550, 588, 145, 40);
    panel.add(btnEliminar);
    
    JLabel lblProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
    lblProductos.setForeground(new Color(210, 210, 210));
    lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblProductos.setBackground(Color.GRAY);
    lblProductos.setBounds(293, 61, 198, 60);
    panel.add(lblProductos);
		
	}
    
    public Pproductos(menuPrincipal MenuPrincipal) {
    
    	presentacionProductos();
    
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
