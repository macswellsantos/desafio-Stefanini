package br.com.stefanini.maratonadev.model;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.List;

import javax.persistence.*;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:27
 */
@Entity
@Table(name = "carro")
public class Carro   extends PanacheEntityBase {
    @Id
    private String placa;

    @Column(name = "ano")
    private int ano;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;
    
    @Column(name="alugado")
    private Boolean alugado;
    
    @OneToMany(mappedBy = "carro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Aluguel> alugueis;
    
    public Carro(String placa) {
		this.placa = placa;
	}
    
    public Carro() {
		super();
	}

	public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

	public Boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	
    
}