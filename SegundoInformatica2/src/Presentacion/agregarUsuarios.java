package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.productos;
import Logica.usuarios;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarUsuarios extends JFrame {
	
	public usuarios usuario = new usuarios();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private String contra;
	private String tipoUsuario;
	private String mail;
    
    public agregarUsuarios() {
    	
        // Configurar la ventana
        setTitle("Agregar Usuarios");
        setSize(388, 429);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("AGREGAR USUARIOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titulo.setBounds(0, 0, 372, 64);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(24, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(24, 105, 150, 25);
        panel.add(nombreField);
        
        JLabel contraLabel = new JLabel("Contraseña");
        contraLabel.setBounds(24, 132, 84, 25);
        panel.add(contraLabel);
        
        JPasswordField contraField = new JPasswordField();
        contraField.setBounds(24, 155, 150, 25);
        panel.add(contraField);
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo Usuario");
        tipoUsuarioLabel.setBounds(24, 229, 100, 25);
        panel.add(tipoUsuarioLabel);
        
        String[] tipoUsu = {"Padre", "Profesor"};
        
        JComboBox<String> tipoUsuarioCbbx = new JComboBox<>(tipoUsu);
        tipoUsuarioCbbx.setBounds(24, 251, 150, 25);
        panel.add(tipoUsuarioCbbx);
        
        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setBounds(24, 178, 100, 25);
        panel.add(mailLabel);
        
        JTextField mailField = new JTextField();
        mailField.setBounds(24, 200, 150, 25);
        panel.add(mailField);
        
        JButton agregarUsuarioBtn = new JButton("Agregar Usuario");
        agregarUsuarioBtn.setBounds(115, 322, 150, 30);
        panel.add(agregarUsuarioBtn);
       
       // Accion para boton AgregarProducto
        agregarUsuarioBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Gets de todos los atributos del producto a crear
        		nombre = nombreField.getText();
        		contra = new String (contraField.getPassword());
        		tipoUsuario = tipoUsuarioCbbx.getSelectedItem().toString();
        		mail = mailField.getText();
        		
        		// Verifica si los atributos son nulos, si son nulos muestra un error, si no, crea el nuevo producto
        		if (nombre.equals("") || contra.equals("") || tipoUsuario.equals("") || mail.equals("")) {
        			
        			JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
        			
        		} else {
        			
//        			usuarios tempUsuario = new usuarios();
//        			String tempNombre = tempUsuario.BuscarUsuario(nombre).getNombre();
//        			
//        			if (tempNombre == null) {
//        				
//        				usuario.setNombre(nombre);
//                		usuario.setCont(contra);
//                		usuario.setMail(mail);
//                		usuario.setTipoUsuario(tipoUsuario);
//                		
//                		usuario.AgregarUsuario();
//                		JOptionPane.showMessageDialog(null, "Usuario agregado con exito!");
//        				
//        			} else {
//        				
//        				JOptionPane.showMessageDialog(null, "Error, el usuario ya existe");
//        				
//        			}	
//        		
        	}
        	}
        	
        });
        			
      
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        }
        
    }
    
        
