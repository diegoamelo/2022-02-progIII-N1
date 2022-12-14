package br.edu.femass.model;

import lombok.Data;

@Data
public class Leitor {

    private Long codigo;
    private String nome;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String pais;
    private String cep;
    private String telefone;
    private Integer prazoMaximoDevolucao;
    private static Long proximoCodigo = 1L;

    public Leitor(){}

    public Leitor(String nome,
                  String rua,
                  Integer numero,
                  String complemento,
                  String bairro,
                  String cidade,
                  String uf,
                  String pais,
                  String cep,
                  String telefone,
                  Integer prazoMaximoDevolucao){
        this.codigo = proximoCodigo;
        proximoCodigo++;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
        this.cep = cep;
        this.telefone = telefone;
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }
}
