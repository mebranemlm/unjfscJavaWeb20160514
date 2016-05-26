package dao.i;

import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import dao.l.UsuarioDAOL;
import model.Usuario;
import util.Conexion;

public class UsuarioDAOI implements UsuarioDAOL {

	Conexion cn= new Conexion();
	@Override
	public Usuario validUser(Usuario obj) throws Exception{
		cn.open();
		Usuario ousu=new Usuario();
		
		try {
			Query q= cn.em.createQuery("SELECT a FROM Usuario a where a.usua=:p1 and a.pass=:p2");
			q.setParameter("p1", obj.getUsua());
			q.setParameter("p2", obj.getPass());
			List<Usuario> lista = q.getResultList();
			for (Usuario usuario: lista){
				ousu=lista.get(0);
			}
			
		} catch (Exception e) {
			 System.out.println("Error en UsuarioDAOI"+e.getMessage());
//			JOptionPane.showMessageDialog(null,);
			// TODO: handle exception
		}
		cn.close();
		return ousu;
	}
}
