package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ESTAMPA database table.
 * 
 */
@Entity
@NamedQuery(name="Estampa.findAll", query="SELECT e FROM Estampa e")
public class Estampa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTAMPA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTAMPA_ID_GENERATOR")
	private long id;

	@Column(name="CANTIDAD_VOTOS")
	private BigDecimal cantidadVotos;

	private String imagen;

	private String informacion;

	private BigDecimal popularidad;

	private BigDecimal precio;

	private BigDecimal ratting;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="estampaBean")
	private List<Camiseta> camisetas;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="TEMA")
	private Tema temaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario usuarioBean;

	public Estampa() {
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public BigDecimal getPopularidad() {
		return this.popularidad;
	}

	public void setPopularidad(BigDecimal popularidad) {
		this.popularidad = popularidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getRatting() {
		return this.ratting;
	}

	public void setRatting(BigDecimal ratting) {
		this.ratting = ratting;
	}

	public List<Camiseta> getCamisetas() {
		return this.camisetas;
	}

	public void setCamisetas(List<Camiseta> camisetas) {
		this.camisetas = camisetas;
	}

	public Camiseta addCamiseta(Camiseta camiseta) {
		getCamisetas().add(camiseta);
		camiseta.setEstampaBean(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setEstampaBean(null);

		return camiseta;
	}

	public Tema getTemaBean() {
		return this.temaBean;
	}

	public void setTemaBean(Tema temaBean) {
		this.temaBean = temaBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}