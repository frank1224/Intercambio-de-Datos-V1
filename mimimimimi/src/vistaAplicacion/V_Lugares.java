package vistaAplicacion;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Lugares extends JFrame{
	private Controller controlador;
	private JButton btnEmpleados;
	private JButton btnNotificaciones;
	private JButton btnLugares;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblFiltro;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblCampoBsqueda;
	private JTextField busquedatxt;
	private JButton btnLimpiar;
	private JComboBox<String> registros;
	
	public V_Lugares() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Actividades");
		setBounds(100, 100, 842, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		btnEmpleados = new JButton("Empleados");
		btnNotificaciones = new JButton("Notificaciones");
        btnLugares = new JButton("Lugares");
        scrollPane = new JScrollPane();
		table = new JTable();
        btnModificar = new JButton("Eliminar todo");
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	try {
				controlador.BorrarLugar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        		
        	}
        });
        lblFiltro = new JLabel("Filtro de Búsqueda");
        btnBuscar = new JButton("Buscar");
        btnLimpiar = new JButton("Limpiar");
        btnRegistrar = new JButton("Registrar");
        lblCampoBsqueda = new JLabel("Campo Búsqueda");
        busquedatxt = new JTextField();
        registros = new JComboBox<String>();
        
        btnEmpleados.setBounds(27, 22, 175, 40);
        getContentPane().add(btnEmpleados);
        btnEmpleados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
               controlador.cambiarEmpleado();;
            }
        });
        
        btnNotificaciones.setBounds(312, 22, 175, 40);
        getContentPane().add(btnNotificaciones);
        btnNotificaciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	controlador.cambiarNotificacion();
            }
        });
        
        btnLugares.setBounds(590, 22, 175, 40);
        getContentPane().add( btnLugares);
        btnLugares.setEnabled(false);
        
        scrollPane.setBounds(27, 193, 673, 242);
        getContentPane().add(scrollPane);
        
        btnModificar.setBounds(710, 353, 120, 23);
        getContentPane().add(btnModificar);
        btnModificar.setEnabled(true);
        btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlador.cambiarModificarLg();
				try {
					controlador.BorrarTodoLugar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        btnEliminar.setBounds(710, 398, 89, 23);
        getContentPane().add(btnEliminar);
        btnEliminar.setEnabled(false);
        
        btnRegistrar.setBounds(710, 308, 89, 23);
        getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarRegistrarLugar();
			}
		});
        
        lblFiltro.setBounds(27, 121, 120, 14);
        getContentPane().add(lblFiltro);
        
        btnBuscar.setBounds(526, 117, 77, 23);
        getContentPane().add(btnBuscar);
        
        btnLimpiar.setBounds(611, 117, 89, 23);
        getContentPane().add(btnLimpiar);
        btnLimpiar.setEnabled(false);
        
        lblCampoBsqueda.setBounds(296, 121, 108, 14);
        getContentPane().add(lblCampoBsqueda);
        
        busquedatxt.setBounds(408, 117, 108, 23);
        getContentPane().add(busquedatxt);
        busquedatxt.setColumns(10);
        busquedatxt.addKeyListener(new KeyAdapter() {
        	public void keyReleased(KeyEvent e) {
        		controlador.mostrarBotonVistaLg();
        	}
        });
        
        registros.setModel(new DefaultComboBoxModel<String>(new String[] { "","CodParque", "Nombre", "Telefono", "Direccion"}));
        registros.setBounds(145, 117, 126, 23);
        getContentPane().add(registros);
        
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controlador.mostrarBotonVistaLg();
			}
		});
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		
        	},
        	new String[] {
        		"Nombre actividad", "Fecha", "Lugar", "Tipo actividad", "Tipo", "N\u00BADestinatarios", "Organizador"
        	}
        ));
        scrollPane.setViewportView(table);  
        
        JButton btnCargarTxt = new JButton("Cargar txt");
        btnCargarTxt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        	}
        });
        btnCargarTxt.setBounds(712, 256, 117, 29);
        getContentPane().add(btnCargarTxt);
	}
	//PARA AÑADIR
	public void setLugar(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"CodParque", "Nombre", "Telefono", "Direccion"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(113);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		//table.getColumnModel().getColumn(4).setPreferredWidth(85);
	
	}
	//
	
	public JTable getTable() {
		return table;
	}

	public JButton getbtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTextField getBusquedatxt() {
		return busquedatxt;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public void setControlador(Controller controlador){
		this.controlador = controlador;
	}
}
/*{"Baloncesto", "12/10/2017", "Madrid", "Baloncesto", "deporte", "1", "Michael Jordan"},
{"Baloncesto", "11/01/2017", "Casteldefels", "Baloncesto", "deporte", "2", "Chrysoprasis ibaca "},
{"Artes marciales mixtas", "8/12/2016", "Ayora", "Artes marciales mixtas", "deporte", "3", "Anderson Silva"},
{"Boxeo", "3/03/2017", "Lugo", "Boxeo", "deporte", "4", "Mohamed Ali"},
{"Musica", "2/02/2017", "Las Palmas", "Musica", "Arte Musical", "5", "Dr.Dre"},
{"Ense\u00F1anza", "5/04/2016", "Alava", "Ense\u00F1anza", "Informatica", "6", "Gabe Newell"},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},*/
