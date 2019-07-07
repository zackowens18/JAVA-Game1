package stickcode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PlayerInput extends KeyAdapter {
	Handler h;
	Player p;
	public PlayerInput(Handler h,Player p) {
		this.h =h;
		this.p = p;
		
		
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_A&& !p.isAttack()) {
			p.setVx(-1);
			p.setLeft(true);
		}
		else if(key==KeyEvent.VK_D&& !p.isAttack()) {
			p.setVx(1);
			p.setLeft(false);
		}
		if(key==KeyEvent.VK_SPACE&& !p.isAttack()) {
			p.setVx(0);
			p.setAttack(true);
			
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_A && !p.isAttack())
			p.setVx(0);
		else if(key==KeyEvent.VK_D&& !p.isAttack())
			p.setVx(0);
		
		
		
		
	}
	
}
