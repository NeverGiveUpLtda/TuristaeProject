package com.app.turistae.model;

public class Usuario {

    private int id;
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String email;
    private Long telefone;
    private String numeroCasa;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String dataNascimento;
    private String profissao;
    private String cadastroPessoaFisica;
    private String registroGeral;

    public Usuario() {
    }

    public Usuario(int id, String nomeUsuario, String senha, String nome, String email, Long telefone, String numeroCasa, String rua, String bairro, String cidade, String estado, String dataNascimento, String profissao, String cadastroPessoaFisica, String registroGeral) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.numeroCasa = numeroCasa;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.cadastroPessoaFisica = cadastroPessoaFisica;
        this.registroGeral = registroGeral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCadastroPessoaFisica() {
        return cadastroPessoaFisica;
    }

    public void setCadastroPessoaFisica(String cadastroPessoaFisica) {
        this.cadastroPessoaFisica = cadastroPessoaFisica;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", numeroCasa='" + numeroCasa + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", profissao='" + profissao + '\'' +
                ", cadastroPessoaFisica='" + cadastroPessoaFisica + '\'' +
                ", registroGeral='" + registroGeral + '\'' +
                '}';
    }

}

//{ AQUI ESTA O OBJETO QUE PEGUEI DO POSTMAN PARA FAZER ESTA CLASSE
//        "nomeUsuario": "ettorerollo",
//        "senha": "SenhaValida@123",
//        "nome": "Ettore Alessandro Rollo",
//        "email": "ettorerollo@hotmail.com",
//        "telefone": "15981261762",
//        "numeroCasa": "71",
//        "rua": "Rua Quinzinho de Barros",
//        "bairro": "Vila Hortência",
//        "cidade": "Sorocaba",
//        "estado": "SP",
//        "dataNascimento": "2000-07-15T00:00",
//        "profissao": "Desenvolvedor Java Júnior",
//        "cadastroPessoaFisica": "479.117.138-12",
//        "registroGeral": "58.270.143-0"
//        }