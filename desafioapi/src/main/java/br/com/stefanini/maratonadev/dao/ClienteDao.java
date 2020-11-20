package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.stefanini.maratonadev.model.Cliente;

@ApplicationScoped
public class ClienteDao {
	
	 public List<Cliente> listar(){
		 return Cliente.listAll();
	 }
	 
	 @Transactional
	 public void inserir(Cliente cliente) {
		 Cliente.persist(cliente);
	 }
		
	@Transactional
	public void alterar(String id, Cliente cliente) {
		
		Cliente clienteSalvo = buscarId(id);
		
		clienteSalvo.setCpf(cliente.getCpf());
		clienteSalvo.setNome(cliente.getNome());
		clienteSalvo.setEmail(cliente.getEmail());
		clienteSalvo.setContato(cliente.getContato());
		clienteSalvo.setCep(cliente.getCep());
		clienteSalvo.setLogradouro(cliente.getLogradouro());
		clienteSalvo.setComplemento(cliente.getComplemento());
		clienteSalvo.setBairro(cliente.getBairro());
		clienteSalvo.setCidade(cliente.getCidade());
		clienteSalvo.setUf(cliente.getUf());
	}
	
	
	@Transactional
	public void deletar(String id) {	
		Cliente cliente = buscarId(id);
		cliente.delete();
	}
	

	@Transactional
	public Cliente buscarId(String id) {
		
		Cliente cliente = Cliente.findById(id);
        if (cliente == null) {
            throw new WebApplicationException("Cliente com o CPF " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        System.out.print("Foi");
        return cliente;
	}
}
