package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public interface FilmeDao {

	Filme pesquisar(Integer id) throws IdNotFoundException;
	
	void cadastrar(Filme filme);
	
	void atualizar(Filme filme) throws IdNotFoundException;
	
	void remover(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}
