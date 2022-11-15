package com.project.turistae.entities;

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
	
	
	public Usuario() {
		
	}

	public Usuario(Long iD_Usuario, String permissao) {
		super();
		ID_Usuario = iD_Usuario;
		this.permissao = permissao;
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
	

}
