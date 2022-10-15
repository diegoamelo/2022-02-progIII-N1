package br.edu.femass.biblioteca.model;

public class Professor extends Leitor{

    private String disciplina;

    public Professor(String nome,
                     String rua,
                     Integer numero,
                     String complemento,
                     String bairro,
                     String cidade,
                     String uf,
                     String pais,
                     String cep,
                     String ddi,
                     String ddd,
                     String telefone,
                     Integer prazoMaximoDevolucao,
                     String disciplina){
        super(nome, rua, numero, complemento, bairro, cidade, uf, pais, cep, ddi, ddd, telefone, 30);
        this.disciplina = disciplina;
    }

    public String toString() {
        return this.getNome().toUpperCase();
    }
}
