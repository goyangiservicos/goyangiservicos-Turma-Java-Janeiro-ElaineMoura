package codigoFonte;

public class JogadorFutsal extends Atleta{
	
	private String pernaMaisForte;
	private Double valorPorGols;
	private int qtdGols;
	public String getPernaMaisForte() {
		return pernaMaisForte;
	}
	
	public void setPernaMaisForte(String pernaMaisForteChegando) {
		this.pernaMaisForte = pernaMaisForteChegando;
	}
	
	public Double getValorPorGols() {
		return valorPorGols;
	}
	
	public void setValorPorGols(Double valorPorGolsChegando) {
		verificaNumeroNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;
	
	}

	@Override
	protected Double calcularPagamento() {
		
		return valorPorGols*50;
	}

	@Override
	protected int qtdTreinoSemana() {
		
		return 5;
	}

	public int getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(int qtdGols) {
		verificaNumeroNegativo((double)qtdGols);
		this.qtdGols = qtdGols;
	}



}