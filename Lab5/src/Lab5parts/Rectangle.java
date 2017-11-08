package Lab5parts;

public class Rectangle extends Shape {
	private int xSideSize;
	private int ySideSize;

	public Rectangle(int x, int y, int xSideSize, int ySideSize) {
		super(x, y);
		this.setxSideSize(xSideSize);
		this.setySideSize(ySideSize);
	}

	@Override
	public void moveNorthSouth(int len) {
		if(len!=0) {
			System.out.println("Rectangle cannot be moved North or South.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void moveWestEast(int len) {
		if(len!=0) {
			System.out.println("Rectangle cannot be moved East or West.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public double getArea() {
		return getxSideSize()*getySideSize();
	}

	@Override
	public double getCircumference() {
		return getxSideSize()+getxSideSize()+getySideSize()+getySideSize();
	}

	public int getxSideSize() {
		return xSideSize;
	}

	public void setxSideSize(int xSideSize) {
		this.xSideSize = xSideSize;
	}

	public int getySideSize() {
		return ySideSize;
	}

	public void setySideSize(int ySideSize) {
		this.ySideSize = ySideSize;
	}

}
