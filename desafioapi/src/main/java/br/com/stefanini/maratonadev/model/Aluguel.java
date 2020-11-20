package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="aluguel")
public class Aluguel extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="carro_placa", updatable=false)
	private Carro carro;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cliente_cpf", updatable=false)
	private Cliente cliente;
	
	@Column(name="data")
	private LocalDateTime dataAluguel;

	public Aluguel(Carro carro, Cliente cliente) {
		this.carro = carro;
		this.cliente = cliente;
	}
	
	public Aluguel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(LocalDateTime dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	
	
	
}
