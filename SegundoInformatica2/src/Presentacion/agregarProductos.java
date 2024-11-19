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
	
    private String nombre;
    private String descripcion;
    private String foto;
    
    private int precio;
    
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
        tituloAgregar.setFont(new Font("Tahoma", Font.BOLD, 35));
        tituloAgregar.setBackground(Color.GRAY);
        tituloAgregar.setBounds(304, 21, 176, 59);
        panel.add(tituloAgregar);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(317, 72, 150, 2);
        panel.add(separator);

        // Etiqueta de título
        JLabel tituloProductos = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        tituloProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloProductos.setBounds(304, 65, 176, 51);
        tituloProductos.setBackground(Color.GRAY);
        tituloProductos.setForeground(new Color(210, 210, 210));
        panel.add(tituloProductos);
        
        // Etiquetas y campos de texto
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(111, 151, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(111, 187, 200, 30);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(111, 227, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(111, 263, 200, 30);
        panel.add(precioField);
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(111, 305, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(111, 341, 200, 120);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
	    scrollPane.setBounds(111, 341, 200, 120);
	    panel.add(scrollPane);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(422, 187, 250, 250);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(469, 462, 160, 35);
        panel.add(btnSubirImagen);
        
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAgregar.setBounds(292, 568, 200, 50);
        panel.add(btnAgregar);
        
        JButton btnVolver = new JButton("←");
        btnVolver.setBounds(10, 11, 50, 15);
        panel.add(btnVolver);

        // Acciones Listeners Botones

        // Volver atras
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	panelProductos ventanaProductos = new panelProductos();
            	ventanaProductos.setVisible(true);
            	agregarProductos.this.dispose();
            }
        });
        
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
                if (nombre.equals("") || precio == 0 || descripcion.equals("") || foto == null) {
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
            	
            } else if (valorActual > 4001) {
            	
            	precioField.setValue(4000);
            	
            }

        });
       
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
