package com.project.turistae.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Blog;
	private String conteudo;
	@ManyToOne
	@JoinColumn(name = "iD_Visitante")
	private Visitante ID_Visitante;
	@ManyToOne
	@JoinColumn(name = "iD_Post")
	private Conteudo ID_Post;
	
	
	public Blog() {
		super();
	}


	public Blog(Long iD_Blog, String conteudo, Visitante iD_Visitante, Conteudo iD_Post) {
		super();
		ID_Blog = iD_Blog;
		this.conteudo = conteudo;
		ID_Visitante = iD_Visitante;
		ID_Post = iD_Post;
	}


	public Long getID_Blog() {
		return ID_Blog;
	}


	public void setID_Blog(Long iD_Blog) {
		ID_Blog = iD_Blog;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public Visitante getID_Visitante() {
		return ID_Visitante;
	}


	public void setID_Visitante(Visitante iD_Visitante) {
		ID_Visitante = iD_Visitante;
	}


	public Conteudo getID_Post() {
		return ID_Post;
	}


	public void setID_Post(Conteudo iD_Post) {
		ID_Post = iD_Post;
	}

}
