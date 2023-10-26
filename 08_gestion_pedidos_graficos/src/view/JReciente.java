package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PedidosService;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JReciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public JReciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(77, 48, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBackground(new Color(255, 255, 128));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(77, 95, 91, 14);
		contentPane.add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(77, 149, 91, 14);
		contentPane.add(lblPrecio);
		
		JLabel jlProducto = new JLabel("");
		jlProducto.setBounds(184, 50, 107, 14);
		contentPane.add(jlProducto);
		
		JLabel jlFecha = new JLabel("");
		jlFecha.setBackground(new Color(0, 255, 128));
		jlFecha.setBounds(178, 97, 107, 14);
		contentPane.add(jlFecha);
		
		JLabel jlPrecio = new JLabel("");
		jlPrecio.setBackground(new Color(255, 128, 0));
		jlPrecio.setBounds(178, 151, 107, 14);
		contentPane.add(jlPrecio);
		
		JButton jbSalir = new JButton("Salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JReciente.this.dispose();
			}
		});
		jbSalir.setBackground(new Color(255, 255, 128));
		jbSalir.setBounds(142, 216, 89, 23);
		contentPane.add(jbSalir);
		//cargar pedido más reciente al crearse la propia ventana
		var service=new PedidosService();
		var pedido=service.pedidoMasReciente();
		jlProducto.setText(pedido.getProducto());
		jlFecha.setText(pedido.getFechaPedido().toString());
		jlPrecio.setText(pedido.getPrecio()+"");	
		this.setVisible(true);
	}

}
