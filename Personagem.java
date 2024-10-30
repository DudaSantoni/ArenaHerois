package arenaDosHerois;

public abstract class Personagem {

	private String nome;
	private int vida;
	private int danoBase;
	private int posicao;

	public Personagem(String nome, int vida, int danoBase) {
		this.nome = nome;
		this.vida = vida;
		this.danoBase = danoBase;  
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDanoBase() {
		return danoBase;
	}

	public void setDanoBase(int danoBase) {
		this.danoBase = danoBase;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void mover(int novaPosicao) {
		this.posicao = novaPosicao;
		System.out.println(nome + " se moveu para a posição " + novaPosicao);
	}

	public abstract void atacar (Personagem oponente);

	public void receberDano (int dano) {
		vida -= dano;
		if (vida < 0) {
			
			vida = 0;
		}
		System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + vida);
	}

	public int calcularDistancia (Personagem oponente) {
		return Math.abs(this.posicao - oponente.getPosicao());
	}
}
