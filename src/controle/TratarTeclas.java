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
			p.setDy(-p.getVelocidade());
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p.setDy(p.getVelocidade());
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			p.setDx(-p.getVelocidade());
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			p.setDx(p.getVelocidade());
			if(p.getSprite().aparencia<42)
				p.getSprite().aparencia+=6;
			else
				p.getSprite().aparencia=0;
		}
	}
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			p.setDy(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p.setDy(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			p.setDx(0);
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			p.setDx(0);
		}
	}
}
