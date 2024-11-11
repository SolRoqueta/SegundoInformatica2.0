package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

    private int limiteVentana = 0;
    
    private panelProductos ventanaProductos;
    private Usuarios ventanaUsuarios;
    private Menus ventanaMenus;
    
    public menuPrincipal() {
    	
        setTitle("Menu Principal");
        setSize(800, 700);
        getContentPane().setBackground(new Color(43, 70, 77));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Welcome Label
        JLabel menuLabel = new JLabel("MENU", SwingConstants.CENTER);
        menuLabel.setBackground(Color.WHITE);
        menuLabel.setBounds(332, 49, 119, 40);
        getContentPane().add(menuLabel);
        menuLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        menuLabel.setBackground(Color.GRAY);
        menuLabel.setForeground(new Color(210, 210, 210));

        // Button for Menu Usuarios
        JButton btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuUsuarios window
                ventanaUsuarios = new Usuarios(menuPrincipal.this);
                ventanaUsuarios.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        btnUsuarios.setBounds(317, 316, 150, 45);
        getContentPane().add(btnUsuarios);      

        // Button for Menu Productos
        JButton btnProductos = new JButton("Productos");
        btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuProductos window
                ventanaProductos = new panelProductos();
                ventanaProductos.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        btnProductos.setBounds(317, 216, 150, 45);
        getContentPane().add(btnProductos);
        
        // Button for Menu M Diarios
        JButton btnMenus = new JButton("Menus");
        btnMenus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMenus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuDiarios window
                ventanaMenus = new Menus(menuPrincipal.this); // Pass reference to menuPrincipal
                ventanaMenus.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        btnMenus.setBounds(317, 416, 150, 45);
        getContentPane().add(btnMenus);
        
        // Boton para cerrar sesion
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuDiarios window
            	
            	JOptionPane.showMessageDialog(null, "Sesion cerrada con exito");
            	login Login = new login();
            	Login.setVisible(true);
            	menuPrincipal.this.dispose();
            }
        });
        btnCerrarSesion.setBounds(317, 516, 150, 45);
        getContentPane().add(btnCerrarSesion);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(332, 90, 120, 2);
        getContentPane().add(separator);

        JLabel principalLabel = new JLabel("PRINCIPAL", SwingConstants.CENTER);
        principalLabel.setForeground(new Color(210, 210, 210));
        principalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        principalLabel.setBackground(Color.WHITE);
        principalLabel.setBounds(327, 95, 130, 20);
        getContentPane().add(principalLabel);

     
    }

}
