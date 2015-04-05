package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROL_PRIVILEGIO database table.
 * 
 */
@Entity
@Table(name="ROL_PRIVILEGIO")
@NamedQuery(name="RolPrivilegio.findAll", query="SELECT r FROM RolPrivilegio r")
public class RolPrivilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_PRIVILEGIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_PRIVILEGIO_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to Privilegio
	@ManyToOne
	@JoinColumn(name="ID_PRIVILEGIO")
	private Privilegio privilegio;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	public RolPrivilegio() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Privilegio getPrivilegio() {
		return this.privilegio;
	}

	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}