package codigoFonte;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args){
		System.out.println("#################Inicio Cadastro de Atletas############");
		Scanner entradaDeDados = new Scanner(System.in);

		JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete(); 
		JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();

		System.out.println("Digite F para jogador(a) de futsal ou B para jogador(a) de basquete");
		String opcao = entradaDeDados.next();
		
		if(opcao.equals("F")){
		System.out.println("Digite o nome do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setNomeAtleta(entradaDeDados.next());
		
		System.out.println("Digite a idade do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setIdade(entradaDeDados.nextInt());
		
		System.out.println("Digite a perna mais forte do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setPernaMaisForte(entradaDeDados.next());
		
		System.out.println("Digite o valor por gol do jogador(a): ");
		jogadorFutsalObjeto.setValorPorGols(entradaDeDados.nextDouble());
		
		System.out.println("Digite quantidade de gols marcardos: ");
		jogadorFutsalObjeto.setQtdGols(entradaDeDados.nextInt());
		
		System.out.println("O valor: "+jogadorFutsalObjeto.calcularPagamento());
		
		
		System.out.println("Nome do jogador(a) é: " + jogadorFutsalObjeto.getNomeAtleta());
		System.out.println("A idade do jogador(a) é: " +jogadorFutsalObjeto.getIdade () );
		System.out.println("Perna mais forte do jogador(a) é: " + jogadorFutsalObjeto.getPernaMaisForte());
		System.out.println("Valor por gols do jogador(a) é: " + jogadorFutsalObjeto.getValorPorGols());
		System.out.println("Valor por gols do jogador(a) é: " + jogadorFutsalObjeto.getQtdGols());
		System.out.println("O valor: " + jogadorFutsalObjeto.calcularPagamento());
		System.out.println("Quantidade treinos semana: " + jogadorBasqueteObjeto.qtdTreinoSemana());	
	        }
	
		if(opcao.equals("B")){
		System.out.println("Digite o nome do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.setNomeAtleta(entradaDeDados.next());
		
		System.out.println("Digite a idade do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.setIdade(entradaDeDados.nextInt());
		
		System.out.println("Digite a braco mais forte do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.setBracoMaisForte(entradaDeDados.next());

		System.out.println("Digite o valor por gol do Basquete: ");
		jogadorBasqueteObjeto.setValorPorPontos(entradaDeDados.nextDouble()); 
		
		System.out.println("Digite quantidade de gols marcardos: ");
		jogadorBasqueteObjeto.setQntPontos(entradaDeDados.nextInt());
		
		System.out.println("O valor: "+jogadorBasqueteObjeto.calcularPagamento());
		
		
		System.out.println("Nome do jogador(a) é: " + jogadorBasqueteObjeto.getNomeAtleta() );
		System.out.println("A idade do jogador(a) é: " + jogadorBasqueteObjeto.getIdade() );
		System.out.println("Braco mais forte do jogador(a) é: " + jogadorBasqueteObjeto.getBracoMaisForte());
		System.out.println("Valor por pontos do jogador(a) é: " + jogadorBasqueteObjeto.getValorPorPontos());
		System.out.println("Valor por gols do jogador(a) é: " + jogadorBasqueteObjeto.getQntPontos());
		System.out.println("O valor: " + jogadorBasqueteObjeto.calcularPagamento());
		System.out.println("Quantidade treinos semana: " + jogadorBasqueteObjeto.qtdTreinoSemana());
		}
	System.out.println("#################Fim do Cadastro de Atletas############");
	}



} 
