package vistaAplicacion;

import java.awt.event.*;
import javax.swing.*;

import controladorAplicacion.Controller;
import java.awt.Font;
import java.awt.Image;

@SuppressWarnings("serial")
public class V_Login extends JFrame {
	private Controller controlador;
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JButton btnEntrar;
	private ImageIcon img;
	private Icon icono;

	public V_Login() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Login");
		setBounds(100, 100, 517, 308);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLogin.setBounds(203, 74, 89, 33);
		getContentPane().add(lblLogin);
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.logearse();
			}
		});
		btnEntrar.setBounds(203, 168, 89, 23);
		getContentPane().add(btnEntrar);
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password\r\n");
		passwordField.setBounds(166, 118, 167, 23);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(10, 11, 30, 30);
		img = new ImageIcon("configuracion.png");
		icono = new ImageIcon(img.getImage().getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(), Image.SCALE_DEFAULT));
		btnNewButton.setIcon(icono);
		getContentPane().add(btnNewButton);
		
	
	}

	public void setControlador(Controller controlador) {
		this.controlador = controlador;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}