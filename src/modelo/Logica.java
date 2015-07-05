package modelo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import view.Render;

public class Logica extends Thread {

	private Personagem p1;
	private Render render;
	private CarregarDados carregarDados;
	private int matriz[][];
	private int gravidade = 4;
	private ArrayList<Rectangle> rectangles;
	private ArrayList<Monstro> monstros;

	public Logica(Personagem p, ArrayList<Monstro> m, Render r) throws IOException {
		this.p1 = p;
		this.render = r;
		this.rectangles = new ArrayList<Rectangle>();
		this.monstros = m;
		for (int i = 0; i < 5; i++) {
			monstros.add(new Monstro((new Random().nextInt(50)*16)+700, 226-45));
		}
		this.carregarDados = new CarregarDados();
		this.matriz = carregarDados
				.carregarMatriz(400, 20, "fase1-camada2.txt");
		render.getMap().montarMapa(
				carregarDados.carregarMatriz(400, 20, "fase1-camada1.txt"));
		render.getMap().montarMapa(matriz);
		render.getMap().montarMapa(
				carregarDados.carregarMatriz(400, 20, "fase1-camada3.txt"));
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] != 0) {
					Rectangle rec = new Rectangle(j * 16, i * 16, 16, 16);
					rectangles.add(rec);
				}
			}
		}
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
		moverMonstros();
		tratarColisaoPersonagemMonstro();
		tratamentoGeral();
	}

	private void tratamentoGeral() {
		for (int i = 0; i < monstros.size(); i++) {
			if(monstros.get(i).getHp()<=0){
				monstros.remove(i);
			}
		}
	}

	private void moverMonstros() {
		for (int i = 0; i < monstros.size(); i++) {
			int posXAnterior = monstros.get(i).getPosX();
			int posYAnterior = monstros.get(i).getPosY();
			monstros.get(i).mexer();
			tratarSairTela(monstros.get(i),posXAnterior, posYAnterior);
//			tratarColisao(monstros.get(i),posXAnterior, posYAnterior);
		}
	}

	private void moverJogador() {
		int posXAnterior = p1.getPosX();
		int posYAnterior = p1.getPosY();
		p1.mexer();
		p1.setPosY(p1.getPosY() + gravidade);
		tratarSairTela(p1,posXAnterior, posYAnterior);
		tratarColisao(p1,posXAnterior, posYAnterior);
	}

	private void tratarColisao(Entidade e,int posXAnterior, int posYAnterior) {
		for (int i = 0; i < rectangles.size(); i++) {
			if (rectangles.get(i).intersects(e.rec())) {
				e.setPosX(posXAnterior);
				e.setPosY(posYAnterior);
				e.setDx(0);
			}
		}
	}

	private void tratarSairTela(Entidade e,int posX, int posY) {

		if ((e.getPosX() < 0) || ((e.getPosX() + 50) > 6400)) {
			e.setPosX(posX);
		}
		if ((e.getPosY() < 0) || ((e.getPosY() + 50) > 226)) {
			e.setPosY(posY);
		}
	}
	
	private void tratarColisaoPersonagemMonstro(){
		for (int i = 0; i < monstros.size(); i++) {
			if (monstros.get(i).rec().intersects(p1.rec())) {
				p1.setHp(p1.getHp()-5);
				monstros.get(i).setHp(monstros.get(i).getHp()-10);
			}
		}
	}
}