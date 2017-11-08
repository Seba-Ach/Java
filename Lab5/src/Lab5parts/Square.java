package Lab5parts;

public class Square extends Shape {
	private int sideSize;

	public Square(int x, int y,int sideSize) {
		super(x, y);
		if(sideSize<=0) {
			System.out.print("ERROR: Side size cannot take such value.\n");
			throw new IllegalArgumentException();
		}
		this.setSideSize(sideSize);
	}

	@Override
	public void moveNorthSouth(int len) {
		if(len!=0) {
			System.out.println("ERROR: Square cannot be moved North or South.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void moveWestEast(int len) { //square can only be moved west(left,negative values)
		if(len<=0) {
			super.x_coordinate=super.x_coordinate+len;
		}
		else {
			System.out.println("ERROR: Wrong value, square can only move West.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public double getArea() {
		return this.getSideSize()*this.getSideSize();
	}

	@Override
	public double getCircumference() {
		return this.getSideSize()+this.getSideSize()+this.getSideSize()+this.getSideSize();
	}

	public int getSideSize() {
		return sideSize;
	}

	public void setSideSize(int sideSize) {
		if(sideSize<=0) {
			throw new IllegalArgumentException();
		}
		this.sideSize = sideSize;
	}

}
