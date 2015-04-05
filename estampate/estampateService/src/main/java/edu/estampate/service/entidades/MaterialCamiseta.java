package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MATERIAL_CAMISETA database table.
 * 
 */
@Entity
@Table(name="MATERIAL_CAMISETA")
@NamedQuery(name="MaterialCamiseta.findAll", query="SELECT m FROM MaterialCamiseta m")
public class MaterialCamiseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATERIAL_CAMISETA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATERIAL_CAMISETA_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="materialCamiseta")
	private List<Camiseta> camisetas;

	public MaterialCamiseta() {
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
		camiseta.setMaterialCamiseta(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setMaterialCamiseta(null);

		return camiseta;
	}

}