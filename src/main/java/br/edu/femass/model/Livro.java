package br.edu.femass.model;

import java.util.List;

public class Livro {

    private Long codigo;
    private String titulo;
    private Autor autor;
    private static Long proximoCodigo = 1L;

    public Livro() {}

    public Livro(String titulo, Autor autor){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public static void atualizarProximoNumero(List<Livro> livros){
        for(Livro livro: livros)
            if(livro.getCodigo() > proximoCodigo)
                proximoCodigo = livro.getCodigo() + 1;
    }

    public String toString() {
        return "Código: " + this.codigo + " - Título: " + this.titulo.toUpperCase() + " - Autor: " + this.autor;
    }
}
