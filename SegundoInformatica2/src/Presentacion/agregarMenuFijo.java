package Presentacion;

import Logica.menuFijo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class agregarMenuFijo extends JFrame {

    public menuFijo producto = new menuFijo(); 

    private menuMenuFijo MenuFijo;

	// Declaracion de atributos de Productos
	private String nombre;
	private int precio;
	private int stock;
	private String descripcion;
	private String caminoFoto;

    public agregarMenuFijo(menuMenuFijo MenuFijo) {

        // Configurar la ventana
        setTitle("Agregar Menu Fijo");
        setSize(388, 468);
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

        // Etiqueta de título
        JLabel tituloMenu = new JLabel("MENUS FIJOS", SwingConstants.CENTER);
        tituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tituloMenu.setBounds(132, 33, 108, 51);
        tituloMenu.setBackground(Color.GRAY);
        tituloMenu.setForeground(new Color(210, 210, 210));
        panel.add(tituloMenu);
        
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
        
        JSpinner stockField = new JSpinner();
        stockField.setBounds(24, 202, 150, 25);
        panel.add(stockField);

        JLabel stockLabel = new JLabel("Stock");
        stockLabel.setForeground(new Color(230, 230, 230));
        stockLabel.setBounds(24, 181, 53, 25);
        panel.add(stockLabel);

        // Panel de imagen
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBackground(new Color(255, 255, 255));
        imagenLabel.setBounds(198, 114, 150, 139);
        imagenLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(imagenLabel);

        // Botones
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.setBounds(215, 275, 118, 25);
        panel.add(subirImagenBtn);

        JButton agregarMenuBtn = new JButton("Agregar Menu");
        agregarMenuBtn.setBounds(111, 357, 150, 30);
        panel.add(agregarMenuBtn);
        
        JButton volverBtn = new JButton("←");
        volverBtn.setBounds(161, 401, 50, 15);
        panel.add(volverBtn);

        // Acciones Botones
        
        // Subir Imagen 
        subirImagenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        // AgregarMenuFijo
        agregarMenuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

       // Volver atras
        volverBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuFijo.setVisible(true); // Mostrar el menú principal
                agregarMenuFijo.this.dispose(); // Cerrar la ventana actual
            }
        });
       
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
}
