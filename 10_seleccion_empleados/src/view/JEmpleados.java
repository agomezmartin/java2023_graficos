package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.ListaDepartamentosModel;
import view.adapters.TablaEmpleadosModel;

public class JEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEmpleados;

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
		scrollPane.setBounds(22, 139, 371, 83);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		JLabel lblNewLabel = new JLabel("Tabla de empleados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 113, 175, 26);
		contentPane.add(lblNewLabel);
		
		JComboBox cbDepartamentos = new JComboBox();
		cbDepartamentos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//si ha seleccionado "Todos", usamos el constructor sin parámetros de TablaEmpleadosModel
				//que carga todos los empleados, si no, cargamos los del departamento elegido
				if(cbDepartamentos.getSelectedIndex()==0) {
					tbEmpleados.setModel(new TablaEmpleadosModel());
				}else {
					tbEmpleados.setModel(new TablaEmpleadosModel(cbDepartamentos.getSelectedItem().toString()));
				}
				
			}
		});
		cbDepartamentos.setBounds(71, 36, 137, 22);
		contentPane.add(cbDepartamentos);
		cbDepartamentos.setModel(new ListaDepartamentosModel());
		
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione departamento");
		lblNewLabel_1.setBounds(71, 11, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
