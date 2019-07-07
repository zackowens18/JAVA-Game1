package stickcode;

import java.awt.image.BufferedImage;

public class ImageSheet {
	BufferedImage image;
	ImageSheet(BufferedImage image){
		this.image=image;
	}
	public BufferedImage grabImage(int col,int row,int width,int height) {
		BufferedImage i = image.getSubimage((col*width)-width, (row*height)-height, width, height);
		return i;
	}
}
