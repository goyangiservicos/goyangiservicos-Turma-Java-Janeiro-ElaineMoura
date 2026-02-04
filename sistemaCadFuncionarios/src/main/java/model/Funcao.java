package model;

import java.math.BigDecimal;

public enum Funcao {

    AUXILIAR_SERVICOS_GERAIS(new BigDecimal("50")),
    ENCARREGADO(new BigDecimal("40")),
    AJUDANTE(new BigDecimal("30"));

    private final BigDecimal valorHora;

    Funcao(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }
}