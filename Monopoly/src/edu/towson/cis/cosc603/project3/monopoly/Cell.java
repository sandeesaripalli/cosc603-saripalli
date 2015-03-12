package edu.towson.cis.cosc603.project3.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class Cell.
 */
public abstract class Cell {
	
	/** The name. */
	private String name;
	
	/** The theOwner. */
	protected Player theOwner;

	/** The available. */
	private boolean available = true;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the theOwner.
	 *
	 * @return the theOwner
	 */
	public Player getTheOwner() {
		return theOwner;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return 0;
	}

	/**
	 * Play action.
	 */
	public abstract void playAction();

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the theOwner.
	 *
	 * @param theOwner the new theOwner
	 */
	public void setTheOwner(Player owner) {
		this.theOwner = owner;
	}
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return name;
    }

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
}