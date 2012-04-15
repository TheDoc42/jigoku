package org.jigoku.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class KanjiDisplayTable extends Dialog {

	private static final int DISPLAYED_COLUMNS = 10;
	private static final int KANJI_DISPLAY_SIZE = 40;
	protected Object result;
	protected Shell shell;
	@Getter
	private Table table;
	private final List<String> data;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public KanjiDisplayTable(Shell parent, int style, List<String> data) {
		super(parent, style);
		this.data = data;
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
		createContents();

		fillDisplayTable();

		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	private void fillDisplayTable() {
		for (int i = 0; i <= Math.ceil(data.size() / DISPLAYED_COLUMNS); i++) {

			List<String> tableRow = data.subList(i * DISPLAYED_COLUMNS,
					Math.min((i + 1) * DISPLAYED_COLUMNS, data.size()));

			TableItem tableItem = new TableItem(table, i);

			for (int j = 0; j < tableRow.size(); j++) {
				tableItem.setText(j, tableRow.get(j));
			}
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.CLOSE);
		shell.setMinimumSize(new Point(400, 150));
		shell.setSize(506, 375);
		shell.setText(getText());
		GridLayout gl_shell = new GridLayout(4, false);
		gl_shell.horizontalSpacing = 4;
		shell.setLayout(gl_shell);

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		scrolledComposite.setMinWidth(420);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.FILL, false, true, 4, 1);
		gd_scrolledComposite.heightHint = 109;
		gd_scrolledComposite.widthHint = 295;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		table = new Table(scrolledComposite, SWT.BORDER | SWT.MULTI);
		table.setLinesVisible(true);

		List<TableColumn> tableColumns = new ArrayList<TableColumn>();

		for (int i = 0; i < DISPLAYED_COLUMNS; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setWidth(KANJI_DISPLAY_SIZE);
			tableColumn.setResizable(false);
			tableColumns.add(tableColumn);
		}

		final TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		tableCursor.setVisible(true);

		// Hide the TableCursor when the user hits the "CTRL" or "SHIFT" key.
		// This allows the user to select multiple items in the table.
		tableCursor.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.CTRL || e.keyCode == SWT.SHIFT || (e.stateMask & SWT.CONTROL) != 0
						|| (e.stateMask & SWT.SHIFT) != 0) {
					tableCursor.setVisible(false);
				}
			}
		});
		// Show the TableCursor when the user releases the "SHIFT" or "CTRL"
		// key.
		// This signals the end of the multiple selection task.
		table.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				if (e.keyCode == SWT.CONTROL && (e.stateMask & SWT.SHIFT) != 0) {
					return;
				}
				if (e.keyCode == SWT.SHIFT && (e.stateMask & SWT.CONTROL) != 0) {
					return;
				}
				if (e.keyCode != SWT.CONTROL && (e.stateMask & SWT.CONTROL) != 0) {
					return;
				}
				if (e.keyCode != SWT.SHIFT && (e.stateMask & SWT.SHIFT) != 0) {
					return;
				}

				TableItem[] selection = table.getSelection();
				TableItem row;
				if (selection.length == 0) {
					row = table.getItem(table.getTopIndex());
				} else {
					row = selection[0];
				}
				table.showItem(row);

				tableCursor.setSelection(row, tableCursor.getColumn());
				tableCursor.setVisible(true);
				tableCursor.setFocus();
			}
		});

		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(new Point(470, 85));

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("xx selected");

		Button btnSelectNone = new Button(shell, SWT.NONE);
		GridData gd_btnSelectNone = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelectNone.widthHint = 100;
		btnSelectNone.setLayoutData(gd_btnSelectNone);
		btnSelectNone.setText("Select none");

		Button btnSelectTestable = new Button(shell, SWT.NONE);
		GridData gd_btnSelectTestable = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelectTestable.widthHint = 100;
		btnSelectTestable.setLayoutData(gd_btnSelectTestable);
		btnSelectTestable.setText("Select testable");

		Button btnSelectDueTesting = new Button(shell, SWT.NONE);
		GridData gd_btnSelectDueTesting = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelectDueTesting.widthHint = 100;
		btnSelectDueTesting.setLayoutData(gd_btnSelectDueTesting);
		btnSelectDueTesting.setText("Select due testing");

	}

}
