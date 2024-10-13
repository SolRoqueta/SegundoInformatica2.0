package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarUsuarios extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
	private JTextField textField;
	private JPasswordField passwordField;
    
    public modificarUsuarios() {
    	
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MODIFICAR ", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(154, 11, 150, 40);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Usuario");
        buscarProductoLabel.setForeground(new Color(230, 230, 230));
        buscarProductoLabel.setBounds(127, 90, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(127, 114, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto 
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(155, 161, 100, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(155, 181, 150, 25);
        panel.add(nombreField);
        nombreField.setEditable(false);
        
        JLabel precioLabel = new JLabel("Contraseña");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(155, 210, 76, 25);
        panel.add(precioLabel);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Mail");
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(155, 264, 100, 25);
        panel.add(descripcionLabel);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(254, 115, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.setBounds(153, 401, 150, 30);
        panel.add(btnModificarProducto);
        btnModificarProducto.setEnabled(false);
        
       // ACCIONES
        
	    // Accion para Boton BuscarProducto
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        	}
        });
     
	    // Accion para Boton ModificarProducto
	    btnModificarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
    
	    // Agregar el panel a la ventana
	    getContentPane().add(panel);
	    
	    JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
	    lblTipoUsuario.setForeground(new Color(230, 230, 230));
	    lblTipoUsuario.setBounds(155, 318, 100, 25);
	    panel.add(lblTipoUsuario);
	    
	    textField = new JTextField();
	    textField.setEditable(false);
	    textField.setBounds(155, 286, 150, 25);
	    panel.add(textField);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(155, 339, 150, 25);
	    panel.add(comboBox);
	    
	    passwordField = new JPasswordField();
	    passwordField.setBounds(155, 233, 150, 25);
	    panel.add(passwordField);
	    
	    JLabel lblUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
	    lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblUsuarios.setForeground(new Color(210, 210, 210));
	    lblUsuarios.setBackground(Color.GRAY);
	    lblUsuarios.setBounds(154, 43, 150, 40);
	    panel.add(lblUsuarios);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBackground(new Color(210, 210, 210));
	    separator.setForeground(new Color(210, 210, 210));
	    separator.setBounds(179, 49, 100, 2);
	    panel.add(separator);
    
    }
  }

