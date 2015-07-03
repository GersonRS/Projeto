package modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite{
	BufferedImage spriteSheet;   

	public int width, height;
	public int rows, columns;
	public BufferedImage[] sprites;
	public int aparencia;
	
	public Sprite(int aparencia, int width, int height, int columns, int rows, String img) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResource(img));
		this.aparencia=aparencia;
		this.width = width;
		this.height = height;
		this.rows = columns;
		this.columns = rows;

		sprites = new BufferedImage[columns * rows];
		for(int i = 0; i < columns; i++) {
			for(int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);
			}
		}
	}
}