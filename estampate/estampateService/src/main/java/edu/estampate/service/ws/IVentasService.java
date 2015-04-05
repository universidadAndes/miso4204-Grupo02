package edu.estampate.service.ws;

import edu.estampate.service.entidades.ColorCamiseta;

/**
 * Define los métodos requeridos para la gestión de ventas de camisetas.
 * 
 * @author JuanCamilo
 * 
 */
public interface IVentasService {

	/**
	 * Obtiene un color de camiseta por id.
	 * 
	 * @param id
	 * @return
	 */
	ColorCamiseta getColorCamiseta(long id);

	/**
	 * Inserta una camiseta en base de datos.
	 * 
	 * @param colorCamiseta
	 */
	void insertarColorCamiseta(ColorCamiseta colorCamiseta);
}
