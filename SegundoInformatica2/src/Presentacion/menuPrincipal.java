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

    public menuPrincipal() {
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
        welcomeLabel.setForeground(new Color(255, 255, 255));

        // Button for Menu Usuarios
        JButton usuariosButton = new JButton("Menu Usuarios");
        usuariosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuUsuarios window
                ventanaUsuarios = new menuUsuarios(menuPrincipal.this);
                ventanaUsuarios.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        usuariosButton.setBounds(80, 155, 133, 31);
        getContentPane().add(usuariosButton);      

        // Button for Menu Productos
        JButton productosButton = new JButton("Menu Productos");
        productosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuProductos window
                ventanaProductos = new menuProductos(menuPrincipal.this);
                ventanaProductos.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        productosButton.setBounds(80, 203, 133, 31);
        getContentPane().add(productosButton);

        // Button for Menu M Fijos
        JButton usuariosButton_1_1 = new JButton("Menu M Fijos");
        usuariosButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuFijo window
                menuMenuFijo ventanaMenuFijo = new menuMenuFijo(menuPrincipal.this);
                ventanaMenuFijo.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        usuariosButton_1_1.setBounds(80, 251, 133, 31);
        getContentPane().add(usuariosButton_1_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(106, 49, 80, 2);
        getContentPane().add(separator);

        JLabel lblPrincipal = new JLabel("PRINCIPAL", SwingConstants.CENTER);
        lblPrincipal.setForeground(Color.WHITE);
        lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrincipal.setBackground(Color.WHITE);
        lblPrincipal.setBounds(101, 52, 90, 20);
        getContentPane().add(lblPrincipal);

        // Button for Menu M Diarios
        JButton btnMenuMDiarios = new JButton("Menu M Diarios");
        btnMenuMDiarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MenuDiarios window
                ventanaMenuDiario = new menuMenuDiario(menuPrincipal.this); // Pass reference to menuPrincipal
                ventanaMenuDiario.setVisible(true);
                menuPrincipal.this.dispose(); // Close the main window
            }
        });
        btnMenuMDiarios.setBounds(80, 102, 133, 31);
        getContentPane().add(btnMenuMDiarios);
    }

    public static void main(String[] args) {
        // Show the main window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }
}
