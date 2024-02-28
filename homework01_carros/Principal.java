package homework01_carros;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		String op;

		do {

			System.out.println("Menu");
			System.out.println("1 - CADASTRAR Carro");
			System.out.println("2 - EDITAR Carro");
			System.out.println("3 - ATUALIZAR a placa do Carro");
			System.out.println("4 - DELETAR Carro pela placa");
			System.out.println("5 - LISTAR TODOS os Carros");

			System.out.println("Modo ADMIN");
			System.out.println("20 – Criar BD e tabela");
			System.out.println("21 – Deletar BD");
			System.out.println("s  – Sair");

			op = ler.nextLine();

			switch (op) {
			case "1": {

				// cadastrar carro

				Carro c0 = new Carro();
				int ano;
				double valor;

				//

				if (!c0.verificaExistenciaBancoDados()) {
					System.err.println("O banco de dados não existe. Crie antes de tentar realizar um cadastro.\n");
				} else {
					System.out.println("Digite o nome do carro:");
					String nome = ler.nextLine();

					System.out.println("Digite a marca do carro:");
					String marca = ler.nextLine();

					System.out.println("Digite a placa do carro:");
					String placa = ler.nextLine();

					if (c0.localizarCarro2(placa) != 0) {
						System.err.println("Esta placa já se encontra no sistema.\n");
						break;
					} else {
						try {
							System.out.println("Digite o ano do carro:");
							ano = Integer.parseInt(ler.nextLine());

							if (ano < 1900) {
								System.err.println("Digite um ano válido. (Maior que 1900)\n");
								break;
							}
						} catch (java.lang.NumberFormatException e) {
							System.err.println("Digite um formato válido para o ano.\n");
							break;
						}

						try {
							System.out.println("Digite o valor do carro:");
							valor = Double.parseDouble(ler.nextLine());

							if (valor < 0) {
								System.err.println("Digite um valor válido. (Maior que 0)\n");
								break;
							}
						} catch (java.lang.NumberFormatException e) {
							System.err.println("Digite um formato válido para o valor.\n");
							break;
						}

						Carro c = new Carro(nome, marca, placa, ano, valor);

						if (c.cadastrarCarro()) {
							System.out.println("Carro cadastrado com sucesso!\n");
						} else {
							System.err.println("Erro ao cadastrar o carro.\n");
						}
					}
				}

				break;

			}

			case "2": {

				// menu editar carro

				String op2;

				do {

					System.out.println("\nMENU ALTERAR CARRO");

					System.out.println("a- ALTERAR nome");
					System.out.println("b- ALTERAR marca");
					System.out.println("c- ALTERAR ano");
					System.out.println("d- ALTERAR valor");
					System.out.println("x - sair");

					op2 = ler.nextLine();

					switch (op2) {
					case "a": {

						Carro c = new Carro();

						System.out.println("Digite a placa do carro:");
						String placa = ler.nextLine();

						if (c.localizarCarro2(placa) == 0) {
							System.err.println("Nenhum carro foi encontrado com essa placa.\n");
							break;
						} else {

							System.out.println("Digite o novo nome:");
							String nome2 = ler.nextLine();

							if (c.editarNomeCarro(nome2, placa)) {
								System.out.println("Nome alterado com sucesso.\n");
							} else {
								System.err.println("Erro ao alterar o nome.\n");
							}
						}

						break;
					}
					case "b": {

						Carro c = new Carro();

						System.out.println("Digite a placa do carro:");
						String placa = ler.nextLine();

						if (c.localizarCarro2(placa) == 0) {
							System.err.println("Nenhum carro foi encontrado com essa placa.\n");
							break;
						} else {
							System.out.println("Digite a nova marca:");
							String marca2 = ler.nextLine();

							if (c.editarMarcaCarro(marca2, placa)) {
								System.out.println("Marca alterada com sucesso.\n");
							} else {
								System.err.println("Erro ao alterar a marca.\n");
							}
						}

						break;
					}

					case "c": {

						Carro c = new Carro();
						int ano2;

						System.out.println("Digite a placa do carro:");
						String placa = ler.nextLine();

						if (c.localizarCarro2(placa) == 0) {
							System.err.println("Nenhum carro foi encontrado com essa placa.\n");
							break;
						} else {

							try {
								System.out.println("Digite o novo ano:");
								ano2 = Integer.parseInt(ler.nextLine());

								if (ano2 < 1900) {
									System.err.println("Digite um ano válido. (Maior que 1900)\n");
									break;
								}
							} catch (java.lang.NumberFormatException e) {
								System.err.println("Digite um formato válido para o ano.\n");
								break;
							}

							if (c.editarAnoCarro(ano2, placa)) {
								System.out.println("Ano alterado com sucesso.\n");
							} else {
								System.err.println("Erro ao alterar o ano.\n");
							}

						}

						break;
					}
					case "d": {

						Carro c = new Carro();
						double valor2 = 0;

						System.out.println("Digite a placa do carro:");
						String placa = ler.nextLine();

						if (c.localizarCarro2(placa) == 0) {
							System.err.println("Nenhum carro foi encontrado com essa placa\n.");
							break;
						} else {

							try {
								System.out.println("Digite o novo valor:");
								valor2 = Double.parseDouble(ler.nextLine());

								if (valor2 < 0) {
									System.err.println("Digite um valor válido. (Maior que 0)\n");
									break;
								}
							} catch (Exception e) {
								System.err.println("Digite um formato válido para o valor.\n");
								break;
							}

							if (c.editarValorCarro(valor2, placa)) {
								System.out.println("Valor alterado com sucesso.\n");
							} else {
								System.err.println("Erro ao alterar o valor.\n");
							}
						}

						break;
					}

					case "x": {

						break;
					}

					default:
						System.err.println("Digite uma das opções do menu.\n");
						break;
					}

				} while (!op2.equalsIgnoreCase("x"));

				break;

			}

			case "3": {

				// atualizar placa do carro

				Carro c = new Carro();

				System.out.println("Digite a placa do carro:");
				String placa = ler.nextLine();

				if (c.localizarCarro2(placa) == 0) {
					System.err.println("Nenhum carro foi encontrado com essa placa.\n");
					break;
				} else {
					System.out.println("Digite a nova placa:");
					String placa2 = ler.nextLine();

					if (c.editarPlacaCarro(placa2, placa)) {
						System.out.println("Placa alterada com sucesso.\n");
					} else {
						System.err.println("Erro ao alterar a placa.\n");
					}

				}
				break;

			}
			case "4": {

				// deletar carro pela placa

				Carro c = new Carro();

				System.out.println("Digite a placa do carro a ser excluído:");
				String placa = ler.nextLine().trim();

				if (c.localizarCarro2(placa) == 0) {
					System.err.println("Nenhum carro foi encontrado com essa placa.\n");
					break;
				} else {
					if (new Carro().excluirCarro(placa)) {
						System.out.println("Carro excluído com sucesso.\n");

					} else {
						System.err.println("Erro ao excluir o carro.\n");
					}
				}

				break;

			}

			case "5": {

				// listar todos os carros

				Carro c = new Carro();

				c.listarCarros();

				break;

			}

			case "20": {

				// criar banco de dados e tabela

				Admin_BD abd = new Admin_BD();

				if (abd.criarBDeTabela()) {
					System.out.println("Operação bem sucedida.\n");
				} else {
					System.err.println("Algo deu errado.\n");
				}

				break;

			}

			case "21": {

				// deletar banco de dados

				Admin_BD abd = new Admin_BD();

				if (abd.deletarBD()) {
					System.out.println("Banco de dados deletado com sucesso.\n");
				} else {
					System.err.println("Erro ao deletar o banco de dados.\n");
				}

				break;

			}

			case "s": {
				System.out.println("Fim do programa.\n");
				break;

			}

			default:
				System.err.println("Digite uma das opções do menu.\n");
				break;
			}

		} while (!op.equalsIgnoreCase("s"));

		ler.close();

	}

}
