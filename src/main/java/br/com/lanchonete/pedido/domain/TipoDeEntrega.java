package br.com.lanchonete.pedido.domain;

public enum TipoDeEntrega {
    DELIVERY("Delivery"),
    MESA("Mesa"),
    LEVAR("Levar");

    private String descricao;

    TipoDeEntrega(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
