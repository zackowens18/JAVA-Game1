package stickcode;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Textures {
	ImageSheet is[]=new ImageSheet[8];
	BufferedImage[] value =new BufferedImage[35]; //.png
	
	
	public Textures() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {

			//value[1] = loader.loadImage("wraith.png");
			value[2] = loader.loadImage("/MonedaD.png");
			value[3] = loader.loadImage("/slime-attack-0.png");
			value[4] = loader.loadImage("/slime-attack-1.png");
			value[5] = loader.loadImage("/slime-attack-2.png");
			value[6] = loader.loadImage("/slime-attack-3.png");
			value[7] = loader.loadImage("/slime-attack-4.png");
			value[8] = loader.loadImage("/slime-die-0.png");
			value[9] = loader.loadImage("/slime-die-1.png");
			value[10] = loader.loadImage("/slime-die-2.png");
			value[11] = loader.loadImage("/slime-die-3.png");
			value[12] = loader.loadImage("/slime-hurt-0.png");
			value[13] = loader.loadImage("/slime-hurt-1.png");
			value[14] = loader.loadImage("/slime-hurt-2.png");
			value[15] = loader.loadImage("/slime-idle-0.png");
			value[16] = loader.loadImage("/slime-idle-1.png");
			value[17] = loader.loadImage("/slime-idle-2.png");
			value[18] = loader.loadImage("/slime-idle-3.png");
			value[19] = loader.loadImage("/slime-move-0.png");
			value[20] = loader.loadImage("/slime-move-1.png");
			value[21] = loader.loadImage("/slime-move-2.png");
			value[22] = loader.loadImage("/slime-move-3.png");
			value[23] = loader.loadImage("/spr_coin_roj.png");
			value[24] = loader.loadImage("/SkeletonAttack.png");
			value[25] = loader.loadImage("/SkeletonDead.png");
			value[26] = loader.loadImage("/SkeletonHit.png");
			value[27] = loader.loadImage("/SkeletonIdle.png");
			value[28] = loader.loadImage("/SkeletonWalk.png");
			value[29] = loader.loadImage("/plx-1.png");
			value[30] = loader.loadImage("/plx-2.png");
			value[31] = loader.loadImage("/plx-3.png");
			value[32] = loader.loadImage("/plx-4.png");
			value[33] = loader.loadImage("/plx-5.png");
			value[34] = loader.loadImage("/Hills Layer 05.png");
			is[0] = new ImageSheet(value[1]);
			is[1] = new ImageSheet(value[23]);
			is[2]= new ImageSheet(value[2]);
			is[3] = new ImageSheet(value[24]);
			is[4] = new ImageSheet(value[25]);
			is[5] = new ImageSheet(value[26]);
			is[6] = new ImageSheet(value[27]);
			is[7] = new ImageSheet(value[28]);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
	}
	public BufferedImage[] getMenu() {
		BufferedImage[] menu = new BufferedImage[6];
		for(int i = 29;i<35;i++) {
			menu[i-29] = value[i];
		}
		
		return menu;
	}
	
	
	public BufferedImage[] getSlimeidle() {
		BufferedImage slimes[] = new BufferedImage[4];
		for(int i = 0;i<4;i++) {
			slimes[i] = value[i+15];
		}
		return slimes;
	}
	
	public BufferedImage[] getSlimeAtt() {
		BufferedImage att[] = new BufferedImage[4];
		for(int i =0;i<4;i++) {
			att[i] = value[i+3];
		}
		return att;
	}
	public BufferedImage[] getSlimeMove() {
		BufferedImage move[] = new BufferedImage[4];
		for(int i =0;i<4;i++) {
			move[i] = value[i+19];
		}
		return move;
	}
	
	
	
	public BufferedImage[] getSAttack() {
		BufferedImage[] s = new BufferedImage[18];
		for(int i = 1; i <19;i++) {
			s[i-1] = is[3].grabImage(i, 1, 43, 37);
		}
		return s;
	}
	
	public BufferedImage[] getSAttackBack() {
		BufferedImage[] s = this.getSAttack();
		for(int i = 0; i <18;i++) {
			BufferedImage b = s[i];
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-b.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    s[i] = op.filter(b, null);
		}
		return s;
	}
	
	public BufferedImage[] getSDead() {
		BufferedImage[] s = new BufferedImage[15];
		for(int i = 1; i <16;i++) {
			s[i-1] = is[4].grabImage(i, 1, 33, 32);
		}
		return s;
	}
	
	public BufferedImage[] getSDeadBack() {
		BufferedImage[] s = this.getSDead();
		for(int i = 0; i <15;i++) {
			BufferedImage b = s[i];
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-b.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    s[i] = op.filter(b, null);
		}
		return s;
	}
	
	public BufferedImage[] getSHit() {
		BufferedImage[] s = new BufferedImage[8];
		for(int i = 1; i <9;i++) {
			s[i-1] = is[5].grabImage(i, 1, 30, 32);
		}
		return s;
	}
	public BufferedImage[] getSHitBack() {
		BufferedImage[] s = this.getSHit();
		for(int i = 0; i <8;i++) {
			BufferedImage b = s[i];
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-b.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    s[i] = op.filter(b, null);
		}
		return s;
	}
	
	
	public BufferedImage[] getSIdle() {
		BufferedImage[] s = new BufferedImage[11];
		for(int i = 1; i <12;i++) {
			s[i-1] = is[6].grabImage(i, 1, 24, 32);
		}
		return s;
	}
	public BufferedImage[] getSIdleBack() {
		BufferedImage[] s = this.getSIdle();
		for(int i = 0; i <11;i++) {
			BufferedImage b = s[i];
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-b.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    s[i] = op.filter(b, null);
		}
		return s;
	}
	
	public BufferedImage[] getSWalk() {
		BufferedImage[] s = new BufferedImage[13];
		for(int i = 1; i <14;i++) {
			s[i-1] = is[7].grabImage(i, 1,22, 33);
		}
		return s;
	}
	
	public BufferedImage[] getSWalkBack() {
		BufferedImage[] s = this.getSWalk();
		for(int i = 0;i<13;i++) {
			BufferedImage b = s[i];
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-b.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    s[i] = op.filter(b, null);
		}
		return s;
	}
	
}
