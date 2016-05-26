package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="t_docente")
public class Docente {
	@Id
	private String codi;
	
	private String nomb,apel;
	
	@Temporal (TemporalType.DATE)
	private Date freg;
	
	private Integer esta;
	
	@ManyToOne
	@JoinColumn(name="usua")
	private Usuario tUsuario;

	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public String getNomb() {
		return nomb;
	}

	public void setNomb(String nomb) {
		this.nomb = nomb;
	}

	public String getApel() {
		return apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
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

	public Usuario gettUsuario() {
		return tUsuario;
	}

	public void settUsuario(Usuario tUsuario) {
		this.tUsuario = tUsuario;
	}
	
	
}
