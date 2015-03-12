package edu.towson.cis.cosc603.project3.monopoly;

public interface IOwnable {

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public abstract int getPrice();

	/**
	 * Play action.
	 * @param msg TODO
	 * @return TODO
	 */
	public abstract boolean playAction(String msg);

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();

}