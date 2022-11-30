package com.project.turistae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Usuario;
	private String permissao;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String senha;

	
	public Usuario() {
		super();
	}

	public Usuario(Long iD_Usuario, String permissao, String email, String senha) {
		super();
		ID_Usuario = iD_Usuario;
		this.permissao = permissao;
		this.email = email;
		this.senha = senha;
	}

	public Long getID_Usuario() {
		return ID_Usuario;
	}

	public void setID_Usuario(Long iD_Usuario) {
		ID_Usuario = iD_Usuario;
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
	
	
	

}
