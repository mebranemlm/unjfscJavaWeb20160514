package bean;

import java.sql.Date;

import model.Usuario;
import dao.i.UsuarioDAOI;

public class UsuarioBean {
	public String usua,pass;
	public Date freg;
	public Integer esta;
	
	public UsuarioDAOI ousuDaoi = new UsuarioDAOI();
	
	
	public String validateLogin() throws Exception{
		String r= "ERROR";
		Usuario ousu = new Usuario();
		ousu.setUsua(getUsua());
		ousu.setPass(getPass());
		Usuario ousu2 = new Usuario();
		ousu2=ousuDaoi.validUser(ousu);
		if(ousu2.getUsua()!=null){
			r="SUCCESS";
			setUsua(ousu2.getUsua());
			setPass(ousu2.getPass());
		}
		
		
		
		return r;
	}
	
	public String getUsua() {
		return usua;
	}
	public void setUsua(String usua) {
		this.usua = usua;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getFreg() {
		return freg;
	}
	public void setFreg(Date freg) {
		this.freg = freg;
	}
	public Integer getEsta() {
		return esta;
	}
	public void setEsta(Integer esta) {
		this.esta = esta;
	}
	
	
}
