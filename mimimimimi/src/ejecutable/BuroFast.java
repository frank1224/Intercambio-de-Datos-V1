package ejecutable;

import controladorAplicacion.Controller;
import modeloAplicacion.Modelo;
import vistaAplicacion.V_Lugares;
import vistaAplicacion.V_Empleados;
import vistaAplicacion.V_Login;
import vistaAplicacion.V_ModificarLugar;
import vistaAplicacion.V_ModificarEmpleado;
import vistaAplicacion.V_ModificarNotificacion;
import vistaAplicacion.V_RegistrarLugar;
import vistaAplicacion.V_RegistrarEmpleado;
import vistaAplicacion.V_RegistrarNotificacion;
import vistaAplicacion.V_Notificaciones;

public class BuroFast{
	BuroFast() {
		super(); 
	}    
	
	public static void main(String[] args) { 
		V_Lugares ventanaLg = new V_Lugares();
		V_Notificaciones ventanaNot = new V_Notificaciones();
		V_ModificarNotificacion ventanaMN = new V_ModificarNotificacion(); 
		V_RegistrarNotificacion ventanaRN = new V_RegistrarNotificacion();
		V_RegistrarEmpleado ventanaRE = new V_RegistrarEmpleado();
		V_RegistrarLugar ventanaRL = new V_RegistrarLugar();
		V_ModificarLugar ventanaML = new V_ModificarLugar();
		V_ModificarEmpleado ventanaME = new V_ModificarEmpleado(); 
		V_Empleados ventanaEM = new V_Empleados();
		V_Login ventanaL = new V_Login();
		Modelo connection = new Modelo();
		//Modelo sb = new Modelo();
		Controller controlador = new Controller(ventanaLg ,ventanaNot,ventanaMN,ventanaRN, ventanaRE,ventanaML,ventanaRL,ventanaME,ventanaL,ventanaEM, connection);
		
			
		  
		//PARA AÑADIR
		connection.setDatosEmpleado(ventanaEM); 
		connection.setDatosLugar(ventanaLg);
		connection.setDatosNotificacion(ventanaNot);
		connection.cargarDatosTablas();
		//
		ventanaLg.setControlador(controlador);
		ventanaNot.setControlador(controlador);
		ventanaMN.setControlador(controlador);
		ventanaRN.setControlador(controlador);
		ventanaRE.setControlador(controlador);
		ventanaML.setControlador(controlador);
		ventanaRL.setControlador(controlador);
		ventanaME.setControlador(controlador);
		ventanaL.setControlador(controlador);
		ventanaEM.setControlador(controlador);
		ventanaL.setVisible(true);
	}
}
