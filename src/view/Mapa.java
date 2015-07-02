package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mapa {

	private BufferedImage tileSet;
	private BufferedImage mapa;

	private int tileSize = 16;
	private int numLinhaTile = 20;
	private int numColunaTile = 400;
	private int imageNumTiles = 38;

	public Mapa() {
		mapa = new BufferedImage(numColunaTile*tileSize, numLinhaTile*tileSize, BufferedImage.TYPE_4BYTE_ABGR);
		try {
			tileSet = ImageIO.read(this.getClass().getClassLoader()
					.getResource("TileSet.png"));
		} catch (IOException e) {
			System.out
					.println("Erro ao buscar imagem do mapa.\nEncerrando aplicação");
			System.exit(0);
		}
	}

	public void montarMapa(int[][] matriz) {

		for (int i = 0; i < numLinhaTile; i++) {
			for (int j = 0; j < numColunaTile; j++) {
				int tile = (matriz[i][j] != 0) ? (matriz[i][j] - 1) : 0;
				int tileRow = (tile / imageNumTiles) | 0;
				int tileCol = (tile % imageNumTiles) | 0;
				mapa.getGraphics().drawImage(tileSet, (j * tileSize),
						(i * tileSize), (j * tileSize) + tileSize,
						(i * tileSize) + tileSize, (tileCol * tileSize),
						(tileRow * tileSize), (tileCol * tileSize) + tileSize,
						(tileRow * tileSize) + tileSize, null);
			}
		}
	}

	public BufferedImage getMapa() {
		return mapa;
	}
}
