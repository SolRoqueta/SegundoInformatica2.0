package Presentacion;

import Logica.productos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminarProductos extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private int idproducto;
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public eliminarProductos() {
    	
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(475, 555);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("ELIMINAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(-30, 0, 519, 60);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Producto");
        buscarProductoLabel.setBounds(122, 78, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(122, 99, 120, 25);
        panel.add(buscarProductoField);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(255, 100, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(153, 440, 150, 30);
        panel.add(btnEliminarProducto);
        btnEliminarProducto.setEnabled(false);
        
        // Accion para boton BuscarProducto
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        		
        		nombre = buscarProductoField.getText();
        		
        		// Verifica el valor del nombre, si es nulo muestra un error, si no existe muestra otro error y finalmente si existe 
        		// lo busca en la base de datos y muestra todos sus 
        				
        		
        	}
        });
    
        // Accion para boton EliminarProducto
	    btnEliminarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	
	    	}
	    });
	    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    }
}
