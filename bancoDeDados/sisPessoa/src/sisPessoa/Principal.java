package sisPessoa;

public class Principal {

	public static void main(String[] args) {

		System.out.println("rodou");
		// cadastro de pessoa
		Pessoa pessoa = new Pessoa("963258", "elaine C Moura", "email@email");
		DaoPessoa daoPessoa = new DaoPessoa();
		daoPessoa.salvarNoBanco(pessoa);
		System.out.println("inseriu a pessoa ok");

		// chama o select pra ver se cadastrou mesmo e os dados.
		Pessoa p = daoPessoa.buscarPessoaPorCpf("963258");
		System.out.println(p);

		// UPDATE pessoa
		Pessoa pessoaAtualizada = new Pessoa("963258", "Elaine Moura Atualizada", "novo@email.com");
		daoPessoa.atualizarNoBanco(pessoaAtualizada);
		System.out.println("atualizou a pessoa ok");
		// chama o select pra ver se atualizou mesmo e os dados.
		Pessoa p2 = daoPessoa.buscarPessoaPorCpf("963258");
		System.out.println(p2);

		// DELETE pessoa
		daoPessoa.deletarPessoaPorCpf("963258");
		System.out.println("deletou a pessoa ok");
		// chama o select pra ver se deletou mesmo e os dados.
		Pessoa p3 = daoPessoa.buscarPessoaPorCpf("963258");
		System.out.println(p3); // vai imprimir null

		// cadastro de animal
		Animal animal = new Animal("987789", "gato", "Elaine");
		System.out.println("inseriu a animal ok");
		DaoAnimal daoAnimal = new DaoAnimal();
		daoAnimal.salvarNoBanco(animal);
		// chama o select pra ver se cadastrou mesmo e os dados.
		Animal a = daoAnimal.buscarAnimalPorMatricula("987789");
		System.out.println(a);

		// UPDATE animal
		Animal animalAtualizado = new Animal("987789", "gato atualizado", "Elaine Moura");
		daoAnimal.atualizarNoBanco(animalAtualizado);
		System.out.println("atualizou a animal ok");
		// chama o select pra ver se atualizou mesmo e os dados.
		Animal a2 = daoAnimal.buscarAnimalPorMatricula("987789");
		System.out.println(a2);

		// DELETE animal
		daoAnimal.deletarAnimalPorMatricula("987789");
		System.out.println("deletou a animal ok");
		// chama o select pra ver se deletou mesmo e os dados.
		Animal a3 = daoAnimal.buscarAnimalPorMatricula("987789");
		System.out.println(a3); // null

		/*
		 * FabricaDeConexoes fabricaDeConexoes = new FabricaDeConexoes();
		 * 
		 * if(fabricaDeConexoes.criarConexaoSisPessoa()!=null) {
		 * System.out.println("conectou"); }else { System.out.println("erro conexao"); }
		 */
	}
}
