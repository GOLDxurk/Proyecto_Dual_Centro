package Ventanas;

import java.awt.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Ventana_Alta_de_nuevo_empleado extends JFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JTextField textFieldTrabajo;
	public Ventana_Alta_de_nuevo_empleado() {
		setTitle("1.ALTA DE NUEVO EMPLEADO");
		
		setSize(700, 600);
		setLocationRelativeTo(null);
		// Cierra la ventana del ejercicio formativo pero no para el programa si no se cierra la principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nick1 = new JLabel("Nombre");
		nick1.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick1.setBounds(190, 18, 104, 59);
		panel.add(nick1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(291, 41, 172, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel nick2 = new JLabel("Apellidos");
		nick2.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick2.setBounds(186, 74, 108, 32);
		panel.add(nick2);
		JLabel nick3 = new JLabel("Email");
		nick3.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick3.setBounds(219, 108, 69, 59);
		panel.add(nick3);
		JLabel nick4 = new JLabel("Teléfono");
		nick4.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick4.setBounds(190, 155, 104, 48);
		panel.add(nick4);
		// Pendiente que este array se llene con los datos de los posibles jefes, estos datos los pilla de la base de datos
		String[] opciones = {""};
		
		JLabel nick = new JLabel("Jefe");
		nick.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick.setBounds(200, 249, 69, 48);
		panel.add(nick);
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(327, 267, 29, 20);
		panel.add(comboBox);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(291, 84, 172, 20);
		panel.add(textFieldApellidos);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(291, 131, 172, 20);
		panel.add(textFieldEmail);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(291, 173, 172, 20);
		panel.add(textFieldTelefono);
		
		JLabel nick6 = new JLabel("Trabajo");
		nick6.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick6.setBounds(190, 193, 104, 48);
		panel.add(nick6);
		
		textFieldTrabajo = new JTextField();
		textFieldTrabajo.setColumns(10);
		textFieldTrabajo.setBounds(291, 211, 172, 20);
		panel.add(textFieldTrabajo);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(Ventana_Alta_de_nuevo_empleado::new);
	}
}
