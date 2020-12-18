package day12;

public class Ship {
	
	private int posX = 0;
	private int posY = 0;
	private int wayX = 10;
	private int wayY = 1;
	
	public void move(Instruction inst) {
		if (inst.getAction().equals("N")) {
			wayY += inst.getValue();
		} else if (inst.getAction().equals("S")) {
			wayY -= inst.getValue();
		} else if (inst.getAction().equals("E")) {
			wayX += inst.getValue();
		} else if (inst.getAction().equals("W")) {
			wayX -= inst.getValue();
		} else if (inst.getAction().equals("L")) {
			rotateWaypoint(360 - inst.getValue());
		} else if (inst.getAction().equals("R")) {
			rotateWaypoint(inst.getValue());
		} else {
			posX += inst.getValue() * wayX;
			posY += inst.getValue() * wayY;
		}
	}
	
	public void rotateWaypoint(int deg) {
		int times = deg / 90;
		for (int i = 0; i < times; i++) {
			int aux = wayX;
			wayX = wayY;
			wayY = -aux;
		}
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	

}
