package br.edu.femass.model;

import lombok.Data;

@Data
public class Professor extends Leitor{

    private String disciplina;

    public Professor(){}

    public Professor(String nome,
                     String rua,
                     Integer numero,
                     String complemento,
                     String bairro,
                     String cidade,
                     String uf,
                     String pais,
                     String cep,
                     String telefone,
                     String disciplina){
        super(nome, rua, numero, complemento, bairro, cidade, uf, pais, cep, telefone, 30);
        this.disciplina = disciplina;
    }

    public String toString() {
        return this.getNome().toUpperCase();
    }
}
