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
		jogadorFutsalObjeto.nomeAtleta = entradaDeDados.next();
		
		System.out.println("Digite a idade do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.idade = entradaDeDados.nextInt();
		
		System.out.println("Digite a perna mais forte do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.pernaMaisForte = entradaDeDados.next();
		
		System.out.println("Digite o valor por gol do jogador(a): ");
		jogadorFutsalObjeto.valorPorGols = entradaDeDados.nextDouble();

		System.out.println("Nome do jogador(a) é: " + jogadorFutsalObjeto.nomeAtleta );
		System.out.println("A idade do jogador(a) é: " + jogadorFutsalObjeto.idade );
		System.out.println("Perna mais forte do jogador(a) é: " + jogadorFutsalObjeto.pernaMaisForte);
		System.out.println("Valor por gols do jogador(a) é: " + jogadorFutsalObjeto.valorPorGols);

	        }
	
		if(opcao.equals("B")){
		System.out.println("Digite o nome do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.nomeAtleta = entradaDeDados.next();
		
		System.out.println("Digite a idade do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.idade = entradaDeDados.nextInt();
		
		System.out.println("Digite a braco mais forte do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.bracoMaisForte = entradaDeDados.next();

		System.out.println("Digite o valor por gol do Basquete: ");
		jogadorBasqueteObjeto.valorPorPontos = entradaDeDados.nextDouble();

		System.out.println("Nome do jogador(a) é: " + jogadorBasqueteObjeto.nomeAtleta );
		System.out.println("A idade do jogador(a) é: " + jogadorBasqueteObjeto.idade );
		System.out.println("Braco mais forte do jogador(a) é: " + jogadorBasqueteObjeto.bracoMaisForte);
		System.out.println("Valor por pontos do jogador(a) é: " + jogadorBasqueteObjeto.valorPorPontos);

		}
	System.out.println("#################Fim do Cadastro de Atletas############");
	}



} 
