package edu.towson.cis.cosc603.project3.monopoly.gui;

import edu.towson.cis.cosc603.project3.monopoly.Cell;

public class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
