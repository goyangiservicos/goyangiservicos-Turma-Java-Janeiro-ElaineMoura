package sisPessoa;

public class Principal {

	public static void main(String[] args) {

		System.out.println("rodou");
		// cadastro de pessoa
		Pessoa pessoa = new Pessoa("963258", "elaine C Moura", "email@email");

		DaoPessoa daoPessoa = new DaoPessoa();
		daoPessoa.salvarNoBanco(pessoa);

		// UPDATE pessoa
		Pessoa pessoaAtualizada = new Pessoa("963258", "Elaine Moura Atualizada", "novo@email.com");
		daoPessoa.atualizarNoBanco(pessoaAtualizada);

		// cadastro de animal
		Animal animal = new Animal("987789", "gato", "Elaine");

		DaoAnimal daoAnimal = new DaoAnimal();
		daoAnimal.salvarNoBanco(animal);

		// UPDATE animal
		Animal animalAtualizado = new Animal("987789", "gato atualizado", "Elaine Moura");
		daoAnimal.atualizarNoBanco(animalAtualizado);
		/*
		 * FabricaDeConexoes fabricaDeConexoes = new FabricaDeConexoes();
		 * 
		 * if(fabricaDeConexoes.criarConexaoSisPessoa()!=null) {
		 * System.out.println("conectou"); }else { System.out.println("erro conexao"); }
		 */
	}
}
