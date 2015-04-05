package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METODO_ENVIO database table.
 * 
 */
@Entity
@Table(name="METODO_ENVIO")
@NamedQuery(name="MetodoEnvio.findAll", query="SELECT m FROM MetodoEnvio m")
public class MetodoEnvio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="METODO_ENVIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="METODO_ENVIO_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="metodoEnvioBean")
	private List<Venta> ventas;

	public MetodoEnvio() {
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

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setMetodoEnvioBean(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setMetodoEnvioBean(null);

		return venta;
	}

}