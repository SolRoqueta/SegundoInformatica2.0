package Presentacion;

import Logica.menuDiario;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarMenuDiario extends JFrame {
	
	public menuDiario menuDiario = new menuDiario();
	
	private menuMenuDiario MenuDiario;
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private int stock;
	private String diaCorrespondiente;
	private String descripcion;
	private String caminoFoto;
	private String foto;
    
    public agregarMenuDiario(menuMenuDiario MenuDiario) {
    	
        // Configurar la ventana
        setTitle("Agregar Menu Diario");
        setSize(433, 551);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(43, 70, 77));
        
        // Labels de Titulos
        JLabel tituloAgregar = new JLabel("AGREGAR", SwingConstants.CENTER);
        tituloAgregar.setForeground(new Color(210, 210, 210));
        tituloAgregar.setFont(new Font("Tahoma", Font.BOLD, 22));
        tituloAgregar.setBackground(Color.GRAY);
        tituloAgregar.setBounds(146, 0, 125, 59);
        panel.add(tituloAgregar);
        
        JLabel tituloMenus = new JLabel("MENUS DIARIOS", SwingConstants.CENTER);
        tituloMenus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloMenus.setBounds(154, 33, 108, 51);
        tituloMenus.setBackground(Color.GRAY);
        tituloMenus.setForeground(new Color(210, 210, 210));
        panel.add(tituloMenus);
        
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 210, 210));
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(158, 45, 100, 2);
        panel.add(separator);
        
        // Labels y Fields
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(new Color(230, 230, 230));
        nombreLabel.setBounds(37, 82, 53, 25);
        panel.add(nombreLabel);
        
        JTextField nombreField = new JTextField();
        nombreField.setBounds(37, 105, 150, 25);
        panel.add(nombreField);
        
        JLabel precioLabel = new JLabel("Precio");
        precioLabel.setForeground(new Color(230, 230, 230));
        precioLabel.setBounds(37, 132, 40, 25);
        panel.add(precioLabel);
        
        JSpinner precioField = new JSpinner();
        precioField.setBounds(37, 153, 150, 25);
        panel.add(precioField);
        
        JLabel stockLabel = new JLabel("Stock");
        stockLabel.setForeground(new Color(230, 230, 230));
        stockLabel.setBounds(37, 181, 53, 25);
        panel.add(stockLabel);
        
        JSpinner stockField = new JSpinner();
        stockField.setBounds(37, 202, 150, 25);
        panel.add(stockField);
        
        JLabel diaLabel = new JLabel("Dia Correspondiente");
        diaLabel.setForeground(new Color(230, 230, 230));
        diaLabel.setBounds(37, 238, 125, 25);
        panel.add(diaLabel);
        
        JComboBox <String> comboBox = new JComboBox();
        comboBox.setBounds(37, 261, 150, 25);
        panel.add(comboBox);
        
        comboBox.addItem("Lunes");
        comboBox.addItem("Martes");
        comboBox.addItem("Miercoles");
        comboBox.addItem("Jueves");
        comboBox.addItem("Viernes");
        
        JLabel descripcionLabel = new JLabel("Descripción");
        descripcionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        descripcionLabel.setForeground(new Color(230, 230, 230));
        descripcionLabel.setBounds(37, 297, 100, 25);
        panel.add(descripcionLabel);
        
        JTextArea descripcionArea = new JTextArea();
        descripcionArea.setBounds(37, 322, 150, 75);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        panel.add(descripcionArea);
        
        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(224, 140, 155, 155);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);
        
        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(242, 315, 118, 25);
        panel.add(subirImagenBtn);
        
        JButton agregarMenuBtn = new JButton("Agregar Menu");
        agregarMenuBtn.setBounds(133, 429, 150, 30);
        panel.add(agregarMenuBtn);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(183, 477, 50, 15);
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
        		MenuDiario.setVisible(true);
        		agregarMenuDiario.this.dispose();
        	}
        });
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
