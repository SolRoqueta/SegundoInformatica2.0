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
    
    private menuUsuarios MenuUsuarios;
    
    // Declaración de atributos de Usuarios
    private String nombre;
    private String contra;
    private String tipoUsuario;
    private String mail;
    
    private String[] tipoUsu = {"Padre", "Profesor"};
    
    public agregarUsuarios(menuUsuarios MenuUsuarios) {
        
        // Configurar la ventana
        setTitle("Agregar Usuarios");
        setSize(326, 463);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Etiqueta de título
        JLabel titulo = new JLabel("AGREGAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(99, 0, 111, 64);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(105, 51, 100, 2);
        panel.add(separator);
        
        JLabel tituloUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
        tituloUsuarios.setForeground(new Color(210, 210, 210));
        tituloUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloUsuarios.setBounds(99, 55, 111, 20);
        panel.add(tituloUsuarios);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(80, 97, 53, 25);
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
        nombreField.setBounds(80, 123, 150, 25);
        panel.add(nombreField);
        
        JLabel contraLabel = new JLabel("Contraseña");
        contraLabel.setForeground(new Color(230, 230, 230));
        contraLabel.setBounds(80, 152, 84, 25);
        panel.add(contraLabel);
        
        JPasswordField contraField = new JPasswordField();
        contraField.setBounds(80, 173, 150, 25);
        panel.add(contraField);
        
        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setForeground(new Color(230, 230, 230));
        mailLabel.setBounds(80, 203, 100, 25);
        panel.add(mailLabel);
        
        JTextField mailField = new JTextField();
        mailField.setBounds(80, 225, 150, 25);
        panel.add(mailField);
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo Usuario");
        tipoUsuarioLabel.setForeground(new Color(230, 230, 230));
        tipoUsuarioLabel.setBounds(80, 253, 100, 25);
        panel.add(tipoUsuarioLabel);
        
        JComboBox<String> tipoUsuarioCbbx = new JComboBox<>(tipoUsu);
        tipoUsuarioCbbx.setBounds(80, 279, 150, 25);
        panel.add(tipoUsuarioCbbx);
        
        // Botón Agregar Usuario
        JButton agregarUsuarioBtn = new JButton("Agregar Usuario");
        agregarUsuarioBtn.setBounds(80, 338, 150, 30);
        panel.add(agregarUsuarioBtn);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(130, 383, 50, 15);
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
        
        // Volver Atras
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuUsuarios.setVisible(true); // Mostrar el menú principal
                agregarUsuarios.this.dispose(); // Cerrar la ventana actual
            }
        });
   
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
