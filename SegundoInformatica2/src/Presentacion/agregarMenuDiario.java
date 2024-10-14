package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Logica.productos;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarMenuDiario extends JFrame {
	
	public productos producto = new productos();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private String descripcion;
	private String foto;
    
    public agregarMenuDiario() {
    	
        // Configurar la ventana
        setTitle("Agregar Productos");
        setSize(433, 551);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Etiqueta de título
        JLabel titulo = new JLabel("MENUS DIARIOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titulo.setBounds(154, 33, 108, 51);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(36, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(36, 105, 150, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(36, 132, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(36, 153, 150, 25);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(63, 311, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(36, 337, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(235, 105, 134, 136);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(243, 261, 118, 25);
        panel.add(subirImagenBtn);
        
        JButton agregarProductoBtn = new JButton("Agregar Menu");
        agregarProductoBtn.setBounds(133, 449, 150, 30);
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
      
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JLabel titulo_1 = new JLabel("AGREGAR", SwingConstants.CENTER);
        titulo_1.setForeground(new Color(210, 210, 210));
        titulo_1.setFont(new Font("Tahoma", Font.BOLD, 22));
        titulo_1.setBackground(Color.GRAY);
        titulo_1.setBounds(146, 0, 125, 59);
        panel.add(titulo_1);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(158, 45, 100, 2);
        panel.add(separator);
        
        JSpinner precioField_1 = new JSpinner();
        precioField_1.setBounds(36, 202, 150, 25);
        panel.add(precioField_1);
        
        JLabel lblCantidad = new JLabel("Stock");
        lblCantidad.setForeground(new Color(230, 230, 230));
        lblCantidad.setBounds(36, 181, 53, 25);
        panel.add(lblCantidad);
        
        JTextArea descripcionArea_1 = new JTextArea();
        descripcionArea_1.setWrapStyleWord(true);
        descripcionArea_1.setLineWrap(true);
        descripcionArea_1.setBounds(227, 337, 150, 75);
        panel.add(descripcionArea_1);
        
        JLabel lblAclaraciones = new JLabel("Aclaraciones");
        lblAclaraciones.setHorizontalAlignment(SwingConstants.CENTER);
        lblAclaraciones.setForeground(new Color(230, 230, 230));
        lblAclaraciones.setBounds(256, 311, 100, 25);
        panel.add(lblAclaraciones);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(36, 261, 150, 25);
        panel.add(comboBox);
        
        JLabel lblDiaCorrespondiente = new JLabel("Dia Correspondiente");
        lblDiaCorrespondiente.setForeground(new Color(230, 230, 230));
        lblDiaCorrespondiente.setBounds(36, 238, 125, 25);
        panel.add(lblDiaCorrespondiente);
        
    }
}
