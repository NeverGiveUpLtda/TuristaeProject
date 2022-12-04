package com.project.turistae.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_turismo")

public class Turismo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Turismo;
	
	private String nomefantasia;
	private String razaosocial;
	private String bairro;
	private String celular;
	private String numero;
	private String logradouro;
	private String cep;
	private String uf;
	private String cnpj;
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "iD_Conteudo")
	private Conteudo iD_Conteudo;
	
	@ManyToOne
	@JoinColumn(name = "iD_Usuario")
	private Usuario ID_Usuario;
	
	public Turismo() {
		
	}

	

	public Turismo(Long iD_Turismo, String nomefantasia, String razaosocial, String bairro, String celular,
			String numero, String logradouro, String cep, String uf, String cnpj, String cidade, Conteudo iD_Conteudo,
			Usuario iD_Usuario) {
		super();
		ID_Turismo = iD_Turismo;
		this.nomefantasia = nomefantasia;
		this.razaosocial = razaosocial;
		this.bairro = bairro;
		this.celular = celular;
		this.numero = numero;
		this.logradouro = logradouro;
		this.cep = cep;
		this.uf = uf;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.iD_Conteudo = iD_Conteudo;
		ID_Usuario = iD_Usuario;
	}



	public Conteudo getiD_Conteudo() {
		return iD_Conteudo;
	}



	public void setiD_Conteudo(Conteudo iD_Conteudo) {
		this.iD_Conteudo = iD_Conteudo;
	}



	public Long getID_Turismo() {
		return ID_Turismo;
	}

	public void setID_Turismo(Long iD_Turismo) {
		ID_Turismo = iD_Turismo;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Usuario getID_Usuario() {
		return ID_Usuario;
	}

	public void setID_Usuario(Usuario iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
		
	
}
	


