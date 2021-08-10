package br.com.lanchonete.pessoas.commons;

public enum TipoPessoa {
    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
