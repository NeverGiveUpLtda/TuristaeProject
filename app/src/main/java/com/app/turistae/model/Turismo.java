package com.app.turistae.model;

import java.io.Serializable;
import java.util.List;

public class Turismo implements Serializable {

    private int id;
    private String nome;
    private Long telefone;
    private int numeroLocal;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cadastroNacionalPessoasJuridicas;
    private String descricao;
    private int usuarioId;
    private int categoriaId;

    private List<Imagem> imagens;

    public Turismo() {}

    public Turismo(int id, String nome, Long telefone, int numeroLocal, String rua, String bairro, String cidade, String estado, String cadastroNacionalPessoasJuridicas, String descricao, int usuarioId, int categoriaId, List<Imagem> imagens) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.numeroLocal = numeroLocal;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cadastroNacionalPessoasJuridicas = cadastroNacionalPessoasJuridicas;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
        this.categoriaId = categoriaId;
        this.imagens = imagens;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCadastroNacionalPessoasJuridicas() {
        return cadastroNacionalPessoasJuridicas;
    }

    public void setCadastroNacionalPessoasJuridicas(String cadastroNacionalPessoasJuridicas) {
        this.cadastroNacionalPessoasJuridicas = cadastroNacionalPessoasJuridicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}
/*
* {
    "nome": "Turismo Legal",
    "telefone": 15981261762,
    "numeroLocal": 46,
    "rua": "André de zunega",
    "bairro": "Vila Hortência",
    "cidade": "Sorocaba",
    "estado": "SP",
    "cadastroNacionalPessoasJuridicas": "12.345.678/0001-00",
    "descricao": "Turismo Muito legal",
    "usuarioId": 1,
    "categoriaId": 1
}
* */