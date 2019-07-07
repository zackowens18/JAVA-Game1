package stickcode;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1684936942264983184L;

	public static final int WIDTH = 800, HEIGHT = WIDTH/12*9;
	private Handler handler;
	private Thread thread;
	private boolean running = false;
	private Menu menu;
	private PlayerInput pi;
	public Textures texture = new Textures();
	private BackGround bg;
	private ArrayList<Slime> slime = new ArrayList<Slime>();
	public STATE gameState = STATE.menu;
	private Player p = new Player(0, 0, 0, 0, texture,slime);
	
	
	public enum STATE{
		menu,game;
	};
	
	
	public Game() {
		new Window(WIDTH,HEIGHT,"Game",this);
		handler = new Handler();
		pi = new PlayerInput(handler,p);
		bg = new BackGround(texture.getMenu(), this, p);
		handler.addObject(bg);
		handler.addObject(p);
		
		menu = new Menu(texture,this);
		this.addMouseListener(menu);
		this.addKeyListener(pi);
		
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		
		
		if(gameState == STATE.game) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			handler.render(g);
			
			
		}else {
			menu.render(g);
		}
		
		
		g.dispose();
		bs.show();
		
	}
	private void tick() {
		if(gameState == STATE.game) {
			handler.tick();
			Spawning(handler);
		}
		else
		{
			menu.tick();
		}
		
		
	}
	public static void main(String args[]) {
		new Game();
	}
	public Textures getTexture() {
		return texture;
	}
	private static int count;
	public void Spawning(Handler h) {
		count++;
		if(count % 500 ==0) {
			Slime s =new Slime(p.getX()+this.getWidth(),445,0,0,50,5, texture,p,handler);
			h.addObject(s);
			slime.add(s);
			//System.out.print("Spawned");
			count=0;
		}
	}
}
