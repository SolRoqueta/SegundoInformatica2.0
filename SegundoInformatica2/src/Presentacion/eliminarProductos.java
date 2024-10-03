package Presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logica.productos;


public class eliminarProductos extends JFrame {

    private JTextField txtNombreProducto;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextArea txtDescripcion;
    private JLabel lblImagen;

    public eliminarProductos() {
        // Configurar la ventana
        setTitle("Eliminar Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        getContentPane().setLayout(null);

        // Panel superior (Eliminar Productos)
        JPanel panelTop = new JPanel();
        panelTop.setBackground(Color.GRAY);
        panelTop.setBounds(0, 0, 400, 50);
        getContentPane().add(panelTop);
        panelTop.setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("ELIMINAR PRODUCTOS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        panelTop.add(lblTitulo, BorderLayout.CENTER);

        // Etiqueta y campo para Nombre Producto
        JLabel lblNombreProducto = new JLabel("Nombre Producto");
        lblNombreProducto.setBounds(10, 70, 120, 14);
        getContentPane().add(lblNombreProducto);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(140, 67, 150, 20);
        getContentPane().add(txtNombreProducto);
        txtNombreProducto.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 66, 80, 23);
        getContentPane().add(btnBuscar);

        // Campo para Nombre
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 110, 120, 14);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 107, 150, 20);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        // Campo para Precio
        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(10, 150, 120, 14);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(140, 147, 150, 20);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);

        // Área de texto para Descripción
        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(10, 190, 120, 14);
        getContentPane().add(lblDescripcion);

        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(140, 187, 150, 60);
        getContentPane().add(txtDescripcion);

        // Espacio para la imagen
        lblImagen = new JLabel();
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblImagen.setBounds(300, 107, 80, 80);
        getContentPane().add(lblImagen);

        JButton btnSubirImagen = new JButton("Subir Imagen");
        btnSubirImagen.setBounds(300, 197, 110, 23);
        getContentPane().add(btnSubirImagen);

        // Botón para Eliminar Producto
        JButton btnEliminarProducto = new JButton("Eliminar Producto");
        btnEliminarProducto.setBounds(140, 270, 150, 23);
        getContentPane().add(btnEliminarProducto);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    eliminarProductos frame = new eliminarProductos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
