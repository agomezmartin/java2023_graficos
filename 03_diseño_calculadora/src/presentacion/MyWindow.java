package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyWindow extends JFrame {
	public MyWindow() {
		//título de la ventana
		super("Primera ventana");
		//comportamiento de botón de cierre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//tamaño y posición
		this.setBounds(10, 10, 600, 400);
		//llamada a método que carga controles en ventana
		initComponents();
		//hacemos visible la ventana
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null); //anulamos gestor de organización
		JLabel jl1=new JLabel("Número 1: ");
		JLabel jl2=new JLabel("Número 2: ");
		JTextField jt1=new JTextField();
		JTextField jt2=new JTextField();
		JButton jbSumar=new JButton("Sumar");
		JButton jbMultiplicar=new JButton("Multiplicar");
		jl1.setBounds(120, 50, 130, 40);
		jt1.setBounds(280,50,80,40);
		jl2.setBounds(120, 130, 130, 40);
		jt2.setBounds(280,130,80,40);
		jbSumar.setBounds(120, 220, 150, 50);
		jbMultiplicar.setBounds(360, 220, 150, 50);
		//añadir control al contenedor
		this.add(jl1);this.add(jl2);this.add(jt1);
		this.add(jt2);this.add(jbSumar);this.add(jbMultiplicar);
	}
}
