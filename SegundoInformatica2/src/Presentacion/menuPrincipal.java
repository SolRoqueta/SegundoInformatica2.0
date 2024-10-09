package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame{
	
	private int limiteVentana = 0;
	
	private menuProductos ventanaProductos;
    private menuUsuarios  ventanaUsuarios;
    private menuReservas ventanaReservas;
	
	public menuPrincipal() {
  
		setTitle("Menu Principal");
		setSize(309, 368);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
        
                // Welcome Label
                JLabel welcomeLabel = new JLabel("MENU PRICIPAL", SwingConstants.CENTER);
                welcomeLabel.setBackground(Color.WHITE);
                welcomeLabel.setBounds(-1, -1, 295, 64);
                getContentPane().add(welcomeLabel);
                welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                welcomeLabel.setBackground(Color.GRAY);
                welcomeLabel.setOpaque(true);
                welcomeLabel.setForeground(new Color(255, 255, 255));
                
               
                // Button for Menu Reservas
                JButton reservasButton = new JButton("Menu Reservas");
                reservasButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	ventanaReservas = new menuReservas(); 
                    }
                });
                    
                reservasButton.setBounds(78, 100, 133, 31);
                getContentPane().add(reservasButton);
                        
                // Button for Menu Usuarios
                JButton usuariosButton = new JButton("Menu Usuarios");
                usuariosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
            		
            		menuUsuarios MenuUsuarios = new menuUsuarios();
            		
            	}
            });
            usuariosButton.setBounds(78, 170, 133, 31);
            getContentPane().add(usuariosButton);      
                
                        // Button for Menu Productos
                        JButton productosButton = new JButton("Menu Productos");
                        productosButton.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		menuProductos MenuProductos = new menuProductos();
                        		
                        	}
                        });
                        productosButton.setBounds(78, 240, 133, 31);
                        getContentPane().add(productosButton);
                        
	}
	
                        public static void main(String[] args) {
                        	// Show the main window
                        	menuPrincipal MenuPrincipal = new menuPrincipal();
                        	MenuPrincipal.setVisible(true);
                        
    }
	
}

