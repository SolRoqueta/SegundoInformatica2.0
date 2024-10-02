package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        titulo.setBounds(-8, 0, 500, 64);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Nombre Producto
        JLabel nombreProductoLabel = new JLabel("Nombre Producto");
        nombreProductoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreProductoLabel.setBounds(183, 84, 118, 25);
        panel.add(nombreProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField nombreProductoField = new JTextField();
        nombreProductoField.setBounds(173, 108, 138, 25);
        panel.add(nombreProductoField);
        
        // Botón Listar
        JButton listarBtn = new JButton("Listar Producto");
        listarBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        listarBtn.setBounds(103, 154, 128, 23);
        panel.add(listarBtn);
        
        // JList para mostrar los productos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        // Ejemplo de datos para la lista
        listModel.addElement("Producto 1");
        listModel.addElement("Producto 2");
        listModel.addElement("Producto 3");
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JButton btnListarTodos = new JButton("Listar Todos");
        btnListarTodos.setBounds(253, 154, 128, 23);
        panel.add(btnListarTodos);
        
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
