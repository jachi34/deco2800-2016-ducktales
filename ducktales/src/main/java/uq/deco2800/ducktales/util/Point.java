package uq.deco2800.ducktales.util;

public class Point implements Comparable<Point> {

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(Point point) {
		return Math.sqrt(Math.pow(point.getX() - x, 2)
				+ Math.pow(point.getY() - y, 2));
	}

	public void moveToward(Point point, double distance) {
		if (distance(point) < distance) {
			this.x = point.x;
			this.y = point.y;
			return;
		}
		double deltaX = x - point.x;
		double deltaY = y - point.y;
		double angle;

		angle = Math.atan2(deltaY, deltaX) + Math.PI;

		double xShift = Math.cos(angle) * distance;
		double yShift = Math.sin(angle) * distance;

		x += xShift;
		y += yShift;
	}

	@Override
	public String toString() {
		return String.format("[%1$,.2f, %2$,.2f]", x, y);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Point)) {
			return false;
		}
		Point point = (Point) object;
		return point.x == this.x && point.y == this.y;
	}

	@Override
	public int hashCode() {
		return (int) (((13 * x) + y) * 17);
	}

	@Override
	public int compareTo(Point point) {
		if (this.y < point.y) {
			return -1;
		} else if (this.y == point.y) {
			if (this.x < point.x) {
				return -1;
			} else if (this.x == point.x) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 1;
		}

	}

}
