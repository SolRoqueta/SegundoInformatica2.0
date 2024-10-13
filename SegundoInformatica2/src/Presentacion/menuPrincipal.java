package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuPrincipal extends JFrame {
	
	private int limiteVentana = 0;
	
	private menuProductos ventanaProductos;
    private menuUsuarios  ventanaUsuarios;
    private menuMenuDiario ventanaMenuDiario;
    static menuPrincipal MenuPrincipal;

	
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
                
               
                // Button for Menu Reservas
                JButton reservasButton = new JButton("Menu Reservas");
                reservasButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    	ventanaMenuDiario = new menuMenuDiario(); 

                    	ventanaMenuDiario = new menuMenuDiario(); 
                    	MenuPrincipal.setVisible(false);
                    
                reservasButton.setBounds(78, 100, 133, 31);
                getContentPane().add(reservasButton);
                
                    }
                });
                        
                // Button for Menu Usuarios
                JButton usuariosButton = new JButton("Menu Usuarios");
                usuariosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
            		
            		menuUsuarios MenuUsuarios = new menuUsuarios();
            		MenuPrincipal.setVisible(false);
            	}
            });
            usuariosButton.setBounds(80, 141, 133, 31);
            getContentPane().add(usuariosButton);      
                
                        // Button for Menu Productos
                        JButton productosButton = new JButton("Menu Productos");
                        productosButton.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		menuProductos MenuProductos = new menuProductos();
                        		MenuPrincipal.setVisible(false);
                        		
                        	}
                        });
                        productosButton.setBounds(80, 186, 133, 31);
                        getContentPane().add(productosButton);
                        
                        JButton usuariosButton_1 = new JButton("Menu Usuarios");
                        usuariosButton_1.setBounds(80, 97, 133, 31);
                        getContentPane().add(usuariosButton_1);
                        
                        JButton usuariosButton_1_1 = new JButton("Menu Usuarios");
                        usuariosButton_1_1.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        	}
                        });
                        usuariosButton_1_1.setBounds(80, 231, 133, 31);
                        getContentPane().add(usuariosButton_1_1);
                        
                        JSeparator separator = new JSeparator();
                        separator.setBounds(106, 49, 80, 2);
                        getContentPane().add(separator);
                        
                        JLabel lblPrincipal = new JLabel("PRINCIPAL", SwingConstants.CENTER);
                        lblPrincipal.setForeground(Color.WHITE);
                        lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 14));
                        lblPrincipal.setBackground(Color.WHITE);
                        lblPrincipal.setBounds(91, 43, 110, 40);
                        getContentPane().add(lblPrincipal);
                        
                        JButton usuariosButton_1_1_1 = new JButton("←");
                        usuariosButton_1_1_1.setBounds(121, 278, 50, 15);
                        getContentPane().add(usuariosButton_1_1_1);
                        
	}
                        
                        public static void main(String[] args) {
                        	// Show the main window
                        	MenuPrincipal = new menuPrincipal();
                        	MenuPrincipal.setVisible(true);
                        }
}
                        
                

