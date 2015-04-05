package edu.estampate.service.daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.estampate.service.entidades.ColorCamiseta;

@Stateless
@LocalBean
public class ColorCamisetaDAO {

	@PersistenceContext(unitName = "estampatePU")
	private EntityManager em;

	/**
	 * Consulta un color de camiseta por id.
	 * 
	 * @param id
	 * @return
	 */
	public ColorCamiseta getColorCamiseta(long id) {
		return em.find(ColorCamiseta.class, id);
	}

	/**
	 * Inserta un color de camiseta en base de datos.
	 * 
	 * @param colorCamiseta
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertarColorCamiseta(ColorCamiseta colorCamiseta) {
		em.persist(colorCamiseta);
	}
}
