package modeloAplicacion;

import java.sql.*;
import java.util.Properties;

import vistaAplicacion.V_Lugares;
import vistaAplicacion.V_Empleados;
import vistaAplicacion.V_Notificaciones;
import vistaAplicacion.V_RegistrarEmpleado;
//import vistaAplicacion.V_RegistrarActividad;
import vistaAplicacion.V_RegistrarLugar;
import vistaAplicacion.V_RegistrarNotificacion;

public class Modelo {
	private String database = "proteccioncivil";
	private String user = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + database;
	private Connection connect;

	private String[][] ArraydatosEmpleado;
	private V_Empleados VAsociacion;
	private String[][] ArraydatosLugar;
	private V_Lugares VActividades;
	private String[][] ArraydatosNotificacion;
	private V_Notificaciones VSubvencion;
	private V_RegistrarLugar RLugar;
	private V_RegistrarNotificacion RNotificacion;
	private V_RegistrarEmpleado REmpleado;
	private AccesoDatos ACdatos;
	private BDManager BDmanager;

	public Modelo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, pwd);
			System.out.println("Database connection enabled");
		} catch (Exception e) {
			System.out.println("Could not connect with database");
			e.printStackTrace();
		}
	}
	/*
	 * public void getDataAso(int row){ try{ String query =
	 * "SELECT * FROM asociacion"; Statement stmt = connect.createStatement();
	 * ResultSet rset = stmt.executeQuery(query); while(rset.next()){
	 * System.out.println(rset.getString(row)); } rset.close(); stmt.close();
	 * }catch(Exception e){ e.printStackTrace(); } }
	 */

	

	

public void intercambiaDatos(){

	String[][] ArraydatosLugar;
	
	
//HashMap<entidad> lista;

/* Se podría hacer new de cualquier clase que implemente la interface */

AccesoDatos emisor = new BDManager();

AccesoDatos receptor = new FileManager();

ArraydatosLugar = emisor.leeTodos();

receptor.escribeTodos(ArraydatosLugar);

}



	public void DataEmpl() {
		try {
			// String query = "Select * from gestionAsociaciones.asociacion";
			String query = "Select * from proteccioncivil.Empleado";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosEmpleado = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosEmpleado[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void registrarEmpleado(String dni, String nombre, String apellido, String fechanaciemiento) {
		try {
			String sql = "Insert into proteccioncivil.Empleado (`dni`,`nombre`,`apellido`,`fechanaciemiento`) values (?, ?, ?, ?)";

			// String sql2 = "Insert into proteccioncivil.asigna
			// (`codinterno`,`codparque`) values (?, ?)";

			PreparedStatement stmt = connect.prepareStatement(sql);
			// PreparedStatement stmt2 = connect.prepareStatement(sql2);

			// stmt2.setString(1, codigointerno2);
			stmt.setString(1, dni);
			// stmt2.setString(2, codparque);
			stmt.setString(2, nombre);
			stmt.setString(3, apellido);
			stmt.setString(4, fechanaciemiento);

			stmt.executeUpdate();
			// stmt2.executeUpdate();
			stmt.close();
			// stmt2.close();
			cargarDatosTablas();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void DataInsta() {
		try {
			String query = "Select * from proteccioncivil.instalacion";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosLugar = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosLugar[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void DataNotifi() {
		try {
			String query = "Select * from proteccioncivil.notificacion";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			ResultSetMetaData rmsd = rset.getMetaData();

			rset.last();
			int a = rmsd.getColumnCount();
			int b = rset.getRow();
			rset.beforeFirst();

			ArraydatosNotificacion = new String[b][a];
			for (int i = 0; i < b; i++) {
				if (rset.next()) {
					for (int j = 0; j < a; j++) {
						ArraydatosNotificacion[i][j] = rset.getString((j + 1));
					}
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void registrarNotificacion(String direccion, String urgencia, String tipo) {

		try {
			String sql = "Insert into proteccioncivil.Notificacion (`direccion`,`urgencia`,`tipo`) values ( ?, ?,?)";
			PreparedStatement stmt = connect.prepareStatement(sql);

			stmt.setString(1, direccion);
			stmt.setString(2, urgencia);
			stmt.setString(3, tipo);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void registrarLugar(String nombre, String telefono, String direccion) {
		/*
		 * INSERT INTO `Instalacion` (`codparque`, `nombre`, `telefono`,
		 * `direccion`) VALUES ('3', 'parque3', '982323', 'parque333');
		 */
		try {
			String sql = "Insert into proteccioncivil.Instalacion (`nombre`,`telefono`,`direccion`) values (?, ?, ?)";
			PreparedStatement stmt = connect.prepareStatement(sql);

			stmt.setString(1, nombre);
			stmt.setString(2, telefono);
			stmt.setString(3, direccion);
			stmt.executeUpdate();
			stmt.close();
			cargarDatosTablas();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public void BorrarEmpleado(String EMP) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Empleado WHERE codinterno = '" + EMP + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarNotificacion(String NOT) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Notificacion WHERE codnotificacion = '" + NOT + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarLugar(String LUG) throws SQLException {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Instalacion WHERE codparque = '" + LUG + "'";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarTodoLugar() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Instalacion";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarTodoNotificacion() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Notificacion";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public void BorrarTodoEmpleado() {

		try {
			String[] querys = new String[1];
			querys[0] = "DELETE FROM proteccioncivil.Empleado";

			PreparedStatement stmt;
			for (int i = 0; i < querys.length; i++) {
				stmt = (PreparedStatement) connect.prepareStatement(querys[i]);
				stmt.executeUpdate();
			}
			cargarDatosTablas();
		} catch (Exception e) {
			System.out.println("Borrado");
		}
	}

	public String[][] getDatosEmpleado() {
		String[] arrDatosUnEmpleado = ArraydatosEmpleado[0];

		String nombre = arrDatosUnEmpleado[1];

		return ArraydatosEmpleado;
	}

	public void setDatosEmpleado(V_Empleados empleado) {
		this.VAsociacion = empleado;
	}

	public String[][] getArraydatosInstalacion() {
		return ArraydatosLugar;
	}

	public void setDatosLugar(V_Lugares lugar) {
		this.VActividades = lugar;
	}

	public String[][] getArrayNotificacion() {
		return ArraydatosNotificacion;
	}

	public void setDatosNotificacion(V_Notificaciones notificacion) {
		this.VSubvencion = notificacion;
	}

	public void setRLugar(V_RegistrarLugar rLugar) {
		this.RLugar = rLugar;
	}

	public void setRNotificacion(V_RegistrarNotificacion rNotificacion) {
		this.RNotificacion = rNotificacion;
	}

	public void setREmpleado(V_RegistrarEmpleado rEmpleado) {
		this.REmpleado = rEmpleado;
	}

	public void cargarDatosTablas() {
		this.DataEmpl();
		VAsociacion.setEmpleado(ArraydatosEmpleado);
		this.DataInsta();
		VActividades.setLugar(ArraydatosLugar);
		this.DataNotifi();
		VSubvencion.setNotificacion(ArraydatosNotificacion);

	}

}
