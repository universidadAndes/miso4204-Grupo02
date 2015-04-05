package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CARRITO_COMPRAS database table.
 * 
 */
@Entity
@Table(name="CARRITO_COMPRAS")
@NamedQuery(name="CarritoCompra.findAll", query="SELECT c FROM CarritoCompra c")
public class CarritoCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CARRITO_COMPRAS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARRITO_COMPRAS_ID_GENERATOR")
	private long id;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to Camiseta
	@OneToMany(mappedBy="carritoCompra")
	private List<Camiseta> camisetas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="carritoCompra")
	private List<Venta> ventas;

	public CarritoCompra() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Camiseta> getCamisetas() {
		return this.camisetas;
	}

	public void setCamisetas(List<Camiseta> camisetas) {
		this.camisetas = camisetas;
	}

	public Camiseta addCamiseta(Camiseta camiseta) {
		getCamisetas().add(camiseta);
		camiseta.setCarritoCompra(this);

		return camiseta;
	}

	public Camiseta removeCamiseta(Camiseta camiseta) {
		getCamisetas().remove(camiseta);
		camiseta.setCarritoCompra(null);

		return camiseta;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setCarritoCompra(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setCarritoCompra(null);

		return venta;
	}

}