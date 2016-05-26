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
			// System.out.println("Error en UsuarioDAOI"+e.getMessage());
			JOptionPane.showMessageDialog(null,e.getMessage());
			// TODO: handle exception
		}
		cn.close();
		return ousu;
	}
	
	@Override
	public Usuario questUser(Usuario obj) throws Exception{
		Usuario letObj=new Usuario();
		cn.open();
		try {
			letObj=cn.em.find(Usuario.class, obj);
		} catch (Exception e) {
			letObj=null;
			System.out.println(e.getMessage());
		}
		cn.close();
		return letObj;
	}
	
	@Override
	public void addUser(Usuario obj) throws Exception{
		Usuario letObj= new Usuario();
		//cn.open();
		try {
			letObj.setUsua(obj.getUsua());
			letObj.setPass(obj.getPass());
			letObj.setFreg(obj.getFreg());
			letObj.setEsta(obj.getEsta());
			cn.open();
			cn.em.getTransaction().begin();
			cn.em.persist(letObj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			cn.close();
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO: handle exception
		}
	}
	
	@Override
	public void editUser(Usuario obj) throws Exception{
		Usuario letObj= new Usuario();
		//cn.open();
		try {
			letObj.setUsua(obj.getUsua());
			letObj.setPass(obj.getPass());
			letObj.setFreg(obj.getFreg());
			letObj.setEsta(obj.getEsta());
			cn.open();
			cn.em.getTransaction().begin();
			cn.em.merge(letObj);
			cn.em.getTransaction().commit();
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			cn.close();
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO: handle exception
		}
	}
	
	@Override
	public List<Usuario> listUser(Usuario obj) throws Exception{
		List<Usuario> letList =null;
		try {
			Query q= cn.em.createQuery("select a from Usuario a where a.usua=:p1");
			q.setParameter("p1", obj.getUsua());
			letList=q.getResultList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// TODO: handle exception
		}
		return letList;
	}
}
