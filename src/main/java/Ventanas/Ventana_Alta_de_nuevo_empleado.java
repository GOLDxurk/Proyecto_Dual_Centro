package Ventanas;

import java.awt.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Ventana_Alta_de_nuevo_empleado extends JFrame {
	public Ventana_Alta_de_nuevo_empleado() {
		setTitle("1.ALTA DE NUEVO EMPLEADO");
		
		setSize(700, 600);
		setLocationRelativeTo(null);
		// Cierra la ventana del ejercicio formativo pero no para el programa si no se cierra la principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		// Pendiente que este array se llene con los datos de los posibles jefes, estos datos los pilla de la base de datos
		String[] opciones = {""};
		
		JLabel nick = new JLabel("Jefe");
		panel.add(nick);
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		panel.add(comboBox);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(Ventana_Alta_de_nuevo_empleado::new);
	}

}
