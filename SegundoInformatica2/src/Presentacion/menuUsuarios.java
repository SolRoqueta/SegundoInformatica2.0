package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuUsuarios extends JFrame {
	
	private menuPrincipal MenuPrincipal;
	
	public menuUsuarios(menuPrincipal MenuPrincipal) {
		// Store the reference to the previous menu
		this.MenuPrincipal = MenuPrincipal;

        // Frame setup
        this.getContentPane().setBackground(new Color(43, 70, 77));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(309, 368);
        this.getContentPane().setLayout(null);
        
        // Welcome Label
        JLabel labelTitulo = new JLabel("MENU", SwingConstants.CENTER);
        labelTitulo.setBackground(Color.WHITE);
        labelTitulo.setBounds(96, 11, 100, 40);
        this.getContentPane().add(labelTitulo);
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        labelTitulo.setBackground(Color.GRAY);
        labelTitulo.setForeground(new Color(210, 210, 210));
        
        // Button to Add Users
        JButton btnAgregarUsuarios= new JButton("Agregar");
        btnAgregarUsuarios.setBounds(84, 88, 125, 31);
        this.getContentPane().add(btnAgregarUsuarios);
        btnAgregarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		agregarUsuarios ventanaAgregar = new agregarUsuarios(menuUsuarios.this);
        		ventanaAgregar.setVisible(true);
        		menuUsuarios.this.dispose();
        	}
        });
        
        // Button to Delete Users
        JButton btnEliminarUsuarios = new JButton("Eliminar");
        btnEliminarUsuarios.setBounds(84, 188, 125, 31);
        this.getContentPane().add(btnEliminarUsuarios);
        btnEliminarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		eliminarUsuarios ventanaEliminar = new eliminarUsuarios(menuUsuarios.this);
        		ventanaEliminar.setVisible(true);
        		menuUsuarios.this.dispose();
        	}
        });
        
        // Button to Modify Users
        JButton btnModificarUsuarios = new JButton("Modificar");
        btnModificarUsuarios.setBounds(84, 138, 125, 31);
        this.getContentPane().add(btnModificarUsuarios);
        btnModificarUsuarios.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		modificarUsuarios ventanaModificar = new modificarUsuarios(menuUsuarios.this);
    		ventanaModificar.setVisible(true);
    		menuUsuarios.this.dispose();
    	}
    });
        
        // Separator
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(106, 49, 80, 2);
        this.getContentPane().add(separator);
        
        JLabel lblUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
        lblUsuarios.setForeground(new Color(210, 210, 210));
        lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuarios.setBackground(Color.WHITE);
        lblUsuarios.setBounds(96, 43, 100, 40);
        this.getContentPane().add(lblUsuarios);
        
        // Back Button (Back to Main Menu)
        JButton btnBack = new JButton("←");
        btnBack.setBounds(121, 291, 50, 15);
        this.getContentPane().add(btnBack);
        
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuPrincipal.setVisible(true); // Show the main menu
        		menuUsuarios.this.dispose();    // Close the current window
        	}
        });

        // Make the frame visible
        this.setVisible(true);
	}
}

