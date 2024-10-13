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
        setSize(326, 429);
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
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(80, 86, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(80, 112, 150, 25);
        panel.add(nombreField);
        
        JLabel contraLabel = new JLabel("Contraseña");
        contraLabel.setForeground(new Color(230, 230, 230));
        contraLabel.setBounds(78, 141, 84, 25);
        panel.add(contraLabel);
        
        JPasswordField contraField = new JPasswordField();
        contraField.setBounds(80, 162, 150, 25);
        panel.add(contraField);
        
        JLabel tipoUsuarioLabel = new JLabel("Tipo Usuario");
        tipoUsuarioLabel.setForeground(new Color(230, 230, 230));
        tipoUsuarioLabel.setBounds(80, 242, 100, 25);
        panel.add(tipoUsuarioLabel);
        
        String[] tipoUsu = {"Padre", "Profesor"};
        
        JComboBox<String> tipoUsuarioCbbx = new JComboBox<>(tipoUsu);
        tipoUsuarioCbbx.setBounds(80, 268, 150, 25);
        panel.add(tipoUsuarioCbbx);
        
        JLabel mailLabel = new JLabel("Mail");
        mailLabel.setForeground(new Color(230, 230, 230));
        mailLabel.setBounds(78, 192, 100, 25);
        panel.add(mailLabel);
        
        JTextField mailField = new JTextField();
        mailField.setBounds(80, 214, 150, 25);
        panel.add(mailField);
        
        JButton agregarUsuarioBtn = new JButton("Agregar Usuario");
        agregarUsuarioBtn.setBounds(80, 323, 150, 30);
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
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(105, 51, 100, 2);
        panel.add(separator);
        
        JLabel lblUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
        lblUsuarios.setForeground(new Color(210, 210, 210));
        lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuarios.setBackground(Color.GRAY);
        lblUsuarios.setBounds(99, 55, 111, 20);
        panel.add(lblUsuarios);
        
        }
        
    }
    
        
