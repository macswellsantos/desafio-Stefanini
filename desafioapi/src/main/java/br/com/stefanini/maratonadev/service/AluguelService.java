package br.com.stefanini.maratonadev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.stefanini.maratonadev.dao.AluguelDao;
import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.model.Aluguel;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.AluguelParser;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@ApplicationScoped
public class AluguelService {
	
	@Inject
	CarroDao carroDao;
	@Inject
	ClienteDao clienteDao;
	@Inject
	AluguelDao aluguelDao;
	
	public void alugar(String placa, String cpf) {
		
		Aluguel aluguel = new Aluguel();
		Carro carro = new Carro();
		Cliente cliente = new Cliente();
		
		carro = carroDao.buscaPlaca(placa);
		
		//Verifica se não está locado
		//if(!carro.getAlugado()) {
			
		
			System.out.println(cpf);
			System.out.println(carro.getModelo());
			cliente = clienteDao.buscarId(cpf);
			
			aluguel.setCarro(new Carro(placa));
			aluguel.setCliente(new Cliente(cpf));
			aluguel.setDataAluguel(LocalDateTime.now());
			Long i = aluguelDao.inserir(aluguel);
			carro.setAlugado(true);
			System.out.println(i);
			carroDao.alterar(carro);
	}
	
	public List<AluguelDto> listar(){
		return aluguelDao.listar().stream().map(AluguelParser.get()::dto).collect(Collectors.toList());
	}
}
