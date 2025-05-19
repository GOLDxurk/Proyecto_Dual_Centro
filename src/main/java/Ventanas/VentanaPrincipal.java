package Ventanas;

import java.awt.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

	// aun en desarrollo
	public VentanaPrincipal() {
		// Título de la ventana
		setTitle("Proyecto Dual en Centro");
		// Tamaño en píxeles de la pestaña
		setSize(700, 600);
		setLocationRelativeTo(null);
		// Bloquea que se pueda maximizar la pestaña
		setResizable(false);
		// Cerrar la aplicación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Centrar la ventana en la pantalla
		setLocationRelativeTo(null);

		// Permite una mayor personalizacion tanto en los elementos
		// que incluyamos dentro como el fonfo del JPanel
		JPanel panel = new JPanel();
		// Posicion de los elementos dentro del JPanel
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Botones con acceso a las actividades sobre la base de datos
		// los JButton estan en un array para luego ser creados leidos por
		// el bucle for
		JButton[] botones = { new JButton("1.ALTA DE NUEVO EMPLEADO"), new JButton("2.ALTA DE NUEVO ALMACEN"),
				new JButton("3.MODIFICACION DE LOS DATOS DE UN CLIENTE"),
				new JButton("4.PEDIDOS DE UN CLIENTE Y VISTA DETALLE"), new JButton("5.ELIMINACION DE UN EMPLEADO"),
				new JButton("6.TRASPASO Y CIERRE DE ALMACEN"), new JButton("7.APLICAR DESCUENTO POR CATEGORIA"),
				new JButton("8.RANKING DE EMPLEADOS POR VOLUMEN DE VENTAS"),
				new JButton("9.INFORME DE VENTAS DE UN MANAGER"),
				new JButton("10.CANCELAR UN PEDIDO Y DEVOLUCION A ALMACÉN") };
		// Aqui hago un pequeño desplazamiento inicial por estetica de la ventana
		panel.add(Box.createVerticalStrut(10));
		// Insercion de los botones preparado en el array, el contador se enarga de leer
		// el array y ejecutar lasordenes

		for (int i = 0; i < botones.length; i++) {
			JButton boton = botones[i];
			botones[i].setBackground(Color.WHITE);
			botones[i].setMaximumSize(new Dimension(500, 30));
			botones[i].setPreferredSize(new Dimension(500, 30));
			botones[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			// addActionListener permite en este caso abrir la ventana de la clase que
			// contiene el ejercicio formativo 1 y el resto de botones que no sean el 0 en este caso
			// mostraran un mensaje de Ejercicio en desarrollo.
			if (i == 0) {
				boton.addActionListener(e -> new Ventana_Alta_de_nuevo_empleado());
			} else {
				boton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Ejercicio en desarrollo.",
						"Información", JOptionPane.INFORMATION_MESSAGE));
			}
			panel.add(botones[i]);
			panel.add(Box.createVerticalStrut(25));

		}
		// Añade el panel para que los botones existan en la ventana
		add(panel);
		// Hacer visible la ventana
		setVisible(true);
	}

	public static void main(String[] args) {
		// Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(VentanaPrincipal::new);
	}

}
