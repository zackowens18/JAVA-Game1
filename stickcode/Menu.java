package stickcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import stickcode.Game.STATE;


public class Menu extends MouseAdapter {
	private Textures t;
	private Game game;
	private Color c;
	public Menu(Textures t,Game g) {
		this.c = Color.black;
		this.t =t;
		this.game = g;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//System.out.println(mx+"   "+ my);
		//System.out.print(mouseOver(mx,my,350,200,150,50));
		if(mouseOver(mx,my,350,200,150,50)) {
			this.game.gameState = STATE.game;
			
			//System.out.println(this.game.gameState);
		}
		
	}
	
	
	
	public void tick() {
		
	}
	public boolean mouseOver(int mx, int my,int x,int y, int width, int height) {
		if(mx>x&& mx<x+width && my>y&& my<y+height) {
			return true;
		}
		return false;
	}
	public void render(Graphics g) {
		
		BufferedImage[] background = t.getMenu();
		for(int i=0; i<5;i++) {
			g.drawImage(background[i],0, 0, game.getWidth(), game.getHeight(),null); 
			g.setFont(new Font("Segoe UI", Font.PLAIN,50));
			g.setColor(c);
			g.drawString("PLAY", 350 ,250);
			//g.setColor(Color.black);
			//g.drawString("Options", 325,350);
		}
	}
	


}

