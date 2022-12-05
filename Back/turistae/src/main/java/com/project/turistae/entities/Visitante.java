package com.project.turistae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_visitantes")

public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Visitante;
	
	@Column
	private String Nome;

	@Column
	private String permissao;

	@Column(unique = true)
	private String email;

	@Column
	private String senha;


	public Visitante() {

	}

	

	public Visitante(Long iD_Visitante, String nome, String permissao, String email, String senha) {
		super();
		ID_Visitante = iD_Visitante;
		Nome = nome;
		this.permissao = permissao;
		this.email = email;
		this.senha = senha;
	}



	public String getPermissao() {
		return permissao;
	}



	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public Long getID_Visitante() {
		return ID_Visitante;
	}

	public void setID_Visitante(Long iD_Visitante) {
		ID_Visitante = iD_Visitante;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}


}
