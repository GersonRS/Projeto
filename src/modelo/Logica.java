package modelo;

import java.io.IOException;

import view.Mapa;

public class Logica extends Thread {

	private Personagem p1;
	private Controle controle;
	private CarregarDados carregarDados;
	private Mapa m;
	private final int CIMA=0,DIREITA=1,BAIXO=2,ESQUERDA=3;


	public Logica(Personagem p, Mapa m) {
		this.p1 = p;
		this.m = m;
		this.carregarDados = new CarregarDados();
		this.controle = p.getControle();
		try {
			m.montarMapa(carregarDados.carregarMatriz(400, 20,
					"fase1-camada1.txt"));
			m.montarMapa(carregarDados.carregarMatriz(400, 20,
					"fase1-camada2.txt"));
			m.montarMapa(carregarDados.carregarMatriz(400, 20,
					"fase1-camada3.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			tratarJogo();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void tratarJogo() {
		moverJogador();
	}

	private void moverJogador() {
		int posXAnterior = p1.getPosX();
		int posYAnterior = p1.getPosY();

		if (controle.isBotaoCima()) {
			p1.andar(CIMA);
		}
		if (controle.isBotaoDireita()) {
			p1.andar(DIREITA);
		}
		if (controle.isBotaoBaixo()) {
			p1.andar(BAIXO);
		}
		if (controle.isBotaoEsquerda()) {
			p1.andar(ESQUERDA);
		}

		tratarSairTela(posXAnterior, posYAnterior);
		tratarColisao(posXAnterior, posYAnterior);

	}

	private void tratarColisao(int posXAnterior, int posYAnterior) {

	}

	private void tratarSairTela(int posX, int posY) {

		if ((p1.getPosX() < 0) || ((p1.getPosX() + 16) > 208)) {
			p1.setPosX(posX);
		}
		if ((p1.getPosY() < 0) || ((p1.getPosY() + 16) > 208)) {
			p1.setPosY(posY);
		}
	}
}