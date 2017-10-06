package vistaAplicacion;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controladorAplicacion.Controller;

@SuppressWarnings("serial")
public class V_Notificaciones extends JFrame {
	private Controller controlador;
	private JButton btnAsociaciones;
	private JButton btnSubvenciones;
	private JButton btnActividades;
	private JScrollPane scrollPane;
	protected JTable table;
	private JLabel lblFiltro;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	protected JButton btnEliminar;
	private JLabel lblCampoBsqueda;
	protected JTextField busquedatxt;
	protected JButton btnLimpiar;
	private JComboBox<String> registros;
	private JButton btnCargarTxt;
	
	public V_Notificaciones() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Subvenciónes");
		setBounds(100, 100, 842, 504);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		btnAsociaciones = new JButton("Empleados");
		btnSubvenciones = new JButton("Notificaciones");
        btnActividades = new JButton("Lugares");
        scrollPane = new JScrollPane();
		table = new JTable();
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.BorrarNotificacion();
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
        
        btnAsociaciones.setBounds(27, 22, 175, 40);
        getContentPane().add(btnAsociaciones);
        btnAsociaciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
               controlador.cambiarEmpleado();
            }
        });
        
        btnSubvenciones.setBounds(346, 22, 175, 40);
        getContentPane().add(btnSubvenciones);
        btnSubvenciones.setEnabled(false);
        
        
        btnActividades.setBounds(624, 22, 175, 40);
        getContentPane().add( btnActividades);
        btnActividades.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	controlador.cambiarLugar();
            }
        });
        
        scrollPane.setBounds(27, 193, 673, 242);
        getContentPane().add(scrollPane);
        
        btnEliminar.setBounds(710, 398, 89, 23);
        getContentPane().add(btnEliminar);
        btnEliminar.setEnabled(false);
        
        btnRegistrar.setBounds(710, 308, 89, 23);
        getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controlador.cambiarRegistrarNot();
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
        		controlador.mostrarBotonVistaNot();
        	}
        });
        
        registros.setModel(new DefaultComboBoxModel<String>(new String[] {"","CodNotificacion", "Direccion", "NivelUrgencia", "TipoUrgencia"}));
        registros.setBounds(145, 117, 126, 23);
        getContentPane().add(registros);
        
        table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controlador.mostrarBotonVistaNot();
			}
		});
        table.setModel(new DefaultTableModel(
                new Object [][] {
                	
                },
                new String [] {
                    "Asociación", "Fecha", "Actividad", "Importe", "Subvención"
                }
            ));
        scrollPane.setViewportView(table);  
        
        JButton button = new JButton("Eliminar todo");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					controlador.BorrarTodoNotificacion();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        button.setEnabled(true);
        button.setBounds(712, 355, 120, 23);
        getContentPane().add(button);
        
        btnCargarTxt = new JButton("Cargar txt");
        btnCargarTxt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnCargarTxt.setBounds(712, 257, 117, 29);
        getContentPane().add(btnCargarTxt);
	}
	//PARA AÑADIR
	public void setNotificacion(Object[][] tabla) {
		table.setModel(new DefaultTableModel(tabla, new String[] {
				"CodNotificacion", "Direccion", "NivelUrgencia", "TipoUrgencia"}));
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

	/*public JButton getBtnModificar() {
		return btnModificar;
	}*/

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
/*{"NBA", "12/10/2016", "Baloncesto", "1200,00€", "Concedida"},
{"ACB", "11/01/2017", "Baloncesto", "1000,00€", "Pendiente"},
{"UFC", "8/12/2016", "Artes marciales mixtas", "1300,00€", "Pendiente"},
{"ABO", "3/03/2017", "Boxeo", "1000,00€", "Pendiente"},
{"N.W.A", "2/02/2017", "Musica", "2000,00€", "Concedida"},
{"U-tad", "5/04/2016", "Enseñanza", "1000,00€", "Concedida"},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null},
{null, null, null, null, null, null, null}*/
