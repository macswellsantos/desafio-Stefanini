package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;


@ApplicationScoped
public class ClienteService {
	
	@Inject
    ClienteDao dao;


    public List<ClienteDto> listar(){
        return dao.listar().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
    }
    
    public void inserir(ClienteDto dto) {
    	dao.inserir(ClienteParser.get().entidade(dto));
    }
    
    public void alterar(String id, ClienteDto dto) {
    	dao.alterar(id, ClienteParser.get().entidade(dto));
    }
    
    public void deletar(String id) {
    	dao.deletar(id);
    }
    
    public ClienteDto buscarPorCpf(String cpf){
        return ClienteParser.get().dto(dao.buscarId(cpf));
    }
    
}
