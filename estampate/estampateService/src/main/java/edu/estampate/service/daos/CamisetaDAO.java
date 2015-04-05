package edu.estampate.service.daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.estampate.service.entidades.Camiseta;

@Stateless
@LocalBean
public class CamisetaDAO {
	
	@PersistenceContext(unitName = "estampatePU")
	private EntityManager em;
	
	public Camiseta getCamiseta(){
		return null;
	}
	
}
