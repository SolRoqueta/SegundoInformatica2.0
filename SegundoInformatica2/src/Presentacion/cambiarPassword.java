package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

public class cambiarPassword extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	private login Login;
	
	public cambiarPassword(login Login) {
		this.Login = Login;
		
		getContentPane().setBackground(new Color(43, 70, 77));
		getContentPane().setLayout(null);
		
		JLabel lblCambiar = new JLabel("Cambiar");
		lblCambiar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiar.setForeground(new Color(210, 210, 210));
		lblCambiar.setFont(new Font("Tahoma", Font.BOLD, 22));
		setSize(800, 700);
		getContentPane().add(lblCambiar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(103, 71, 100, 2);
		getContentPane().add(separator);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(new Color(210, 210, 210));
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(88, 73, 130, 27);
		getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(88, 148, 130, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar ");
		btnNewButton.setBounds(88, 273, 130, 23);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 209, 130, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(88, 132, 108, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		lblNuevaContrasea.setForeground(Color.WHITE);
		lblNuevaContrasea.setBounds(88, 193, 115, 14);
		getContentPane().add(lblNuevaContrasea);
		setBounds(100, 100, 322, 391);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
		

		
