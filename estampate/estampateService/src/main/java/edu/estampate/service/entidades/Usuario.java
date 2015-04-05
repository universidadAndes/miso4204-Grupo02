package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	private long id;

	@Column(name="CANTIDAD_VOTOS")
	private BigDecimal cantidadVotos;

	private String password;

	private BigDecimal ratting;

	private String username;

	//bi-directional many-to-one association to CarritoCompra
	@OneToMany(mappedBy="usuarioBean")
	private List<CarritoCompra> carritoCompras;

	//bi-directional many-to-one association to Estampa
	@OneToMany(mappedBy="usuarioBean")
	private List<Estampa> estampas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA")
	private Persona personaBean;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL")
	private Rol rolBean;

	//bi-directional many-to-one association to UsuarioRedsocial
	@OneToMany(mappedBy="usuario")
	private List<UsuarioRedsocial> usuarioRedsocials;

	public Usuario() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCantidadVotos() {
		return this.cantidadVotos;
	}

	public void setCantidadVotos(BigDecimal cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getRatting() {
		return this.ratting;
	}

	public void setRatting(BigDecimal ratting) {
		this.ratting = ratting;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CarritoCompra> getCarritoCompras() {
		return this.carritoCompras;
	}

	public void setCarritoCompras(List<CarritoCompra> carritoCompras) {
		this.carritoCompras = carritoCompras;
	}

	public CarritoCompra addCarritoCompra(CarritoCompra carritoCompra) {
		getCarritoCompras().add(carritoCompra);
		carritoCompra.setUsuarioBean(this);

		return carritoCompra;
	}

	public CarritoCompra removeCarritoCompra(CarritoCompra carritoCompra) {
		getCarritoCompras().remove(carritoCompra);
		carritoCompra.setUsuarioBean(null);

		return carritoCompra;
	}

	public List<Estampa> getEstampas() {
		return this.estampas;
	}

	public void setEstampas(List<Estampa> estampas) {
		this.estampas = estampas;
	}

	public Estampa addEstampa(Estampa estampa) {
		getEstampas().add(estampa);
		estampa.setUsuarioBean(this);

		return estampa;
	}

	public Estampa removeEstampa(Estampa estampa) {
		getEstampas().remove(estampa);
		estampa.setUsuarioBean(null);

		return estampa;
	}

	public Persona getPersonaBean() {
		return this.personaBean;
	}

	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	public Rol getRolBean() {
		return this.rolBean;
	}

	public void setRolBean(Rol rolBean) {
		this.rolBean = rolBean;
	}

	public List<UsuarioRedsocial> getUsuarioRedsocials() {
		return this.usuarioRedsocials;
	}

	public void setUsuarioRedsocials(List<UsuarioRedsocial> usuarioRedsocials) {
		this.usuarioRedsocials = usuarioRedsocials;
	}

	public UsuarioRedsocial addUsuarioRedsocial(UsuarioRedsocial usuarioRedsocial) {
		getUsuarioRedsocials().add(usuarioRedsocial);
		usuarioRedsocial.setUsuario(this);

		return usuarioRedsocial;
	}

	public UsuarioRedsocial removeUsuarioRedsocial(UsuarioRedsocial usuarioRedsocial) {
		getUsuarioRedsocials().remove(usuarioRedsocial);
		usuarioRedsocial.setUsuario(null);

		return usuarioRedsocial;
	}

}