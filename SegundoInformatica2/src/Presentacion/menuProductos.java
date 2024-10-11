package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuProductos extends JFrame {
	
	public menuProductos() {

        JFrame frame = new JFrame("Menu Productos");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(309, 378);
        frame.getContentPane().setLayout(null);
        
                JLabel labelTitulo = new JLabel("MENU PRODUCTOS", SwingConstants.CENTER);
                labelTitulo.setBackground(Color.WHITE);
                labelTitulo.setBounds(-1, -1, 295, 64);
                frame.getContentPane().add(labelTitulo);
                labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
                labelTitulo.setBackground(Color.GRAY);
                labelTitulo.setOpaque(true);
                labelTitulo.setForeground(new Color(255, 255, 255));
                
                        // Boton para Agregar Productos
                        JButton btnAgregarProductos= new JButton("Agregar");
                        btnAgregarProductos.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		agregarProductos ventanaAgregar = new agregarProductos();
                        		ventanaAgregar.setVisible(true);

                        	}
                        });
                        btnAgregarProductos.setBounds(80, 100, 125, 31);
                        frame.getContentPane().add(btnAgregarProductos);
                        
                        // Boton para Modificar Productos
                        JButton btnModificarProductos = new JButton("Modificar");
                        btnModificarProductos.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		modificarProductos ventanaModificar = new modificarProductos();
                        		ventanaModificar.setVisible(true);

                        	}
                        });
                        btnModificarProductos.setBounds(80, 150, 125, 31);
                        frame.getContentPane().add(btnModificarProductos);
                                
                        // Boton para Eliminar Productos
                        JButton btnEliminarProductos = new JButton("Eliminar");
                        btnEliminarProductos.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		eliminarProductos ventanaEliminar = new eliminarProductos();
                        		ventanaEliminar.setVisible(true);
                        		
                        	}
                        });
                        btnEliminarProductos.setBounds(80, 200, 125, 31);
                        frame.getContentPane().add(btnEliminarProductos);
                        
                        // Boton para Listar Productos
                        JButton btnListarProductos = new JButton("Listar");
                        btnListarProductos.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		
                        		listarProductos ventanaListar = new listarProductos();
                        		ventanaListar.setVisible(true);
                        		
                        	}
                        });
                        btnListarProductos.setBounds(80, 250, 125, 31);
                        frame.getContentPane().add(btnListarProductos);

        // Make the frame visible
        frame.setVisible(true);
        
	}
}
