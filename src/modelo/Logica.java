package modelo;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import view.Render;

public class Logica extends Thread {

	private Personagem p1;
	private Render render;
	private CarregarDados carregarDados;
	private int matriz[][];
	private int gravidade = 4;
	private ArrayList<Rectangle> rectangles;
	private ArrayList<Monstro> monstros;
	private ArrayList<Item> itens;
	private int numMonstros = 5;
	

	public Logica(Personagem p, ArrayList<Monstro> m, Render r, ArrayList<Item> i2) throws IOException {
		this.p1 = p;
		this.itens = i2;
		this.render = r;
		this.rectangles = new ArrayList<Rectangle>();
		this.monstros = m;
		for (int i = 0; i < numMonstros; i++) {
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
			try {
				tratarJogo();
				render.repaint();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void tratarJogo() throws IOException {
		moverJogador();
		moverMonstros();
		tratarColisaoPersonagemMonstro();
		tratarColisaoPersonagemItem();
		tratamentoGeral();
	}

	private void tratamentoGeral() throws IOException {
		for (int i = 0; i < monstros.size(); i++) {
			if(monstros.get(i).getHp()<=0){
				itens.add(new Item(monstros.get(i).getPosX(), monstros.get(i).getPosY(), "item.png"));
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
	
	private void tratarColisaoPersonagemItem(){
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).rec().intersects(p1.rec())) {
				itens.get(i).setPosX(32*p1.getInventario().size()+32);
				itens.get(i).setPosY(60);
				p1.getInventario().add(itens.get(i));
				itens.remove(i);
			}
		}
	}
}