package presentacion;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	public MyWindow() {
		//título de la ventana
		super("Primera ventana");
		//comportamiento de botón de cierre
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//tamaño y posición
		this.setBounds(10, 10, 500, 300);
		//hacemos visible la ventana
		this.setVisible(true);
	}
}
