package com.esprit.domain.gestionEntites.gestionActivite;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Activite;

/**
 * Session Bean implementation class GestionActivite
 */
@Stateless
public class GestionActivite implements GestionActiviteLocal,
		GestionActiviteRemote {

	@PersistenceContext
	EntityManager entityManager;

	public GestionActivite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Activite a) {
		entityManager.persist(a);

	}

	@Override
	public void deleteByRef(int ref) {
		entityManager.remove(entityManager.find(Activite.class, ref));
	}

	@Override
	public void delete(Activite t) {
		entityManager.remove(entityManager.find(Activite.class,
				t.getRefActivite()));

	}

	@Override
	public void update(Activite a) {
		entityManager.merge(a);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllTypeActivite() {
		// TODO Auto-generated method stub
		String query = "select libelleActivite from Activite";
		return entityManager.createQuery(query).getResultList();
	}
	
	

	@Override
	public Activite findByRef(int ref) {
		return entityManager.find(Activite.class, ref);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activite> findAll() {
		return entityManager.createQuery("SELECT a from Activite a")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activite> findByNom(String nomActivite) {
		return entityManager
				.createQuery(
						"select a from Activite a where a.nomActivite like :anomActivite ")
				.setParameter("anomActivite", nomActivite).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Activite> findByDescription(String description) {
		return entityManager
				.createQuery(
						"select a from Activite a where a.description like :adescription ")
				.setParameter("adescription", description).getResultList();
	}

}