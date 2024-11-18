package Presentacion;

import Logica.menuDiario;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class modificarMenus extends JFrame {
	
	public menuDiario menuDiario = new menuDiario();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private int stock;
	private String diaCorrespondiente;
	private String descripcion;
	private String caminoFoto;
	private String foto;
    
    public modificarMenus() {
    	
        // Configurar la ventana
        setTitle("Agregar Menu");
        setSize(800, 700);	
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Labels de Titulos
        JLabel tituloAgregar = new JLabel("AGREGAR", SwingConstants.CENTER);
        tituloAgregar.setForeground(new Color(210, 210, 210));
        tituloAgregar.setFont(new Font("Tahoma", Font.BOLD, 35));
        tituloAgregar.setBackground(Color.GRAY);
        tituloAgregar.setBounds(289, 16, 206, 59);
        panel.add(tituloAgregar);
        
        JLabel tituloMenus = new JLabel("MENUS", SwingConstants.CENTER);
        tituloMenus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloMenus.setBounds(338, 56, 108, 51);
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
        nombreField.setBounds(119, 181, 175, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(118, 212, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.addChangeListener(e -> {
        	
            int valorActual = (int) precioField.getValue();
            
            if (valorActual < 0) {
            	
            	precioField.setValue(0);
            	
            }

        });
        precioField.setBounds(119, 239, 175, 25);
        panel.add(precioField);
        
        JLabel stockLabel = new JLabel("Stock");
        stockLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        stockLabel.setForeground(new Color(230, 230, 230));
        stockLabel.setBounds(119, 272, 33, 25);
        panel.add(stockLabel);
        
        JSpinner stockField = new JSpinner();
        stockField.addChangeListener(e -> {
        	
            int valorActual = (int) stockField.getValue();
            
            if (valorActual < 0) {
            	
            	stockField.setValue(0);
            	
            }

        });
        stockField.setBounds(119, 300, 175, 25);
        panel.add(stockField);
        
        JLabel diaLabel = new JLabel("Dia");
        diaLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        diaLabel.setForeground(new Color(230, 230, 230));
        diaLabel.setBounds(119, 335, 33, 25);
        panel.add(diaLabel);
        
        JComboBox <String> comboBox = new JComboBox<String>();
        comboBox.setBounds(119, 359, 175, 25);
        panel.add(comboBox);
        
        comboBox.addItem("Lunes");
        comboBox.addItem("Martes");
        comboBox.addItem("Miercoles");
        comboBox.addItem("Jueves");
        comboBox.addItem("Viernes");
        
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
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(413, 187, 250, 250);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(458, 463, 160, 35);
        panel.add(subirImagenBtn);
        
        JButton agregarMenuBtn = new JButton("Agregar Menu");
        agregarMenuBtn.setBounds(292, 574, 200, 50);
        panel.add(agregarMenuBtn);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(10, 11, 50, 15);
        panel.add(volverBtn);
      
       // Acciones botones
        
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
                    foto = fc.getSelectedFile().getAbsolutePath();
                }
        		
		            }
        });
       
       // AgregarMenu
        agregarMenuBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Gets de todos los atributos del usuario a crear
                nombre = nombreField.getText();
                precio = Integer.parseInt(precioField.getValue().toString());
        		
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
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(342, 67, 100, 2);
        panel.add(separator);
    }
}
