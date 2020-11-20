package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.AluguelDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.AluguelService;

@Path("aluguel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AluguelRest {
	
	@Inject
	AluguelService service;
	
	@POST
	@Path("{placa}/{cpf}")
    @Operation(summary = "Realizar um novo aluguel",
            description = "Realiza a locação")
    @APIResponse(responseCode = "201",
            description = "aluguel",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = AluguelDto.class))
            }
    )
	
	public Response alugar(@PathParam("placa")String placa, @PathParam("cpf") String cpf) {
		
		service.alugar(placa, cpf);
		
		return Response
                .status(Response.Status.CREATED)
                .build();
	}

	@GET
    @Operation(summary = "Lista de Locações",
            description = "Lista as Locações realizadas")
    @APIResponse(responseCode = "200",
            description = "aluguel",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = AluguelDto.class))
                    }
            
    )
	public Response listar() {
		return Response
                .status(Response.Status.OK)
                .entity(service.listar())
                .build();
	}
	
}
