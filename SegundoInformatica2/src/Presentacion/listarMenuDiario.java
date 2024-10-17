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

public class listarMenuDiario extends JFrame {
	
	private productos producto = new productos();
	
	private menuMenuDiario MenuDiario;
	
	private JTable Table;
	private JTextField textField;
	private JTable tablaListarProductos;
	private JTable tabla;
    
    public listarMenuDiario(menuMenuDiario MenuDiario) {
         
        // Configurar la ventana
        setTitle("Listar Productos");
        setSize(500, 538);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("LISTAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(193, 11, 100, 50);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiqueta de Nombre Producto
        JLabel nombreProductoLabel = new JLabel("Nombre Menu");
        nombreProductoLabel.setForeground(new Color(255, 255, 255));
        nombreProductoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nombreProductoLabel.setBounds(106, 95, 102, 14);
        panel.add(nombreProductoLabel);
        
        getContentPane().add(panel);
        
        textField = new JTextField();
        textField.setBounds(106, 116, 127, 20);
        panel.add(textField);  
        
        JLabel lblProductos = new JLabel("MENUS DIARIOS", SwingConstants.CENTER);
        lblProductos.setForeground(new Color(210, 210, 210));
        lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProductos.setBackground(Color.GRAY);
        lblProductos.setBounds(182, 41, 120, 50);
        panel.add(lblProductos);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(192, 52, 100, 2);
        panel.add(separator);
        
        JComboBox <String> comboBox = new JComboBox();
        comboBox.setBounds(267, 116, 100, 20);
        panel.add(comboBox);
        
        comboBox.addItem("Nombre");
        comboBox.addItem("Todos");
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(92, 153, 300, 300);
        panel.add(scrollPane);
        
        JButton btnNewButton = new JButton("←");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuDiario.setVisible(true);
        		listarMenuDiario.this.dispose();
        	}
        });
        btnNewButton.setBounds(217, 468, 50, 15);
        panel.add(btnNewButton);
        
    }
}
