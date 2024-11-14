package Presentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import Logica.productos;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarProductos extends JFrame {

	productos producto = new productos();
	
    // Declaracion de atributos de Productos
    private String nombre;
    private int precio;
    private String descripcion;
    private String foto;
    
    public agregarProductos() {
    	
    	presentacionAgregar();
    }
    
    public void presentacionAgregar() {
        
        // Configurar la ventana
        setTitle("Agregar Productos");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        JLabel tituloAgregar = new JLabel("AGREGAR", SwingConstants.CENTER);
        tituloAgregar.setForeground(new Color(210, 210, 210));
        tituloAgregar.setFont(new Font("Tahoma", Font.BOLD, 22));
        tituloAgregar.setBackground(Color.GRAY);
        tituloAgregar.setBounds(123, 0, 125, 59);
        panel.add(tituloAgregar);
        
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
        
        // Botones
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(215, 239, 118, 25);
        panel.add(btnSubirImagen);
        
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.setBounds(111, 315, 150, 30);
        panel.add(btnAgregar);
        
        JButton btnVolver = new JButton("←");
        btnVolver.setBounds(10, 11, 50, 15);
        panel.add(btnVolver);

        // Acciones Listeners Botones

        // Subir Imagen
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
                    Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_FAST);
                    // Mostrar la imagen en imagenLabel
                    imagenLabel.setIcon(new ImageIcon(image));
                    foto = fc.getSelectedFile().getAbsolutePath();
                }
            }
        });

        // Agregar Producto
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
      
                nombre = nombreField.getText();
                descripcion = descripcionArea.getText();
                precio = (Integer) precioField.getValue();
                
                
                // Verifica si los atributos son nulos, si son nulos muestra un error, si no, crea el nuevo producto
                if (nombre.equals("") || precio == 0 || foto == null) {
                    JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
                } else {
                    productos tempProducto = new productos();
                    String tempNombre = null;
                    
					try {
						//TEMPORAL, CAMBIAR A BUSCAR POR ID
						tempNombre = tempProducto.BuscarProducto(nombre).getNombre();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                    
                    if (tempNombre == null) {
                        producto.setNombre(nombre);
                        producto.setDescripcion(descripcion);
                        producto.setPrecio(precio);
                        
                        try {
							producto.setInputStream(foto, null);
							System.out.println(producto.getInputStream());
							producto.AgregarProducto();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
                      
                        JOptionPane.showMessageDialog(null, "Producto agregado con exito!");
                        panelProductos ventanaProductos = new panelProductos();
                    	ventanaProductos.setVisible(true);
                    	agregarProductos.this.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, el producto ya existe");
                    }    
                    
                    
                }
                
            }
        
            
        });

        // Volver atras
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	panelProductos ventanaProductos = new panelProductos();
            	ventanaProductos.setVisible(true);
            	agregarProductos.this.dispose();
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
