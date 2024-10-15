package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarUsuarios extends JFrame {
	
	public productos producto = new productos();
	
	private menuUsuarios MenuUsuarios;
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
	private JTextField textField;
	private JPasswordField passwordField;
    
    public modificarUsuarios(menuUsuarios MenuUsuarios) {
    	
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(351, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MODIFICAR ", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(92, 10, 150, 40);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Usuario");
        buscarProductoLabel.setForeground(new Color(230, 230, 230));
        buscarProductoLabel.setBounds(58, 93, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(58, 119, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto 
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(92, 161, 100, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(92, 181, 150, 25);
        panel.add(nombreField);
        nombreField.setEditable(false);
        
        JLabel precioLabel = new JLabel("Contraseña");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(92, 210, 76, 25);
        panel.add(precioLabel);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Mail");
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(92, 264, 100, 25);
        panel.add(descripcionLabel);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(199, 120, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.setBounds(92, 382, 150, 30);
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
	    lblTipoUsuario.setBounds(92, 318, 100, 25);
	    panel.add(lblTipoUsuario);
	    
	    textField = new JTextField();
	    textField.setEditable(false);
	    textField.setBounds(92, 286, 150, 25);
	    panel.add(textField);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(92, 339, 150, 25);
	    panel.add(comboBox);
	    
	    passwordField = new JPasswordField();
	    passwordField.setBounds(92, 233, 150, 25);
	    panel.add(passwordField);
	    
	    JLabel lblUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
	    lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblUsuarios.setForeground(new Color(210, 210, 210));
	    lblUsuarios.setBackground(Color.GRAY);
	    lblUsuarios.setBounds(92, 42, 150, 40);
	    panel.add(lblUsuarios);
	    
	    JSeparator separator = new JSeparator();
	    separator.setBackground(new Color(210, 210, 210));
	    separator.setForeground(new Color(210, 210, 210));
	    separator.setBounds(117, 48, 100, 2);
	    panel.add(separator);
	    
	    JButton btnModificarProducto_1 = new JButton("←");
	    btnModificarProducto_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnModificarProducto_1.setBounds(142, 426, 50, 15);
	    panel.add(btnModificarProducto_1);
    
    }
  }

