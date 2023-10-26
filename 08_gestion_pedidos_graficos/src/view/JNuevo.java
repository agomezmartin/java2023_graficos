package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PedidosService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtProducto;
	private JTextField jtFecha;
	private JTextField jtPrecio;

	
	/**
	 * Create the frame.
	 */
	public JNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(75, 56, 103, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaEnvo = new JLabel("Fecha envío");
		lblFechaEnvo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaEnvo.setBounds(75, 115, 103, 14);
		contentPane.add(lblFechaEnvo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(75, 176, 103, 14);
		contentPane.add(lblPrecio);
		
		jtProducto = new JTextField();
		jtProducto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtProducto.selectAll();
			}
		});
		jtProducto.setBounds(176, 55, 86, 20);
		contentPane.add(jtProducto);
		jtProducto.setColumns(10);
		
		jtFecha = new JTextField();
		jtFecha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtFecha.selectAll();
			}
		});
		jtFecha.setColumns(10);
		jtFecha.setBounds(176, 114, 86, 20);
		contentPane.add(jtFecha);
		
		jtPrecio = new JTextField();
		jtPrecio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtPrecio.selectAll();
			}
		});
		jtPrecio.setColumns(10);
		jtPrecio.setBounds(176, 175, 86, 20);
		contentPane.add(jtPrecio);
		
		JButton jbGuardar = new JButton("Guardar");
		jbGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=new PedidosService();
				service.guardarPedido(jtProducto.getText(),
								LocalDate.parse(jtFecha.getText()), 
								Double.parseDouble(jtPrecio.getText()));
				
				jtProducto.requestFocus(); //manda foco al control
			}
		});
		jbGuardar.setBounds(62, 227, 89, 23);
		contentPane.add(jbGuardar);
		
		JButton jbSalir = new JButton("Salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JNuevo.this.dispose();
			}
		});
		jbSalir.setBounds(252, 227, 89, 23);
		contentPane.add(jbSalir);
		this.setVisible(true);
	}

}
