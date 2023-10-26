package view.adapters;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Pedido;
import service.PedidosService;

public class ListaPedidosModel extends DefaultListModel<Pedido> {
	List<Pedido> pedidos;
	
	public ListaPedidosModel() {
		pedidos=new PedidosService().todos();
	}

	@Override
	public int getSize() {
		return pedidos.size();
	}

	@Override
	public Pedido getElementAt(int index) {
		return pedidos.get(index);
	}

}
