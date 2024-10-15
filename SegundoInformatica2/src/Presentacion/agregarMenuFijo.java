package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.productos;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarMenuFijo extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public agregarMenuFijo() {
    	
        // Configurar la ventana
        setTitle("Agregar Productos");
        setSize(388, 468);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MENUS FIJOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titulo.setBounds(132, 33, 108, 51);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
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
        descripcionLabel.setBounds(24, 228, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(24, 252, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(215, 132, 118, 121);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(215, 275, 118, 25);
        panel.add(subirImagenBtn);
        
        JButton agregarProductoBtn = new JButton("Agregar Menu");
        agregarProductoBtn.setBounds(111, 357, 150, 30);
        panel.add(agregarProductoBtn);
        
        // Accion para boton Subir Imagen
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
		            	Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(),imagenLabel.getHeight(), Image.SCALE_FAST);
		   
		            	// Mostrar la imagen en imagenLabel
			            imagenLabel.setIcon(new ImageIcon(image));
			            foto = fc.getSelectedFile().getAbsolutePath();
		            	
		            }
        		
        	}
        });
       
       // Accion para boton AgregarProducto
        agregarProductoBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Gets de todos los atributos del producto a crear
        		nombre = nombreField.getText();
        		descripcion = descripcionArea.getText();
        		precio = (Integer) precioField.getValue();
        		
        		// Verifica si los atributos son nulos, si son nulos muestra un error, si no, crea el nuevo producto
        		if (nombre.equals("") || descripcion.equals("") || precio == 0 || foto == null) {
        			
        			JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
        			
        		} else {
        			
        			productos tempProducto = new productos();
        			String tempNombre = tempProducto.BuscarProducto(nombre).getNombre();
        			
        			if (tempNombre == null) {
        				
        				producto.setNombre(nombre);
                		producto.setDescripcion(descripcion);
                		producto.setPrecio(precio);
                		producto.setFoto(foto);
                		
                		producto.AgregarProducto();
                		JOptionPane.showMessageDialog(null, "Producto agregado con exito!");
        				
        			} else {
        				
        				JOptionPane.showMessageDialog(null, "Error, el producto ya existe");
        				
        			}	
        		}	
        	}
        });
      
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JLabel titulo_1 = new JLabel("AGREGAR", SwingConstants.CENTER);
        titulo_1.setForeground(new Color(210, 210, 210));
        titulo_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo_1.setBackground(Color.GRAY);
        titulo_1.setBounds(123, 0, 125, 59);
        panel.add(titulo_1);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(136, 45, 100, 2);
        panel.add(separator);
        
        JSpinner precioField_1 = new JSpinner();
        precioField_1.setBounds(24, 202, 150, 25);
        panel.add(precioField_1);
        
        JLabel lblCantidad = new JLabel("Stock");
        lblCantidad.setForeground(new Color(230, 230, 230));
        lblCantidad.setBounds(24, 181, 53, 25);
        panel.add(lblCantidad);
        
        JButton agregarProductoBtn_1 = new JButton("←");
        agregarProductoBtn_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        agregarProductoBtn_1.setBounds(161, 401, 50, 15);
        panel.add(agregarProductoBtn_1);
        
    }
}
