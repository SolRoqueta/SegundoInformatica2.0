package Presentacion;

import Logica.productos;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminarProductos extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private int idproducto;
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public eliminarProductos() {
    	
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(475, 555);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        buscarProductoLabel.setBounds(122, 78, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(122, 99, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(72, 200, 100, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(72, 220, 150, 25);
        panel.add(nombreField);
        nombreField.setEditable(false);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(72, 250, 47, 25);
        panel.add(precioLabel);
        
        JTextField precioField = new JTextField();
        precioField.setBounds(72, 270, 150, 25);
        panel.add(precioField);
        precioField.setEditable(false);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setBounds(72, 300, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setEditable(false);
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
        scrollPane.setBounds(72, 320, 150, 75);
        panel.add(scrollPane); 
        
        JComboBox cbbxProductos = new JComboBox();
        cbbxProductos.setBounds(122, 144, 214, 22);
        panel.add(cbbxProductos);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(267, 230, 148, 148);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(255, 100, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(153, 440, 150, 30);
        panel.add(btnEliminarProducto);
        btnEliminarProducto.setEnabled(false);
        
        // Accion para boton BuscarProducto
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		        		
        		nombre = buscarProductoField.getText();
        		
        		// Verifica el valor del nombre, si es nulo muestra un error, si no existe muestra otro error y finalmente si existe 
        		// lo busca en la base de datos y muestra todos sus atributos
        		
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
			
        				idproducto = producto.getId();
        				nombre = producto.getNombre();
                		descripcion = producto.getDescripcion();
                		precio = producto.getPrecio();
                		foto = producto.getFoto();
                		
                		nombreField.setText(nombre);
                		precioField.setText(Integer.toString(precio));
                		descripcionArea.setText(descripcion);
                		
                		// Se crea un image icon con el path de la foto seleccionada y una imagen que agarra la foto y las medidas del image Label
                		ImageIcon imageIcon = new ImageIcon(foto);
                		Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
                		imagenLabel.setIcon(new ImageIcon(image));
                		
                		
                		cbbxProductos.addItem( "ID: " + idproducto + " | " + nombre + " | " + "$" + precio);
        				
        			}
        			   
        		}
        		
        	}
        });
    
        // Accion para boton EliminarProducto
	    btnEliminarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		int confirmar = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar el producto?", "Si", JOptionPane.YES_NO_OPTION);
	
	    		// Verifica si el usuario confirmo la eliminacion del producto
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
	    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    }
}
