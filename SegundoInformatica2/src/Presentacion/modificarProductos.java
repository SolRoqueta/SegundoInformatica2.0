package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class modificarProductos extends JFrame {
	
	public productos producto = new productos();
	
	private menuProductos MenuProductos;
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
	private boolean modificoLaFoto = false;
    
    public modificarProductos(menuProductos MenuProductos) {
    	
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(475, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MODIFICAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo.setBounds(158, 22, 150, 20);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Nombre Producto");
        buscarProductoLabel.setForeground(new Color(230, 230, 230));
        buscarProductoLabel.setBounds(134, 92, 121, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		
        		if (( buscarProductoField.getText().length() >= 30 )) {
        			
        			e.consume();
        			
        		}
        		
        	}
        });
        buscarProductoField.setBounds(135, 114, 120, 25);
        panel.add(buscarProductoField);
        
        // Etiquetas y campos de texto 
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(72, 157, 100, 25);
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
        nombreField.setBounds(72, 178, 150, 25);
        panel.add(nombreField);
        nombreField.setEditable(false);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(72, 214, 47, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.addChangeListener(e -> {
        	
            int valorActual = (int) precioField.getValue();
            
            if (valorActual < 0) {
            	
            	precioField.setValue(0);
            	
            }

        });
        precioField.setBounds(72, 234, 150, 25);
        panel.add(precioField);
        
        JFormattedTextField newPrecioField = new JFormattedTextField();
        newPrecioField.setEnabled(false);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(72, 270, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        descripcionArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
        scrollPane.setBounds(72, 295, 150, 75);
        panel.add(scrollPane); 
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(275, 188, 133, 119);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
        // Botones
        JButton btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setBounds(271, 115, 78, 23);
        panel.add(btnBuscarProducto);
        
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(283, 326, 117, 25);
        panel.add(btnSubirImagen);
        btnSubirImagen.setEnabled(false);
        
        JButton btnModificarProducto = new JButton("Modificar Producto");
        btnModificarProducto.setBounds(154, 392, 150, 30);
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
        			
        			producto = producto.BuscarProducto(nombre);
        			
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
                	
                		nombreField.setText(nombre);
                		descripcionArea.setText(descripcion);
                		precioField.setValue(precio);
                		
                		// Se crea un image icon con el path de la foto del producto y una imagen que agarra la foto y las medidas del image Label
                		ImageIcon imageIcon = new ImageIcon(producto.getFotoPaMostrar());
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
	    			setModificoLaFoto(false);
	    			
	            } else {
	            		
	            	// Se crea un image icon con el path de la foto seleccionada y una imagen que agarra la foto y las medidas del image Label
	            	ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
	            	Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
	   
	            	// Mostrar la imagen en imagenLabel
		            imagenLabel.setIcon(new ImageIcon(image));
		            foto = fc.getSelectedFile().getAbsolutePath();
		            producto.setFoto(foto);
		            setModificoLaFoto(true);
	            	
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
	    		
	    		if (getModificoLaFoto()) {
	    			
	    			producto.setFoto(foto);
	    			
	    		}
	    		
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
	    
	    JLabel lblProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
	    lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblProductos.setForeground(new Color(210, 210, 210));
	    lblProductos.setBackground(Color.GRAY);
	    lblProductos.setBounds(183, 53, 100, 20);
	    panel.add(lblProductos);
	    
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(210, 210, 210));
	    separator.setBounds(183, 50, 100, 3);
	    panel.add(separator);
	    
	    JButton btnModificarProducto_1 = new JButton("←");
	    btnModificarProducto_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuProductos.setVisible(true); // Show the main menu
        		modificarProductos.this.dispose();    // Close the current window
        	}
        });
	    btnModificarProducto_1.setBounds(204, 435, 50, 15);
	    panel.add(btnModificarProducto_1);
    
    }
    
    public void setPrecio(int input) {
    	
    	precio = input;
    	
    }

	public boolean getModificoLaFoto() {
		return modificoLaFoto;
	}

	public void setModificoLaFoto(boolean modificoLaFoto) {
		this.modificoLaFoto = modificoLaFoto;
	}
    
  }

