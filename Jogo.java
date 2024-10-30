package arenaDosHerois;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Personagem mago = new Mago ("Merlin");
		Personagem gigante = new Gigante("Eren");
		Personagem guerreiro = new Guerreiro("Levi");
		Personagem arqueiro = new Arqueiro ("Sasha");

		Personagem [] personagens = { mago, gigante, guerreiro, arqueiro };
		Tabuleiro tabuleiro = new Tabuleiro (personagens, 10); // Tabuleiro com 10 posições.

		tabuleiro.iniciarJogo();

		while (!tabuleiro.checarVencedor()) {
			for (Personagem p: personagens) {
				if (p.getVida() > 0) {
					System.out.println(p.getNome() + ": (1) Atacar ou (2) Mover?");
					int escolha = scanner.nextInt();

					if (escolha == 1) {
						System.out.println("Escolha um oponente para atacar:");
						// Lista os oponentes vivos.
						for (int i = 0; i < personagens.length; i++) {
							if (personagens[i] != p && personagens[i].getVida() > 0) { 
								System.out.println(i + ": " + personagens[i].getNome());
							}
						}

						// Lê o índice do oponente e verifica se está dentro dos limites
						int oponenteEscolhido;
						while (true) {
							oponenteEscolhido = scanner.nextInt();
							if (oponenteEscolhido >= 0 && oponenteEscolhido < personagens.length
									&& personagens[oponenteEscolhido] != p 
									&& personagens[oponenteEscolhido].getVida() > 0) { 
								break; // Entrada válida

							} else {
								System.out.println("Escolha inválida, tente novamente.");
							}
						}
						p.atacar(personagens[oponenteEscolhido]);
					} else {
						System.out.println("Escolha uma nova posição (0 a 9):");
						int novaPosicao = scanner.nextInt(); 
						tabuleiro.movimentarPersonagem (p, novaPosicao);
					}
				}
			}
		}
		scanner.close();
	}
}

