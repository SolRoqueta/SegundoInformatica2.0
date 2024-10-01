package Presentacion;

import Logica.productos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificarProductos extends JFrame {
	
	public productos producto = new productos();
	private int id_productos;
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
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(72, 199, 47, 25);
        panel.add(precioLabel);
        
        JTextField precioField = new JTextField();
        precioField.setBounds(72, 220, 150, 25);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setBounds(72, 253, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(72, 275, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(275, 170, 133, 119);
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(imagenLabel);
        
      
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//Este seccion del codigo se ejecuta cuando el boton Subir Imagen es apretado 
                	JFileChooser fc = new JFileChooser();
	        		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        		
	        		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
	        		fc.setFileFilter(filtro);
	        		fc.showOpenDialog(subirImagenBtn);
        		
        			ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
        			Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
        			
					// Display the image in the label
	                imagenLabel.setIcon(new ImageIcon(image));
	                
	                foto = fc.getSelectedFile().getAbsolutePath();
                
        	}
        });
        subirImagenBtn.setBounds(283, 302, 117, 25);
        panel.add(subirImagenBtn);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setBounds(267, 100, 78, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		nombre = buscarProductoField.getText();
        		
        		producto = producto.BuscarProducto(nombre, 1);
   
        		id_productos = producto.getId();
        		nombre = producto.getNombre();
        		descripcion = producto.getDescripcion();
        		precio = producto.getPrecio();
        		foto = producto.getFoto();
        		
        		nombreField.setText(nombre);
        		descripcionArea.setText(descripcion);
        		precioField.setText(String.valueOf(precio));
        		
        		ImageIcon imageIcon = new ImageIcon(foto);
				Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
        		imagenLabel.setIcon(new ImageIcon(image));
        		
        	}
        });
        panel.add(btnNewButton);
    
    // Botón Modificar Producto
    JButton modificarProductoBtn = new JButton("Modificar Producto");
    modificarProductoBtn.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		nombre = nombreField.getText();
    		descripcion = descripcionArea.getText();
    		precio = Integer.parseInt(precioField.getText());
	        
    		producto.setNombre(nombre);
    		producto.setDescripcion(descripcion);
    		producto.setPrecio(precio);
    		producto.setFoto(foto);
    		
    		producto.ModificarProducto();
    			
    	}
    });
    
    modificarProductoBtn.setBounds(153, 394, 150, 30);
    panel.add(modificarProductoBtn);
    
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            modificarProductos ventana = new modificarProductos();
            ventana.setVisible(true);
        });
    }
}
