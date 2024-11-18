package Presentacion;

import Logica.menus;
import Logica.productos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class panelMenus extends JFrame {
	
	public menus menu = new menus();
	// Declaracion de atributos de Productos
	private String nombre;
	
	private DefaultTableModel modeloTabla;
	private JTable tablaMenus;
    
	public panelMenus() {
		presentacionMenus();
	}
	
	// Se encarga de mostrar todos los productos en la tabla
	 	public void mostrarMenusTabla(String atributo, int opcion) {
	 			  
	 	        List<Object[]> infoMenus = menu.BuscarMenus(atributo, opcion);

	 	        modeloTabla.setRowCount(0);

	 	        for (Object[] fila : infoMenus) {
	 	            modeloTabla.addRow(fila);
	 	        }
	 	    
	 	}
		
	
    public void presentacionMenus() {
    	
        // Configurar la ventana
        setTitle("Panel Menus");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        // Etiqueta de título
        JLabel titulo = new JLabel("PANEL", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
        titulo.setBounds(293, 21, 198, 60);
        titulo.setBackground(Color.GRAY);
        titulo.setForeground(new Color(210, 210, 210));
        panel.add(titulo);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(330, 72, 124, 2);
        panel.add(separator);
        
        JLabel lblMenu = new JLabel("MENUS", SwingConstants.CENTER);
        lblMenu.setForeground(new Color(210, 210, 210));
        lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMenu.setBackground(Color.GRAY);
        lblMenu.setBounds(293, 61, 198, 60);
        panel.add(lblMenu);
        
        // Etiqueta de Buscar Producto
        JLabel buscarMenuLabel = new JLabel("Buscar Menu");
        buscarMenuLabel.setForeground(new Color(255, 255, 255));
        buscarMenuLabel.setBounds(177, 117, 121, 25);
        panel.add(buscarMenuLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarMenuField = new JTextField();
        buscarMenuField.setBounds(177, 142, 293, 30);
        panel.add(buscarMenuField);
    
        String[] filtros = {"Nombre", "Precio", "Stock", "Dia"};
        
        JComboBox<String> chcbxOpcionesBuscar = new JComboBox<String>();
        chcbxOpcionesBuscar.setBounds(438, 142, 121, 30);
        chcbxOpcionesBuscar.addItem(filtros[0]);
        chcbxOpcionesBuscar.addItem(filtros[1]);
        chcbxOpcionesBuscar.addItem(filtros[2]);
        chcbxOpcionesBuscar.addItem(filtros[3]);
        panel.add(chcbxOpcionesBuscar);
        
        //Creacion tabla
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Precio", "Descripcion", "Stock", "Dia"}, 0);
        tablaMenus = new JTable(modeloTabla);
        tablaMenus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMenus.getTableHeader().setReorderingAllowed(false);
        
        tablaMenus.setRowSelectionAllowed(true);  // Permite la selección de filas
        tablaMenus.setColumnSelectionAllowed(false); // Desactiva la selección de columnas
        tablaMenus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección de una sola fila a la vez (opcional) 
        
	    JScrollPane scrollPane = new JScrollPane(tablaMenus);
	    scrollPane.setBounds(39, 196, 705, 365);
	    panel.add(scrollPane);
	    
	    mostrarMenusTabla("", 4);
	    
	    JButton btnVolver = new JButton("←");
	    btnVolver.setBounds(10, 11, 50, 15);
	    panel.add(btnVolver);
	    
	    JButton btnAplicarFiltro = new JButton("Aplicar");
	    btnAplicarFiltro.setBounds(574, 142, 121, 30);
	    panel.add(btnAplicarFiltro);
	    
	    JButton btnAgregar = new JButton("Agregar");
	    btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnAgregar.setBounds(86, 588, 145, 40);
	    panel.add(btnAgregar);
	    
	    JButton btnModificar = new JButton("Modificar");
	    btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnModificar.setBounds(318, 588, 145, 40);
	    panel.add(btnModificar);
	    
	    JButton btnEliminar = new JButton("Eliminar");
	    btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    btnEliminar.setBounds(550, 588, 145, 40);
	    panel.add(btnEliminar);

	    // Mouse y Change Listeners
	    
//	    tablaUsuarios.addMouseListener(new MouseAdapter() {
//	        @Override
//	        public void mouseClicked(MouseEvent e) {
//	            if (e.getClickCount() == 1) { 
//	                int selectedRow = tablaUsuarios.rowAtPoint(e.getPoint());
//	                if (selectedRow != -1) {
//	                    btnEliminar.setEnabled(true);
//	                    btnModificar.setEnabled(true);
//	                }
//	            }
//	        }
//	    });
	    
	    // Accion Listener Botones
	    
	    // Volver
	    btnVolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		menuPrincipal ventanaPrincipal = new menuPrincipal();
	    		ventanaPrincipal.setVisible(true);
	    		panelMenus.this.dispose();
	    		
	    	}
	    });
	    
	    btnAgregar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	    		
	    		agregarMenus ventanaAgregar = new agregarMenus();
	    		ventanaAgregar.setVisible(true);
	    		panelMenus.this.dispose();
	    		
	    	}
	    });
	    
	    btnModificar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		modificarMenus ventanaModificar = new modificarMenus();
	    		ventanaModificar.setVisible(true);
	    		panelMenus.this.dispose();
	    	}
	    });
    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    }
}
