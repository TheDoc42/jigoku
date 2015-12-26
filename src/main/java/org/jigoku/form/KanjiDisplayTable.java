package org.jigoku.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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

		table = new Table(scrolledComposite, SWT.HIDE_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(false);

		List<TableColumn> tableColumns = new ArrayList<TableColumn>();

		for (int i = 0; i < DISPLAYED_COLUMNS; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
			tableColumn.setWidth(KANJI_DISPLAY_SIZE);
			tableColumn.setResizable(false);
			tableColumns.add(tableColumn);
		}

		table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(final Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < DISPLAYED_COLUMNS; i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							System.out.println("Item " + index + "-" + i);
							final int col = i;
							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									item.setBackground(col, Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
								}
							});

						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible) {
						return;
					}
					index++;
				}
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
