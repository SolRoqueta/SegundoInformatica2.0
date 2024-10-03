package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Menu Principal");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(309, 368);
        frame.getContentPane().setLayout(null);
        
                // Welcome Label
                JLabel welcomeLabel = new JLabel("MENU PRICIPAL", SwingConstants.CENTER);
                welcomeLabel.setBackground(Color.WHITE);
                welcomeLabel.setBounds(-1, -1, 295, 64);
                frame.getContentPane().add(welcomeLabel);
                welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                welcomeLabel.setBackground(Color.GRAY);
                welcomeLabel.setOpaque(true);
                welcomeLabel.setForeground(new Color(255, 255, 255));
                
                        // Button for Menu Productos
                        JButton productosButton = new JButton("Menu Productos");
                        productosButton.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        productosButton.setBounds(85, 240, 122, 31);
                        frame.getContentPane().add(productosButton);
                        
                                // Button for Menu Reservas
                                JButton reservasButton = new JButton("Menu Reservas");
                                reservasButton.setBounds(85, 173, 122, 31);
                                frame.getContentPane().add(reservasButton);
                                
                                        // Button for Menu Usuarios
                                        JButton usuariosButton = new JButton("Menu Usuarios");
                                        usuariosButton.setBounds(85, 105, 122, 31);
                                        frame.getContentPane().add(usuariosButton);

        // Make the frame visible
        frame.setVisible(true);
    }
}
