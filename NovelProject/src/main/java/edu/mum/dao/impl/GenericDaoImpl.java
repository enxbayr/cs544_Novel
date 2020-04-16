package edu.mum.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.mum.dao.GenericDao;
import edu.mum.dao.UserDao;

/*@SuppressWarnings("unchecked")
@Repository*/
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
		daoType = type;
	}

	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public T delete(T entity) {
		entityManager.remove(entity);
		return entity;
	}

	@Override
	public T delete(Long id) {
		T entity = findOne(id);
		delete(entity);
		return entity;
	}

	@Override
	public T findOne(Long id) {
		return (T) entityManager.find(daoType, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return entityManager.createQuery("from " + daoType.getName()).getResultList();
	}

	@Override
	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public List<T> findAll(String s, Object hint) {
		return (List<T>) entityManager.createQuery("SELECT m FROM User AS m").setHint(s, hint).getResultList();
	}

}