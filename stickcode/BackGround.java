package stickcode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject {
	private BufferedImage[] image;
	private int xxx;
	private int xxxx;
	private int xxxxx;
    private int xx;
    private Game game;
    private Player p;
    private static int c;
 
    public BackGround(BufferedImage image[],Game g,Player p) {
        this(image,g,0,0,p);
    
    }
 
    public BackGround(BufferedImage image[],Game g,int x, int y,Player p) {
    	super(x,y,0,0,ID.bg);
        this.game = g;
        this.image=image;
        this.p = p;
    }
   
    public void render(Graphics g) {
    	g.drawImage(image[0], 0, 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[1], xxxx, 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[1], xxxx+(game.getWidth()), 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[2], xxx, 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[2], xxx+(game.getWidth()), 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[3], xxxxx, 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[3], xxxxx+(game.getWidth()), 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[4],this.xx, 0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[4],this.xx+game.getWidth(),0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[4],this.xx+(game.getWidth()*2),0,game.getWidth(),game.getHeight(),null);
    	g.drawImage(image[5],this.xx,300,game.getWidth(),260,null);
    	g.drawImage(image[5],this.xx+game.getWidth(),300,game.getWidth(),260,null);
    	g.drawImage(image[5],this.xx+(game.getWidth()*2),300,game.getWidth(),260,null);
    	
    }
    public void tick() {
    	if(p.getX()>game.getWidth()/2-75) {
    		this.xx = this.xx-(p.getVx());
    	if(c%3==0) {
    		this.xxx = this.xxx-(p.getVx());
    	}
    	if(c%4==0){
    		this.xxxxx = this.xxxx-p.getVx();
    	}
    	if(c%5 ==0) {
    		this.xxxx =this.xxxx-(p.getVx());
    		c=0;
    	}
    	c++;
    	}
    	
    }
    public void resetBackground(Player p) {
    	this.p = p;
    }
}
