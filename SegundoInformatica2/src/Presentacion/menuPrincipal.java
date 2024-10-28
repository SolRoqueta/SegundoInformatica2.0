package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {

    private int limiteVentana = 0;
    
    private menuProductos ventanaProductos;
    private menuUsuarios ventanaUsuarios;
    private menuMenuDiario ventanaMenuDiario;

    private login Login;
    
    public menuPrincipal(login Login) {
    	
    	this.Login = Login;
    	
        setTitle("Menu Principal");
        setSize(309, 368);
        getContentPane().setBackground(new Color(43, 70, 77));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("MENU", SwingConstants.CENTER);
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setBounds(91, 11, 110, 40);
        getContentPane().add(welcomeLabel);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        welcomeLabel.setBackground(Color.GRAY);
        welcomeLabel.setForeground(new Color(210, 210, 210));

        // Button for Menu Usuarios
        JButton usuariosButton = new JButton("Usuarios");
        usuariosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuUsuarios window
                ventanaUsuarios = new menuUsuarios(menuPrincipal.this);
                ventanaUsuarios.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        usuariosButton.setBounds(80, 151, 133, 31);
        getContentPane().add(usuariosButton);      

        // Button for Menu Productos
        JButton productosButton = new JButton("Productos");
        productosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuProductos window
                ventanaProductos = new menuProductos(menuPrincipal.this);
                ventanaProductos.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        productosButton.setBounds(80, 101, 133, 31);
        getContentPane().add(productosButton);
        
        // Button for Menu M Diarios
        JButton btnMenus = new JButton("Menus");
        btnMenus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuDiarios window
                ventanaMenuDiario = new menuMenuDiario(menuPrincipal.this); // Pass reference to menuPrincipal
                ventanaMenuDiario.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        btnMenus.setBounds(80, 201, 133, 31);
        getContentPane().add(btnMenus);
        
        // Boton para cerrar sesion
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuDiarios window
            	
            	JOptionPane.showMessageDialog(null, "Sesion cerrada con exito");
            	Login.setVisible(true);
            	menuPrincipal.this.dispose();
            }
        });
        btnCerrarSesion.setBounds(80, 251, 133, 31);
        getContentPane().add(btnCerrarSesion);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(106, 49, 80, 2);
        getContentPane().add(separator);

        JLabel lblPrincipal = new JLabel("PRINCIPAL", SwingConstants.CENTER);
        lblPrincipal.setForeground(new Color(210, 210, 210));
        lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrincipal.setBackground(Color.WHITE);
        lblPrincipal.setBounds(101, 52, 90, 20);
        getContentPane().add(lblPrincipal);

     
    }

}
