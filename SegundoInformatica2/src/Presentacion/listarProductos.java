package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;

public class listarProductos extends JFrame {
    
    public listarProductos() {
        // Configurar la ventana
        setTitle("Listar Productos");
        setSize(500, 538);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null); // Usamos layout nulo para posicionar los elementos manualmente
        panel.setBackground(Color.LIGHT_GRAY);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("LISTAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(0, 0, 500, 64);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Nombre Producto
        JLabel nombreProductoLabel = new JLabel("Nombre Producto");
        nombreProductoLabel.setBounds(141, 81, 118, 25);
        panel.add(nombreProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField nombreProductoField = new JTextField();
        nombreProductoField.setBounds(138, 105, 120, 25);
        panel.add(nombreProductoField);
        
        // ComboBox para seleccionar un criterio o categoría
        JComboBox<String> comboBox = new JComboBox<>(new String[] {"ID", "Nombre", "Categoría"});
        comboBox.setBounds(280, 105, 61, 25);
        panel.add(comboBox);
        
        // Botón Listar
        JButton listarBtn = new JButton("Listar");
        listarBtn.setBounds(192, 149, 100, 30);
        panel.add(listarBtn);
        
        // JList para mostrar los productos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Ejemplo de datos para la lista
        listModel.addElement("Producto 1");
        listModel.addElement("Producto 2");
        listModel.addElement("Producto 3");
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JList list = new JList();
        list.setBounds(103, 199, 278, 278);
        panel.add(list);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            listarProductos ventana = new listarProductos();
            ventana.setVisible(true);
        });
    }
}
