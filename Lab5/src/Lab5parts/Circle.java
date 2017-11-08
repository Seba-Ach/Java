package Lab5parts;

public class Circle extends Shape {
	private int radius;

	public Circle(int x, int y,int radius) {
		super(x, y);
		this.setRadius(radius);		
	}

	@Override
	public void moveNorthSouth(int len) { //circle can only be moved north
		if(len>0) {
			super.x_coordinate=super.x_coordinate+len;
			super.y_coordinate=super.y_coordinate+len;
		}
		else {
			System.out.println("ERROR: Wrong value, circle can only move North.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void moveWestEast(int len) {
		if(len!=0) {
			System.out.println("Circle cannot be moved West or East.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double getArea() {
		return Math.PI*this.getRadius()*this.getRadius();
	}

	@Override
	public double getCircumference() {
		return 2*Math.PI*this.getRadius();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	

}
