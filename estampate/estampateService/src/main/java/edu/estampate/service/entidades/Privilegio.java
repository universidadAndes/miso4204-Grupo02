package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRIVILEGIO database table.
 * 
 */
@Entity
@NamedQuery(name="Privilegio.findAll", query="SELECT p FROM Privilegio p")
public class Privilegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRIVILEGIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIVILEGIO_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to RolPrivilegio
	@OneToMany(mappedBy="privilegio")
	private List<RolPrivilegio> rolPrivilegios;

	public Privilegio() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolPrivilegio> getRolPrivilegios() {
		return this.rolPrivilegios;
	}

	public void setRolPrivilegios(List<RolPrivilegio> rolPrivilegios) {
		this.rolPrivilegios = rolPrivilegios;
	}

	public RolPrivilegio addRolPrivilegio(RolPrivilegio rolPrivilegio) {
		getRolPrivilegios().add(rolPrivilegio);
		rolPrivilegio.setPrivilegio(this);

		return rolPrivilegio;
	}

	public RolPrivilegio removeRolPrivilegio(RolPrivilegio rolPrivilegio) {
		getRolPrivilegios().remove(rolPrivilegio);
		rolPrivilegio.setPrivilegio(null);

		return rolPrivilegio;
	}

}