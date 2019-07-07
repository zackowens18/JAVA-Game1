package stickcode;

import java.awt.Graphics;

public abstract class GameObject {
	protected int x,y,Vx,Vy;
	public enum ID{
		player,enemy,bg}
	private ID id;
	
	public GameObject(int x, int y, int Vx,int Vy,ID i) {
		this.x = x;
		this.y = y;
		this.Vx = Vx;
		this.Vy = Vy;
		this.id = i;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVx() {
		return Vx;
	}
	public void setVx(int vx) {
		Vx = vx;
	}
	public int getVy() {
		return Vy;
	}
	public void setVy(int vy) {
		Vy = vy;
	}
	public ID getID() {
		return id;
	}
	
}
