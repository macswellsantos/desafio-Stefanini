package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.model.Aluguel;

public class AluguelParser {
    public static AluguelParser get(){
        return  new AluguelParser();
    }

    public AluguelDto dto(Aluguel entidade){
    	AluguelDto dto = new AluguelDto();

        dto.setId(entidade.getId());
        dto.setPlaca(entidade.getCarro().getPlaca());
        dto.setModelo(entidade.getCarro().getModelo());
        dto.setCpf(entidade.getCliente().getCpf());
        dto.setNome(entidade.getCliente().getNome());
        dto.setDataAluguel(entidade.getDataAluguel());
        
        return dto;
    }
    

}
