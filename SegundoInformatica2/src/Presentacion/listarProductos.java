package Presentacion;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.productos;
import java.util.ArrayList;
import java.util.List;

public class listarProductos extends JFrame {
	
	private productos producto = new productos();
	private JTable Table;
	private JTextField textField;
	private JTable tablaListarProductos;
	private JTable tabla;
    
    public listarProductos() {
         
        // Configurar la ventana
        setTitle("Listar Productos");
        setSize(500, 538);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("LISTAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(-11, 0, 507, 63);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Nombre Producto
        JLabel nombreProductoLabel = new JLabel("Nombre Producto");
        nombreProductoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreProductoLabel.setBounds(191, 91, 102, 14);
        panel.add(nombreProductoLabel);
        
        // Botón Listar
        JButton btnListarProductos = new JButton("Listar Producto");
        JButton btnListarTodos = new JButton("Listar Todos");
        
        //Se ejecuta cuando el boton Listar Todos es pulsado 
        btnListarProductos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        	}
        });
        
        btnListarProductos.setBounds(277, 158, 105, 23);
        panel.add(btnListarProductos);
       
        //Se ejecuta cuando el boton Listar Todos es pulsado 
        btnListarTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		productos producto = new productos();
        		String[][] datos = producto.BuscarProductos();
        		
        		String[] columnas = {"ID", "Nombre","Precio", "Descripcion"};
        		
        		tabla = new JTable(datos, columnas);
        		
        		JScrollPane scrollPane = new JScrollPane(tabla);
        		scrollPane.setBounds(98, 191, 300, 300);
        		panel.add(scrollPane);
        		
        		tabla.setPreferredScrollableViewportSize(new Dimension(450, 100));
                tabla.setFillsViewportHeight(true);

        	}
        });
        
        btnListarTodos.setBounds(101, 158, 105, 23);
        panel.add(btnListarTodos);
        
        getContentPane().add(panel);
        
        textField = new JTextField();
        textField.setBounds(178, 109, 127, 20);
        panel.add(textField);  
        
    }
    
}
