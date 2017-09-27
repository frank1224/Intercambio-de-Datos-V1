package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_RegistrarEmpleado extends JFrame {
	private Controller controlador;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textFecha;

	public V_RegistrarEmpleado() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Registrar Empleado");
		setBounds(100, 100, 556, 336);
		setLocationRelativeTo(null);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(56, 48, 63, 14);
		getContentPane().add(label);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(56, 122, 108, 14);
		getContentPane().add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(294, 51, 72, 14);
		getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(383, 48, 86, 20);
		getContentPane().add(textApellido);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(170, 45, 86, 20);
		getContentPane().add(textNombre);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(170, 119, 86, 20);
		getContentPane().add(textDni);
		
		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeEpleado();
				
				controlador.altaEmpleado(textDni.getText(), textNombre.getText(), textApellido.getText(), textFecha.getText());
				
			}
		});
		button.setBounds(296, 209, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(399, 209, 89, 23);
		getContentPane().add(button_1);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(383, 119, 86, 20);
		getContentPane().add(textFecha);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(294, 122, 72, 14);
		getContentPane().add(lblFechaNacimiento);
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}