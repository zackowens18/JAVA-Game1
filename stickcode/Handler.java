package stickcode;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	private LinkedList<GameObject> obj = new LinkedList<GameObject>();
	public void tick() {
		for(GameObject o:obj) {
			o.tick();
		}
	}
	public void render(Graphics g) {
		for(GameObject o:obj) {
			o.render(g);
		}
	}
	public void addObject(GameObject object) {
		this.obj.add(object);
	}
	public void removeObject(GameObject object) {
		this.obj.remove(object);
	}
	public int size() {
		return this.obj.size();
	}
	public GameObject get(int i) {
		return obj.get(i);
	}
}
