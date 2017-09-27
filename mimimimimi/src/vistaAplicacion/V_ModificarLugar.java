package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_ModificarLugar extends JFrame {
	private JTextField txtAso;
	private JTextField textImpo;
	private JTextField txtFecha;
	private JTextField txtActi;
	private Controller controlador;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtBaloncesto;
	private JButton btnGuardar;
	private JButton btnCancelar;

	public V_ModificarLugar() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Actividad");
		setBounds(100, 100, 535, 275);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblAsociacin = new JLabel("Actividad:");
		JLabel lblImporte = new JLabel("Fecha:");
		JLabel lblFecha = new JLabel("Tipo:");
		JLabel lblActividad = new JLabel("Nº Destinatarios:");
		JLabel lblLugar = new JLabel("Lugar:");
		JLabel lblOrganizador = new JLabel("Organizador:");
		JLabel lblTipoAsocia = new JLabel("Tipo Actividad:");
		txtAso = new JTextField("Baloncesto");
		textImpo = new JTextField("Jordan");
		txtFecha = new JTextField("Deporte");
		txtActi = new JTextField("Madrid");
		txtBaloncesto = new JTextField("Baloncesto");
		textField_1 = new JTextField("12/10/2017");
		textField = new JTextField("1");
		btnGuardar = new JButton("Guardar");
		btnCancelar = new JButton("Cancelar");
		
		lblAsociacin.setBounds(44, 34, 63, 14);
		getContentPane().add(lblAsociacin);
		
		lblImporte.setBounds(297, 146, 59, 14);
		getContentPane().add(lblImporte);
		
		lblFecha.setBounds(297, 34, 59, 14);
		getContentPane().add(lblFecha);

		lblActividad.setBounds(44, 146, 108, 14);
		getContentPane().add(lblActividad);
		
		lblLugar.setBounds(297, 91, 59, 14);
		getContentPane().add(lblLugar);

		txtFecha.setColumns(10);
		txtFecha.setBounds(368, 31, 86, 20);
		getContentPane().add(txtFecha);

		txtActi.setColumns(10);
		txtActi.setBounds(368, 88, 86, 20);
		getContentPane().add(txtActi);
		
		txtAso.setBounds(158, 31, 86, 20);
		getContentPane().add(txtAso);
		txtAso.setColumns(10);

		textImpo.setColumns(10);
		textImpo.setBounds(158, 88, 86, 20);
		getContentPane().add(textImpo);

		textField.setColumns(10);
		textField.setBounds(158, 143, 86, 20);
		getContentPane().add(textField);

		textField_1.setColumns(10);
		textField_1.setBounds(365, 143, 86, 20);
		getContentPane().add(textField_1);

		lblOrganizador.setBounds(44, 91, 108, 14);
		getContentPane().add(lblOrganizador);

		lblTipoAsocia.setBounds(44, 197, 108, 14);
		getContentPane().add(lblTipoAsocia);

		txtBaloncesto.setColumns(10);
		txtBaloncesto.setBounds(158, 192, 86, 20);
		getContentPane().add(txtBaloncesto);
		
		btnGuardar.setBounds(284, 195, 89, 23);
		getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cerrarMLugar();
			}
		});

		btnCancelar.setBounds(387, 195, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarMLugar();;
			}
		});

	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}