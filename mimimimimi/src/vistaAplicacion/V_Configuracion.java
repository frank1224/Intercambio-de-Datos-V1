package vistaAplicacion;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;

@SuppressWarnings("serial")
public class V_Configuracion extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public V_Configuracion() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 401, 233);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblConfigurarConexinBbdd = new JLabel("CONFIGURAR CONEXIÓN BBDD");
		lblConfigurarConexinBbdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurarConexinBbdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfigurarConexinBbdd.setBounds(10, 11, 365, 27);
		getContentPane().add(lblConfigurarConexinBbdd);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(220, 117, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(20, 114, 68, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblBaseDeDatos = new JLabel("Base de datos:");
		lblBaseDeDatos.setBounds(20, 60, 77, 14);
		getContentPane().add(lblBaseDeDatos);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(220, 63, 46, 14);
		getContentPane().add(lblUrl);
		
		textField = new JTextField();
		textField.setBounds(107, 57, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 111, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(276, 60, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(276, 114, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(187, 161, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(286, 161, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
