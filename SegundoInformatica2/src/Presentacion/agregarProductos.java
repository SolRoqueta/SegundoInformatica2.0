package Presentacion;

import javax.swing.*;

import Logica.productos;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agregarProductos extends JFrame {
	
	public productos producto = new productos();
	private int id_productos;
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
        
        JTextField precioField = new JTextField();
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
        imagenLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        panel.add(imagenLabel);
        
        JButton subirImagenBtn = new JButton("Subir Imagen");
        subirImagenBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//Este seccion del codigo se ejecuta cuando el boton Subir Imagen es apretado 
        		
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
        		precio = Integer.parseInt(precioLabel.getText());
//        		foto = 
        		
        		producto.setNombre(nombre);
        		producto.setDescripcion(descripcion);
        		producto.setPrecio(precio);
        		producto.setFoto(foto);
        		
        	}
        });
        agregarProductoBtn.setBounds(115, 322, 150, 30);
        panel.add(agregarProductoBtn);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }
    
}
