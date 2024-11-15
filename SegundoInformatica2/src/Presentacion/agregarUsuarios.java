package Presentacion;

import Logica.usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class agregarUsuarios extends JFrame {
    
    public usuarios usuario = new usuarios();
    
    // Declaración de atributos de Usuarios
    private String nombre;
    private String contra;
    private String tipoUsuario;
    private String mail;
    
    private String[] tipoUsu = {"Padre", "Profesor"};
    
    public agregarUsuarios() {
        
        // Configurar la ventana
        setTitle("Agregar Usuarios");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Etiqueta de título
        JLabel titulo = new JLabel("AGREGAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
        titulo.setBounds(304, 21, 176, 59);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(317, 72, 150, 2);
        panel.add(separator);
        
        JLabel tituloUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
        tituloUsuarios.setForeground(new Color(210, 210, 210));
        tituloUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloUsuarios.setBounds(304, 65, 176, 51);
        panel.add(tituloUsuarios);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(292, 164, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		
        		if (( nombreField.getText().length() >= 30 )) {
        			
        			e.consume();

        		}
        		        		
        	}
        });
        nombreField.setBounds(292, 200, 200, 30);
        panel.add(nombreField);
        
        JLabel contraLabel = new JLabel("Contraseña");
        contraLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contraLabel.setForeground(new Color(230, 230, 230));
        contraLabel.setBounds(291, 243, 84, 25);
        panel.add(contraLabel);
        
        JPasswordField contraField = new JPasswordField();
        contraField.setBounds(292, 279, 200, 30);
        panel.add(contraField);
        
        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        mailLabel.setForeground(new Color(230, 230, 230));
        mailLabel.setBounds(292, 323, 100, 25);
        panel.add(mailLabel);
        
        JTextField mailField = new JTextField();
        mailField.setBounds(292, 359, 200, 30);
        panel.add(mailField);
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo Usuario");
        tipoUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tipoUsuarioLabel.setForeground(new Color(230, 230, 230));
        tipoUsuarioLabel.setBounds(292, 411, 100, 25);
        panel.add(tipoUsuarioLabel);
        
        JComboBox<String> tipoUsuarioCbbx = new JComboBox<>(tipoUsu);
        tipoUsuarioCbbx.setBounds(292, 445, 200, 30);
        panel.add(tipoUsuarioCbbx);
        
        // Botón Agregar Usuario
        JButton agregarUsuarioBtn = new JButton("Agregar Usuario");
        agregarUsuarioBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        agregarUsuarioBtn.setBounds(292, 540, 200, 50);
        panel.add(agregarUsuarioBtn);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);
        
        // Acciones Botones
        
        // Agregar Usuario
        agregarUsuarioBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // Gets de todos los atributos del usuario a crear
                nombre = nombreField.getText();
                contra = new String(contraField.getPassword());
                tipoUsuario = tipoUsuarioCbbx.getSelectedItem().toString();
                mail = mailField.getText();
                
                // Verifica si los atributos son nulos
                if (nombre.equals("") || contra.equals("") || tipoUsuario.equals("") || mail.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
                } else {
                	
                	String tempNombre = usuario.BuscarUsuario(nombre).getNombre();
                    
                    if (tempNombre == null) {
                    	
                    	usuario.setNombre(nombre);
                    	usuario.setCont(contra);
                    	usuario.setTipoUsuario(tipoUsuario);
                    	usuario.setMail(mail);
                    	usuario.AgregarUsuario();
                    	
                    	JOptionPane.showMessageDialog(null, "Usuario, " + nombre + " agregado con exito!");
                    	
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, el producto ya existe");
                    } 
                	
                }
                
            }
        });
        
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	panelUsuarios ventanaPanelUsuarios = new panelUsuarios();
            	ventanaPanelUsuarios.setVisible(true);
            	agregarUsuarios.this.dispose();	
            }
        });
   
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
