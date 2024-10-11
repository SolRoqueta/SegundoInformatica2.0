package Presentacion;

import javax.swing.*;
import java.awt.*;

public class menuUsuarios extends JFrame {
	public menuUsuarios() {

        // Create the frame
        JFrame frame = new JFrame("Menu Usuarios");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(309, 368);
        frame.getContentPane().setLayout(null);
        
                // Welcome Label
                JLabel labelTitulo = new JLabel("MENU USUARIOS", SwingConstants.CENTER);
                labelTitulo.setBackground(Color.WHITE);
                labelTitulo.setBounds(-1, -1, 295, 64);
                frame.getContentPane().add(labelTitulo);
                labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
                labelTitulo.setBackground(Color.GRAY);
                labelTitulo.setOpaque(true);
                labelTitulo.setForeground(new Color(255, 255, 255));
                
                        // Boton para Agregar Usuarios
                        JButton btnAgregarUsuarios= new JButton("Agregar");
                        btnAgregarUsuarios.setBounds(80, 100, 125, 31);
                        frame.getContentPane().add(btnAgregarUsuarios);
                        
                        // Boton para Modificar Usuarios
                        JButton btnModificarUsuarios = new JButton("Modificar");
                        btnModificarUsuarios.setBounds(80, 150, 125, 31);
                        frame.getContentPane().add(btnModificarUsuarios);
                                
                        // Boton para Eliminar Usuarios
                        JButton btnEliminarUsuarios = new JButton("Eliminar");
                        btnEliminarUsuarios.setBounds(80, 200, 125, 31);
                        frame.getContentPane().add(btnEliminarUsuarios);
                        
                        // Boton para Listar Usuarios
                        JButton btnListarUsuarios = new JButton("Listar");
                        btnListarUsuarios.setBounds(80, 250, 125, 31);
                        frame.getContentPane().add(btnListarUsuarios);

        // Make the frame visible
        frame.setVisible(true);
        
	}
}
