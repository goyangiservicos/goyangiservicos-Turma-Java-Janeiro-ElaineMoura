package sisPessoa;

public class Principal {

	public static void main(String[] args) {

		System.out.println("rodou");

		Pessoa pessoa = new Pessoa("963258", "elaine C Moura", "email@email");

		DaoPessoa daoPessoa = new DaoPessoa();
		daoPessoa.salvarNoBanco(pessoa);

		// cadastro de animal

		Animal animal = new Animal("987789", "gato", "Elaine");

		DaoAnimal daoAnimal = new DaoAnimal();
		daoAnimal.salvarNoBanco(animal);

		/*
		 * FabricaDeConexoes fabricaDeConexoes = new FabricaDeConexoes();
		 * 
		 * if(fabricaDeConexoes.criarConexaoSisPessoa()!=null) {
		 * System.out.println("conectou"); }else { System.out.println("erro conexao"); }
		 */
	}
}
