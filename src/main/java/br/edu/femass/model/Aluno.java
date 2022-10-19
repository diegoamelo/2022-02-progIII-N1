package br.edu.femass.model;

import lombok.Data;

@Data
public class Aluno extends Leitor{

    private String matricula;

    public Aluno(){}

    public Aluno(String nome,
                 String rua,
                 Integer numero,
                 String complemento,
                 String bairro,
                 String cidade,
                 String uf,
                 String pais,
                 String cep,
                 String telefone,
                 String matricula){
        super(nome, rua, numero, complemento, bairro, cidade, uf, pais, cep, telefone, 15);
        this.matricula = matricula;
    }

    public String toString() {
        return this.getNome().toUpperCase();
    }
}
