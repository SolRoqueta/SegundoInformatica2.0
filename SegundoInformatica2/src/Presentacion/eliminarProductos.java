package Presentacion;
import javax.swing.*;
import java.awt.*;

public class eliminarProductos extends JFrame {
    
    public eliminarProductos() {
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setSize(271, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null); // Usamos layout nulo para posicionar los elementos manualmente
        panel.setBackground(Color.LIGHT_GRAY);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("ELIMINAR PRODUCTOS", SwingConstants.CENTER);
        titulo.setBounds(0, 0, 255, 51);
        titulo.setOpaque(true);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        // Etiqueta de Buscar Producto
        JLabel buscarProductoLabel = new JLabel("Buscar Producto");
        buscarProductoLabel.setBounds(39, 89, 101, 25);
        panel.add(buscarProductoLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarProductoField = new JTextField();
        buscarProductoField.setBounds(39, 115, 120, 25);
        panel.add(buscarProductoField);
        
        // ComboBox para seleccionar un criterio o categoría
        JComboBox<String> comboBox = new JComboBox<>(new String[] {"ID", "Nombre", "Categoría"});
        comboBox.setBounds(171, 115, 61, 25);
        panel.add(comboBox);
        
        // Botón Eliminar Producto
        JButton eliminarProductoBtn = new JButton("Eliminar Producto");
        eliminarProductoBtn.setBounds(52, 193, 150, 30);
        panel.add(eliminarProductoBtn);
        
        // Agregar el panel a la ventana
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            eliminarProductos ventana = new eliminarProductos();
            ventana.setVisible(true);
        });
    }
}
