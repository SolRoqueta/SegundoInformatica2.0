package Presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login extends JFrame {

    public login() {
        // Configuración básica de la ventana
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(589, 424);
        getContentPane().setLayout(null);  // Layout absoluto para ubicar los componentes manualmente

        // Panel derecho para el formulario de login
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(43, 70, 77));
        rightPanel.setBounds(251, 0, 322, 391);
        getContentPane().add(rightPanel);
                                                
                                                        // Etiqueta "Nombre"
                                                        JLabel nameLabel = new JLabel("Nombre");
                                                        nameLabel.setForeground(new Color(240, 240, 240));
                                                        nameLabel.setBounds(86, 123, 100, 20);
                                                        rightPanel.add(nameLabel);
                                                        
                                                                // Campo de texto para el nombre
                                                                JTextField nameField = new JTextField();
                                                                nameField.setBounds(86, 149, 150, 20);
                                                                rightPanel.add(nameField);
                                                                
                                                                        // Etiqueta "Login"
                                                                        JLabel loginLabel = new JLabel("LOGIN");
                                                                        loginLabel.setForeground(new Color(210, 210, 210));
                                                                        loginLabel.setBounds(119, 32, 83, 30);
                                                                        rightPanel.add(loginLabel);
                                                                        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                                                        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
                                                                        
                                                                                // Campo de texto para la contraseña
                                                                                JPasswordField passwordField = new JPasswordField();
                                                                                passwordField.setBounds(86, 229, 150, 20);
                                                                                rightPanel.add(passwordField);
                                                                                
                                                                                        // Etiqueta "Contraseña"
                                                                                        JLabel passwordLabel = new JLabel("Contraseña");
                                                                                        passwordLabel.setForeground(new Color(240, 240, 240));
                                                                                        passwordLabel.setBounds(86, 209, 100, 20);
                                                                                        rightPanel.add(passwordLabel);
                                                                                        
                                                                                        JButton loginButton = new JButton("Login");
                                                                                        loginButton.setBounds(111, 302, 100, 30);
                                                                                        rightPanel.add(loginButton);
                                                                                        
                                                                                        JSeparator separator = new JSeparator();
                                                                                        separator.setBackground(new Color(210, 210, 210));
                                                                                        separator.setForeground(new Color(210, 210, 210));
                                                                                        separator.setBounds(111, 62, 100, 2);
                                                                                        rightPanel.add(separator);
                                                                                        
                                                                                        JLabel lblBienvenidoa = new JLabel("BIENVENIDO/A");
                                                                                        lblBienvenidoa.setBackground(new Color(210, 210, 210));
                                                                                        lblBienvenidoa.setForeground(new Color(210, 210, 210));
                                                                                        lblBienvenidoa.setHorizontalAlignment(SwingConstants.CENTER);
                                                                                        lblBienvenidoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
                                                                                        lblBienvenidoa.setBounds(96, 62, 130, 30);
                                                                                        rightPanel.add(lblBienvenidoa);
                                                                                        
                                                                                        JPanel rightPanel_1_1 = new JPanel();
                                                                                        rightPanel_1_1.setLayout(null);
                                                                                        rightPanel_1_1.setBackground(new Color(53, 88, 96));
                                                                                        rightPanel_1_1.setBounds(0, 0, 263, 391);
                                                                                        getContentPane().add(rightPanel_1_1);
                                                                                        loginButton.addActionListener(new ActionListener() {
                                                                                        	public void actionPerformed(ActionEvent e) {
                                                                                        	}
                                                                                        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}
