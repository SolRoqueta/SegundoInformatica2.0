package Presentacion;

import Logica.productos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Productos extends JFrame {
	
	public productos producto = new productos();
	
	private menuPrincipal MenuPrincipal;
	
	// Declaracion de atributos de Productos
	private int idproducto;
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public Productos(menuPrincipal MenuPrincipal) {
    	
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
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(39, 196, 705, 365);
    panel.add(scrollPane);
    
    JButton btnVolver = new JButton("←");
    btnVolver.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		MenuPrincipal.setVisible(true);
    		Productos.this.dispose();
    	}
    });
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
    panel.add(btnModificar);
    
    JButton btnEliminar = new JButton("Eliminar");
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
}
