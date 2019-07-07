package stickcode;

import java.awt.Graphics;

public class Slime extends GameObject {
	private int hp,damage;
	private Textures t;
	private boolean alive;
	private Player p;
	private Animation move,attack;
	private Handler h;
	public Slime(int x, int y, int Vx, int Vy,int health,int damage,Textures t,Player p,Handler h) {
		super(x, y, -1, Vy,ID.enemy);
		this.damage = damage;
		this.hp = health;
		this.t = t;
		this.p=p;
		this.h=h;
		alive = true;
		 move = new Animation(8,t.getSlimeMove());
		 attack = new Animation(4,t.getSlimeAtt());
		 count=0;
	}

	public int getHealth() {
		return hp;
	}

	public void setHealth(int health) {
		this.hp = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	private static int count;
	public void tick() {
		if(p.getVx()==1) {
			this.Vx=-2;
		}else {
			this.Vx=-1;
		}
		if(hp<0) {alive=false;}
		if(alive) {
		if(this.x >p.getX()+90) {
			this.x+=Vx;
			move.runAnimation();
		}else {
			Vx=0;
			attack.runAnimation();
			if(count%60==0) {
				damage();
				count =0;
			}
		}
		}
	}

	public void render(Graphics g) {
		if(alive) {
		if(this.x !=p.getX()+90) {
			move.drawAnimation(g, x, y, 100, 100);
		}else {
			attack.drawAnimation(g, x, y, 100, 100);
		}
		}
	}
	public void damage() {
		p.setHp(p.getHp()-this.damage);
	}
	

}
