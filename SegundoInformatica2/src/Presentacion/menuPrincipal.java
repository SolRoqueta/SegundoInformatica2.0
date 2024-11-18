package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

    private int limiteVentana = 0;
    
    private panelProductos ventanaProductos;
    private panelUsuarios ventanaUsuarios;
    private panelMenus ventanaMenus;
    
    public menuPrincipal() {
    	menuPresentacion();
    }
    
    public void menuPresentacion() {
    	
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

        // Botones
        
        JButton btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUsuarios.setBounds(304, 302, 175, 50);
        getContentPane().add(btnUsuarios);      

        JButton btnProductos = new JButton("Productos");
        btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnProductos.setBounds(304, 202, 175, 50);
        getContentPane().add(btnProductos);
        
        JButton btnMenus = new JButton("Menus");
        btnMenus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMenus.setBounds(304, 402, 175, 50);
        getContentPane().add(btnMenus);
        
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCerrarSesion.setBounds(304, 502, 175, 50);
        getContentPane().add(btnCerrarSesion);
        
        btnUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaUsuarios = new panelUsuarios();
                ventanaUsuarios.setVisible(true); // Abre la nueva ventana
                menuPrincipal.this.dispose(); // Cierra la ventana actual
            }
        });
        
        btnProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaProductos = new panelProductos();
                ventanaProductos.setVisible(true); // Abre la nueva ventana
                menuPrincipal.this.dispose(); // Cierra la ventana actual
            }
        });
        
        btnMenus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMenus = new panelMenus();
                ventanaMenus.setVisible(true); // Abre la nueva ventana
                menuPrincipal.this.dispose(); // Cierra la ventana actual
            }
        });
        
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	login Login = new login();
            	Login.setVisible(true); // Abre la nueva ventana
            	menuPrincipal.this.dispose(); // Cierra la ventana actual
            }
        });

     
    }

}
