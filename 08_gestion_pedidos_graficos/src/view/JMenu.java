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
import view.adapters.ListaPedidosModel;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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
		JList<Pedido> lstPedidos = new JList<>();
		lstPedidos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Pedido pedido=lstPedidos.getSelectedValue();
				JOptionPane.showMessageDialog(JMenu.this, "Pedido seleccionado: "+pedido.getProducto()+
						" - "+pedido.getFechaPedido()+" - "+pedido.getPrecio());
			}
		});
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
				//instanciamos modelo de datos y se lo asignamos al JList
				ListaPedidosModel model=new ListaPedidosModel();
				lstPedidos.setModel(model);
			}
		});
		jbTodos.setBounds(36, 172, 170, 23);
		contentPane.add(jbTodos);
		
		JButton jbSalir = new JButton("Salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu.this.dispose();
			}
		});
		jbSalir.setBounds(83, 278, 89, 23);
		contentPane.add(jbSalir);
		
		JLabel lblNewLabel = new JLabel("Pedidos");
		lblNewLabel.setBounds(291, 158, 46, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 183, 129, 93);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(lstPedidos);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido pedido=lstPedidos.getSelectedValue();
				PedidosService service=new PedidosService();
				service.eliminarPedido(pedido);
				//para actualizar la lista
				lstPedidos.setModel(new ListaPedidosModel());
			}
		});
		btnEliminar.setBounds(281, 296, 89, 23);
		contentPane.add(btnEliminar);
	}
}
