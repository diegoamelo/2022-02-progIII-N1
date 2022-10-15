package br.edu.femass.biblioteca.model;

import java.util.List;

public class Livro {

    private Long codigo;
    private String titulo;
    private List<Autor> autores;
    private static Long proximoCodigo = 1L;

    public Livro(String titulo, List<Autor> autores){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.autores = autores;
    }

    public String toString() {
        return this.titulo.toUpperCase();
    }
}
