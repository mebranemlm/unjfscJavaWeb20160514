package dao.l;

import java.util.List;

import model.Usuario;

public interface UsuarioDAOL {
	public abstract Usuario validUser(Usuario obj) throws Exception; 
	public abstract Usuario questUser(Usuario obj) throws Exception;
	public abstract void addUser(Usuario obj) throws Exception;
	public abstract void editUser(Usuario obj) throws Exception;
	public abstract List<Usuario> listUser(Usuario obj) throws Exception;
}
