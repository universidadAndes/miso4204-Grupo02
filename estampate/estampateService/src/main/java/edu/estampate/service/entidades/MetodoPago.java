package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the METODO_PAGO database table.
 * 
 */
@Entity
@Table(name="METODO_PAGO")
@NamedQuery(name="MetodoPago.findAll", query="SELECT m FROM MetodoPago m")
public class MetodoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="METODO_PAGO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="METODO_PAGO_ID_GENERATOR")
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="metodoPagoBean")
	private List<Venta> ventas;

	public MetodoPago() {
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
		venta.setMetodoPagoBean(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setMetodoPagoBean(null);

		return venta;
	}

}