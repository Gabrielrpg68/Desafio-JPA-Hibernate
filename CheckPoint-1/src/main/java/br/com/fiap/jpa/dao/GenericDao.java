package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

//T -> define o tipo da entidade
//K -> define o tipo da chave primária
public interface GenericDao<T, K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K id) throws IdNotFoundException;
	
	T pesquisar(K id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}