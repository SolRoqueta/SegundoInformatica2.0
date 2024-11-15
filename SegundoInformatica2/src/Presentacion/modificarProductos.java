package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.compresorFoto;
import Logica.convertidorFoto;
import Logica.productos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class modificarProductos extends JFrame {

	productos producto = new productos();
	convertidorFoto cF = new convertidorFoto();
	compresorFoto compFoto = new compresorFoto();

	  private String nombre;
	  private int precio;
	  private String descripcion;
	  private String fotoPath;
	  private InputStream is;
    
    public modificarProductos(String nombre) throws IOException {
    	this.nombre = nombre;
    	producto = producto.BuscarProducto(this.nombre);
    	
    	this.precio = producto.getPrecio();
    	this.descripcion = producto.getDescripcion();
    	this.is = producto.getInputStream();
    	
    	presentacionModificar();
    }
    
    private void presentacionModificar() throws IOException {
        
        // Configurar la ventana
        setTitle("Modificar Productos");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        JLabel tituloModificar = new JLabel("MODIFICAR", SwingConstants.CENTER);
        tituloModificar.setForeground(new Color(210, 210, 210));
        tituloModificar.setFont(new Font("Tahoma", Font.BOLD, 22));
        tituloModificar.setBackground(Color.GRAY);
        tituloModificar.setBounds(123, 0, 125, 59);
        panel.add(tituloModificar);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(136, 45, 100, 2);
        panel.add(separator);

        // Etiqueta de título
        JLabel tituloProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        tituloProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloProductos.setBounds(132, 33, 108, 51);
        tituloProductos.setBackground(Color.GRAY);
        tituloProductos.setForeground(new Color(210, 210, 210));
        panel.add(tituloProductos);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(24, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(24, 105, 150, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(24, 132, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(24, 153, 150, 25);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(24, 178, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(24, 203, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(215, 105, 118, 121);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Setea los atributos del producto a los fields de la ventana
        precioField.setValue(precio); 
        nombreField.setText(nombre);
        descripcionArea.setText(descripcion);
       
        // Convierte el InputStream del producto a un Image Icon y lo setea al label de la foto para mostrarlo
        try {
        	// Usa la clase convertidorFoto y convierte el input Stream del producto a un ImageIcon
        	 ImageIcon fotoOriginal = cF.convertirInputStreamAFoto(is);
        	 
        	 // Se encarga de escalar la imagen al mismo tamaño que el imageLabel creando un scaledIcon
        	 Image imagen = fotoOriginal.getImage();
             Image scaledImagen = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
             ImageIcon scaledIcon = new ImageIcon(scaledImagen);
             
             imagenLabel.setIcon(scaledIcon);
             
        } catch (IOException e) {
        	e.printStackTrace();
        }
       
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(215, 239, 118, 25);
        panel.add(subirImagenBtn);
        
        JButton btnModificar = new JButton("Modificar Producto");
        btnModificar.setBounds(111, 315, 150, 30);
        panel.add(btnModificar);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);

        // Acciones Listeners Botones

        // Subir Imagen
        subirImagenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se crea un JfileChooser y se aplica un filtro para solo archivos
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
                // Se crea un filtro de extension que solo permite archivos de imagen
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
                fc.setFileFilter(filtro);
                fc.showOpenDialog(subirImagenBtn);
                
                if (fc.getSelectedFile() == null) {
                    JOptionPane.showMessageDialog(null, "Error, foto no seleccionada");
                } else {
                    // Se crea un image icon con el path de la foto seleccionada y una imagen que agarra la foto y las medidas del image Label
                    ImageIcon imageIcon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_FAST);
                    // Mostrar la imagen en imagenLabel
                    imagenLabel.setIcon(new ImageIcon(image));
                    fotoPath = fc.getSelectedFile().getAbsolutePath();
                }
            }
        });


        // Boton Modificar
        btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			
        			producto = producto.BuscarProducto(nombre);

        			nombre = nombreField.getText();
                    descripcion = descripcionArea.getText();
                    precio = (Integer) precioField.getValue();
                    
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setDescripcion(descripcion);
                    
                    if (fotoPath == null) {
                    	producto.setInputStream(null, producto.getInputStream());
                    } else {
                    	producto.setInputStream(fotoPath, null);
                    }
                    
                    int option = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres modificar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
   	             
	   	             // Comprobar la respuesta
	   	             if (option == JOptionPane.YES_OPTION) {
	   	            	producto.ModificarProducto();
	   	 	    		JOptionPane.showMessageDialog(panel, "Producto modificado");
		   	 	    	panelProductos ventanaProductos = new panelProductos();
		            	ventanaProductos.setVisible(true);
		        		modificarProductos.this.dispose(); 
	   	             } else {
	   	            	 JOptionPane.showMessageDialog(panel, "Producto no modificado");
	   	             }
						
				} catch (IOException e1) {
//					e1.printStackTrace();
				} 
  
        	}
        });
        
        // Boton volver
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	panelProductos ventanaProductos = new panelProductos();
            	ventanaProductos.setVisible(true);
        		modificarProductos.this.dispose();           	
            }
        });
        
        // Key y Change Listeners
        
        // Key listener Nombre (Se encarga de no permitir mas de 30 caracteres)
        nombreField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
        		
        		if (( nombreField.getText().length() >= 30 )) {	
        			e.consume();
        		}  		        		
        	}
        });
        
        // Change Listener Precio (Se encarga de no permitir valores negativos)
        precioField.addChangeListener(e -> {
        	
            int valorActual = (int) precioField.getValue();
            
            if (valorActual < 0) {
            	precioField.setValue(0);
            }

        });
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
