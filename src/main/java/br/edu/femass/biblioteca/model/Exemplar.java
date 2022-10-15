package br.edu.femass.biblioteca.model;

import java.time.LocalDate;
import java.util.List;

public class Exemplar {

    private Long codigo;
    private LocalDate dataAquisicao;
    private Livro livro;
    private static Long proximoCodigo = 1L;

    public Exemplar(LocalDate dataAquisicao, Livro livro){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = dataAquisicao;
        this.livro = livro;
    }

}
