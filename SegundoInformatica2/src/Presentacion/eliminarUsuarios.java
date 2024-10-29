package Presentacion;

import Logica.productos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminarUsuarios extends JFrame {
	
	public productos producto = new productos();
	
	private menuUsuarios MenuUsuarios;
	
	// Declaracion de atributos de Productos
	private int idproducto;
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public eliminarUsuarios(menuUsuarios MenuUsuarios) {
    	
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(500, 575);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("ELIMINAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(177, 11, 130, 60);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Buscar Usuario");
        buscarProductoLabel.setForeground(new Color(255, 255, 255));
        buscarProductoLabel.setBounds(92, 92, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(92, 119, 186, 23);
        panel.add(buscarProductoField);
        
        JButton btnEliminarProducto = new JButton("Eliminar Usuarios");
        btnEliminarProducto.setBounds(167, 487, 150, 30);
        panel.add(btnEliminarProducto);
        btnEliminarProducto.setEnabled(false);
    
        // Accion para boton EliminarProducto
	    btnEliminarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    	}
	    });
	    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    JLabel lblProductos = new JLabel("USUARIOS", SwingConstants.CENTER);
    lblProductos.setForeground(new Color(210, 210, 210));
    lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblProductos.setBackground(Color.GRAY);
    lblProductos.setBounds(192, 52, 100, 40);
    panel.add(lblProductos);
    
    JSeparator separator = new JSeparator();
    separator.setBackground(new Color(210, 210, 210));
    separator.setBounds(192, 58, 100, 2);
    panel.add(separator);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(60, 153, 363, 318);
    panel.add(scrollPane);
    
    JButton btnEliminarProducto_1 = new JButton("←");
    btnEliminarProducto_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MenuUsuarios.setVisible(true); // Show the main menu
    		eliminarUsuarios.this.dispose();    // Close the current window
    	}
    });
    
    btnEliminarProducto_1.setBounds(10, 11, 50, 15);
    panel.add(btnEliminarProducto_1);
    
    JButton btnNewButton = new JButton("Buscar");
    btnNewButton.setBounds(302, 119, 89, 23);
    panel.add(btnNewButton);
    
    }
}
