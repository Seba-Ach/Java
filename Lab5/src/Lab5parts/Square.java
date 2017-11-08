package Lab5parts;

public class Square extends Shape {
	private int sideSize;

	public Square(int x, int y,int sideSize) {
		super(x, y);
		this.setSideSize(sideSize);
	}

	@Override
	public void moveNorthSouth(int len) {
		if(len!=0) {
			System.out.println("Square cannot be moved North or South.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void moveWestEast(int len) { //square can only be moved west(left,negative values)
		if(len<0) {
			super.x_coordinate=super.x_coordinate+len;
			super.y_coordinate=super.y_coordinate+len;
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

	public double getSideSize() {
		return sideSize;
	}

	public void setSideSize(double sideSize) {
		this.sideSize = sideSize;
	}

}
