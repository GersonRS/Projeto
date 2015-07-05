package modelo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

public class Monstro extends Entidade {

	private Random r;
	private int controle = 0;
	private int hp, hpMax;

	public Monstro(int posX, int posY) throws IOException {
		super(posX, posY, "zumbi.png");
		this.tamanhoX = 30;
		this.tamanhoY = 45;
		this.velocidade = 5;
		this.animated = 7;
		this.hp=20;
		this.hpMax=20;
		this.r = new Random();
	}

	public void mexer() {
		controle++;
		if (controle % 10 == 0) {
			direcao = r.nextInt(2);
		}
		if (direcao == 0){
			dx = velocidade;
			animated=0;
		}
		if (direcao == 1){
			dx = -velocidade;
			animated=7;
		}
		posX += dx;
		posY += dy;
	}

	public Rectangle rec() {
		return new Rectangle(posX + 16, posY, tamanhoX, tamanhoY);
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}
