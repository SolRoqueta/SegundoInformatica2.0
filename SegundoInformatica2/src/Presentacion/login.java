package Presentacion;

import java.awt.*;
import javax.swing.border.Border;
import javax.swing.*;


public class login extends JFrame {

    public login() {
        // Configuración básica de la ventana
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        getContentPane().setLayout(null);  // Layout absoluto para ubicar los componentes manualmente

        // Panel derecho para el formulario de login
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(33, 53, 72));
        rightPanel.setBounds(-15, -16, 632, 391);  // Tamaño y posición del panel derecho

        // Panel interno del formulario
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(191, 190, 190));
        loginPanel.setBounds(293, 13, 326, 381);  // Ubicación del panel de login en el panel derecho
        rightPanel.add(loginPanel);

        // Etiqueta "Login"
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        loginLabel.setBounds(113, 65, 83, 30);  // Posición de la etiqueta "Login"
        loginPanel.add(loginLabel);

        // Etiqueta "Nombre"
        JLabel nameLabel = new JLabel("Nombre");
        nameLabel.setBounds(82, 112, 100, 20);  // Posición de la etiqueta "Nombre"
        loginPanel.add(nameLabel);

        // Campo de texto para el nombre
        JTextField nameField = new JTextField();
        nameField.setBounds(82, 132, 150, 20);  // Posición del campo de texto para el nombre
        loginPanel.add(nameField);

        // Etiqueta "Contraseña"
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(82, 177, 100, 20);  // Posición de la etiqueta "Contraseña"
        loginPanel.add(passwordLabel);

        // Campo de texto para la contraseña
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(82, 196, 150, 20);  // Posición del campo de texto para la contraseña
        loginPanel.add(passwordField);
        
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setForeground(SystemColor.control);
        backgroundPanel.setBounds(59, 48, 195, 269);
        loginPanel.add(backgroundPanel);
        backgroundPanel.setLayout(null);
        backgroundPanel.setBackground(new Color(220, 220, 220));
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(47, 197, 100, 30);
        backgroundPanel.add(loginButton);
        getContentPane().add(rightPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}
