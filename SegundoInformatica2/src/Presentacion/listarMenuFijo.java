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

public class listarMenuFijo extends JFrame {
	
	private productos producto = new productos();
	private JTable Table;
	private JTextField textField;
	private JTable tablaListarProductos;
	private JTable tabla;
    
    public listarMenuFijo() {
         
        // Configurar la ventana
        setTitle("Listar Productos");
        setSize(500, 538);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 73));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("LISTAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(193, 11, 100, 50);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Nombre Producto
        JLabel nombreProductoLabel = new JLabel("Nombre Producto");
        nombreProductoLabel.setForeground(new Color(255, 255, 255));
        nombreProductoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nombreProductoLabel.setBounds(106, 100, 102, 14);
        panel.add(nombreProductoLabel);
        
        getContentPane().add(panel);
        
        textField = new JTextField();
        textField.setBounds(106, 116, 127, 20);
        panel.add(textField);  
        
        JLabel lblProductos = new JLabel("MENUS FIJOS", SwingConstants.CENTER);
        lblProductos.setForeground(Color.WHITE);
        lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProductos.setBackground(Color.GRAY);
        lblProductos.setBounds(187, 41, 110, 50);
        panel.add(lblProductos);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(192, 52, 100, 2);
        panel.add(separator);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(264, 116, 100, 20);
        panel.add(comboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(92, 175, 300, 300);
        panel.add(scrollPane);
        
    }
}
