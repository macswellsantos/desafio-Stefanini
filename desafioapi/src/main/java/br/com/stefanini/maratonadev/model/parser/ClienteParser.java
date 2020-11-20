package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {
	
	 public static ClienteParser get(){
		 return  new ClienteParser();
	 }

    public ClienteDto dto(Cliente entidade){
    	
        ClienteDto dto = new ClienteDto();

        dto.setCpf(entidade.getCpf());
        dto.setNome(entidade.getNome());
        dto.setEmail(entidade.getEmail());
        dto.setContato(entidade.getContato());
        dto.setCep(entidade.getCep());
        dto.setLogradouro(entidade.getLogradouro());
        dto.setComplemento(entidade.getComplemento());
        dto.setBairro(entidade.getBairro());
        dto.setCidade(entidade.getCidade());
        dto.setUf(entidade.getUf());
        
        return dto;
    }
	    
	    public Cliente entidade(ClienteDto dto){
	    	
	        Cliente entidade = new Cliente();

	        entidade.setCpf(dto.getCpf());
	        entidade.setNome(dto.getNome());
	        entidade.setEmail(dto.getEmail());
	        entidade.setContato(dto.getContato());
	        entidade.setCep(dto.getCep());
	        entidade.setLogradouro(dto.getLogradouro());
	        entidade.setComplemento(dto.getComplemento());
	        entidade.setBairro(dto.getBairro());
	        entidade.setCidade(dto.getCidade());
	        entidade.setUf(dto.getUf());
	        
	        return entidade;
	    }
}
