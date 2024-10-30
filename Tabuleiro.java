package arenaDosHerois;

public class Tabuleiro {
	private Personagem [] personagens;
	private int tamanho;

	public Tabuleiro (Personagem [] personagens, int tamanho) {
		this.personagens = personagens;
		this.tamanho = tamanho;
	}

	public void iniciarJogo() {
		System.out.println("Iniciando o jogo!"); 
		for (int i = 0; i < personagens.length; i++) {
			personagens [i].mover(i * 2); // Coloca cada personagem em uma posição inicial
		}
		exibirTabuleiro();
	}

	public void exibirTabuleiro() {
		System.out.println("\nPosições no Tabuleiro:");
		for (Personagem p : personagens) {
			if (p.getVida() > 0) {
				System.out.println(p.getNome() + " está na posição " + p.getPosicao() + " com " + p.getVida() + " de vida.");
			}
		}

		System.out.println();

	}
	public void movimentarPersonagem (Personagem p, int novaPosicao) {
		if (novaPosicao < 0 || novaPosicao >= tamanho) {
			System.out.println("Movimento inválido! Fora dos limites do tabuleiro.");
		} else {
			p.mover(novaPosicao);
			exibirTabuleiro();
		}
	}
	public boolean checarVencedor() {
		int vivos = 0;
		Personagem vencedor = null;
		for (Personagem p : personagens) {
			if (p.getVida() > 0) {
				vivos++;
				vencedor = p;
			}
		}

		if (vivos == 1) {
			System.out.println("O vencedor é " + vencedor.getNome() + "!");
			return true;
		}
		return false;
	}

}
