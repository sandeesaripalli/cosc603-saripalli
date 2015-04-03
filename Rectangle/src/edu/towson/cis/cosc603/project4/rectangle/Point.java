package edu.towson.cis.cosc603.project4.rectangle;

/**
 * The Point Class.
 */
public class Point {

	/** x and y coordinates. */
	private Double x, y;

	/**
	 * Instantiates a new point.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	Point(Double x, Double y) {
		this.setX(x);/**Constructor assignment of the x should be x but it was y and that was our bug here  */
		this.setY(y);
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
}
