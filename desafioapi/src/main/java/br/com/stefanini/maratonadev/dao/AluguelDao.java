package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Aluguel;

@ApplicationScoped
public class AluguelDao {

	@Transactional
	public Long inserir(Aluguel aluguel) {
		Aluguel.persist(aluguel);
		return aluguel.getId();
	}
	
	public List<Aluguel> listar(){
		 return Aluguel.listAll();
	}
	
}
