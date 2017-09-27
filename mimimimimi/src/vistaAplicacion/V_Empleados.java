package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Empleados extends JFrame{
	private Controller controlador;
	private JButton btnEmpleados;
	private JButton btnNotificaciones;
	private JButton btnLugares;
	private JScrollPane scrollPane;
	protected JTable table;
	private JLabel lblFiltro;
	private JButton btnBuscar;
	protected JButton BtnModificar;
	protected JButton BtnEliminar;
	private JLabel lblCampoBsqueda;
	protected JTextField textField;
	protected JButton BtnLimpiar;
	private JButton btnAmpliar;
	private JComboBox<String> registros;
	private JButton btnRegistrar;

	public V_Empleados() {
		initComponents();
	}
	private void initComponents() {
		setTitle("Empleados\n");
		setBounds(100, 100, 842, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		btnEmpleados = new JButton("Empleados");
		btnNotificaciones = new JButton("Notificacion");
		btnLugares = new JButton("Lugares");
		scrollPane = new JScrollPane();
		table = new JTable();
		BtnModificar = new JButton("Modificar");
		BtnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarModificarEmp();
			}
		});
		BtnEliminar = new JButton("Eliminar");
		lblFiltro = new JLabel("Filtro de Búsqueda");
		btnBuscar = new JButton("Buscar");
		BtnLimpiar = new JButton("Limpiar");
		btnAmpliar = new JButton("Ampliar");
		lblCampoBsqueda = new JLabel("Campo Búsqueda");
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		controlador.mostrarBotonvistaEmp();
        	}
        });
		registros = new JComboBox<String>();

		btnEmpleados.setBounds(27, 22, 175, 40);
		getContentPane().add(btnEmpleados);
		btnEmpleados.setEnabled(false);

		btnNotificaciones.setBounds(306, 22, 175, 40);
		getContentPane().add(btnNotificaciones);
		btnNotificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarNotificacion();
			}
		});

		btnLugares.setBounds(584, 22, 175, 40);
		getContentPane().add(btnLugares);
		btnLugares.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				controlador.cambiarLugar();
			}
		});

		scrollPane.setBounds(27, 193, 673, 242);
		getContentPane().add(scrollPane);

		BtnModificar.setBounds(710, 353, 89, 23);
		getContentPane().add(BtnModificar);
		BtnModificar.setEnabled(false);

		BtnEliminar.setBounds(710, 398, 89, 23);
		getContentPane().add(BtnEliminar);
		BtnEliminar.setEnabled(false);

		lblFiltro.setBounds(27, 121, 120, 14);
		getContentPane().add(lblFiltro);

		btnBuscar.setBounds(526, 117, 77, 23);
		getContentPane().add(btnBuscar);

		BtnLimpiar.setBounds(611, 117, 89, 23);
		getContentPane().add(BtnLimpiar);
		BtnLimpiar.setEnabled(false);

		lblCampoBsqueda.setBounds(296, 121, 108, 14);
		getContentPane().add(lblCampoBsqueda);

		btnAmpliar.setBounds(710, 196, 89, 23);
		getContentPane().add(btnAmpliar);

		textField.setBounds(408, 117, 108, 23);
		getContentPane().add(textField);
		textField.setColumns(10);

		registros.setModel(new DefaultComboBoxModel<String>(new String[] { "","CodInterno", "DNI", "Nombre", "Apellido", "FechaNacimiento" }));
		registros.setBounds(145, 117, 126, 23);
		getContentPane().add(registros);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controlador.mostrarBotonvistaEmp();
			}
		});
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},

				new String[] { 
						
				}));
		scrollPane.setViewportView(table);
		
		btnRegistrar = new JButton("Registrar\n");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarRegistrarEmpleado();
			}
		});
		btnRegistrar.setEnabled(true);
		btnRegistrar.setBounds(712, 307, 89, 23);
		getContentPane().add(btnRegistrar);
	}

	//PARA AÑADIR
	
	public void setEmpleado(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"CodInterno", "DNI", "Nombre", "Apellido", "FechaNacimiento"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
/*		table.getColumnModel().getColumn(5).setPreferredWidth(113);
		table.getColumnModel().getColumn(6).setPreferredWidth(92);
		table.getColumnModel().getColumn(7).setPreferredWidth(85);
		table.getColumnModel().getColumn(8).setPreferredWidth(113);
		table.getColumnModel().getColumn(9).setPreferredWidth(92);
		table.getColumnModel().getColumn(10).setPreferredWidth(85);
		table.getColumnModel().getColumn(11).setPreferredWidth(92);
		table.getColumnModel().getColumn(12).setPreferredWidth(92);
		table.getColumnModel().getColumn(13).setPreferredWidth(85);
		table.getColumnModel().getColumn(14).setPreferredWidth(113);
	*/	
	}
	//

	public JTable getTable() {
		return table;
	}
	public JButton getbtnModificar() {
		return BtnModificar;
	}
	public JButton getbtnEliminar() {
		return BtnEliminar;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getbtnLimpiar() {
		return BtnLimpiar;
	}
	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}
}

/*
{ "NBA", "Baloncesto", "092829N", "C/Iverson", "deporte", "Madrid", "02123", "91233432",
							"65244262", "Michael Jordan", "CJ@g.com", "92892828" },
					{ "ACB", "Baloncesto", "3383783F", "C/Gasol", "deporte", "Casteldefels", "09382", "93847473",
							"62788889", " Chrysoprasis ibaca ", "JS@g.com", "88927979" },
					{ "UFC", "Artes marciales mixtas", "3893838G", "C/Silva", "deporte", "Ayora", "08765",
							"95667654", "67878876", "Bruce Lee ", "BL@g.com", "98726265" },
					{ "ABO", "Boxeo", "7873837B", "C/Ali", "deporte", "Lugo", "06527", "96565245", "65676881",
							"Cassius Clay", "CL@g.com", "96767678" },
					{ "N.W.A", "Musica", "9787876W", "C/eazy E", "Arte musical", "Las palmas", "06372", "94565545",
							"67876353", "Ice Cube", "IC@g.com", "96353529" },
					{ "U-tad", "Enseñanza", "9827972S", "C/Newell", "Informatica", "Alava", "07162", "97652526",
							"61524253", "Gabe Newell", "GN@g.com", "98786676" } },
*/

