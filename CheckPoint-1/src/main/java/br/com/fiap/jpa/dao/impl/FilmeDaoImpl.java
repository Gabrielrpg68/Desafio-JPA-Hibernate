package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.FilmeDao;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public class FilmeDaoImpl implements FilmeDao {
	
	private EntityManager em;
	
	public FilmeDaoImpl(EntityManager em) {
		this.em = em;
	}

	public Filme pesquisar(Integer id) throws IdNotFoundException {
		//Pesquisar o filme no banco
		Filme filme = em.find(Filme.class, id);
		//Validar se o filme não existe (se é igual null)
		if (filme == null)
			//Se existir, lançar uma exception
			throw new IdNotFoundException(); 
		//Se não existir, Retorna a film
		return filme;
	}

	public void cadastrar(Filme filme) {
		em.persist(filme);
		System.out.println("Filme cadastrado");
	}

	public void atualizar(Filme filme) throws IdNotFoundException {
		//validar se o filme existe no banco, para ser atualizado
		pesquisar(filme.getCodigo()); 
		em.merge(filme);
		System.out.println("Filme Atualizado");
	}

	public void remover(Integer id) throws IdNotFoundException {
		Filme filme = pesquisar(id);
		em.remove(filme);
		System.out.println("Filme removido");
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
}
