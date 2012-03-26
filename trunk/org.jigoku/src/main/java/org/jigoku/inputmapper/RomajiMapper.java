package org.jigoku.inputmapper;

import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

@Deprecated
public class RomajiMapper {
	protected HashMap<String, String> romajiToKana;

	protected HashMap<String, String> initHash() {
		HashMap<String, String> rtk = new HashMap<String, String>();

		// base charactes

		rtk.put("a", "あ");
		rtk.put("i", "い");
		rtk.put("u", "う");
		rtk.put("e", "え");
		rtk.put("o", "お");
		rtk.put("ka", "か");
		rtk.put("ki", "き");
		rtk.put("ku", "く");
		rtk.put("ke", "け");
		rtk.put("ko", "こ");
		rtk.put("sa", "さ");
		rtk.put("shi", "し");
		rtk.put("su", "す");
		rtk.put("se", "せ");
		rtk.put("so", "そ");
		rtk.put("ta", "た");
		rtk.put("chi", "ち");
		rtk.put("tsu", "つ");
		rtk.put("te", "て");
		rtk.put("to", "と");
		rtk.put("na", "な");
		rtk.put("ni", "に");
		rtk.put("nu", "ぬ");
		rtk.put("ne", "ね");
		rtk.put("no", "の");
		rtk.put("ha", "は");
		rtk.put("hi", "ひ");
		rtk.put("fu", "ふ");
		rtk.put("he", "へ");
		rtk.put("ho", "ほ");
		rtk.put("ma", "ま");
		rtk.put("mi", "み");
		rtk.put("mu", "む");
		rtk.put("me", "め");
		rtk.put("mo", "も");
		rtk.put("ra", "ら");
		rtk.put("ri", "り");
		rtk.put("ru", "る");
		rtk.put("re", "れ");
		rtk.put("ro", "ろ");
		rtk.put("ya", "や");
		rtk.put("yu", "ゆ");
		rtk.put("yo", "よ");
		rtk.put("wa", "わ");
		rtk.put("o", "を");
		rtk.put("n", "ん");

		// alternate spelling

		rtk.put("/", "っ");
		rtk.put("ti", "ち");
		rtk.put("si", "し");
		rtk.put("tu", "つ");
		rtk.put("hu", "ふ");

		// modified characters

		rtk.put("ga", "が");
		rtk.put("gi", "ぎ");
		rtk.put("gu", "ぐ");
		rtk.put("ge", "げ");
		rtk.put("go", "ご");
		rtk.put("za", "ざ");
		rtk.put("ji", "じ");
		rtk.put("zu", "ず");
		rtk.put("ze", "ぜ");
		rtk.put("zo", "ぞ");
		rtk.put("da", "だ");
		rtk.put("ji", "じ");
		rtk.put("zu", "ず");
		rtk.put("ze", "ぜ");
		rtk.put("zo", "ぞ");
		rtk.put("ba", "ば");
		rtk.put("bi", "び");
		rtk.put("bu", "ぶ");
		rtk.put("be", "べ");
		rtk.put("bo", "ぼ");
		rtk.put("pa", "ぱ");
		rtk.put("pi", "ぴ");
		rtk.put("pu", "ぷ");
		rtk.put("pe", "ぺ");
		rtk.put("po", "ぽ");

		// composites

		rtk.put("kya", "きゃ");
		rtk.put("sha", "しゃ");
		rtk.put("cha", "ちゃ");
		rtk.put("nya", "にゃ");
		rtk.put("hya", "ひゃ");
		rtk.put("mya", "みゃ");
		rtk.put("rya", "りゃ");
		rtk.put("gya", "ぎゃ");
		rtk.put("ja", "じゃ");
		rtk.put("cha", "ぢゃ");
		rtk.put("bya", "びゃ");
		rtk.put("pya", "ぴゃ");
		rtk.put("kyu", "きゅ");
		rtk.put("shu", "しゅ");
		rtk.put("chu", "ちゅ");
		rtk.put("nyu", "にゅ");
		rtk.put("hyu", "ひゅ");
		rtk.put("myu", "みゅ");
		rtk.put("ryu", "りゅ");
		rtk.put("gyu", "ぎゅ");
		rtk.put("ju", "じゅ");
		rtk.put("chu", "ぢゅ");
		rtk.put("byu", "びゅ");
		rtk.put("pyu", "ぴゅ");
		rtk.put("kyo", "きょ");
		rtk.put("sho", "しょ");
		rtk.put("cho", "ちょ");
		rtk.put("nyo", "にょ");
		rtk.put("hyo", "ひょ");
		rtk.put("myo", "みょ");
		rtk.put("ryo", "りょ");
		rtk.put("gyo", "ぎょ");
		rtk.put("jo", "じょ");
		rtk.put("cho", "ぢょ");
		rtk.put("byo", "びょ");
		rtk.put("pyo", "ぴょ");

		return rtk;
	}

	public RomajiMapper() {
		if (romajiToKana == null) {
			romajiToKana = initHash();
		}
	}

	public String map(final String input) {
		String needle = "";
		StringBuilder output = new StringBuilder();
		int maxkeylength = 0;

		Set<String> keys = romajiToKana.keySet();
		for (String string : keys) {
			if (string.length() > maxkeylength) {
				maxkeylength = string.length();
			}
		}

		int index = 0;

		nextstringbit: while (index < input.length()) {

			// check the matches in decreasing lengths
			int restlength = input.length() - index;
			int testlength = maxkeylength;

			while (testlength > 0) {
				if (restlength >= testlength) {
					needle = input.substring(index, index + testlength);
					if (romajiToKana.containsKey(needle)) {
						output.append(romajiToKana.get(needle));
						index += testlength;
						continue nextstringbit;
					}
				}
				testlength--;
			}

			// character not found... illegal entry;
			// abort later, make sure we won't get stuck for now
			index++;
		}
		return output.toString();

	}
}
