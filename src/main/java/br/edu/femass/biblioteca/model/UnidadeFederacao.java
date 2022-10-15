package br.edu.femass.biblioteca.model;

public enum UnidadeFederacao {

    AMAZONAS("Amazonas", "AM", "Manaus"),
    ALAGOAS("Alagoas", "AL", "Maceió"),
    ACRE("Acre", "AC", "Rio Branco"),
    AMAPA("Amapá", "AP", "Macapá"),
    BAHIA("Bahia", "BA", "Salvador"),
    PARA("Pará", "PA", "Belém"),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
    GOIAS("Goiás", "GO", "Goiânia"),
    MARANHAO("Maranhão", "MA", "São Luís"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
    TOCANTINS("Tocantins", "TO", "Palmas"),
    PIAUI("Piauí", "PI", "Teresina"),
    SAO_PAULO("São Paulo", "SP", "São Paulo"),
    RONDONIA("Rondônia", "RO", "Porto Velho"),
    RORAIMA("Roraima", "RR", "Boa Vista"),
    PARANA("Paraná", "PR", "Curitiba"),
    CEARA("Ceará", "CE", "Fortaleza"),
    PERNAMBUCO("Pernambuco", "PE", "Recife"),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis"),
    PARAIBA("Paraíba", "PB", "João Pessoa"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    SERGIPE("Sergipe", "SE", "Aracaju"),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília");

    private final String nome;
    private final String sigla;
    private final String capital;

    UnidadeFederacao(final String nome, final String sigla, final String capital) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
    }

    public static UnidadeFederacao fromUF(final String nomeUf) {
        for (final UnidadeFederacao uf : UnidadeFederacao.values())
            if (uf.nome.equalsIgnoreCase(nomeUf))
                return uf;
        throw new IllegalArgumentException(nomeUf);
    }

    public static UnidadeFederacao fromSigla(final String sigla) {
        for (final UnidadeFederacao uf : UnidadeFederacao.values())
            if (uf.sigla.equalsIgnoreCase(sigla))
                return uf;
        throw new IllegalArgumentException(sigla);
    }

    public static UnidadeFederacao fromCapital(final String capital) {
        for (final UnidadeFederacao uf : UnidadeFederacao.values())
            if (uf.capital.equalsIgnoreCase(capital))
                return uf;
        throw new IllegalArgumentException(capital);
    }

    public String getNome() {
        return this.nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getCapital() {
        return this.capital;
    }

    @Override
    public String toString() {
        return nome;
    }
}
