package br.edu.femass.model;

import java.time.LocalDateTime;

public class Emprestimo {

    private Exemplar exemplar;
    private Leitor leitor;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataPrevistaDevolucao;
    private LocalDateTime dataDevolucao;

    public Emprestimo(){}

    public Emprestimo(Exemplar exemplar,
                      Leitor leitor,
                      LocalDateTime dataEmprestimo,
                      LocalDateTime dataPrevistaDevolucao) {
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = null;
    }

    public Emprestimo(Exemplar exemplar,
                      Leitor leitor,
                      LocalDateTime dataEmprestimo,
                      LocalDateTime dataPrevistaDevolucao,
                      LocalDateTime dataDevolucao
        ) {
        this.exemplar = exemplar;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDateTime getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toString() {
        return "Código: " + this.exemplar.getCodigo() +
                " - Título: " + this.exemplar.getLivro().getTitulo().toUpperCase() +
                " - Responsável: " + this.leitor.toString();
    }
}
