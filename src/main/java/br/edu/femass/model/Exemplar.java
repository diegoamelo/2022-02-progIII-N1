package br.edu.femass.model;

import java.time.LocalDateTime;
import java.util.List;

public class Exemplar {

    private Long codigo;
    private LocalDateTime dataAquisicao;
    private Livro livro;
    private static Long proximoCodigo = 1L;
    private boolean emprestado;

    public Exemplar() {}

    public Long getCodigo() {
        return codigo;
    }

    public LocalDateTime getDataAquisicao() {
        return dataAquisicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void empresta() {
        this.emprestado = true;
    }

    public void devolve(){
        this.emprestado = false;
    }

    public Exemplar(LocalDateTime dataAquisicao, Livro livro){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.dataAquisicao = dataAquisicao;
        this.livro = livro;
        this.emprestado = false;
    }

    public static void atualizarProximoNumero(List<Exemplar> exemplares){
        for(Exemplar exemplar: exemplares)
            if(exemplar.getCodigo() > proximoCodigo)
                proximoCodigo = exemplar.getCodigo() + 1;
    }

    public String toString() {
        return "Código: " + this.codigo + " - Título: " + this.livro.getTitulo().toUpperCase();
    }
}
