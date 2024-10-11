package Presentacion;

import javax.swing.*;
import java.awt.*;

public class menuMenuDiario extends JFrame {
	public menuMenuDiario() {

        // Create the frame
        JFrame frame = new JFrame("Menu Reservas");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(309, 368);
        frame.getContentPane().setLayout(null);
        
                // Welcome Label
                JLabel labelTitulo = new JLabel("MENU RESERVAS", SwingConstants.CENTER);
                labelTitulo.setBackground(Color.WHITE);
                labelTitulo.setBounds(-1, -1, 295, 64);
                frame.getContentPane().add(labelTitulo);
                labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
                labelTitulo.setBackground(Color.GRAY);
                labelTitulo.setOpaque(true);
                labelTitulo.setForeground(new Color(255, 255, 255));
                
                        // Boton para Agregar Reservas
                        JButton btnAgregarReservas= new JButton("Agregar");
                        btnAgregarReservas.setBounds(80, 100, 125, 31);
                        frame.getContentPane().add(btnAgregarReservas);
                        
                        // Boton para Modificar Reservas
                        JButton btnModificarReservas = new JButton("Modificar");
                        btnModificarReservas.setBounds(80, 150, 125, 31);
                        frame.getContentPane().add(btnModificarReservas);
                                
                        // Boton para Eliminar Reservas
                        JButton btnEliminarReservas = new JButton("Eliminar");
                        btnEliminarReservas.setBounds(80, 200, 125, 31);
                        frame.getContentPane().add(btnEliminarReservas);
                        
                        // Boton para Listar Reservas
                        JButton btnListarReservas = new JButton("Listar");
                        btnListarReservas.setBounds(80, 250, 125, 31);
                        frame.getContentPane().add(btnListarReservas);

        // Make the frame visible
        frame.setVisible(true);
        
	}
}
