import java.util.Scanner;

//Sistema de cadastro de atleta
//Heranca
//Classe Atleta(objeto) - nome, idade (atributos) - classe pai é abstrata.
//Classe JogadorDeFutebol - PernaMaisForte, ValorPorGols
//Classe JogadorDeVolei - BracoMaisForte, ValorPorPontos

public class Principal{ // as chaves indica o inicio da classe;

	public static void main(String[] args){
		System.out.println("#################Inicio cadastro de atleta############");
		Scanner entradaDeDados = new Scanner(System.in);

		JogadorFutebol jogadorFutebol = new JogadorFutebol(); 
		JogadorVolei jogadorVolei = new JogadorVolei();

		System.out.println("Digite F para jogador de futebol ou V para jogador de volei");
		String opcao = entradaDeDados.next();
		
		if(opcao.equals("F")){
		System.out.println("Digite o nome do jogador de futebol: ");
		jogadorFutebol.nomeAtleta = entradaDeDados.next();
		
		System.out.println("Digite a idade do jogador de futebol: ");
		jogadorFutebol.idade = entradaDeDados.nextInt();
		
		System.out.println("Digite a perna mais forte do jogador de futebol: ");
		jogadorFutebol.pernaMaisForte = entradaDeDados.next();
		
		System.out.println("Digite o valor por gol do jogador: ");
		jogadorFutebol.valorPorGols = entradaDeDados.nextDouble();

		System.out.println("Nome do jogador é: " + jogadorFutebol.nomeAtleta );
		System.out.println("A idade do jogador é: " + jogadorFutebol.idade );
		System.out.println("Perna mais forte do jogador é: " + jogadorFutebol.pernaMaisForte);
		System.out.println("Valor por gols do jogador é: " + jogadorFutebol.valorPorGols);

	        }
	
		if(opcao.equals("V")){
		System.out.println("Digite o nome do jogador de volei: ");
		jogadorVolei.nomeAtleta = entradaDeDados.next();
		
		System.out.println("Digite a idade do jogador de volei: ");
		jogadorVolei.idade = entradaDeDados.nextInt();
		
		System.out.println("Digite a braco mais forte do jogador de volei: ");
		jogadorVolei.bracoMaisForte = entradaDeDados.next();

		System.out.println("Digite o valor por gol do volei: ");
		jogadorVolei.valorPorPontos = entradaDeDados.nextDouble();

		System.out.println("Nome do jogador é: " + jogadorVolei.nomeAtleta );
		System.out.println("A idade do jogador é: " + jogadorVolei.idade );
		System.out.println("Braco mais forte do jogador é: " + jogadorVolei.bracoMaisForte);
		System.out.println("Valor por pontos do jogador é: " + jogadorVolei.valorPorPontos);

		}
	System.out.println("#################Fim############");
	}



} //o fechamento da chave, fechamento da classe. Alinhada com o texto que inicia a classe.
