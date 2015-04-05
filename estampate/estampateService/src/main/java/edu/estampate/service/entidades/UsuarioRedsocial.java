package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USUARIO_REDSOCIAL database table.
 * 
 */
@Entity
@Table(name="USUARIO_REDSOCIAL")
@NamedQuery(name="UsuarioRedsocial.findAll", query="SELECT u FROM UsuarioRedsocial u")
public class UsuarioRedsocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_REDSOCIAL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_REDSOCIAL_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to RedSocial
	@ManyToOne
	@JoinColumn(name="ID_REDSOCIAL")
	private RedSocial redSocial;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public UsuarioRedsocial() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RedSocial getRedSocial() {
		return this.redSocial;
	}

	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}