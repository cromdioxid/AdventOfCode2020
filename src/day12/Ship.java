package day12;

public class Ship {
	
	private int posX = 0;
	private int posY = 0;
	private int orientation = 90;
	
	public void move(Instruction inst) {
		if (inst.getAction().equals("N")) {
			posX += inst.getValue();
		} else if (inst.getAction().equals("S")) {
			posX -= inst.getValue();
		} else if (inst.getAction().equals("E")) {
			posY += inst.getValue();
		} else if (inst.getAction().equals("W")) {
			posY -= inst.getValue();
		} else if (inst.getAction().equals("L")) {
			orientation = ((orientation + 360) - inst.getValue()) % 360;
		} else if (inst.getAction().equals("R")) {
			orientation = (orientation + inst.getValue()) % 360;
		} else {
			if (orientation == 0) {
				posX += inst.getValue();
			} else if (orientation == 90) {
				posY += inst.getValue();
			} else if (orientation == 180) {
				posX -= inst.getValue();
			} else {
				posY -= inst.getValue();
			}
		}
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	

}
