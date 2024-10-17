package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuProductos extends JFrame {

    private menuPrincipal MenuPrincipal; // Reference to the main menu

    public menuProductos(menuPrincipal MenuPrincipal) {
        this.MenuPrincipal = MenuPrincipal; // Set the reference to the main menu

        setTitle("Menu Productos");
        getContentPane().setBackground(new Color(43, 70, 77));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(309, 368);
        getContentPane().setLayout(null);
        
        JLabel labelTitulo = new JLabel("MENU", SwingConstants.CENTER);
        labelTitulo.setBackground(Color.WHITE);
        labelTitulo.setBounds(96, 11, 100, 40);
        getContentPane().add(labelTitulo);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        labelTitulo.setBackground(Color.GRAY);
        labelTitulo.setForeground(new Color(210, 210, 210));
        
        // Boton para Agregar Productos
        JButton btnAgregarProductos = new JButton("Agregar");
        btnAgregarProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProductos ventanaAgregar = new agregarProductos(menuProductos.this);
                ventanaAgregar.setVisible(true);
                menuProductos.this.dispose();
            }
        });
        btnAgregarProductos.setBounds(84, 88, 125, 31);
        getContentPane().add(btnAgregarProductos);
        
        // Boton para Modificar Productos
        JButton btnModificarProductos = new JButton("Modificar");
        btnModificarProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarProductos ventanaModificar = new modificarProductos(menuProductos.this);
                ventanaModificar.setVisible(true);
                menuProductos.this.dispose();
            }
        });
        btnModificarProductos.setBounds(84, 138, 125, 31);
        getContentPane().add(btnModificarProductos);
                
        // Boton para Eliminar Productos
        JButton btnEliminarProductos = new JButton("Eliminar");
        btnEliminarProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProductos ventanaEliminar = new eliminarProductos(menuProductos.this);
                ventanaEliminar.setVisible(true);
                menuProductos.this.dispose();
            }
        });
        btnEliminarProductos.setBounds(84, 188, 125, 31);
        getContentPane().add(btnEliminarProductos);
        
        // Boton para Listar Productos
        JButton btnListarProductos = new JButton("Listar");
        btnListarProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProductos ventanaListar = new listarProductos(menuProductos.this);
                ventanaListar.setVisible(true);
                menuProductos.this.dispose();
            }
        });
        btnListarProductos.setBounds(84, 238, 125, 31);
        getContentPane().add(btnListarProductos);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setForeground(new Color(210, 210, 210));
        separator.setBounds(101, 49, 90, 2);
        getContentPane().add(separator);
        
        JLabel lblProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        lblProductos.setForeground(new Color(210, 210, 210));
        lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProductos.setBackground(Color.WHITE);
        lblProductos.setBounds(96, 43, 100, 40);
        getContentPane().add(lblProductos);
        
        JButton btnBack = new JButton("\u2190");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.setVisible(true); // Show the main menu
                menuProductos.this.dispose(); // Close the current window
            }
        });
        btnBack.setBounds(121, 291, 50, 15);
        getContentPane().add(btnBack);

        // Make the frame visible
        setVisible(true); // Show the current window
    }
}
