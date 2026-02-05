package model;

import java.math.BigDecimal;

public class FuncionarioInterno extends Pessoa {

	private String matricula;
	private Cargo cargo;
	private BigDecimal salario;
	private boolean primeiroAcesso;

	public boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	// Regra de negócio: PLR = 80% do salario
	public BigDecimal getPlr() {
		if (salario == null) {
			return BigDecimal.ZERO;
		}
		return salario.multiply(new BigDecimal("0.8"));
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}