package edu.towson.cis.cosc603.project3.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class GoToJailCell.
 */
public class GoToJailCell extends Cell {
	
	/**
	 * Instantiates a new go to jail cell.
	 */
	public GoToJailCell() {
		setName("Go to Jail");
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc442.project1.monopoly.Cell#playAction()
	 */
	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		GameMaster.instance().getGameBoard().queryCell("Jail");
		GameMaster.instance().sendToJail(currentPlayer);
	}
}