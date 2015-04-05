package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RED_SOCIAL database table.
 * 
 */
@Entity
@Table(name="RED_SOCIAL")
@NamedQuery(name="RedSocial.findAll", query="SELECT r FROM RedSocial r")
public class RedSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RED_SOCIAL_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RED_SOCIAL_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to UsuarioRedsocial
	@OneToMany(mappedBy="redSocial")
	private List<UsuarioRedsocial> usuarioRedsocials;

	public RedSocial() {
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

	public List<UsuarioRedsocial> getUsuarioRedsocials() {
		return this.usuarioRedsocials;
	}

	public void setUsuarioRedsocials(List<UsuarioRedsocial> usuarioRedsocials) {
		this.usuarioRedsocials = usuarioRedsocials;
	}

	public UsuarioRedsocial addUsuarioRedsocial(UsuarioRedsocial usuarioRedsocial) {
		getUsuarioRedsocials().add(usuarioRedsocial);
		usuarioRedsocial.setRedSocial(this);

		return usuarioRedsocial;
	}

	public UsuarioRedsocial removeUsuarioRedsocial(UsuarioRedsocial usuarioRedsocial) {
		getUsuarioRedsocials().remove(usuarioRedsocial);
		usuarioRedsocial.setRedSocial(null);

		return usuarioRedsocial;
	}

}