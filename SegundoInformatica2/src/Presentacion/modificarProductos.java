package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import Logica.productos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class modificarProductos extends JFrame {

	productos producto = new productos();

	  private String nombre;
	  private String precio;
	  private String descripcion;
    
    public modificarProductos(String nombre, String precio, String descripcion, panelProductos panelProductos) {
    	this.nombre = nombre;
    	this.precio = precio;
    	this.descripcion = descripcion;
    	
    	presentacionModificar(panelProductos);
    }
    
    private void presentacionModificar(panelProductos pProductos) {
        
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

        // Etiqueta de título
        JLabel tituloProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        tituloProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloProductos.setBounds(132, 33, 108, 51);
        tituloProductos.setBackground(Color.GRAY);
        tituloProductos.setForeground(new Color(210, 210, 210));
        panel.add(tituloProductos);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(136, 45, 100, 2);
        panel.add(separator);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(24, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
//        		
        		if (( nombreField.getText().length() >= 30 )) {
        			
        			e.consume();

        		}
//        		        		
        	}
        });
        nombreField.setBounds(24, 105, 150, 25);
        panel.add(nombreField);
        
        nombreField.setText(nombre);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(24, 132, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.addChangeListener(e -> {
        	
            int valorActual = (int) precioField.getValue();
            
            if (valorActual < 0) {
            	
            	precioField.setValue(0);
            	
            }

        });
        precioField.setBounds(24, 153, 150, 25);
        panel.add(precioField);
        
        Integer precioInt = Integer.valueOf(precio);
        precioField.setValue(precioInt); // Establecer el valor numérico
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(24, 178, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(24, 203, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        descripcionArea.setText(descripcion);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(215, 105, 118, 121);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(215, 239, 118, 25);
        panel.add(subirImagenBtn);
        
        JButton btnModificar = new JButton("Modificar Producto");
        btnModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		producto = producto.BuscarProducto(nombre);
        		
        		producto.setNombre(nombreField.getText());
        		producto.setDescripcion(descripcionArea.getText());
        		
        		producto.ModificarProducto();
        		
        		panelProductos ventanaProductos = new panelProductos();
            	ventanaProductos.setVisible(true);
        		modificarProductos.this.dispose();   
  
        	}
        });
        btnModificar.setBounds(111, 315, 150, 30);
        panel.add(btnModificar);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);

        // Acciones Botones

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
//                    foto = fc.getSelectedFile().getAbsolutePath();
                }
            }
        });


        // Volver atras
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	panelProductos ventanaProductos = new panelProductos();
            	ventanaProductos.setVisible(true);
        		modificarProductos.this.dispose();           	
            }
        });
       
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
