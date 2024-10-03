package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.productos;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarProductos extends JFrame {
	
	public productos producto = new productos();
	private String nombre;
	private String descripcion;
	private int precio;
	private String foto;
	
	public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            agregarProductos ventana = new agregarProductos();
            ventana.setVisible(true);
        });
    }
    
    public agregarProductos() {
        // Configurar la ventana
        setTitle("Agregar Productos");
        setSize(388, 429);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null); // Usamos layout nulo para posicionar los elementos manualmente
        panel.setBackground(Color.LIGHT_GRAY);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("AGREGAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titulo.setBounds(0, 0, 372, 64);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(24, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(24, 105, 150, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setBounds(24, 132, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(24, 153, 150, 25);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
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
        
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//Este seccion del codigo se ejecuta cuando el boton Subir Imagen es apretado 
        		JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
				fc.setFileFilter(filtro);
				fc.showOpenDialog(subirImagenBtn);
				
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
        subirImagenBtn.setBounds(215, 239, 118, 25);
        panel.add(subirImagenBtn);
        
        // Botón Agregar Producto
        JButton agregarProductoBtn = new JButton("Agregar Producto");
        agregarProductoBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//Se activa cuando el boton Agregar producto es pulsado
        		
        		nombre = nombreField.getText();
        		descripcion = descripcionArea.getText();
        		precio = (Integer) precioField.getValue();
        		
        		if (nombre.equals("") || descripcion.equals("") || precio == 0 || foto == null) {
        			
        			JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
        			
        		} else {
        			
        			productos tempProducto = new productos();
        			String tempNombre = tempProducto.BuscarProducto(nombre, 1).getNombre();
        			
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
        agregarProductoBtn.setBounds(115, 322, 150, 30);
        panel.add(agregarProductoBtn);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
    
}
