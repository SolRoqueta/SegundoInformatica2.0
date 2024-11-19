package Presentacion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {

	private String nombre;
	private String contra;
	
	public login() {
		loginPresentacion();
	}
	
    public void loginPresentacion() {
       
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);  // Layout absoluto para ubicar los componentes manualmente

        // Panel derecho para el formulario de login
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(43, 70, 77));
        rightPanel.setBounds(390, 0, 400, 661);
        getContentPane().add(rightPanel);

        // Etiqueta "Nombre"
        JLabel nameLabel = new JLabel("Nombre");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setForeground(new Color(240, 240, 240));
        nameLabel.setForeground(new Color(240, 240, 240));
        nameLabel.setBounds(100, 213, 100, 20);
        rightPanel.add(nameLabel);
                                                        
        // Campo de texto para el nombre
        JTextField nameField = new JTextField();
        nameField.setBounds(100, 244, 200, 30);
        rightPanel.add(nameField);
        
        // Campo de texto para la contraseña
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 359, 200, 30);
        rightPanel.add(passwordField);

        // Etiqueta "Contraseña"
        JLabel passwordLabel = new JLabel("Contraseña");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(240, 240, 240));
        passwordLabel.setBounds(100, 328, 100, 20);
        rightPanel.add(passwordLabel);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginButton.setBounds(100, 548, 200, 40);
        rightPanel.add(loginButton);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setForeground(new Color(210, 210, 210));
        separator.setBounds(137, 76, 125, 2);
        rightPanel.add(separator);
        
        // Etiqueta "Login"
        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setBounds(127, 39, 146, 30);
        rightPanel.add(loginLabel);
        loginLabel.setForeground(new Color(210, 210, 210));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        
        JLabel lblBienvenidoa = new JLabel("BIENVENIDO/A");
        lblBienvenidoa.setBounds(93, 79, 213, 30);
        rightPanel.add(lblBienvenidoa);
        lblBienvenidoa.setBackground(new Color(210, 210, 210));
        lblBienvenidoa.setForeground(new Color(210, 210, 210));
        lblBienvenidoa.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenidoa.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setForeground(new Color(53, 88, 96));
        separator_1_1_1.setBackground(new Color(53, 88, 96));
        separator_1_1_1.setBounds(0, 139, 400, 2);
        rightPanel.add(separator_1_1_1);
        
        JPanel rightPanel_1_1 = new JPanel();
        rightPanel_1_1.setLayout(null);
        rightPanel_1_1.setBackground(new Color(53, 88, 96));
        rightPanel_1_1.setBounds(0, 0, 400, 661);
        getContentPane().add(rightPanel_1_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(138, 419, 190, 190);
        rightPanel_1_1.add(lblNewLabel);
        
        JLabel lblLaCantina = new JLabel("LA CANTINA");
        lblLaCantina.setHorizontalAlignment(SwingConstants.CENTER);
        lblLaCantina.setForeground(new Color(210, 210, 210));
        lblLaCantina.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblLaCantina.setBounds(79, 39, 249, 30);
        rightPanel_1_1.add(lblLaCantina);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(new Color(210, 210, 210));
        separator_1.setBackground(new Color(210, 210, 210));
        separator_1.setBounds(100, 76, 200, 2);
        rightPanel_1_1.add(separator_1);
        
        JLabel lblLaCantina_1 = new JLabel("DE DANIELA");
        lblLaCantina_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblLaCantina_1.setForeground(new Color(210, 210, 210));
        lblLaCantina_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblLaCantina_1.setBounds(110, 79, 182, 30);
        rightPanel_1_1.add(lblLaCantina_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(new Color(43, 70, 77));
        separator_1_1.setBackground(new Color(43, 70, 77));
        separator_1_1.setBounds(0, 139, 400, 2);
        rightPanel_1_1.add(separator_1_1);
        
        // Action Listeners
        
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		nombre = nameField.getText();
        		contra = new String (passwordField.getPassword());
        		
        		if (nombre.equals("admin") && contra.equals("admin")) {
        			
        			menuPrincipal ventanaPrincipal = new menuPrincipal();
        			
        			JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso! Bienvenido, " + nombre);
        			nameField.setText(null);
        			passwordField.setText(null);
        			
        			ventanaPrincipal.setVisible(true);
        			login.this.dispose();
        			
        		} else if (!nombre.equals("admin")) {
        			JOptionPane.showMessageDialog(null, "Nombre de Usuario Incorrecto");
        		} else if (!contra.equals("admin")) {
        			JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
        		}
        		
        	}
        });
        
        // Key Listeners
        
        nameField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		
        		if (( nameField.getText().length() >= 30 )) {
        			
        			e.consume();
        			
        		}
        		
        	}
        });
        
        passwordField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent evt) {
        		
        		String password = new String (passwordField.getPassword());
        		
        		if (( password.length() >= 30 )) {
        			
        			evt.consume();
        			
        		}
        		
        	}
        });
                                                             
    }
    
    public static void main(String[] args) {
        // Show the main window
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
}
