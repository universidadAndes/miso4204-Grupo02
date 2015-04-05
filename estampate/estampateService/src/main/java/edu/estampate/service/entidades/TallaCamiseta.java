package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TALLA_CAMISETA database table.
 * 
 */
@Entity
@Table(name="TALLA_CAMISETA")
@NamedQuery(name="TallaCamiseta.findAll", query="SELECT t FROM TallaCamiseta t")
public class TallaCamiseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TALLA_CAMISETA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TALLA_CAMISETA_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="tallaCamiseta")
	private List<Camiseta> camisetas;

	public TallaCamiseta() {
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

	public List<Camiseta> getCamisetas() {
		return this.camisetas;
	}

	public void setCamisetas(List<Camiseta> camisetas) {
		this.camisetas = camisetas;
	}

	public Camiseta addCamiseta(Camiseta camiseta) {
		getCamisetas().add(camiseta);
		camiseta.setTallaCamiseta(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setTallaCamiseta(null);

		return camiseta;
	}

}