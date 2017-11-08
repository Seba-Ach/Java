package Lab5parts;

public class Circle extends Shape {
	private int radius;

	public Circle(int x, int y,int radius) {
		super(x, y);
		if(radius<=0) {
			System.out.print("ERROR: Radius must be bigger than zero.\n");
			throw new IllegalArgumentException();
		}
		this.setRadius(radius);		
		
	}

	@Override
	public void moveNorthSouth(int len) { //circle can only be moved north
		if(len>=0) {
			this.y_coordinate=this.y_coordinate+len;
		}
		else {
			System.out.println("ERROR: Wrong value, circle can only move North.");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void moveWestEast(int len) {
		if(len!=0) {
			System.out.println("ERROR: Circle cannot be moved West or East.");
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

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		if(radius<=0) {
			System.out.print("ERROR: Radius must be bigger than zero.\n");
			throw new IllegalArgumentException();
		}
		this.radius = radius;
	}
	

}
