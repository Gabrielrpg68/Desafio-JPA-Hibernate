package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class GenericDaoImpl<T,K> implements GenericDao<T, K> {

	private EntityManager em;
	
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(T entidade) {
		em.persist(entidade);
		System.out.println("Filme cadastrado com sucesso");
	}

	public void atualizar(T entidade) {
		em.merge(entidade);
		System.out.println("Filme Atualizado com sucesso");
	}

	public void remover(K id) throws IdNotFoundException {
		T entidade = pesquisar(id);
		em.remove(entidade);
		System.out.println("O metodo pesquisar não funciona no GenericDAO, logo, não sera possivel fazer o remove, pois teriamos que pesquisar antes o objeto a ser deletedo");
		System.out.println("Filme Removido com sucesso");
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

	public T pesquisar(K id) throws IdNotFoundException {
		return null;
	}
}
