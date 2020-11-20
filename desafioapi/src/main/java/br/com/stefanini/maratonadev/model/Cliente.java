package br.com.stefanini.maratonadev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name="cliente")
public class Cliente extends PanacheEntityBase{
	
	
	@Id
	private String cpf;
	
	@Column(name="nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="contato", nullable = false)
	private String contato;
	
	@Column(name="cep", nullable = false)
	private String cep;
	
	@Column(name="logradouro", nullable = true)
	private String logradouro;
	
	@Column(name="complemento", nullable = true)
	private String complemento;
	
	@Column(name="bairro", nullable = false)
	private String bairro;
	
	@Column(name="cidade", nullable = false)
	private String cidade;
	
	@Column(name="uf", nullable = false)
	private String uf;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Aluguel> alugueis;
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}
	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	
	
	
}
