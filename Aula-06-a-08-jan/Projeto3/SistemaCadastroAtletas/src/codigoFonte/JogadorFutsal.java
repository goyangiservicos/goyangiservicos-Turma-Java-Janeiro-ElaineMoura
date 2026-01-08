package codigoFonte;

public class JogadorFutsal extends Atleta{
	
	private String pernaMaisForte;
	private Double valorPorGols;
	
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
		Utilitario util = new Utilitario();
		util.verificaNumeroNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;
	
	}
}