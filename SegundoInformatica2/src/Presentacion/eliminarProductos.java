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
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Producto");
        buscarProductoLabel.setForeground(new Color(255, 255, 255));
        buscarProductoLabel.setBounds(106, 97, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(106, 116, 127, 20);
        panel.add(buscarProductoField);
        
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(167, 482, 150, 30);
        panel.add(btnEliminarProducto);
        btnEliminarProducto.setEnabled(false);
    
        // Accion para boton EliminarProducto
	    btnEliminarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	
	    	}
	    });
	    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    JLabel lblProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
    lblProductos.setForeground(Color.WHITE);
    lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblProductos.setBackground(Color.GRAY);
    lblProductos.setBounds(192, 52, 100, 40);
    panel.add(lblProductos);
    
    JComboBox comboBox = new JComboBox();
    comboBox.setBounds(264, 116, 100, 20);
    panel.add(comboBox);
    
    JSeparator separator = new JSeparator();
    separator.setBounds(192, 58, 100, 2);
    panel.add(separator);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(92, 158, 300, 300);
    panel.add(scrollPane);
    
    }
}
