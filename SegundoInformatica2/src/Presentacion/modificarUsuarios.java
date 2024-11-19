package Presentacion;

import Logica.usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class modificarUsuarios extends JFrame {
    
    public usuarios usuario = new usuarios();
    
    private String nombre;
    private String contra;
    private String tipoUsuario;
    private String mail;
    private String tempNombre;
    
    private boolean mostrandoCont = false;
    
    private String[] tipoUsu = {"Padre", "Profesor"};
    
    private ImageIcon iconMostrar = new ImageIcon("src/imagenes/eye.png"); // Ruta de la imagen
    private ImageIcon iconEsconder = new ImageIcon("src/imagenes/hidden.png"); 
    
    private int newWidth = 30; // Nuevo ancho
    private int newHeight = 30; // Nueva altura
    
    public modificarUsuarios(String nombre) {
    	this.nombre = nombre;
    	usuario = usuario.BuscarUsuario(this.nombre);
    	
    	this.contra = usuario.getCont();
    	this.mail = usuario.getMail();
    	this.tipoUsuario = usuario.getTipoUsuario();
    	
    	presentacionModificar();
    	
    }
    
    public ImageIcon escalarImagen(ImageIcon icono) {
    	Image scaledImage = icono.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
    	
		return resizedIcon;
    }
    
    public void presentacionModificar() {
    	
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
        JLabel titulo = new JLabel("MODIFICAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
        titulo.setBounds(280, 21, 223, 59);
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
        
        JTextField contraTextField = new JTextField();
        contraTextField.setBounds(292, 279, 200, 30);
        panel.add(contraTextField);
        contraTextField.setVisible(false); // Inicialmente oculto
        
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
        JButton btnModificarUsuarios = new JButton("Modificar Usuarios");
        btnModificarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnModificarUsuarios.setBounds(292, 540, 200, 50);
        panel.add(btnModificarUsuarios);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);
        
        ImageIcon iconScaled = escalarImagen(iconMostrar);
        
        JButton btnMostrarCont = new JButton(iconScaled);
        btnMostrarCont.setBounds(509, 280, iconScaled.getIconWidth(), iconScaled.getIconHeight());
        btnMostrarCont.setBorderPainted(false);
        btnMostrarCont.setContentAreaFilled(false);
        btnMostrarCont.setFocusPainted(false);
        panel.add(btnMostrarCont);
        
        // Acciones Botones
        
        // Setea los atributos del producto a los fields de la ventana
        nombreField.setText(nombre);
        mailField.setText(mail);
        contraField.setText(contra);
        tipoUsuarioCbbx.setSelectedItem(tipoUsuario);
        
        // Modificar Usuario
        btnModificarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	usuario = usuario.BuscarUsuario(nombre);
    			nombre = nombreField.getText();
    			
    			if (mostrandoCont == false) {
    				char[] contraChars = contraField.getPassword();
        	        contra = new String(contraChars);
    			} else {
    				contra = contraTextField.getText();
    			}
    			
    				tipoUsuario = tipoUsuarioCbbx.getSelectedItem().toString();
	    	        int id = usuario.getId();
	                String mail = mailField.getText();
    	        
    	        // Verifica si los atributos son nulos
                if (nombre.equals("") || mail.equals("") || contra.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
                } else {
                
                	// Patrón para validar el email
		            Pattern pat = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");

		            // El email a validar
		            Matcher mather = pat.matcher(mail);

		            if (mather.find() == true) {
		                	
		            	tempNombre = usuario.BuscarUsuario(nombre).getNombre();
		                	
		                usuario.setNombre(nombre);
		                usuario.setMail(mail);
		                usuario.setCont(contra);
		                usuario.setTipoUsuario(tipoUsuario);
		                usuario.setId(id);
                
                int option = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres modificar el usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
	             
   	             // Comprobar la respuesta
   	             if (option == JOptionPane.YES_OPTION) {
   	            	 
   	            	usuario.ModificarUsuario();
   	 	    		JOptionPane.showMessageDialog(panel, "Usuario modificado");
	   	 	    	panelUsuarios ventanaUsuarios = new panelUsuarios();
	            	ventanaUsuarios.setVisible(true);
	        		modificarUsuarios.this.dispose();
   	            	 
   	             } else {
   	            	 JOptionPane.showMessageDialog(panel, "Usuario no modificado");
   	             }
   	             
		            } else {
		             JOptionPane.showMessageDialog(null, "El email ingresado es inválido.");
		            }
   	             
                }
                
            }
        });
        
        // Volver Atras
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	panelUsuarios ventanaPanelUsuarios = new panelUsuarios();
            	ventanaPanelUsuarios.setVisible(true);
            	modificarUsuarios.this.dispose();	
            }
        });
        
        // Mostrar Cont
        btnMostrarCont.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		   
        		if (mostrandoCont == false) {
        			contra = new String(contraField.getPassword());
	        		contraField.setVisible(false);
	        		contraTextField.setText(contra);
	        		
            		btnMostrarCont.setIcon(escalarImagen(iconEsconder));
	        		
	        		contraTextField.setVisible(true);
	        		mostrandoCont = true;
	        		
        		} else {
        			contra = contraTextField.getText();
        			contraTextField.setVisible(false);
        			contraField.setText(contra);
        			
        			btnMostrarCont.setIcon(escalarImagen(iconMostrar));
            		
        			contraField.setVisible(true);
            		mostrandoCont = false;
            	
        		}
        	}
        });
        
        // Key listener Nombre (Se encarga de no permitir mas de 30 caracteres)
        nombreField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {   
        		
        		if (( nombreField.getText().length() >= 30 )) {
        			e.consume();
        		}    		        		
        	}
        });
        
        // Key listener Contra (Se encarga de no permitir mas de 30 caracteres)
        contraField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {   
        		
        		contra = new String(contraField.getPassword());
        		
        		if (( contra.length() >= 30 )) {
        			e.consume();
        		}    		        		
        	}
        });
        
        // Key listener ContraText (Se encarga de no permitir mas de 30 caracteres)
        contraTextField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {   
        		
        		if (( contraTextField.getText().length() >= 30 )) {
        			e.consume();
        		}    		        		
        	}
        });
        
        
        // Key listener Mail (Se encarga de no permitir mas de 30 caracteres)
        mailField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {   
        		
        		if (( mailField.getText().length() >= 30 )) {
        			e.consume();
        		}    		        		
        	}
        });
   
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
    
}
    
    
