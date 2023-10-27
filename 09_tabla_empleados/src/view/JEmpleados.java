package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaEmpleadosModel;

public class JEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEmpleados;
	private JButton btEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEmpleados frame = new JEmpleados();
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
	public JEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 48, 371, 83);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		JLabel lblNewLabel = new JLabel("Tabla de empleados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(63, 11, 175, 26);
		contentPane.add(lblNewLabel);
		
		btEmpleados = new JButton("Ver empleados");
		btEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbEmpleados.setModel(new TablaEmpleadosModel());
			}
			
		});
		btEmpleados.setBounds(123, 180, 156, 23);
		contentPane.add(btEmpleados);
	}
}
