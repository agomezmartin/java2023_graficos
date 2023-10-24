package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		//título de la ventana
		super("Primera ventana");
		//comportamiento de botón de cierre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//tamaño y posición
		this.setBounds(10, 10, 500, 300);
		//llamada a método que carga controles en ventana
		initComponents();
		//hacemos visible la ventana
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(null); //anulamos gestor de organización
		JButton jb1=new JButton("Pulsar aquí");
		jb1.setBounds(100, 50, 150, 40);
		//añadir control al contenedor
		this.add(jb1);
	}
}
