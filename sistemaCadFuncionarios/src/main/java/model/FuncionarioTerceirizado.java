package model;

import java.math.BigDecimal;

public class FuncionarioTerceirizado extends Pessoa {

    private Funcao funcao;
    private String empresa;
    private BigDecimal horasTrabalhadas;
    private boolean primeiroAcesso;

    // custo = (horas * valorHora) + 30%
    public BigDecimal getCusto() {
        if (funcao == null || horasTrabalhadas == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal base = horasTrabalhadas.multiply(funcao.getValorHora());
        return base.multiply(new BigDecimal("1.3"));
    }

    public boolean isPrimeiroAcesso() {
        return primeiroAcesso;
    }

    public void setPrimeiroAcesso(boolean primeiroAcesso) {
        this.primeiroAcesso = primeiroAcesso;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(BigDecimal horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}