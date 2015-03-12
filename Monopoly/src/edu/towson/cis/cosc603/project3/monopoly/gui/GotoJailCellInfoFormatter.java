package edu.towson.cis.cosc603.project3.monopoly.gui;

import edu.towson.cis.cosc603.project3.monopoly.Cell;

public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
	}
}
