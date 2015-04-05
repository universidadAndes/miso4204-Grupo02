package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COLOR_CAMISETA database table.
 * 
 */
@Entity
@Table(name="COLOR_CAMISETA")
@NamedQuery(name="ColorCamiseta.findAll", query="SELECT c FROM ColorCamiseta c")
public class ColorCamiseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COLOR_CAMISETA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLOR_CAMISETA_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="colorCamiseta", fetch = FetchType.EAGER)
	private List<Camiseta> camisetas;

	public ColorCamiseta() {
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
		camiseta.setColorCamiseta(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setColorCamiseta(null);

		return camiseta;
	}

}