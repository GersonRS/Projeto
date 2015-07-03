package modelo;

import java.io.IOException;

import view.Render;

public class Logica extends Thread {

	private Personagem p1;
	private Render render;
	private CarregarDados carregarDados;
	private int matriz[][];

	public Logica(Personagem p, Render r) throws IOException {
		this.p1 = p;
		this.render = r;
		this.carregarDados = new CarregarDados();
		this.matriz = carregarDados
				.carregarMatriz(400, 20, "fase1-camada2.txt");
		render.getMap().montarMapa(
				carregarDados.carregarMatriz(400, 20, "fase1-camada1.txt"));
		render.getMap().montarMapa(matriz);
		render.getMap().montarMapa(
				carregarDados.carregarMatriz(400, 20, "fase1-camada3.txt"));
	}

	public void run() {
		while (true) {
			render.repaint();
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
		if(p1.getAnimated()==7){
			if(!(p1.getHp()<=0))
				p1.setHp(p1.getHp()-10);
		}
	}

	private void moverJogador() {
		int posXAnterior = p1.getPosX();
		int posYAnterior = p1.getPosY();
		p1.mexer();
		tratarSairTela(posXAnterior, posYAnterior);
		tratarColisao(posXAnterior, posYAnterior);

	}

	private void tratarColisao(int posXAnterior, int posYAnterior) {

	}

	private void tratarSairTela(int posX, int posY) {

		if ((p1.getPosX() < 0) || ((p1.getPosX() + 16) > 6400)) {
			p1.setPosX(posX);
		}
		if ((p1.getPosY() < 0) || ((p1.getPosY() + 16) > 228)) {
			p1.setPosY(posY);
		}
	}
}