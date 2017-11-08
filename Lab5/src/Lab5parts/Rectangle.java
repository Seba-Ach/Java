package Lab5parts;

public class Rectangle extends Shape {
	private int xSideSize;
	private int ySideSize;

	public Rectangle(int x, int y, int xSideSize, int ySideSize) {
		super(x, y);
		if(xSideSize<=0 || ySideSize<=0) {
			System.out.print("ERROR: Sides cannot take such a value.");
			throw new IllegalArgumentException();
		}
		this.setxSideSize(xSideSize);
		this.setySideSize(ySideSize);
	}

	@Override
	public void moveNorthSouth(int len) {
		if(len!=0) {
			System.out.println("ERRO: Rectangle cannot be moved North or South.");
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void moveWestEast(int len) {
		if(len!=0) {
			System.out.println("ERROR: Rectangle cannot be moved East or West.");
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
		if(xSideSize<=0) {
			throw new IllegalArgumentException();
		}
		this.xSideSize = xSideSize;
	}

	public int getySideSize() {
		return ySideSize;
	}

	public void setySideSize(int ySideSize) {
		if(ySideSize<=0) {
			throw new IllegalArgumentException();
		}
		this.ySideSize = ySideSize;
	}

}
