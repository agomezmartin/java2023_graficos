package view.adapters;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import service.EmpleadosService;

public class ListaDepartamentosModel extends DefaultComboBoxModel<String> {
	ArrayList<String> departamentos;
	public ListaDepartamentosModel() {
		departamentos=new ArrayList<>(new EmpleadosService().departamentos());
		departamentos.add(0, "-Todos-");
	}
	@Override
	public int getSize() {
		return departamentos.size();
	}
	@Override
	public String getElementAt(int index) {
		return departamentos.get(index);
	}
	
	
}
