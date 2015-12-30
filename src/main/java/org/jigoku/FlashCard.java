package org.jigoku;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.jigoku.romajiToKanaMapper.RomajiToKanaMapper;

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

	public boolean checkSolution(String string, RomajiToKanaMapper mapper) {
		return StringUtils.equals(solution, mapper.map(string));
	}
}
