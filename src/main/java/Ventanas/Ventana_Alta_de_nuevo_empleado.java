package Ventanas;

import java.awt.*;
import java.util.List;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import Tablas.EMPLOYEES;
import Controladores.employeeDAO;

/**
 * Ventana Swing que permite dar de alta a un nuevo empleado. Incluye campos de
 * entrada, selección de jefe desde un JComboBox, y calendario para la fecha de
 * contratación. Toda la información se recoge y se envía al DAO para ser
 * insertada en la base de datos.
 */
public class Ventana_Alta_de_nuevo_empleado extends JFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JTextField textFieldTrabajo;
	private JComboBox<EMPLOYEES> comboBoxJefes = new JComboBox<>();

	public Ventana_Alta_de_nuevo_empleado() {
		setTitle("1.ALTA DE NUEVO EMPLEADO");

		setSize(700, 400);
		setLocationRelativeTo(null);
		// Este Jframe hara que solo se cierre la ventana sin finalizar el programa
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel nick1 = new JLabel("Nombre");
		nick1.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick1.setBounds(51, 41, 104, 59);
		panel.add(nick1);
		/**
		 * Campo de texto para el nombre del nuevo empleado.
		 */
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(154, 64, 172, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel nick2 = new JLabel("Apellidos");
		nick2.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick2.setBounds(347, 54, 108, 32);
		panel.add(nick2);
		JLabel nick3 = new JLabel("Email");
		nick3.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick3.setBounds(61, 84, 69, 59);
		panel.add(nick3);
		JLabel nick4 = new JLabel("Teléfono");
		nick4.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick4.setBounds(347, 89, 104, 48);
		panel.add(nick4);

		JLabel nick = new JLabel("Jefe");
		nick.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick.setBounds(78, 185, 69, 48);
		panel.add(nick);
		/**
		 * ComboBox que permite seleccionar a un jefe de entre los empleados ya
		 * existentes.
		 */
		comboBoxJefes = new JComboBox<>();
		comboBoxJefes.setBounds(161, 203, 165, 20);
		panel.add(comboBoxJefes);
		cargarJefesEnComboBox();
		// Renderizado personalizado para mostrar solo nombre + apellido
		comboBoxJefes.setRenderer(new ListCellRenderer<EMPLOYEES>() {
			private final DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

			@Override
			public Component getListCellRendererComponent(JList<? extends EMPLOYEES> list, EMPLOYEES value, int index,
					boolean isSelected, boolean cellHasFocus) {
				JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				if (value != null) {
					renderer.setText(value.getFirst_name() + " " + value.getLast_name());
				}
				return renderer;
			}
		});
		/**
		 * Campo de texto para los apellidos del nuevo empleado.
		 */
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(454, 64, 172, 20);
		panel.add(textFieldApellidos);
		/**
		 * Campo de texto para el correo electrónico del nuevo empleado.
		 */
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(154, 107, 172, 20);
		panel.add(textFieldEmail);
		/**
		 * Campo de texto para el número de teléfono del nuevo empleado.
		 */
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(454, 107, 172, 20);
		panel.add(textFieldTelefono);

		JLabel nick6 = new JLabel("Trabajo");
		nick6.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick6.setBounds(51, 138, 104, 48);
		panel.add(nick6);
		/**
		 * Campo de texto para el puesto de trabajo del nuevo empleado.
		 */
		textFieldTrabajo = new JTextField();
		textFieldTrabajo.setColumns(10);
		textFieldTrabajo.setBounds(154, 154, 172, 20);
		panel.add(textFieldTrabajo);
		/**
		 * Campo de Jcalendar JDataChooser que permite en la ventana tener un calendario
		 * interactivo para la seleccion de la fecha de contratacion.
		 */
		JDateChooser dateChooser_fecha_contratacion = new JDateChooser();
		dateChooser_fecha_contratacion.setDateFormatString("dd-MM-yy");
		dateChooser_fecha_contratacion.setDate(new Date());
		dateChooser_fecha_contratacion.setBounds(395, 203, 134, 20);
		panel.add(dateChooser_fecha_contratacion);
		// Configura el botón para insertar el nuevo empleado
		JButton btnNewButton = new JButton("Insertar Empleado");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					try {
						// Aqui recogemos los datos de las entradas escritas en la ventana
						String nombre = textFieldNombre.getText().trim();
						String apellido = textFieldApellidos.getText().trim();
						String email = textFieldEmail.getText().trim();
						String telefono = textFieldTelefono.getText().trim();
						String trabajo = textFieldTrabajo.getText().trim();
						Date fecha = dateChooser_fecha_contratacion.getDate();
						// String managerSeleccionado = (String) comboBoxJefes.getSelectedItem();

						// Una medida de control por si el usuario deja vacio campos
						boolean verificaDatosRellenos = true;
						if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty()
								|| trabajo.isEmpty()) {
							verificaDatosRellenos = false;
						}
						// Convertir la fecha a java.sql.Date
						java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());

						// Obtener el ID del manager para enlistar posibles jefes
						EMPLOYEES managerSeleccionado = (EMPLOYEES) comboBoxJefes.getSelectedItem();
						int managerId = managerSeleccionado != null ? managerSeleccionado.getEmployee_id() : 0;
						// Crear objeto Empleado
						EMPLOYEES nuevoEmpleado = new EMPLOYEES();
						nuevoEmpleado.setFirst_name(nombre);
						nuevoEmpleado.setLast_name(apellido);
						nuevoEmpleado.setEmail(email);
						nuevoEmpleado.setPhone(telefono);
						nuevoEmpleado.setJob_title(trabajo);
						nuevoEmpleado.setHire_date(fechaSQL);
						nuevoEmpleado.setManager_id(managerId);

						// Se crea el objeto dao de la clase employeeDAO para el insert si los campos
						// estan rellenos
						employeeDAO dao = new employeeDAO();

						// Confirmacion de insercion de datos
						if (verificaDatosRellenos == true) {
							dao.insertarDatos(nuevoEmpleado);
							JOptionPane.showMessageDialog(null, "Empleado insertado correctamente.");
						} else {
							JOptionPane.showMessageDialog(null,
									"Empleado no insertado, verifique si los campos estan correctos antes de continuar.");
						}

						// Confirmacion de error de inserion de datos
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error al insertar empleado: " + ex.getMessage());
					}
				}
			}
		});
		btnNewButton.setBounds(225, 255, 235, 23);
		panel.add(btnNewButton);

		JLabel nick7 = new JLabel("Fecha de contratacion");
		nick7.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick7.setBounds(347, 138, 241, 48);
		panel.add(nick7);

		setVisible(true);

	}

	/**
	 * Método privado que consulta a la base de datos para obtener todos los
	 * posibles jefes, y los carga en el comboBox usando renderizado personalizado.
	 */
	private void cargarJefesEnComboBox() {
		List<EMPLOYEES> jefes = employeeDAO.obtenerJefes();
		for (EMPLOYEES jefe : jefes) {
			comboBoxJefes.addItem(jefe);
		}
	}

	/**
	 * Método main que permite ejecutar esta ventana de forma independiente para
	 * pruebas o lanzamientos directos.
	 */
	public static void main(String[] args) {
		// Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(Ventana_Alta_de_nuevo_empleado::new);
	}
}
