package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	
	@Inject
	ClienteService service;
	
	@GET
    @Operation(summary = "Listar clientes",
            description = "Lista de cliente com as informações cadastradas")
    @APIResponse(responseCode = "200",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
	public Response listar() {
		return Response
                .status(Response.Status.OK)
                .entity(service.listar())
                .build();
	}
	
	@POST
    @Operation(summary = "Inserir clientes",
            description = "Insere um novo cliente")
    @APIResponse(responseCode = "201",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
	public Response inserir(ClienteDto cliente) {
		
		service.inserir(cliente);
		
		return Response
                .status(Response.Status.CREATED)
                .build();
	}
	
	@PUT
	@Path("{id}")
    @Operation(summary = "Editar clientes",
            description = "Edita as informações cadastrada do cliente")
    @APIResponse(responseCode = "200",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
	
	public Response alterar(@PathParam("id") String id, ClienteDto cliente) {
		
		service.alterar(id, cliente);
		
		return Response
                .status(Response.Status.OK)
                .build();
	}
	
	
	@DELETE
	@Path("{id}")
    @Operation(summary = "Deletar cliente",
            description = "Deletar um cliente pelo CPF")
    @APIResponse(responseCode = "200",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
	
	public Response deletar(@PathParam("id") String id) {
		
		service.deletar(id);
		
		return Response
                .status(Response.Status.OK)
                .build();
	}
	
	@GET
	@Path("{id}")
    @Operation(summary = "Buscar cliente",
            description = "Busca um cliente pelo CPF")
    @APIResponse(responseCode = "200",
            description = "cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteDto.class))
            }
    )
	
	public Response buscar(@PathParam("id") String id) {
		
		
		return Response
                .status(Response.Status.OK)
                .entity(service.buscarPorCpf(id))
                .build();
	}
}
