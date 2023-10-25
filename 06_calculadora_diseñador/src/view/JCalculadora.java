package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtNumero1;
	private JTextField jtNumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCalculadora frame = new JCalculadora();
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
	public JCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(120, 38, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número 2:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(120, 80, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		jtNumero1 = new JTextField();
		jtNumero1.setBounds(211, 35, 69, 20);
		contentPane.add(jtNumero1);
		jtNumero1.setColumns(10);
		
		jtNumero2 = new JTextField();
		jtNumero2.setBounds(211, 77, 71, 20);
		contentPane.add(jtNumero2);
		jtNumero2.setColumns(10);
		JLabel jlResultado = new JLabel("");
		
		JButton jbSumar = new JButton("Sumar");
		jbSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlResultado.setText(
					Integer.parseInt(jtNumero1.getText())+Integer.parseInt(jtNumero2.getText())+""
				);
			}
		});
		jbSumar.setBounds(46, 135, 89, 23);
		contentPane.add(jbSumar);
		
		JButton jbMultiplicar = new JButton("Multiplicar");
		jbMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlResultado.setText(
						Integer.parseInt(jtNumero1.getText())*Integer.parseInt(jtNumero2.getText())+""
				);
			}
		});
		jbMultiplicar.setBounds(163, 135, 117, 23);
		contentPane.add(jbMultiplicar);
		
		JButton jbSalir = new JButton("Salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp=JOptionPane.showConfirmDialog(JCalculadora.this, "¿Desea salir?","Alerta",JOptionPane.YES_NO_OPTION);
				if(resp==JOptionPane.YES_OPTION) {
					JCalculadora.this.dispose();
				}
			}
		});
		jbSalir.setBounds(316, 135, 89, 23);
		contentPane.add(jbSalir);
		
		
		jlResultado.setBounds(160, 204, 46, 14);
		contentPane.add(jlResultado);
	}
}
