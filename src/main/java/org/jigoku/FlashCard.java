package org.jigoku;

import lombok.Data;

import java.util.ArrayList;

/**
 * Represents a complete FlashCard as presented to the student.
 */
@Data
public class FlashCard {
	private final String contents;
	private final String hint;
	private final String firstCharRow;
	private String solution;
	private ArrayList<JapChar> displayChars = new ArrayList<>();
}
