package org.jigoku.form;

import lombok.Getter;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class KanjiTable extends AbstractTableModel {

	public KanjiTable() {
	}

	public int getColumnCount() {
		return 10;
	}

	public int getRowCount() {
		return 10;
	}

	public Object getValueAt(int row, int col) {
		return new Integer(row * col);
	}

}