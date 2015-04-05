package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to RolPrivilegio
	@OneToMany(mappedBy="rol")
	private List<RolPrivilegio> rolPrivilegios;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rolBean")
	private List<Usuario> usuarios;

	public Rol() {
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
		rolPrivilegio.setRol(this);

		return rolPrivilegio;
	}

	public RolPrivilegio removeRolPrivilegio(RolPrivilegio rolPrivilegio) {
		getRolPrivilegios().remove(rolPrivilegio);
		rolPrivilegio.setRol(null);

		return rolPrivilegio;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRolBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRolBean(null);

		return usuario;
	}

}