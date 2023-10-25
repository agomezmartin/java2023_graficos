package presentacion;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		JButton jbSalir=new JButton("Salir");
		JLabel jlRespuesta=new JLabel();
		jl1.setBounds(120, 50, 130, 40);
		jt1.setBounds(280,50,80,40);
		jl2.setBounds(120, 130, 130, 40);
		jt2.setBounds(280,130,80,40);
		jbSumar.setBounds(70, 220, 120, 40);
		jbMultiplicar.setBounds(220, 220, 120, 40);
		jbSalir.setBounds(360, 220, 100, 40);
		jlRespuesta.setBounds(150, 300, 100, 30);
		//añadir control al contenedor
		this.add(jl1);this.add(jl2);this.add(jt1);
		this.add(jt2);this.add(jbSumar);this.add(jbMultiplicar);
		this.add(jlRespuesta);this.add(jbSalir);
		//eventos
		jbSumar.addActionListener(a->{
			try {
				jlRespuesta.setText(
					Integer.parseInt(jt1.getText())+Integer.parseInt(jt2.getText())+"");
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Debe ser un valor numérico!!!");
			}
			
		});
		jbMultiplicar.addActionListener(a->jlRespuesta.setText(
					Integer.parseInt(jt1.getText())*Integer.parseInt(jt2.getText())+""));
		jbSalir.addActionListener(a->{
			int resp=JOptionPane.showConfirmDialog(this, "¿Desea salir?","Alerta",JOptionPane.YES_NO_OPTION);
			if(resp==JOptionPane.YES_OPTION) {
				this.dispose();
			}
		});
		
		jt1.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent e) {}
						@Override
			public void focusGained(FocusEvent e) {
				jt1.setText("");//borramos caja de texto
			}
		});
		jt2.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent e) {}			
			@Override
			public void focusGained(FocusEvent e) {
				jt2.setText("");//borramos caja de texto
			}
		});
	}
}
