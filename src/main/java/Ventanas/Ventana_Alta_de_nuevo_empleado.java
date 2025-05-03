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
public class Ventana_Alta_de_nuevo_empleado extends JFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JTextField textFieldTrabajo;

	public Ventana_Alta_de_nuevo_empleado() {
		setTitle("1.ALTA DE NUEVO EMPLEADO");
		
		setSize(700, 400);
		setLocationRelativeTo(null);
		// Cierra la ventana del ejercicio formativo pero no para el programa si no se cierra la principal
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nick1 = new JLabel("Nombre");
		nick1.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick1.setBounds(51, 41, 104, 59);
		panel.add(nick1);
		
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
		// Pendiente que este array se llene con los datos de los posibles jefes, estos datos los pilla de la base de datos
				String[] opciones = {""};
		
		JLabel nick = new JLabel("Jefe");
		nick.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick.setBounds(78, 185, 69, 48);
		panel.add(nick);
		JComboBox<String> comboBoxJefes;
		comboBoxJefes = new JComboBox<>(opciones);
		comboBoxJefes.setBounds(161, 203, 165, 20);
		panel.add(comboBoxJefes);
		cargarJefesEnComboBox();
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(454, 64, 172, 20);
		panel.add(textFieldApellidos);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(154, 107, 172, 20);
		panel.add(textFieldEmail);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(454, 107, 172, 20);
		panel.add(textFieldTelefono);
		
		JLabel nick6 = new JLabel("Trabajo");
		nick6.setFont(new Font("Tahoma", Font.BOLD, 20));
		nick6.setBounds(51, 138, 104, 48);
		panel.add(nick6);
		
		textFieldTrabajo = new JTextField();
		textFieldTrabajo.setColumns(10);
		textFieldTrabajo.setBounds(154, 154, 172, 20);
		panel.add(textFieldTrabajo);
		
		JDateChooser dateChooser_fecha_contratacion = new JDateChooser();dateChooser_fecha_contratacion.setDateFormatString("dd-MM-yy");dateChooser_fecha_contratacion.setDate(new Date());dateChooser_fecha_contratacion.setBounds(395,203,134,20);panel.add(dateChooser_fecha_contratacion);
		
		JButton btnNewButton = new JButton("Insertar Empleado");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
				        try {
				            // Aqui recogemos los datos de las entradas escritas en la ventana
				            String nombre = textFieldNombre.getText();
				            String apellido = textFieldApellidos.getText();
				            String email = textFieldEmail.getText();
				            String telefono = textFieldTelefono.getText();
				            String trabajo = textFieldTrabajo.getText();
				            Date fecha = dateChooser_fecha_contratacion.getDate();
				            String managerSeleccionado = (String) comboBoxJefes.getSelectedItem();
				            
				            // Convertir la fecha a java.sql.Date
				            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());

				            // Obtener el ID del manager (suponiendo que el combo tiene algo como "102 - Juan Pérez")
				            int managerId = Integer.parseInt(managerSeleccionado.split(" ")[0]);

				            // 2. Crear objeto Empleado
				            EMPLOYEES nuevoEmpleado = new EMPLOYEES();
				            nuevoEmpleado.setFirst_name(nombre);
				            nuevoEmpleado.setLast_name(apellido);
				            nuevoEmpleado.setEmail(email);
				            nuevoEmpleado.setPhone(telefono);
				            nuevoEmpleado.setJob_title(trabajo);
				            nuevoEmpleado.setHire_date(fechaSQL);
				            nuevoEmpleado.setManager_id(managerId);

				            // Inserta datos usando la clase employeeDAO
				            employeeDAO dao = new employeeDAO();
				            dao.insertarDatos(nuevoEmpleado);

				            // 4. Mensaje de éxito
				            JOptionPane.showMessageDialog(null, "Empleado insertado correctamente.");

				        } catch (Exception ex) {
				            ex.printStackTrace();
				            JOptionPane.showMessageDialog(null, "Error al insertar empleado: " + ex.getMessage());
				        }
				    }
			}});
		btnNewButton.setBounds(225,255,235,23);
		panel.add(btnNewButton);

	JLabel nick7 = new JLabel(
			"Fecha de contratacion");nick7.setFont(new Font("Tahoma",Font.BOLD,20));nick7.setBounds(347,138,241,48);panel.add(nick7);

	

	setVisible(true);
		
	}
	private void cargarJefesEnComboBox() {
        List<EMPLOYEES> jefes = employeeDAO.obtenerJefes();
        for (EMPLOYEES jefe : jefes) {
        	comboBoxJefes.addItem(jefe);
        }
    }
	public static void main(String[] args) {
		// Ejecutar en el hilo de eventos de Swing
		SwingUtilities.invokeLater(Ventana_Alta_de_nuevo_empleado::new);
	}
}
