package br.edu.femass.biblioteca.model;

public class Autor {

    private String nome;
    private String sobrenome;
    private String nacionalidade;

    public Autor(String nome, String sobrenome, String nacionalidade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
    }

    public String toString() {
        return this.nome.toUpperCase() + " " + this.sobrenome;
    }
}
