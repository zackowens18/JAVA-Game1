package stickcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private BufferedImage image;
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(this.getClass().getResource(path));
		}catch(IOException e) {
			e.printStackTrace();
			System.out.print("Error in paths of images");
		}
		return image;
	}
}
