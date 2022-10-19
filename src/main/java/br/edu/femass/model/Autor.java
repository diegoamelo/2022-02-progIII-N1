package br.edu.femass.model;

import java.util.Objects;

public class Autor {

    private String nome;
    private String sobrenome;
    private String nacionalidade;

    public Autor(){}

    public Autor(String nome, String sobrenome, String nacionalidade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nome, autor.nome)
                && Objects.equals(sobrenome, autor.sobrenome)
                && Objects.equals(nacionalidade, autor.nacionalidade);
    }

    public String toString() {
        return this.nome.toUpperCase() + " " + this.sobrenome.toUpperCase();
    }

}
