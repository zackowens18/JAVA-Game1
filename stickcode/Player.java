package stickcode;

import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends GameObject {
	private int damage,hp;
	private Textures t;
	private Animation walk,dead,hit,attack,walkb,idleb,hitb,deadb,idle;
	private boolean Attack;
	private boolean Left;
	private ArrayList<Slime> s;
	public Player(int x, int y, int Vx, int Vy,Textures tex,ArrayList<Slime> s) {
		super(x, y, Vx, Vy,ID.player);
		damage = 30;
		hp = 100;
		t = tex;
		this.s=s;
		Left = false;
		Attack = false;
		walk = new Animation(8,t.getSWalk());
		walkb= new Animation(8,tex.getSWalkBack());
		hitb = new Animation(8,tex.getSHitBack());
		idleb =new Animation(8,tex.getSIdleBack());
		idle = new Animation(8,tex.getSIdle());
		attack = new Animation(4,tex.getSAttack());
		/*dead = new Animation(8,tex.getSDead());
		hit = new Animation(8,tex.getSHit());
		deadb = new Animation(8,tex.getSDeadBack());*/
	}

	
	public boolean isAttack() {
		return Attack;
	}


	public void setAttack(boolean attack) {
		Attack = attack;
	}


	public boolean isLeft() {
		return Left;
	}


	public void setLeft(boolean left) {
		Left = left;
	}


	public void tick() {
		
		if(this.getX()<Game.WIDTH/2-75) {
			this.setX(this.getX()+this.getVx());
		}
		if(Attack) {
			
			if(!attack.getFinished()) {
			attack.runAnimation();
			
			
			}else {
				attack.setFinished(false);
				Attack = false;
				damage();
			}
		}
		if(this.Vx>0&&!Attack)
			walk.runAnimation();
		if(this.Vx<0&&!Attack)
			walkb.runAnimation();
		if(this.Vx == 0&&!Attack) {
			if(Left) {
				idleb.runAnimation();
			}else {
				idle.runAnimation();
			}
		
		}
		
		//dead.runAnimation();
		//hit.runAnimation();
		/*walkb.runAnimation();
		hitb.runAnimation();
		deadb.runAnimation();*/
	}


	public void render(Graphics g) {
		if(this.Vx>0)
			walk.drawAnimation(g,x,445,100,100);
		if(this.Vx<0)
			walkb.drawAnimation(g,x,445,100,100);
		if(this.Vx == 0&&!Attack) {
			if(Left) {
			idleb.drawAnimation(g,x,445,100,100);
			}else {
			idle.drawAnimation(g, x, 445,100,100);
			} 
		}
		if(Attack) {
			
			attack.drawAnimation(g,x,415,140,130);
		}
		/*dead.drawAnimation(g,100,25,100,100);
		hit.drawAnimation(g,150,150,100,100);
		
		walkb.drawAnimation(g,300,100,100,100);
		
		hitb.drawAnimation(g, 0, 400, 100, 100);
		deadb.drawAnimation(g, 200, 300, 100, 100);*/
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}
	private void damage() {
		for(int i = 0;i<s.size();i++) {
			Slime g = s.get(i);
			if(g.getX()>410&&g.getX()<600) {
				g.setHealth(g.getHealth()-this.damage);
				
			}
		}
	}

}
//LEFT OFF AT Setting up Player input fix @ player indput and test inputs fix all esle