package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.User;
import service.UsuariosService;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtUsuario;
	private JTextField jtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 42, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(72, 94, 112, 14);
		contentPane.add(lblContrasea);
		
		jtUsuario = new JTextField();
		jtUsuario.setBounds(162, 41, 86, 20);
		contentPane.add(jtUsuario);
		jtUsuario.setColumns(10);
		
		jtPassword = new JTextField();
		jtPassword.setColumns(10);
		jtPassword.setBounds(162, 93, 86, 20);
		contentPane.add(jtPassword);
		
		JButton jbEntrar = new JButton("Entrar");
		jbEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuariosService service=new UsuariosService();
				User user=new User(jtUsuario.getText(), jtPassword.getText());
				if(service.autenticar(user)) {
					JOptionPane.showMessageDialog(JLogin.this, "Usuario válido!!");
				}else {
					JOptionPane.showMessageDialog(JLogin.this, "Usuario incorrecto, vuelva a intentar");
				}
			}
		});
		jbEntrar.setBounds(174, 154, 89, 23);
		contentPane.add(jbEntrar);
	}

}
