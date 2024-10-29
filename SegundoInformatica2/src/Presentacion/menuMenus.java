package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuMenus extends JFrame {

    private menuPrincipal MenuPrincipal; // Reference to the main menu

    public menuMenus(menuPrincipal MenuPrincipal) {
        this.MenuPrincipal = MenuPrincipal; // Set the reference to the main menu

        setTitle("Menu Menus Diarios");
        getContentPane().setBackground(new Color(43, 70, 77));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(309, 368);
        getContentPane().setLayout(null);
        
        // Welcome Label
        JLabel labelTitulo = new JLabel("MENU", SwingConstants.CENTER);
        labelTitulo.setBackground(Color.WHITE);
        labelTitulo.setBounds(96, 11, 100, 40);
        getContentPane().add(labelTitulo);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        labelTitulo.setBackground(Color.GRAY);
        labelTitulo.setForeground(new Color(210, 210, 210));
        
        // Boton para Agregar Usuarios
        JButton btnAgregarUsuarios = new JButton("Agregar");
        btnAgregarUsuarios.setBounds(84, 98, 125, 31);
        getContentPane().add(btnAgregarUsuarios);
        btnAgregarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	agregarMenus ventanaAgregar = new agregarMenus(menuMenus.this);
            	ventanaAgregar.setVisible(true);
            	menuMenus.this.dispose();
            }
        });
        
        // Boton para Eliminar Usuarios
        JButton btnEliminarUsuarios = new JButton("Eliminar");
        btnEliminarUsuarios.setBounds(84, 223, 125, 31);
        getContentPane().add(btnEliminarUsuarios);
        btnEliminarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	eliminarMenus ventanaEliminar = new eliminarMenus(menuMenus.this);
            	ventanaEliminar.setVisible(true);
            	menuMenus.this.dispose();
            }
        });
        
        // Boton para Modificar Usuarios
        JButton btnModificarUsuarios = new JButton("Modificar");
        btnModificarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	modificarMenus ventanaModificar = new modificarMenus(menuMenus.this);
            	ventanaModificar.setVisible(true);
            	menuMenus.this.dispose();
            }
        });
        btnModificarUsuarios.setBounds(84, 159, 125, 31);
        getContentPane().add(btnModificarUsuarios);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setForeground(new Color(210, 210, 210));
        separator.setBounds(106, 49, 80, 2);
        getContentPane().add(separator);
        
        JLabel lblUsuarios = new JLabel("MENUS DIARIOS", SwingConstants.CENTER);
        lblUsuarios.setForeground(new Color(210, 210, 210));
        lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuarios.setBackground(Color.WHITE);
        lblUsuarios.setBounds(90, 43, 113, 40);
        getContentPane().add(lblUsuarios);
        
        JButton btnBack = new JButton("←");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.setVisible(true); // Show the main menu
                menuMenus.this.dispose(); // Close the current window
            }
        });
        btnBack.setBounds(121, 287, 50, 15);
        getContentPane().add(btnBack);

        // Make the frame visible
        setVisible(true); // Show the current window
    }
}
