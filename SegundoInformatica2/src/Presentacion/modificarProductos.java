package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarProductos extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public modificarProductos() {
    	
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MODIFICAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(-21, 0, 519, 60);
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
        
        // Etiquetas y campos de texto 
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
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(72, 220, 150, 25);
        panel.add(precioField);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setBounds(72, 253, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        descripcionArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
        scrollPane.setBounds(72, 275, 150, 75);
        panel.add(scrollPane); 
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(275, 170, 133, 119);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(267, 100, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(283, 302, 117, 25);
        panel.add(btnSubirImagen);
        btnSubirImagen.setEnabled(false);
        
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.setBounds(153, 394, 150, 30);
        panel.add(btnModificarProducto);
        btnModificarProducto.setEnabled(false);
        
       // ACCIONES
        
	    // Accion para Boton BuscarProducto
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		nombreField.setEditable(true);
        		newPrecioField.setEditable(true);
        		descripcionArea.setEditable(true);
        		
        		nombre = buscarProductoField.getText();
        		
        		// Verifica el valor del nombre, si es nulo muestra un error, si no existe muestra otro error y finalmente si existe 
        		// lo busca en la base de datos y muestra todos sus atributos
        		
        		if (nombre.equals("")) {
        			
        			JOptionPane.showMessageDialog(null, "Nombre del producto no ingresado");
        			btnModificarProducto.setEnabled(false);
        			
        			nombreField.setText("");
            		descripcionArea.setText("");
            		precioField.setValue(0);
            		foto = "";
            		
            		imagenLabel.setIcon(new ImageIcon(foto));
        			
        		} else {
        			
        			producto = producto.BuscarProducto(nombre, 1);
        			
        			if (producto.getNombre() == null) {
        				
        				JOptionPane.showMessageDialog(null, "Producto no encontrado");
        				btnModificarProducto.setEnabled(false);
        				btnSubirImagen.setEnabled(false);
        				
        				nombreField.setText("");
                		descripcionArea.setText("");
                		precioField.setValue(0);
                		
                		foto = "";
                		imagenLabel.setIcon(new ImageIcon(foto));
                		
        			} else {
        				
        				btnModificarProducto.setEnabled(true);
        				btnSubirImagen.setEnabled(true);
        				nombre = producto.getNombre();
                		descripcion = producto.getDescripcion();
                		precio = producto.getPrecio();
                		foto = producto.getFoto();
                	
                		nombreField.setText(nombre);
                		descripcionArea.setText(descripcion);
                		precioField.setValue(precio);
                		
                		// Se crea un image icon con el path de la foto del producto y una imagen que agarra la foto y las medidas del image Label
                		ImageIcon imageIcon = new ImageIcon(foto);
                		Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
                		imagenLabel.setIcon(new ImageIcon(image));
        				
        			}	   
        		}
        	}
        });
      
	    // Accion para Boton SubirImagen
        btnSubirImagen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Se crea un JfileChooser y se aplica un filtro para solo archivos
                JFileChooser fc = new JFileChooser();
	        	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        	
	        	// Se crea un filtro de extension que solo permite archivos de imagen	
	        	FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
	        	fc.setFileFilter(filtro);
	        	fc.showOpenDialog(btnSubirImagen);
        		
	            if (fc.getSelectedFile() == null) {
	    			
	    			JOptionPane.showMessageDialog(null, "Error, foto no seleccionada");
	    			
	            } else {
	            		
	            	// Se crea un image icon con el path de la foto seleccionada y una imagen que agarra la foto y las medidas del image Label
	            	ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
	            	Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
	   
	            	// Mostrar la imagen en imagenLabel
		            imagenLabel.setIcon(new ImageIcon(image));
		            foto = fc.getSelectedFile().getAbsolutePath();
	            	
	            }
        	}
        });
     
	    // Accion para Boton ModificarProducto
	    btnModificarProducto.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		nombre = nombreField.getText();
	    		descripcion = descripcionArea.getText();
	    		precio = (Integer) precioField.getValue();
	    		
	    		producto.setNombre(nombre);
	    		producto.setDescripcion(descripcion);
	    		producto.setPrecio(precio);
	    		producto.setFoto(foto);
	    		
	    		int confirmar = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres modificar el producto?", "Si", JOptionPane.YES_NO_OPTION);
	
	    		if (confirmar == JOptionPane.YES_OPTION) {
	    			
	    		    producto.ModificarProducto();
	    		    JOptionPane.showMessageDialog(null, "Producto modificado con exito!");
	    		    
	    		} else {
	    			
	    			JOptionPane.showMessageDialog(null, "Producto no modificado");
	    			
	    		}	
	    	}
	    });
    
	    // Agregar el panel a la ventana
	    getContentPane().add(panel);
    
    }
  }

