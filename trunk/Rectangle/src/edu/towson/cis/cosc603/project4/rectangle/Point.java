package edu.towson.cis.cosc603.project4.rectangle;

/**
 * The Point Class.
 */
public class Point {

	/** x and y coordinates. */
	Double x, y;

	/**
	 * Instantiates a new point.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	Point(Double x, Double y) {
		this.x = x;/**Constructor assignment of the x should be x but it was y and that was our bug here  */
		this.y = y;
	}
}
