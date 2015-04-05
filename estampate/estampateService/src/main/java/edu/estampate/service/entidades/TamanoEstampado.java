package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TAMANO_ESTAMPADO database table.
 * 
 */
@Entity
@Table(name="TAMANO_ESTAMPADO")
@NamedQuery(name="TamanoEstampado.findAll", query="SELECT t FROM TamanoEstampado t")
public class TamanoEstampado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAMANO_ESTAMPADO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAMANO_ESTAMPADO_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="tamanoEstampadoBean")
	private List<Camiseta> camisetas;

	public TamanoEstampado() {
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
		camiseta.setTamanoEstampadoBean(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setTamanoEstampadoBean(null);

		return camiseta;
	}

}