package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_ModificarEmpleado extends JFrame {
	private Controller controlador;
	private JTextField txtDenominacinDeLa;
	private JTextField txtCodigoPostal;
	private JTextField txtMunicipioprovincia;
	private JTextField txtDnicif;
	private JTextField txtDireccion;
	private JTextField txtTelf;
	private JTextField txtMail;
	private JTextField txtTelfMovil;
	private JTextField txtFax;
	private JCheckBox chckbxActaOCertificacion;
	private JCheckBox chckbxCertificacionDeDemicilio;
	private JCheckBox chckbxCodigodeCertificacionfiscal;
	private JCheckBox chckbxCopiadelosestatutosdelaasociacionoentidadciudadana;
	private JCheckBox chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM;
	private JLabel lblDenominacióndelaasociacionoentidadciudadana;
	private JLabel lblMunicipio;
	private JLabel lblCdigoPostal;
	private JLabel lblDireccin;
	private JLabel lblTelfFijo;
	private JLabel lblDnicif;
	private JLabel lblMail;
	private JLabel lblTelfMovil;
	private JLabel lblFax;
	private JLabel lblDocumentosAEntregar;

	public V_ModificarEmpleado() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Modificar Asociacion");
		setBounds(100, 100, 842, 504);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		txtDenominacinDeLa = new JTextField();
		txtDenominacinDeLa.setText("NBA");
		txtDenominacinDeLa.setBounds(25, 63, 377, 20);
		getContentPane().add(txtDenominacinDeLa);
		txtDenominacinDeLa.setColumns(10);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setText("28021");
		txtCodigoPostal.setBounds(227, 124, 175, 20);
		getContentPane().add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);

		txtMunicipioprovincia = new JTextField();
		txtMunicipioprovincia.setText("Madrid");
		txtMunicipioprovincia.setBounds(25, 124, 175, 20);
		getContentPane().add(txtMunicipioprovincia);
		txtMunicipioprovincia.setColumns(10);

		txtDnicif = new JTextField();
		txtDnicif.setText("02400870K");
		txtDnicif.setBounds(227, 253, 175, 20);
		getContentPane().add(txtDnicif);
		txtDnicif.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setText("C/Iverson");
		txtDireccion.setBounds(25, 188, 377, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);

		txtTelf = new JTextField();
		txtTelf.setText("91 991 91 91");
		txtTelf.setBounds(25, 253, 175, 20);
		getContentPane().add(txtTelf);
		txtTelf.setColumns(10);

		txtMail = new JTextField();
		txtMail.setText("Basketverde@gmail.com");
		txtMail.setBounds(25, 315, 377, 20);
		getContentPane().add(txtMail);
		txtMail.setColumns(10);

		txtTelfMovil = new JTextField();
		txtTelfMovil.setText("650 45 03 02");
		txtTelfMovil.setBounds(25, 380, 175, 20);
		getContentPane().add(txtTelfMovil);
		txtTelfMovil.setColumns(10);

		txtFax = new JTextField();
		txtFax.setText("91 991 91 97");
		txtFax.setBounds(227, 380, 175, 20);
		getContentPane().add(txtFax);
		txtFax.setColumns(10);

		chckbxActaOCertificacion = new JCheckBox("Acta o Certificacion");
		chckbxActaOCertificacion.setSelected(true);
		chckbxActaOCertificacion.setBounds(426, 77, 156, 23);
		getContentPane().add(chckbxActaOCertificacion);

		chckbxCertificacionDeDemicilio = new JCheckBox("Certificacion de domicilio, sede o sedes sociales");
		chckbxCertificacionDeDemicilio.setBounds(426, 123, 352, 22);
		getContentPane().add(chckbxCertificacionDeDemicilio);

		chckbxCodigodeCertificacionfiscal = new JCheckBox("Codigo de Certificacion fiscal");
		chckbxCodigodeCertificacionfiscal.setBounds(426, 169, 352, 23);
		getContentPane().add(chckbxCodigodeCertificacionfiscal);

		chckbxCopiadelosestatutosdelaasociacionoentidadciudadana = new JCheckBox(
				"Copia de los estatutos de la asociacion o entidad ciudadana");
		chckbxCopiadelosestatutosdelaasociacionoentidadciudadana.setSelected(true);
		chckbxCopiadelosestatutosdelaasociacionoentidadciudadana.setBounds(426, 216, 411, 20);
		getContentPane().add(chckbxCopiadelosestatutosdelaasociacionoentidadciudadana);

		chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM = new JCheckBox(
				"Resoluci\u00F3n de la deleaci\u00F3n provincial correspondiente de la JCMM");
		chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM.setBounds(426, 261, 455, 23);
		getContentPane().add(chckbxResolucióndeladeleaciónprovincialcorrespondientedelaJCMM);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.cerrarMNotificacion();
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(578, 379, 89, 23);
		getContentPane().add(btnGuardar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(681, 380, 89, 23);
		getContentPane().add(btnLimpiar);
		lblDenominacióndelaasociacionoentidadciudadana = new JLabel(
				"Denominación de la asociacion o entidad ciudadana:");
		lblDenominacióndelaasociacionoentidadciudadana.setBounds(25, 38, 377, 16);
		getContentPane().add(lblDenominacióndelaasociacionoentidadciudadana);
		lblMunicipio = new JLabel("Municipio (Provincia):");
		lblMunicipio.setBounds(25, 100, 135, 16);
		getContentPane().add(lblMunicipio);
		lblCdigoPostal = new JLabel("Código postal:");
		lblCdigoPostal.setBounds(227, 100, 135, 16);
		getContentPane().add(lblCdigoPostal);
		lblDireccin = new JLabel("Dirección:");
		lblDireccin.setBounds(25, 167, 135, 16);
		getContentPane().add(lblDireccin);
		lblTelfFijo = new JLabel("Telf Fijo:");
		lblTelfFijo.setBounds(25, 231, 61, 16);
		getContentPane().add(lblTelfFijo);
		lblDnicif = new JLabel("DNI/CIF:");
		lblDnicif.setBounds(227, 231, 61, 16);
		getContentPane().add(lblDnicif);
		lblMail = new JLabel("Mail:");
		lblMail.setBounds(25, 295, 61, 16);
		getContentPane().add(lblMail);
		lblTelfMovil = new JLabel("Telf Movil:");
		lblTelfMovil.setBounds(25, 360, 73, 16);
		getContentPane().add(lblTelfMovil);
		lblFax = new JLabel("Fax:");
		lblFax.setBounds(227, 360, 61, 16);
		getContentPane().add(lblFax);
		lblDocumentosAEntregar = new JLabel("Documentos a entregar:");
		lblDocumentosAEntregar.setBounds(426, 38, 156, 16);
		getContentPane().add(lblDocumentosAEntregar);
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}
