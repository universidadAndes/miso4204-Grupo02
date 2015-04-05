package edu.estampate.service.ws;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import edu.estampate.service.daos.ColorCamisetaDAO;
import edu.estampate.service.entidades.ColorCamiseta;

/**
 * Implementa los métodos requeridos para la gestión de ventas.
 * 
 * @author JuanCamilo
 * 
 */
@Path("/ventas")
@Stateless
@LocalBean
public class VentasService implements IVentasService {
	
	@EJB
	ColorCamisetaDAO colorCamisetaDAO;

	/* (non-Javadoc)
	 * @see edu.estampate.service.ws.IVentasService#getColorCamiseta(long)
	 */
	@Override
	@GET
	@Path("/getColorCamiseta/{id}")
	public ColorCamiseta getColorCamiseta(@PathParam("id") long id) {
		return colorCamisetaDAO.getColorCamiseta(id);
	}

	/* (non-Javadoc)
	 * @see edu.estampate.service.ws.IVentasService#insertarColorCamiseta(edu.estampate.service.entidades.ColorCamiseta)
	 */
	@Override
	@POST
	public void insertarColorCamiseta(ColorCamiseta colorCamiseta) {
		colorCamisetaDAO.insertarColorCamiseta(colorCamiseta);
	}

}
