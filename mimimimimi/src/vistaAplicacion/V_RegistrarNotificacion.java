package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_RegistrarNotificacion extends JFrame {
	private JTextField txtNotificacion;
	private JTextField txtDireccion;
	//private JTextField txtFecha;
	private JTextField txtTipo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private Controller controlador;

	public V_RegistrarNotificacion() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Registrar Notificacion");
		setBounds(100, 100, 519, 238);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		//JLabel lblEmpleado = new JLabel("codnotificacion:");
		JLabel lblDireccion = new JLabel("direccion:");
		//JLabel lblSubvencin = new JLabel("Estado");
		JLabel lblUrgencia = new JLabel("urgencia:");
		JLabel lblTipo = new JLabel("tipo:");
		JComboBox<String> comboUrgencia = new JComboBox<String>();
		txtNotificacion = new JTextField();
		txtDireccion = new JTextField();
		//txtFecha = new JTextField();
		txtTipo = new JTextField();
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		
//		lblEmpleado.setBounds(48, 25, 69, 14);
//		getContentPane().add(lblEmpleado);

		lblDireccion.setBounds(48, 82, 48, 14);
		getContentPane().add(lblDireccion);

//		lblSubvencin.setBounds(61, 143, 54, 14);
//		getContentPane().add(lblSubvencin);

		comboUrgencia.setModel(new DefaultComboBoxModel<String>(new String[] {"baja","media","alta"}));
		comboUrgencia.setBounds(363, 23, 92, 20);
		getContentPane().add(comboUrgencia);

		txtNotificacion.setBounds(127, 22, 115, 20);
		getContentPane().add(txtNotificacion);
		txtNotificacion.setColumns(10);

		txtDireccion.setColumns(10);
		txtDireccion.setBounds(125, 79, 115, 20);
		getContentPane().add(txtDireccion);
		
		lblUrgencia.setBounds(272, 25, 43, 14);
		getContentPane().add(lblUrgencia);

		lblTipo.setBounds(272, 82, 58, 14);
		getContentPane().add(lblTipo);
		
//		txtFecha.setColumns(10);
//		txtFecha.setBounds(110, 176, 115, 20);
//		getContentPane().add(txtFecha);

		txtTipo.setColumns(10);
		txtTipo.setBounds(340, 79, 115, 20);
		getContentPane().add(txtTipo);

		btnGuardar.setBounds(272, 176, 86, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeNotificacion();
				
				controlador.altaNotificacion(txtDireccion.getText(), (String) comboUrgencia.getSelectedItem(), txtTipo.getText());
//controlador.altaSubvencion(txtAso.getText(), textImpo.getText(), txtFecha.getText(), txtActi.getText() ,(String) comboEstado.getSelectedItem());
			}
		});
		
		btnCancelar.setBounds(369, 176, 86, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarRNotificacion();
			}
		});
		

	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}
