package Presentacion;

import Logica.usuarios;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminarUsuarios extends JFrame {
	
	public usuarios usuario = new usuarios();
	
	// Declaracion de atributos de Productos
		private int idusuario;
		private String nombre;
		private String contra;
		private String tipoUsuario;
		private String mail;
		private JTable tabla;
    
    public eliminarUsuarios() {
    	
        // Configurar la ventana
        setTitle("Eliminar Usuarios");
        setSize(475, 555);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("ELIMINAR USUARIOS", SwingConstants.CENTER);
        titulo.setBounds(-30, 0, 519, 60);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarUsuariosLabel = new JLabel("Nombre Usuarios");
        buscarUsuariosLabel.setBounds(122, 78, 121, 25);
        panel.add(buscarUsuariosLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarUsuariosField = new JTextField();
        buscarUsuariosField.setBounds(122, 99, 120, 25);
        panel.add(buscarUsuariosField);
        
        JButton btnBuscarUsuarios = new JButton("Buscar Usuarios");
        btnBuscarUsuarios.setBounds(254, 96, 150, 30);
        panel.add(btnBuscarUsuarios);
        
        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnEliminarUsuario.setBounds(153, 440, 150, 30);
        panel.add(btnEliminarUsuario);
        btnEliminarUsuario.setEnabled(false);
        
        // Accion para boton BuscarUsuarios
        btnBuscarUsuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        		
//        		nombre = buscarUsuariosField.getText();	
////        		
////        		// Verifica el valor del nombre, si es nulo muestra un error, si no existe muestra otro error y finalmente si existe 
////        		// lo busca en la base de datos y muestra todos sus atributos
////        		
//        		if (nombre.equals("")) {
////        			
//        			btnEliminarUsuario.setEnabled(false);
//        			JOptionPane.showMessageDialog(null, "Nombre del usuario no ingresado");
////        			
//        		} else {
        			
        			usuarios usuario = new usuarios();
            		String[][] datos = usuario.BuscarUsuarios();
            		
            		String[] columnas = {"ID", "Nombre","Tipo Usuario"};
            		
            		tabla = new JTable(datos, columnas);
            		
            		JScrollPane scrollPane = new JScrollPane(tabla);
            		scrollPane.setBounds(98, 191, 300, 300);
            		panel.add(scrollPane);
            		
            		tabla.setPreferredScrollableViewportSize(new Dimension(450, 100));
                    tabla.setFillsViewportHeight(true);
        			
//        			if (usuario.getNombre() == null) {
//        				
//        				btnEliminarUsuario.setEnabled(false);
//        				JOptionPane.showMessageDialog(null, "Producto no encontrado");
//        				
////        			}
        			   
//        		}
        		
        	}
        });
    
        // Accion para boton EliminarProducto
	    btnEliminarUsuario.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		int confirmar = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar el producto?", "Si", JOptionPane.YES_NO_OPTION);
	
	    		// Verifica si el usuario confirmo la eliminacion del producto
	    		if (confirmar == JOptionPane.YES_OPTION) {
	    		    usuario.EliminarUsuario();
	    		    JOptionPane.showMessageDialog(null, "Producto eliminado con exito!");
	        		
	    		} else {    			
	    			JOptionPane.showMessageDialog(null, "Producto no eliminado");
	    		}
	    	}
	    });
	    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    }
}
