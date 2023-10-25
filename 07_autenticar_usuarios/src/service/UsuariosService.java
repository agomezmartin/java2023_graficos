package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.User;

public class UsuariosService {
	private Stream<User> getUsers(){
		String ruta="c:\\temp\\usuarios.json";
		Gson gson=new Gson();
		try(FileReader reader=new FileReader(ruta);){
			User[] usuarios=gson.fromJson(reader, User[].class);
			return Arrays.stream(usuarios);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public boolean autenticar(User user) {
		return getUsers() //Stream<User>
		.anyMatch(u->u.getUsuario().equals(user.getUsuario())&&u.getPassword().equals(user.getPassword()));//boolean
	}
}
