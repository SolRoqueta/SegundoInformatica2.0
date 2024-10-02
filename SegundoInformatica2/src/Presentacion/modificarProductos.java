package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarProductos extends JFrame {
	
	public productos producto = new productos();
	private String nombre;
	private String descripcion;
	private int precio;
	private String foto;
    
    public modificarProductos() {
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        // Botón Buscar Producto
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(267, 100, 78, 23);
        
        // Botón Subir Imagen
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setEnabled(false);
        
        // Botón Modificar Producto
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.setEnabled(false);
        
     //Se ejecuta cuando el boton Buscar Producto es apretado
        btnBuscarProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		btnSubirImagen.setEnabled(true);
        		nombreField.setEditable(true);
        		newPrecioField.setEditable(true);
        		descripcionArea.setEditable(true);
        		btnModificarProducto.setEnabled(true);
        		
        		nombre = buscarProductoField.getText();
        		
        		if (nombre.equals("")) {
        			
        			JOptionPane.showMessageDialog(null, "Nombre del producto no ingresado");

        		} else {
        			
        			producto = producto.BuscarProducto(nombre, 1);
        			
        			if (producto.getNombre() == null) {
        				
        				JOptionPane.showMessageDialog(null, "Producto no encontrado");
        				
        			} else {
        				
        				nombre = producto.getNombre();
                		descripcion = producto.getDescripcion();
                		precio = producto.getPrecio();
                		foto = producto.getFoto();
                		
                		nombreField.setText(nombre);
                		descripcionArea.setText(descripcion);
                		precioField.setValue(precio);
                		
                		ImageIcon imageIcon = new ImageIcon(foto);
        				Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
                		imagenLabel.setIcon(new ImageIcon(image));
        				
        			}
        			   
        		}
        		
        	}
        });
        panel.add(btnBuscarProducto);
        
      // Se ejecuta cuando el boton Subir Imagen es apretado 
        btnSubirImagen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                JFileChooser fc = new JFileChooser();
	        	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        		
	        	FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
	        	fc.setFileFilter(filtro);
	        	fc.showOpenDialog(btnSubirImagen);
        		
        		
	            if (fc.getSelectedFile() == null) {
	    			
	    			JOptionPane.showMessageDialog(null, "Error, foto no seleccionada");
	    			
	            } else {
	            	
	            	
	            	ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
	            	Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
	   
	            	// Mostrar la imagen en imagenLabel
		            imagenLabel.setIcon(new ImageIcon(image));
		            foto = fc.getSelectedFile().getAbsolutePath();
	            	
	            }
                
        	}
        });
        btnSubirImagen.setBounds(283, 302, 117, 25);
        panel.add(btnSubirImagen);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
    // Se ejecuta cuando el boton Modificar Producto es apretado 
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
    
    btnModificarProducto.setBounds(153, 394, 150, 30);
    panel.add(btnModificarProducto);
    
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            modificarProductos ventana = new modificarProductos();
            ventana.setVisible(true);
        });
    }
}
