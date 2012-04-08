package org.jigoku.form;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class KanjiDisplayTableTest {
	@Test
	public void testMe() {

		List<String> data = new ArrayList<String>();

		for (int i = 0; i <= 70; i++) {
			data.add("" + i);
		}

		KanjiDisplayTable kanjiDisplayTable = new KanjiDisplayTable(new Shell(new Display()), 0, data);
		kanjiDisplayTable.open();
	}
}
