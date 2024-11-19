package Presentacion;

import Logica.compresorFoto;
import Logica.convertidorFoto;
import Logica.menus;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

public class modificarMenus extends JFrame {
	
	public menus menu = new menus();
	
	convertidorFoto convFoto = new convertidorFoto();
	compresorFoto compFoto = new compresorFoto();

	private String nombre;
	private String dia;
	private String descripcion;
	private String fotoPath;
	
	private int precio;
	private int stock;
	
	private InputStream is;
    
	public modificarMenus(String nombre) throws IOException {
		this.nombre = nombre;
		
		menu = menu.BuscarMenu(nombre);
		
		this.precio = menu.getPrecio();
		this.stock = menu.getStock();
		this.descripcion = menu.getDescripcion();
		this.dia = menu.getDiaCorrespondiente();
		this.is = menu.getInputStream();
		
		presentacionModificar();
	}
	
    public void presentacionModificar() {
    	
        // Configurar la ventana
        setTitle("Modificar Menu");
        setSize(800, 700);	
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Labels de Titulos
        JLabel tituloAgregar = new JLabel("MODIFICAR", SwingConstants.CENTER);
        tituloAgregar.setForeground(new Color(210, 210, 210));
        tituloAgregar.setFont(new Font("Tahoma", Font.BOLD, 35));
        tituloAgregar.setBackground(Color.GRAY);
        tituloAgregar.setBounds(261, 16, 262, 59);
        panel.add(tituloAgregar);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(342, 67, 100, 2);
        panel.add(separator);
        
        JLabel tituloMenus = new JLabel("MENUS", SwingConstants.CENTER);
        tituloMenus.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloMenus.setBounds(338, 60, 108, 51);
        tituloMenus.setBackground(Color.GRAY);
        tituloMenus.setForeground(new Color(210, 210, 210));
        panel.add(tituloMenus);
        
        // Labels y Fields
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(119, 152, 62, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(119, 181, 175, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(118, 212, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(119, 239, 175, 25);
        panel.add(precioField);
        
        JLabel stockLabel = new JLabel("Stock");
        stockLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        stockLabel.setForeground(new Color(230, 230, 230));
        stockLabel.setBounds(119, 272, 33, 25);
        panel.add(stockLabel);
        
        JSpinner stockField = new JSpinner();
        stockField.setBounds(119, 300, 175, 25);
        panel.add(stockField);
        
        JLabel diaLabel = new JLabel("Dia");
        diaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        diaLabel.setForeground(new Color(230, 230, 230));
        diaLabel.setBounds(119, 335, 33, 25);
        panel.add(diaLabel);
        
        JComboBox <String> diaCbbx = new JComboBox<String>();
        diaCbbx.setBounds(119, 359, 175, 25);
        panel.add(diaCbbx);
        
        diaCbbx.addItem("Lunes");
        diaCbbx.addItem("Martes");
        diaCbbx.addItem("Miercoles");
        diaCbbx.addItem("Jueves");
        diaCbbx.addItem("Viernes");
        diaCbbx.addItem("Fijo");
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        descripcionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(119, 394, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(119, 426, 175, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        JScrollPane scrollPane = new JScrollPane(descripcionArea);
	    scrollPane.setBounds(119, 426, 175, 75);
	    panel.add(scrollPane);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(413, 187, 250, 250);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        
        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(458, 463, 160, 35);
        panel.add(btnSubirImagen);
        
        JButton btnModificarMenu = new JButton("Modificar Menu");
        btnModificarMenu.setBounds(292, 574, 200, 50);
        panel.add(btnModificarMenu);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);
        
        // Setea los valores del producto seleccionado
        
        precioField.setValue(precio); 
        nombreField.setText(nombre);
        stockField.setValue(stock);
        diaCbbx.setSelectedItem(dia);
        descripcionArea.setText(descripcion);
        
        // Convierte el InputStream del producto a un Image Icon y lo setea al label de la foto para mostrarlo
        try {
        	// Usa la clase convertidorFoto y convierte el input Stream del producto a un ImageIcon
        	 ImageIcon fotoOriginal = convFoto.convertirInputStreamAFoto(is);
        	 
        	 // Se encarga de escalar la imagen al mismo tamaño que el imageLabel creando un scaledIcon
        	 Image imagen = fotoOriginal.getImage();
             Image scaledImagen = imagen.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
             ImageIcon scaledIcon = new ImageIcon(scaledImagen);
             
             imagenLabel.setIcon(scaledIcon);
             
        } catch (IOException e) {
        	e.printStackTrace();
        }
      
       // Accion Listeners botones
        
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
                    fotoPath = fc.getSelectedFile().getAbsolutePath();
                }
        		
		            }
        });
       
       // AgregarMenu
        btnModificarMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					menu = menu.BuscarMenu(nombre);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

    			nombre = nombreField.getText();
                precio = (Integer) precioField.getValue();
                stock = (Integer) stockField.getValue();
                descripcion = descripcionArea.getText();
                dia = diaCbbx.getSelectedItem().toString();
                
                if (dia.equals("Fijo")) {
              	  menu.setDiario(false);
                } else {
              	  menu.setDiario(true);
                } 
                
                if (fotoPath == null) {
                	
                	try {
						menu.setInputStream(null, menu.getInputStream());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                	
                } else {
                	
                	try {
						menu.setInputStream(fotoPath, null);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                	
                }
                
                // Verifica si los atributos son nulos, si son nulos muestra un error, si no, crea el nuevo producto
                if (nombre.equals("") || precio == 0 || descripcion.equals("")) {
                	
                    JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos");
                    
                } else {
                
                    menu.setNombre(nombre);
                    menu.setPrecio(precio);
                    menu.setStock(stock);
                    menu.setDescripcion(descripcion);
                    menu.setDiaCorrespondiente(dia);
                    
                    int option = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres modificar el menu?", "Confirmación", JOptionPane.YES_NO_OPTION);
   	             
	   	             // Comprobar la respuesta
	   	             if (option == JOptionPane.YES_OPTION) {
	   	            	 
	   	            	try {
							menu.ModificarMenu();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	   	            	
	   	 	    		JOptionPane.showMessageDialog(panel, "Producto modificado");
		   	 	    	panelMenus ventanaMenus= new panelMenus();
		            	ventanaMenus.setVisible(true);
		        		modificarMenus.this.dispose(); 
		        		
	   	             } else {
	   	            	 
	   	            	 JOptionPane.showMessageDialog(panel, "Producto no modificado");
	   	            	 
	   	             }
   	             
                }
        	}
        });
        
      // Volver Atras
        volverBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panelMenus ventanaMenus = new panelMenus();
        		ventanaMenus.setVisible(true);
        		modificarMenus.this.dispose();
        	}
        });
        
        nombreField.addKeyListener(new KeyAdapter() {
        	public void keyTyped(KeyEvent e) {
     		
        		if (( nombreField.getText().length() >= 30 )) {
        			
        			e.consume();

        		}
     		        		
        	}
        });
        
        precioField.addChangeListener(e -> {
	        	
	            int valorActual = (int) precioField.getValue();
	            
	            if (valorActual < 0) {
	            	
	            	precioField.setValue(0);
	            	
	            } else if (valorActual > 4000) {
	            	
	            	precioField.setValue(4000);
	            	
	            }
	
	        });
 
	  stockField.addChangeListener(e -> {
	 	
	     int valorActual = (int) stockField.getValue();
	     
	     if (valorActual < 0) {
	     	
	     	stockField.setValue(0);
	     	
	     } else if (valorActual > 101) {
         	
         	stockField.setValue(100);
         	
         }
	
	 });
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
    }
}
