package edu.estampate.service.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CAMISETA database table.
 * 
 */
@Entity
@NamedQuery(name="Camiseta.findAll", query="SELECT c FROM Camiseta c")
public class Camiseta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMISETA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMISETA_ID_GENERATOR")
	private long id;

	private BigDecimal precio;

	private String texto;

	//bi-directional many-to-one association to CarritoCompra
	@ManyToOne
	@JoinColumn(name="CARRITO")
	private CarritoCompra carritoCompra;

	//bi-directional many-to-one association to ColorCamiseta
	@ManyToOne
	@JoinColumn(name="COLOR")
	private ColorCamiseta colorCamiseta;

	//bi-directional many-to-one association to Estampa
	@ManyToOne
	@JoinColumn(name="ESTAMPA")
	private Estampa estampaBean;

	//bi-directional many-to-one association to MaterialCamiseta
	@ManyToOne
	@JoinColumn(name="MATERIAL")
	private MaterialCamiseta materialCamiseta;

	//bi-directional many-to-one association to TallaCamiseta
	@ManyToOne
	@JoinColumn(name="TALLA")
	private TallaCamiseta tallaCamiseta;

	//bi-directional many-to-one association to TamanoEstampado
	@ManyToOne
	@JoinColumn(name="TAMANO_ESTAMPADO")
	private TamanoEstampado tamanoEstampadoBean;

	//bi-directional many-to-one association to UbicacionEstampado
	@ManyToOne
	@JoinColumn(name="UBICACION_ESTAMPADO")
	private UbicacionEstampado ubicacionEstampadoBean;

	public Camiseta() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public CarritoCompra getCarritoCompra() {
		return this.carritoCompra;
	}

	public void setCarritoCompra(CarritoCompra carritoCompra) {
		this.carritoCompra = carritoCompra;
	}

	public ColorCamiseta getColorCamiseta() {
		return this.colorCamiseta;
	}

	public void setColorCamiseta(ColorCamiseta colorCamiseta) {
		this.colorCamiseta = colorCamiseta;
	}

	public Estampa getEstampaBean() {
		return this.estampaBean;
	}

	public void setEstampaBean(Estampa estampaBean) {
		this.estampaBean = estampaBean;
	}

	public MaterialCamiseta getMaterialCamiseta() {
		return this.materialCamiseta;
	}

	public void setMaterialCamiseta(MaterialCamiseta materialCamiseta) {
		this.materialCamiseta = materialCamiseta;
	}

	public TallaCamiseta getTallaCamiseta() {
		return this.tallaCamiseta;
	}

	public void setTallaCamiseta(TallaCamiseta tallaCamiseta) {
		this.tallaCamiseta = tallaCamiseta;
	}

	public TamanoEstampado getTamanoEstampadoBean() {
		return this.tamanoEstampadoBean;
	}

	public void setTamanoEstampadoBean(TamanoEstampado tamanoEstampadoBean) {
		this.tamanoEstampadoBean = tamanoEstampadoBean;
	}

	public UbicacionEstampado getUbicacionEstampadoBean() {
		return this.ubicacionEstampadoBean;
	}

	public void setUbicacionEstampadoBean(UbicacionEstampado ubicacionEstampadoBean) {
		this.ubicacionEstampadoBean = ubicacionEstampadoBean;
	}

}