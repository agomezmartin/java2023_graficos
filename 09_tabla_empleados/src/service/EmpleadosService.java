package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {
	private Stream<Empleado> getEmpleados(){
		String ruta="c:\\temp\\empleados.json";
		Gson gson=new Gson();
		try(FileReader reader=new FileReader(ruta);){
			Empleado[] empleados=gson.fromJson(reader, Empleado[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Empleado> empleados(){
		return getEmpleados() //Stream<Empleado>
				.collect(Collectors.toList());
	}
}
