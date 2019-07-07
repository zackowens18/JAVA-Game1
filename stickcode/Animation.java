package stickcode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {
	private int speed;
	private int frames,index,count;
	private BufferedImage[] images;
	private BufferedImage current_image;
	private boolean Finished;
	public Animation(int speed,BufferedImage...args) {
		this.speed=speed;
		images = new BufferedImage[args.length];
		for(int i = 0; i < args.length;i++) {
			images[i] = args[i];
		}
		frames = args.length;
		
	}
	public void runAnimation() {
		index++;
		if(index>speed) {
			index=0;
			nextFrame();
		}
	}
	private void nextFrame() {
		for(int i = 0; i <frames;i++) {
			if(count==i) {
				current_image =images[i];
			}
		}
		count++;
		if(count>frames) {
			count=0;
			this.Finished =true;
		}
	}
	public boolean getFinished() {
		return Finished;
	}
	public void setFinished(boolean finished) {
		Finished = finished;
	}
	public void drawAnimation(Graphics g, int x, int y) {
		g.drawImage(current_image,x,y,null);
		
	}
	public void drawAnimation(Graphics g, int x, int y, int scaleX,int scaleY) {
		g.drawImage(current_image,x,y,scaleX,scaleY,null);
	}
	
	
}
