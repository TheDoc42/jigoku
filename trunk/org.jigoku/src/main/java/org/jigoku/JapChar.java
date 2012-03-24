package org.jigoku;

public class JapChar {
	public String original = "";
	public String furigana = "";
	public int kanjiId = 0;
	
	public JapChar(String original, String furigana, int kanjiId) {
		this.original = original;
		this.furigana = furigana;
		this.kanjiId = kanjiId;
	}
}
