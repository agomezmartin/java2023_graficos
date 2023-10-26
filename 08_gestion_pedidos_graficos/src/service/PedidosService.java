package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Pedido;

public class PedidosService {
	
	String dir="c:\\temp\\pedidos.txt";
	Path path;
	//en constructor comprobamos si el fichero existe, si no, lo creamos
	public PedidosService() {
		File file=new File(dir);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		path=Path.of(dir);
	}
	private Stream<Pedido> getPedidos(){
		try {
			return Files.lines(path) //Stream<String>
					.map(s->new Pedido(s.split("[,-]")[0],
										LocalDate.parse(s.split(",")[1]),
										Double.parseDouble(s.split(",")[2]))); //Stream<Pedido>
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty(); //devuelve Stream vacío si hay excepción
		}
	}
	
	public void guardarPedido(String producto, LocalDate fechaPedido,double precio) {
		String linea=producto+","+fechaPedido+","+precio;
		try{			
			Files.writeString(path, linea+System.lineSeparator(), StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}	
	}
	
	public Pedido pedidoMasReciente() {
		return getPedidos() //Stream<Pedido>
			.max((a,b)->a.getFechaPedido().compareTo(b.getFechaPedido())) //Optional<Pedido>
			.orElse(null);		
	}
	
	public 	List<Pedido> pedidosPrecio(double precioMax) {
			return getPedidos()
						.filter(p->p.getPrecio()<=precioMax)//Stream<Pedido>
						.toList();		
	}	
	public List<Pedido> anteriores(int meses){		
		LocalDate referencia=LocalDate.now().minusMonths(meses);
		return getPedidos()
					.filter(p->p.getFechaPedido().isBefore(referencia))
					.toList();		
	}
	
	public List<Pedido> todos(){
		return getPedidos() //Stream<Pedido>
				.toList();
	}
	
	public void eliminarPedido(Pedido p) {
		//Recuperar todos los pedidos menos el que queremos eliminar
		//transformar a objeto String
		//generar una lista
		//volcar la lista en el fichero
		List<String> pedidos=getPedidos()//Stream<Pedido>
		.filter(ped->!(ped.getProducto().equals(p.getProducto())&&
					ped.getFechaPedido().equals(p.getFechaPedido())&&
					ped.getPrecio()==p.getPrecio())) //Stream<Pedido>
		.map(ped->ped.getProducto()+","+ped.getFechaPedido()+","+ped.getPrecio())//Stream<String>
		.collect(Collectors.toList());
		try {
			Files.write(Path.of(dir), pedidos);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
