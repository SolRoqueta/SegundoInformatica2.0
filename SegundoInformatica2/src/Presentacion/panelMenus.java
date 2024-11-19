package Presentacion;

import Logica.menus;
import Logica.productos;
import Logica.usuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class panelMenus extends JFrame {
	
	public menus menu = new menus();

	private String nombre;
	private String atributo;
	
	private int filtroSeleccionado;
	private int filaSeleccionada;
	
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
        
        JLabel lblFiltro = new JLabel("Filtro: Nombre");
	    lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblFiltro.setForeground(new Color(255, 255, 255));
	    lblFiltro.setBounds(438, 121, 124, 14);
	    panel.add(lblFiltro);
        
        // Etiqueta de Buscar Producto
        JLabel buscarMenuLabel = new JLabel("Buscar Menu");
        buscarMenuLabel.setForeground(new Color(255, 255, 255));
        buscarMenuLabel.setBounds(97, 116, 121, 25);
        panel.add(buscarMenuLabel);
        
        // Campo de texto para buscar productos
        JTextField buscarMenuField = new JTextField();
        buscarMenuField.setBounds(97, 142, 309, 30);
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
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Precio", "Stock", "Descripcion", "Dia"}, 0);
        tablaMenus = new JTable(modeloTabla){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
             }
          };
          tablaMenus.setRowSelectionAllowed(false);
        tablaMenus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaMenus.getTableHeader().setReorderingAllowed(false);
        
        tablaMenus.setRowSelectionAllowed(true);  // Permite la selección de filas
        tablaMenus.setColumnSelectionAllowed(false); // Desactiva la selección de columnas
        tablaMenus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección de una sola fila a la vez (opcional) 
        
	    JScrollPane scrollPane = new JScrollPane(tablaMenus);
	    scrollPane.setBounds(39, 196, 705, 365);
	    panel.add(scrollPane);
	    
	    mostrarMenusTabla("", 4);
	    
	    // Botones 
	    
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
	    
	    tablaMenus.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 1) { 
	                int selectedRow = tablaMenus.rowAtPoint(e.getPoint());
	                if (selectedRow != -1) {
	                    btnEliminar.setEnabled(true);
	                    btnModificar.setEnabled(true);
	                }
	            }
	        }
	    });
	    
	    // Accion Listener Botones
	    
	    // Volver
	    btnVolver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		menuPrincipal ventanaPrincipal = new menuPrincipal();
	    		ventanaPrincipal.setVisible(true);
	    		panelMenus.this.dispose();
	    		
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
	    		        lblFiltro.setText("Filtro: Precio");
	    		        break;

	    		    case 2:
	    		        lblFiltro.setText("Filtro: Stock");
	    		        break;

	    		    case 3:
	    		        lblFiltro.setText("Filtro: Dia");
	    		        break;

	    		    default:
	    		        lblFiltro.setText("Filtro: Desconocido");
	    		        break;
	    		
	    	}
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
	    		
	    		filaSeleccionada = tablaMenus.getSelectedRow();
	    		menus menu = new menus();

	  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
	  		    	
	  		        // Obtenemos los valores de cada columna
	  		    	nombre = tablaMenus.getValueAt(filaSeleccionada, 0).toString(); // Columna 1: Nombre
	  		        	
						try {
							menu = menu.BuscarMenu(nombre);
							
							modificarMenus ventanaModificar = new modificarMenus(nombre);
				    		ventanaModificar.setVisible(true);
				    		panelMenus.this.dispose();
				    		
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	    		
	    	}
	  		    
	    	}
	    });
	    
	    btnEliminar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		filaSeleccionada = tablaMenus.getSelectedRow();
	
	  		    if (filaSeleccionada != -1) { // -1 significa que no hay ninguna fila seleccionada
	  		    	
	  		    	nombre = tablaMenus.getValueAt(filaSeleccionada, 0).toString(); // Columna 1: Nombre
	  		        
	  		    } else {
	  		        System.out.println("No hay ninguna fila seleccionada.");
	  		    }
	    		
	    		try {
	    			
					menu = menu.BuscarMenu(nombre);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		
	    		 int option = JOptionPane.showConfirmDialog(panel, "¿Estás seguro de que quieres eliminar el menu " + nombre + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
	             
	             // Comprobar la respuesta
	             if (option == JOptionPane.YES_OPTION) {
	            	menu.EliminarMenu();
	 	    		modeloTabla.removeRow(filaSeleccionada);
	 	    		JOptionPane.showMessageDialog(panel, "Menu eliminado");
	             } else {
	            	 JOptionPane.showMessageDialog(panel, "Menu no eliminado");
	             }
	    		
	    		
	    		
	    	}
	    });
	    
	    // Key Listener buscador
	    buscarMenuField.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		
        		if (buscarMenuField.getText().equals("")) {
        			mostrarMenusTabla("", 0);
        		} else {
        			
        			if (filtroSeleccionado >= 0 && filtroSeleccionado <= 3) {
        			    atributo = buscarMenuField.getText();
        			    mostrarMenusTabla(atributo, filtroSeleccionado);
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
