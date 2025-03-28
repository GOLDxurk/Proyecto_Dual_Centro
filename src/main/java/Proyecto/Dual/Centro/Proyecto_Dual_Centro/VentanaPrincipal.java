package Proyecto.Dual.Centro.Proyecto_Dual_Centro;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

	//aun en desarrollo
	public VentanaPrincipal() {
		// Título de la ventana
		setTitle("Proyecto Dual en Centro");
		// Tamaño en píxeles
		setSize(700, 600);
		//Cerrar la aplicación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Centrar la ventana en la pantalla
		setLocationRelativeTo(null); 
		String[] opciones = {"manager_id", "primary_key"};
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(50, 50, 120, 30);
		add(comboBox);
		
		JButton boton = new JButton("prueba");
		boton.addActionListener(e -> JOptionPane.showMessageDialog(null, "¡Hola, mundo!"));
		boton.setBounds(50, 50, 120, 30);
		add(boton);
		//Hacer visible la ventana
		setVisible(true); 
	}

	public static void main(String[] args) {
		//Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(VentanaPrincipal::new); 
	}

}
