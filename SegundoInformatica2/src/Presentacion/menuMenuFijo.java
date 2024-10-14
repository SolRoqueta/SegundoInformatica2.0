package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuMenuFijo extends JFrame {
	public menuMenuFijo() {

        // Create the frame
        JFrame frame = new JFrame("Menu Usuarios");
        frame.getContentPane().setBackground(new Color(43, 70, 77));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(309, 368);
        frame.getContentPane().setLayout(null);
        
                // Welcome Label
                JLabel labelTitulo = new JLabel("MENU", SwingConstants.CENTER);
                labelTitulo.setBackground(Color.WHITE);
                labelTitulo.setBounds(96, 11, 100, 40);
                frame.getContentPane().add(labelTitulo);
                labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
                labelTitulo.setBackground(Color.GRAY);
                labelTitulo.setForeground(new Color(255, 255, 255));
                
                        // Boton para Agregar Usuarios
                        JButton btnAgregarUsuarios= new JButton("Agregar");
                        btnAgregarUsuarios.setBounds(84, 86, 125, 31);
                        frame.getContentPane().add(btnAgregarUsuarios);
                        btnAgregarUsuarios.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                    		
                    		agregarUsuarios ventanaAgregar = new agregarUsuarios();
                    		ventanaAgregar.setVisible(true);

                    	}
                    });
                        
                        // Boton para Eliminar Usuarios
                        JButton btnEliminarUsuarios = new JButton("Eliminar");
                        btnEliminarUsuarios.setBounds(84, 186, 125, 31);
                        frame.getContentPane().add(btnEliminarUsuarios);
                        btnEliminarUsuarios.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                        		
                        		eliminarUsuarios ventanaEliminar = new eliminarUsuarios();
                        		ventanaEliminar.setVisible(true);

                        	}
                        });
                        
                        // Boton para Modificar Usuarios
                        JButton btnModificarUsuarios = new JButton("Modificar");
                        btnModificarUsuarios.setBounds(84, 136, 125, 31);
                        frame.getContentPane().add(btnModificarUsuarios);
                                
                        // Boton para Listar Usuarios
                        JButton btnListarUsuarios = new JButton("Listar");
                        btnListarUsuarios.setBounds(84, 236, 125, 31);
                        frame.getContentPane().add(btnListarUsuarios);
                        
                        JSeparator separator = new JSeparator();
                        separator.setBounds(106, 45, 80, 2);
                        frame.getContentPane().add(separator);
                        
                        JLabel lblUsuarios = new JLabel("MENUS FIJOS", SwingConstants.CENTER);
                        lblUsuarios.setForeground(Color.WHITE);
                        lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
                        lblUsuarios.setBackground(Color.WHITE);
                        lblUsuarios.setBounds(96, 40, 100, 40);
                        frame.getContentPane().add(lblUsuarios);
                        
                        JButton btnListarUsuarios_1 = new JButton("←");
                        btnListarUsuarios_1.setBounds(121, 292, 50, 15);
                        frame.getContentPane().add(btnListarUsuarios_1);

        // Make the frame visible
        frame.setVisible(true);
        
	}
}
