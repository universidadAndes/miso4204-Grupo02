package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TEMA database table.
 * 
 */
@Entity
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMA_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Estampa
	@OneToMany(mappedBy="temaBean")
	private List<Estampa> estampas;

	public Tema() {
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

	public List<Estampa> getEstampas() {
		return this.estampas;
	}

	public void setEstampas(List<Estampa> estampas) {
		this.estampas = estampas;
	}

	public Estampa addEstampa(Estampa estampa) {
		getEstampas().add(estampa);
		estampa.setTemaBean(this);

		return estampa;
	}

	public Estampa removeEstampa(Estampa estampa) {
		getEstampas().remove(estampa);
		estampa.setTemaBean(null);

		return estampa;
	}

}