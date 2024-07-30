package class_;

public class ComputeDTO {
	private int x, y;
	private int sum, sub, mul;
	private double div;

	// setter -------------------
	public void setX(int x) {
		// System.out.println("this : " + this); //this 확인하기위해서
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	// getter ------------------
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSum() {
		return sum;
	}

	public int getSub() {
		return sub;
	}

	public int getMul() {
		return mul;
	}

	public double getDiv() {
		return div;
	}

	// -------------------------

	public void calc() {
		sum = this.x + this.y;
		sub = x - y;
		mul = this.x * y;
		div = (double) x / this.y;
	}

}