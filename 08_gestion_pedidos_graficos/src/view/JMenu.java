package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;

public class JMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu();
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
	public JMenu() {
		JTextArea txtPedidos = new JTextArea();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jbNuevo = new JButton("Nuevo pedido");
		jbNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JNuevo();				
			}
		});
		jbNuevo.setBounds(36, 42, 170, 23);
		contentPane.add(jbNuevo);
		
		JButton jbReciente = new JButton("Pedido más reciente");
		jbReciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JReciente();
			}
		});
		jbReciente.setBounds(36, 108, 170, 23);
		contentPane.add(jbReciente);
		
		JButton jbTodos = new JButton("Mostrar todos");
		jbTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPedidos.setText("");
				var service=new PedidosService();
				List<Pedido> pedidos=service.todos();
				for(Pedido pedido:pedidos) {
					txtPedidos.setText(txtPedidos.getText()+pedido.getProducto()+System.lineSeparator());
				}
			}
		});
		jbTodos.setBounds(36, 166, 170, 23);
		contentPane.add(jbTodos);
		
		
		txtPedidos.setBounds(241, 146, 87, 134);
		contentPane.add(txtPedidos);
		
		JButton jbSalir = new JButton("Salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu.this.dispose();
			}
		});
		jbSalir.setBounds(83, 278, 89, 23);
		contentPane.add(jbSalir);
	}
}
