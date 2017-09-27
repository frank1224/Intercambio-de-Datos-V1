package controladorAplicacion;

import javax.swing.JOptionPane;

import modeloAplicacion.Modelo;

import java.sql.*;
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
import modeloAplicacion.Modelo;

public class Controller {
	private V_Lugares visLug;
	private V_Notificaciones vistNot;
	private V_ModificarNotificacion vistaMN;
	private V_RegistrarNotificacion vistaRN;
	private V_ModificarLugar vistaML;
	private V_RegistrarLugar vistaRL;
	private V_RegistrarEmpleado vistaRE;
	private V_ModificarEmpleado vistaME;
	private V_Login vistaL;
	private V_Empleados vistaEmp;
	private Modelo database;
	private Connection connection;
	private Modelo RLugar;
	private Modelo RNotificacion;
	private Modelo REmpleado;
	
	
	public Controller(V_Lugares visLug,V_Notificaciones vistNot,V_ModificarNotificacion vistaMN,V_RegistrarNotificacion vistaRN,V_RegistrarEmpleado vistaRE,V_ModificarLugar vistaML,V_RegistrarLugar vistaRL,V_ModificarEmpleado vistaME,V_Login vistaL,V_Empleados vistaEmp, Modelo database) {
		this.visLug = visLug;
		this.vistNot = vistNot;
		this.vistaMN = vistaMN;
		this.vistaRN = vistaRN;
		this.vistaRE = vistaRE;
		this.vistaRL = vistaRL;
		this.vistaML = vistaML;
		this.vistaME = vistaME;
		this.vistaL = vistaL;
		this.vistaEmp = vistaEmp;
		this.database = database;
		
	}

	public void cambiarEmpleado() {
		vistaEmp.setVisible(true);
		visLug.dispose();
		//vistaRegistro.dispose();
		vistNot.dispose();
	}

	public void cambiarNotificacion() {
		vistNot.setVisible(true);
		visLug.dispose();
		//vistaRegistro.dispose();
		vistaEmp.dispose();
	}
	
	public void cambiarLugar(){
		visLug.setVisible(true);
		vistNot.dispose();
		//vistaRegistro.dispose();
		vistaEmp.dispose();
	}

	public void cambiarRegistrar() {
		//vistaRegistro.setVisible(true);
		vistNot.dispose();
		visLug.dispose();
		vistaEmp.dispose();
	}

	public void mostrarBotonVistaLg() {
		if (visLug.getTable().getSelectedRow() != -1 && visLug.getTable().getModel().getValueAt(visLug.getTable().getSelectedRow(),visLug.getTable().getSelectedColumn()) != null) {
			visLug.getBtnEliminar().setEnabled(true);
			visLug.getbtnModificar().setEnabled(true);
		} else {
			visLug.getBtnEliminar().setEnabled(false);
			visLug.getbtnModificar().setEnabled(false);
		}
		if(visLug.getBusquedatxt().getText().length() != 0) {
			visLug.getBtnLimpiar().setEnabled(true);
		} else {
			visLug.getBtnLimpiar().setEnabled(false);
		}
	}
	
	public void mostrarBotonVistaNot() {
		if (vistNot.getTable().getSelectedRow() != -1 && vistNot.getTable().getModel().getValueAt(vistNot.getTable().getSelectedRow(),vistNot.getTable().getSelectedColumn()) != null) {
			vistNot.getBtnEliminar().setEnabled(true);
			vistNot.getBtnModificar().setEnabled(true);
		} else {
			vistNot.getBtnEliminar().setEnabled(false);
			vistNot.getBtnModificar().setEnabled(false);
		}
		if(vistNot.getBusquedatxt().getText().length() != 0) {
			vistNot.getBtnLimpiar().setEnabled(true);
		} else {
			vistNot.getBtnLimpiar().setEnabled(false);
		}
	}
	
	public void mostrarBotonvistaEmp() {
		if (vistaEmp.getTable().getSelectedRow() != -1 && vistaEmp.getTable().getModel().getValueAt(vistaEmp.getTable().getSelectedRow(),vistaEmp.getTable().getSelectedColumn()) != null) {
			vistaEmp.getbtnEliminar().setEnabled(true);
			vistaEmp.getbtnModificar().setEnabled(true);
		} else {
			vistaEmp.getbtnEliminar().setEnabled(false);
			vistaEmp.getbtnModificar().setEnabled(false);
		}
		if(vistaEmp.getTextField().getText().length() != 0) {
			vistaEmp.getbtnLimpiar().setEnabled(true);
		} else {
			vistaEmp.getbtnLimpiar().setEnabled(false);
		}
	}
	
	public void cambiarModificarNot(){
		vistaMN.setVisible(true);
	}
	
	public void cambiarRegistrarNot(){
		vistaRN.setVisible(true);
	}
	
	public void cambiarModificarLg(){
		vistaML.setVisible(true);
	}
	
	public void cambiarModificarEmp(){
		vistaME.setVisible(true);
	}
	
	public void cerrarMEmpleado(){
		vistaME.dispose();
	}
	
	public void cambiarRegistrarLugar(){
		vistaRL.setVisible(true);
	}
	
	public void cambiarRegistrarEmpleado(){
		vistaRE.setVisible(true);
	}
	
	public void cerrarMNotificacion(){
		vistaMN.dispose();
	}
	public void cerrarRNotificacion(){
		vistaRN.dispose();
	}
	
	public void cerrarMLugar(){
		vistaML.dispose();
	}
	
	public void cerrarRLugar(){
		vistaRL.dispose();
	}
	//PARA AÑADIR
	public void AsociacionModelo(Modelo modelobbdd){
		this.database=modelobbdd;
		
	}
	
	
	
	//PARA AÑADIR
	public void cargarDatos(){
		database.cargarDatosTablas();
		
	}
	
	
	
	public void altaLugar(String nombre, String telefono, String direccion){
		this.database.registrarLugar(nombre, telefono, direccion);
	}
	
	public void setRLugar(Modelo rLugar) {
		this.RLugar = rLugar;
	}
	
	
	
	public void altaNotificacion( String direccion, String urgencia, String tipo){
		this.database.registrarNotificacion( direccion, urgencia, tipo);
	}
	
	
	public void setNotificacion(Modelo rNotificacion) {
		this.RNotificacion = rNotificacion;
	}
	
	public void altaEmpleado(String dni, String nombre, String apellido, String fechanacimiento){
		this.database.registrarEmpleado(dni, nombre, apellido, fechanacimiento);
	}
	
	
	public void setEmpleado(Modelo rEmpleado) {
		this.REmpleado = rEmpleado;
	}
	

	public void logearse() {		
			String Contrasena = "1";		
			String Pass = new String(vistaL.getPasswordField().getPassword());
			if (Pass.equals(Contrasena)) {
				vistaEmp.setVisible(true);
				vistaL.dispose();
			} else {
				JOptionPane.showMessageDialog(vistaL, "Codigo incorrecto");
			}
	}

	public void mensajeRLugar(){
		JOptionPane.showMessageDialog(vistaML, "Se ha registrado correctamente");
	}
	
	public void mensajeNotificacion(){
		JOptionPane.showMessageDialog(vistaMN, "Se ha registrado correctamente");
	}
	
	public void mensajeEpleado(){
		JOptionPane.showMessageDialog(vistaME, "Se ha registrado correctamente");
	}
	
}
