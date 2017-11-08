package Lab5parts;

public abstract class Shape implements Moveable {
	protected int x_coordinate;
	protected int y_coordinate;
	public abstract double getArea();
	public abstract double getCircumference();
	public Shape(int x, int y) {
		this.x_coordinate=x;
		this.y_coordinate=y;
	}
	
	@Override
	public String toString() {
		return ("["+this.x_coordinate+"\t"+y_coordinate+"]");
	}
}
