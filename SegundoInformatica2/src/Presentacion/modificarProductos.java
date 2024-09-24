package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarProductos extends JFrame {
    
    public modificarProductos() {
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MODIFICAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(-21, 0, 519, 60);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Producto");
        buscarProductoLabel.setBounds(135, 78, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(135, 99, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto para modificar los datos del producto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(72, 150, 100, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(72, 170, 150, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(72, 199, 47, 25);
        panel.add(precioLabel);
        
        JTextField precioField = new JTextField();
        precioField.setBounds(72, 220, 150, 25);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setBounds(72, 253, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(291, 183, 100, 100);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(283, 302, 117, 25);
        panel.add(subirImagenBtn);
        
        // Botón Modificar Producto
        JButton modificarProductoBtn = new JButton("Modificar Producto");
        modificarProductoBtn.setBounds(153, 394, 150, 30);
        panel.add(modificarProductoBtn);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(267, 100, 78, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel.add(btnNewButton);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            modificarProductos ventana = new modificarProductos();
            ventana.setVisible(true);
        });
    }
}
