package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_RegistrarLugar extends JFrame {
	private JTextField txtNombreLugar;
	//private JTextField txtOrganizador;
	//private JTextField txtTipo;
	private JTextField txtDireccion;
	private Controller controlador;
	private JTextField txtTelLugar;
//	private JTextField txtFecha;
//	private JTextField txtTipoAct;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public V_RegistrarLugar() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Lugar");
		setBounds(100, 100, 535, 275);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblAsociacin = new JLabel("Nombre");
		//JLabel lblImporte = new JLabel("Fecha:");
		//JLabel lblFecha = new JLabel("Tipo:");
		JLabel lblActividad = new JLabel("Telefono");
		JLabel lblLugar = new JLabel("Direccion");
		//JLabel lblOrganizador = new JLabel("Organizador:");
		//JLabel lblTipoAsocia = new JLabel("Tipo Actividad:");
		txtNombreLugar = new JTextField();
		//txtOrganizador = new JTextField();
		//txtTipo = new JTextField();
		txtDireccion = new JTextField();
		//txtTipoAct = new JTextField();
		//txtFecha = new JTextField();
		txtTelLugar = new JTextField();
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");

		lblAsociacin.setBounds(44, 34, 63, 14);
		getContentPane().add(lblAsociacin);

//		lblImporte.setBounds(297, 146, 59, 14);
//		getContentPane().add(lblImporte);
//
//		lblFecha.setBounds(297, 34, 59, 14);
//		getContentPane().add(lblFecha);

		lblActividad.setBounds(44, 108, 108, 14);
		getContentPane().add(lblActividad);

		lblLugar.setBounds(284, 72, 72, 14);
		getContentPane().add(lblLugar);

//		txtTipo.setColumns(10);
//		txtTipo.setBounds(368, 31, 86, 20);
//		getContentPane().add(txtTipo);

		txtDireccion.setColumns(10);
		txtDireccion.setBounds(368, 69, 86, 20);
		getContentPane().add(txtDireccion);

		txtNombreLugar.setBounds(158, 31, 86, 20);
		getContentPane().add(txtNombreLugar);
		txtNombreLugar.setColumns(10);

//		txtOrganizador.setColumns(10);
//		txtOrganizador.setBounds(158, 88, 86, 20);
//		getContentPane().add(txtOrganizador);

		txtTelLugar.setColumns(10);
		txtTelLugar.setBounds(164, 105, 86, 20);
		getContentPane().add(txtTelLugar);

//		txtFecha.setColumns(10);
//		txtFecha.setBounds(365, 143, 86, 20);
//		getContentPane().add(txtFecha);

//		lblOrganizador.setBounds(44, 91, 108, 14);
//		getContentPane().add(lblOrganizador);
//
//		lblTipoAsocia.setBounds(44, 197, 108, 14);
//		getContentPane().add(lblTipoAsocia);

//		txtTipoAct.setColumns(10);
//		txtTipoAct.setBounds(158, 192, 86, 20);
//		getContentPane().add(txtTipoAct);

		btnGuardar.setBounds(284, 195, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mensajeRLugar();
				
				controlador.altaLugar(txtNombreLugar.getText(),txtTelLugar.getText(),txtDireccion.getText());
			}
		});

		btnCancelar.setBounds(387, 195, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarRLugar();
				;
			}
		});
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}