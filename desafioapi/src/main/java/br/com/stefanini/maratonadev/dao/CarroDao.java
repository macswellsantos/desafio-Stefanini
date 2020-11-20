package br.com.stefanini.maratonadev.dao;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.util.List;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:30
 */
@RequestScoped
public class CarroDao {

    public List<Carro> listar(){
        return Carro.listAll(Sort.by("modelo,marca").ascending());
    }
    
    public Carro buscaPlaca(String placa) {
    	Carro carro = Carro.findById(placa);
    	if (carro == null) {
            throw new WebApplicationException("Carro com a placa " + placa + " não existe.", Response.Status.NOT_FOUND);
        }
    	return carro ;
    }

    @Transactional
	public void alterar(Carro carro) {
		Carro carroSalvo = buscaPlaca(carro.getPlaca());
		carroSalvo.setAlugado(carro.getAlugado());
	}
}
