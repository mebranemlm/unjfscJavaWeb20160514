package bean;

import java.util.Date;
import java.util.List;

import model.Usuario;
import dao.i.UsuarioDAOI;

public class UsuarioBean {
	public String usua,pass;
	public Date freg;
	public Integer esta;
	
	public UsuarioDAOI oDaoi = new UsuarioDAOI();
	
	private List<Usuario> list;
	private int list_size;
	private boolean sw_edit;
	//Usuario obj = new Usuario();
	
	public boolean actionAdd(){
		sw_edit=false;
		return sw_edit;
	}
	
	public boolean actionEdit(){
		sw_edit=true;
		return sw_edit;
	}
	
	public String validateLogin() throws Exception{
		String r= "ERROR";
		Usuario ousu = new Usuario();
		ousu.setUsua(getUsua());
		ousu.setPass(getPass());
		Usuario ousu2 = new Usuario();
		ousu2=oDaoi.validUser(ousu);
		if(ousu2.getUsua()!=null){
			r="SUCCESS";
			setUsua(ousu2.getUsua());
			setPass(ousu2.getPass());
		}		
		return r;
	}
	
	public void addUser() throws Exception{
		Usuario letObj=new Usuario();
		letObj.setUsua(getUsua());
		letObj.setPass(getPass());
		letObj.setFreg(getFreg());
		letObj.setEsta(getEsta());
		oDaoi.addUser(letObj);
	}
	
	public void editUser() throws Exception{
		Usuario letObj=new Usuario();
		letObj.setUsua(getUsua());
		letObj.setPass(getPass());
		letObj.setFreg(getFreg());
		letObj.setEsta(getEsta());
		oDaoi.editUser(letObj);
	}
	
	public void listUser() throws Exception{
		Usuario ltObj=new Usuario();
		ltObj.setUsua(getUsua());
		ltObj=oDaoi.questUser(ltObj);
		list=oDaoi.listUser(ltObj);
		list_size=list.size();
	}
	
	public void clean() throws Exception{
		setUsua(null);
		setPass(null);
		setFreg(null);
		setEsta(-1);
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

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public int getList_size() {
		return list_size;
	}

	public void setList_size(int list_size) {
		this.list_size = list_size;
	}

	public boolean isSw_edit() {
		return sw_edit;
	}

	public void setSw_edit(boolean sw_edit) {
		this.sw_edit = sw_edit;
	}
	
	
}
