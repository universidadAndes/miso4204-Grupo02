package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UBICACION_ESTAMPADO database table.
 * 
 */
@Entity
@Table(name="UBICACION_ESTAMPADO")
@NamedQuery(name="UbicacionEstampado.findAll", query="SELECT u FROM UbicacionEstampado u")
public class UbicacionEstampado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UBICACION_ESTAMPADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UBICACION_ESTAMPADO_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="ubicacionEstampadoBean")
	private List<Camiseta> camisetas;

	public UbicacionEstampado() {
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
		camiseta.setUbicacionEstampadoBean(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setUbicacionEstampadoBean(null);

		return camiseta;
	}

}