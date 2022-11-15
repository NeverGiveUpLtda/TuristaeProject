package com.project.turistae.entities;
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
	private String Nome;
	private String email;
	private String senha;
	@ManyToOne
	@JoinColumn(name = "iD_Usuario")
	private Usuario ID_Usuario;
	
	public Visitante() {
		
	}

	public Visitante(Long iD_Visitante, String nome, String email, String senha, Usuario iD_Usuario) {
		super();
		ID_Visitante = iD_Visitante;
		Nome = nome;
		this.email = email;
		this.senha = senha;
		ID_Usuario = iD_Usuario;
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

	public Usuario getID_Usuario() {
		return ID_Usuario;
	}

	public void setID_Usuario(Usuario iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}

}
