package org.jigoku;
import java.util.ArrayList;

import lombok.Data;

/**
 * Represents a complete FlashCard as presented to the student.
 */
@Data
public class FlashCard {
    private final String contents;
    private final String hint;
    private String solution;
    private final String firstcharrow;
    private ArrayList<JapChar> displaychars = new ArrayList<JapChar>();
}
