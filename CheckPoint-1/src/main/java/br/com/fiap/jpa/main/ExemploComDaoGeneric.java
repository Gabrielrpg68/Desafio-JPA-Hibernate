package br.com.fiap.jpa.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Filme;
import br.com.fiap.jpa.entity.GeneroFilme;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploComDaoGeneric {

	public static void main(String[] args) {
		
		//Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma Filme
		Filme filme = new Filme("Forest Gump", GeneroFilme.ACAO, "02:30", new GregorianCalendar(1994, Calendar.JULY, 01));

		//Instanciar uma FilmeDaoImpl
		GenericDao<Filme, Integer> dao = new GenericDaoImpl(em);
		
		//Cadastrar
		try {
			dao.cadastrar(filme);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar o nome da filme
			filme.setNome("Clube da Luta");
			dao.atualizar(filme);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
}



