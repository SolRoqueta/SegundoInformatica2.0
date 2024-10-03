package Presentacion;

import Logica.productos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminarProductos extends JFrame {
	
	public productos producto = new productos();
	private String nombre;
	private String descripcion;
	private int precio;
	private String foto;
    
    public eliminarProductos() {
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("ELIMINAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(-30, 0, 519, 60);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Producto");
        buscarProductoLabel.setBounds(135, 78, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(135, 99, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto para modificar los datos del producto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(72, 150, 100, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(72, 170, 150, 25);
        panel.add(nombreField);
        nombreField.setEditable(false);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(72, 199, 47, 25);
        panel.add(precioLabel);
        
        JTextField precioField = new JTextField();
        precioField.setBounds(72, 220, 150, 25);
        panel.add(precioField);
        precioField.setEditable(false);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setBounds(72, 253, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setEditable(false);
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
        scrollPane.setBounds(72, 275, 150, 75);
        panel.add(scrollPane); 
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(267, 188, 148, 148);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
        // Botón Buscar Producto
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(267, 100, 78, 23);
        
        // Botón Eliminar Producto
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setEnabled(false);
        
     //Se ejecuta cuando el boton Buscar Producto es apretado
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        		
        		nombre = buscarProductoField.getText();
        		
        		if (nombre.equals("")) {
        			
        			btnEliminarProducto.setEnabled(false);
        			JOptionPane.showMessageDialog(null, "Nombre del producto no ingresado");
        			
        			nombreField.setText("");
            		descripcionArea.setText("");
            		foto = "";
            		
            		imagenLabel.setIcon(new ImageIcon(foto));
        			
        		} else {
        			
        			producto = producto.BuscarProducto(nombre, 1);
        			
        			if (producto.getNombre() == null) {
        				
        				btnEliminarProducto.setEnabled(false);
        				JOptionPane.showMessageDialog(null, "Producto no encontrado");
                		
        			} else {
        				
        				btnEliminarProducto.setEnabled(true);
        				
        				nombre = producto.getNombre();
                		descripcion = producto.getDescripcion();
                		precio = producto.getPrecio();
                		foto = producto.getFoto();
                	
                		
                		nombreField.setText(nombre);
                		precioField.setText(Integer.toString(precio));
                		descripcionArea.setText(descripcion);
                		
                		ImageIcon imageIcon = new ImageIcon(foto);
                		Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
                		imagenLabel.setIcon(new ImageIcon(image));
        				
        			}
        			   
        		}
        		
        	}
        });
        panel.add(btnBuscarProducto);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
    // Se ejecuta cuando el boton Eliminar Producto es apretado 
    btnEliminarProducto.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int confirmar = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar el producto?", "Si", JOptionPane.YES_NO_OPTION);

    		if (confirmar == JOptionPane.YES_OPTION) {
    		    producto.EliminarProducto();
    		    JOptionPane.showMessageDialog(null, "Producto eliminado con exito!");
    		    
    		    nombreField.setText("");
    			precioField.setText("");
    			descripcionArea.setText("");
    		 
        		foto = "";
        		imagenLabel.setIcon(new ImageIcon(foto));
    		} else {    			
    			JOptionPane.showMessageDialog(null, "Producto no eliminado");
    		}
    		
    			
    	}
    });
    
    btnEliminarProducto.setBounds(153, 394, 150, 30);
    panel.add(btnEliminarProducto);
    
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            eliminarProductos ventana = new eliminarProductos();
            ventana.setVisible(true);
        });
    }
}
