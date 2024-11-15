package Presentacion;

import Logica.usuarios;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class panelUsuarios extends JFrame {
	
	public usuarios usuario = new usuarios();
	
	// Declaracion de atributos de Productos
	private String nombre;
	private int filtroSeleccionado;
	private String atributo;
	
	private DefaultTableModel modeloTabla;
	private JTable tablaUsuarios;
    
    public panelUsuarios() {
    	
    	presentacionUsuarios();
    }
    
    // Se encarga de mostrar todos los productos en la tabla
 	public void mostrarUsuariosTabla(String atributo, int opcion) {
 			  
 	        List<Object[]> infoUsuarios = usuario.BuscarUsuarios(atributo, opcion);

 	        modeloTabla.setRowCount(0);

 	        for (Object[] fila : infoUsuarios) {
 	            modeloTabla.addRow(fila);
 	        }
 	    
 	}
    
    public void presentacionUsuarios() {
    	
        // Configurar la ventana
        setTitle("Panel Usuarios");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(43, 70, 77));
        panel.setLayout(null);
        
        JLabel tituloPanel = new JLabel("PANEL", SwingConstants.CENTER);
        tituloPanel.setFont(new Font("Tahoma", Font.BOLD, 35));
        tituloPanel.setBounds(293, 21, 198, 60);
        tituloPanel.setBackground(Color.GRAY);
        tituloPanel.setForeground(new Color(210, 210, 210));
        panel.add(tituloPanel);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(210, 210, 210));
        separator.setBounds(330, 72, 124, 2);
        panel.add(separator);
        
        JLabel tituloUsuarios = new JLabel("USUARIOS", SwingConstants.CENTER);
        tituloUsuarios.setForeground(new Color(210, 210, 210));
        tituloUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloUsuarios.setBackground(Color.GRAY);
        tituloUsuarios.setBounds(293, 61, 198, 60);
        panel.add(tituloUsuarios);
        
        JLabel lblFiltro = new JLabel("Filtro: Nombre");
	    lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblFiltro.setForeground(new Color(255, 255, 255));
	    lblFiltro.setBounds(438, 121, 124, 14);
	    panel.add(lblFiltro);
        
        // Etiqueta de Buscar Producto
        JLabel lblBuscarUsuario = new JLabel("Buscar Usuario");
        lblBuscarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblBuscarUsuario.setForeground(new Color(255, 255, 255));
        lblBuscarUsuario.setBounds(97, 116, 121, 25);
        panel.add(lblBuscarUsuario);
        
        // Campo de texto para buscar productos
        JTextField buscarUsuarioField = new JTextField();
        buscarUsuarioField.setBounds(97, 142, 309, 30);
        panel.add(buscarUsuarioField);
        
        String[] filtros = {"Nombre", "Mail", "Tipo", "Fecha"};
        
        JComboBox chcbxOpcionesBuscar = new JComboBox();
        chcbxOpcionesBuscar.setBounds(438, 142, 121, 30);
        chcbxOpcionesBuscar.addItem(filtros[0]);
        chcbxOpcionesBuscar.addItem(filtros[1]);
        chcbxOpcionesBuscar.addItem(filtros[2]);
        chcbxOpcionesBuscar.addItem(filtros[3]);
        panel.add(chcbxOpcionesBuscar);
        
        //Creacion tabla
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Mail", "Tipo", "Ultimo Acceso"}, 0);
        tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        
        tablaUsuarios.setRowSelectionAllowed(true);  // Permite la selección de filas
        tablaUsuarios.setColumnSelectionAllowed(false); // Desactiva la selección de columnas
        tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección de una sola fila a la vez (opcional) 
        
	    JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
	    scrollPane.setBounds(39, 196, 705, 365);
	    panel.add(scrollPane);
	    
	    mostrarUsuariosTabla("", 3);
    
	    //Botones
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
    
	    
	    // Accion Listeners Botones
	    
	    // Volver Atras
	    btnVolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		menuPrincipal ventanaPrincipal = new menuPrincipal();
	    		ventanaPrincipal.setVisible(true);
	    		panelUsuarios.this.dispose();
	    	}
	    });
	    
	    // Agregar Usuario
	    btnAgregar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {	
	    		
				agregarUsuarios ventanaAgregar = new agregarUsuarios();
				ventanaAgregar.setVisible(true);
				panelUsuarios.this.dispose();	
			}
	    });
	    
	    btnAplicarFiltro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		  filtroSeleccionado = chcbxOpcionesBuscar.getSelectedIndex();
	    		  
	    		  switch (filtroSeleccionado) {
	    		    case 0:
	    		        lblFiltro.setText("Filtro: Nombre");
	    		        break;

	    		    case 1:
	    		        lblFiltro.setText("Filtro: Mail");
	    		        break;

	    		    case 2:
	    		        lblFiltro.setText("Filtro: Tipo");
	    		        break;

	    		    case 3:
	    		        lblFiltro.setText("Filtro: Fecha");
	    		        break;

	    		    default:
	    		        lblFiltro.setText("Filtro: Desconocido");
	    		        break;
	    		} 
	    		 
	    	}
	    });
	    
	    btnModificar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		modificarUsuarios ventanaModificar = new modificarUsuarios();
	    		ventanaModificar.setVisible(true);
	    		panelUsuarios.this.dispose();
	    	}
	    });
	    
	    buscarUsuarioField.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		
        		if (buscarUsuarioField.getText().equals("")) {
        			mostrarUsuariosTabla("", 0);
        		} else {
        			
        			if (filtroSeleccionado >= 0 && filtroSeleccionado <= 3) {
        			    atributo = buscarUsuarioField.getText();
        			    mostrarUsuariosTabla(atributo, filtroSeleccionado);
        			} else {
        			    throw new IllegalArgumentException("Filtro seleccionado no válido: " + filtroSeleccionado);
        			}
        			
        		}
        		
        	}
        });
	    
	    
	    
    
    // Agregar el panel a la ventana
    getContentPane().add(panel);
    
    }
    
}
