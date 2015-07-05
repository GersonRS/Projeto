package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import modelo.Personagem;

public class TratarTeclas extends KeyAdapter{
	
	Personagem p;
	
	public TratarTeclas(Personagem p) {
		this.p = p;
	}

	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);		
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			p.cima=true;
			p.pulo=true;
//			p.setDy(-p.getVelocidade());
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p.baixo=true;
//			p.setDy(p.getVelocidade());
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			p.esquerda=true;
//			p.setDx(-p.getVelocidade());
//			p.setDirecao(1);
//			p.setAnimated(p.getAnimated()+1);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			p.direita=true;
//			p.setDx(p.getVelocidade());
//			p.setDirecao(0);
//			p.setAnimated(p.getAnimated()+1);
			
			
//			if(p.getSprite().aparencia<42)
//				p.getSprite().aparencia+=6;
//			else
//				p.getSprite().aparencia=0;
		}
		if(p.getAnimated()>=8)
			p.setAnimated(0);
	}
	
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			p.cima=false;
//			p.pulo=false;
//			p.setDy(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p.baixo=false;
//			p.setDy(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			p.esquerda=false;
//			p.setDx(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			p.direita=false;
//			p.setDx(0);
		}
	}
}
