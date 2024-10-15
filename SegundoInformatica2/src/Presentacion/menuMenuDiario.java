package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuMenuDiario extends JFrame {

    private menuPrincipal MenuPrincipal; // Reference to the main menu

    public menuMenuDiario(menuPrincipal MenuPrincipal) {
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
        labelTitulo.setForeground(new Color(255, 255, 255));
        
        // Boton para Agregar Usuarios
        JButton btnAgregarUsuarios = new JButton("Agregar");
        btnAgregarUsuarios.setBounds(84, 86, 125, 31);
        getContentPane().add(btnAgregarUsuarios);
        btnAgregarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        // Boton para Eliminar Usuarios
        JButton btnEliminarUsuarios = new JButton("Eliminar");
        btnEliminarUsuarios.setBounds(84, 186, 125, 31);
        getContentPane().add(btnEliminarUsuarios);
        btnEliminarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        // Boton para Modificar Usuarios
        JButton btnModificarUsuarios = new JButton("Modificar");
        btnModificarUsuarios.setBounds(84, 136, 125, 31);
        getContentPane().add(btnModificarUsuarios);
        
        // Boton para Listar Usuarios
        JButton btnListarUsuarios = new JButton("Listar");
        btnListarUsuarios.setBounds(84, 236, 125, 31);
        getContentPane().add(btnListarUsuarios);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(106, 45, 80, 2);
        getContentPane().add(separator);
        
        JLabel lblUsuarios = new JLabel("MENUS DIARIOS", SwingConstants.CENTER);
        lblUsuarios.setForeground(Color.WHITE);
        lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuarios.setBackground(Color.WHITE);
        lblUsuarios.setBounds(90, 40, 113, 40);
        getContentPane().add(lblUsuarios);
        
        JButton btnBack = new JButton("←");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal.setVisible(true); // Show the main menu
                menuMenuDiario.this.dispose(); // Close the current window
            }
        });
        btnBack.setBounds(121, 292, 50, 15);
        getContentPane().add(btnBack);

        // Make the frame visible
        setVisible(true); // Show the current window
    }
}
