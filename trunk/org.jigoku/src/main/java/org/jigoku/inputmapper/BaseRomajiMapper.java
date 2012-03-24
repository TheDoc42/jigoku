package org.jigoku.inputmapper;

import java.util.HashMap;
import java.util.Set;

public abstract class BaseRomajiMapper implements StringMapper {

	protected static BaseRomajiMapper brm = null;
	protected static HashMap<String,String> translator = null;

	public BaseRomajiMapper() {
		if (BaseRomajiMapper.translator == null) {
			BaseRomajiMapper.translator = initTranslator();
		}
	}
	
	private HashMap<String, String> initTranslator() {
		HashMap<String,String> translator = new HashMap<String,String>();
		
		translator.put("a", "あ");
		translator.put("i", "い");
		translator.put("u", "う");
		translator.put("e", "え");
		translator.put("o", "お");
		translator.put("ka", "か");
		translator.put("ki", "き");
		translator.put("ku", "く");
		translator.put("ke", "け");
		translator.put("ko", "こ");
		translator.put("sa", "さ");
		translator.put("shi", "し");
		translator.put("su", "す");
		translator.put("se", "せ");
		translator.put("so", "そ");
		translator.put("ta", "た");
		translator.put("te", "て");
		translator.put("to", "と");
		translator.put("na", "な");
		translator.put("ni", "に");
		translator.put("nu", "ぬ");
		translator.put("ne", "ね");
		translator.put("no", "の");
		translator.put("ha", "は");
		translator.put("hi", "ひ");
		translator.put("he", "へ");
		translator.put("ho", "ほ");
		translator.put("ma", "ま");
		translator.put("mi", "み");
		translator.put("mu", "む");
		translator.put("me", "め");
		translator.put("mo", "も");
		translator.put("ra", "ら");
		translator.put("ri", "り");
		translator.put("ru", "る");
		translator.put("re", "れ");
		translator.put("ro", "ろ");
		translator.put("ya", "や");
		translator.put("yu", "ゆ");
		translator.put("yo", "よ");
		translator.put("wa", "わ");
		translator.put("wo", "を");
		translator.put("n", "ん");
		
		//chi, tsu, fu are ambiguous
		
//		translator.put("chi", "ち");
//		translator.put("tsu", "つ");
//		translator.put("fu", "ふ");

		//modified characters
		
		translator.put("ga", "が");
		translator.put("gi", "ぎ");
		translator.put("gu", "ぐ");
		translator.put("ge", "げ");
		translator.put("go", "ご");
		translator.put("za", "ざ");
		translator.put("zu", "ず");
		translator.put("ze", "ぜ");
		translator.put("zo", "ぞ");
		translator.put("da", "だ");
		translator.put("zu", "ず");
		translator.put("ze", "ぜ");
		translator.put("zo", "ぞ");
		translator.put("ba", "ば");
		translator.put("bi", "び");
		translator.put("bu", "ぶ");
		translator.put("be", "べ");
		translator.put("bo", "ぼ");
		translator.put("pa", "ぱ");
		translator.put("pi", "ぴ");
		translator.put("pu", "ぷ");
		translator.put("pe", "ぺ");
		translator.put("po", "ぽ");

		//ji kanas are ambiguous
//		translator.put("ji", "じ");
//		translator.put("ji", "じ");
		
		//composites

		translator.put("kya", "きゃ");
		translator.put("sha", "しゃ");
		translator.put("cha", "ちゃ");
		translator.put("nya", "にゃ");
		translator.put("hya", "ひゃ");
		translator.put("mya", "みゃ");
		translator.put("rya", "りゃ");
		translator.put("gya", "ぎゃ");
		translator.put("jya", "じゃ");
		translator.put("cha", "ぢゃ");
		translator.put("bya", "びゃ");
		translator.put("pya", "ぴゃ");
		translator.put("kyu", "きゅ");
		translator.put("shu", "しゅ");
		translator.put("chu", "ちゅ");
		translator.put("nyu", "にゅ");
		translator.put("hyu", "ひゅ");
		translator.put("myu", "みゅ");
		translator.put("ryu", "りゅ");
		translator.put("gyu", "ぎゅ");
		translator.put("jyu", "じゅ");
		translator.put("chu", "ぢゅ");
		translator.put("byu", "びゅ");
		translator.put("pyu", "ぴゅ");
		translator.put("kyo", "きょ");
		translator.put("sho", "しょ");
		translator.put("cho", "ちょ");
		translator.put("nyo", "にょ");
		translator.put("hyo", "ひょ");
		translator.put("myo", "みょ");
		translator.put("ryo", "りょ");
		translator.put("gyo", "ぎょ");
		translator.put("jo", "じょ");
		translator.put("cho", "ぢょ");
		translator.put("byo", "びょ");
		translator.put("pyo", "ぴょ");
		
		//small tsu

//		translator.put("kka", "っか");
//		translator.put("kki", "っき");
//		translator.put("kku", "っく");
//		translator.put("kke", "っけ");
//		translator.put("kko", "っこ");
//		translator.put("ssa", "っさ");
//		translator.put("sshi", "っし");
//		translator.put("ssu", "っす");
//		translator.put("sse", "っせ");
//		translator.put("sso", "っそ");
//		translator.put("tta", "った");
//		translator.put("cchi", "っち");
//		translator.put("ttsu", "っつ");
//		translator.put("tte", "って");
//		translator.put("tto", "っと");
		
		//modified characters
		
//		translator.put("gga", "っが");
//		translator.put("ggi", "っぎ");
//		translator.put("ggu", "っぐ");
//		translator.put("gge", "っげ");
//		translator.put("ggo", "っご");
//		translator.put("zza", "っざ");
//		translator.put("jji", "っじ");
//		translator.put("zzu", "っず");
//		translator.put("zze", "っぜ");
//		translator.put("zzo", "っぞ");
//		translator.put("dda", "っだ");
//		translator.put("jji", "っじ");
//		translator.put("zzu", "っず");
//		translator.put("zze", "っぜ");
//		translator.put("zzo", "っぞ");
//		translator.put("bba", "っば");
//		translator.put("bbi", "っび");
//		translator.put("bbu", "っぶ");
//		translator.put("bbe", "っべ");
//		translator.put("bbo", "っぼ");
//		translator.put("ppa", "っぱ");
//		translator.put("ppi", "っぴ");
//		translator.put("ppu", "っぷ");
//		translator.put("ppe", "っぺ");
//		translator.put("ppo", "っぽ");
		
		//composites

//		translator.put("kkya", "っきゃ");
//		translator.put("ssha", "っしゃ");
//		translator.put("ccha", "っちゃ");
//		translator.put("nnya", "っにゃ");
//		translator.put("ggya", "っぎゃ");
//		translator.put("jja", "っじゃ");
//		translator.put("ccha", "っぢゃ");
//		translator.put("bbya", "っびゃ");
//		translator.put("ppya", "っぴゃ");
//		translator.put("kkyu", "っきゅ");
//		translator.put("sshu", "っしゅ");
//		translator.put("cchu", "っちゅ");
//		translator.put("ggyu", "っぎゅ");
//		translator.put("jju", "っじゅ");
//		translator.put("cchu", "っぢゅ");
//		translator.put("bbyu", "っびゅ");
//		translator.put("ppyu", "っぴゅ");
//		translator.put("kkyo", "っきょ");
//		translator.put("ssho", "っしょ");
//		translator.put("ccho", "っちょ");
//		translator.put("nnyo", "っにょ");
//		translator.put("hhyo", "っひょ");
//		translator.put("mmyo", "っみょ");
//		translator.put("rryo", "っりょ");
//		translator.put("ggyo", "っぎょ");
//		translator.put("jjo", "っじょ");
//		translator.put("ccho", "っぢょ");
//		translator.put("bbyo", "っびょ");
//		translator.put("ppyo", "っぴょ");
		
		return translator;
	}
	
	public String map(String input) {
		
		input = input.toLowerCase();
		
		String needle = "";
		StringBuilder output = new StringBuilder();
		int maxkeylength = 0;
		
		Set<String> keys = BaseRomajiMapper.translator.keySet();
		for (String string : keys) {
			if (string.length() > maxkeylength) {
				maxkeylength = string.length();
			}
		}
		
		int index = 0;

		nextstringbit:
		while (index<input.length()) {
			
			//check the matches in decreasing lengths
			int restlength = input.length() - index;
			int testlength = maxkeylength;

			while (testlength > 0) {
				if (restlength >= testlength) {
					needle = input.substring(index, index + testlength);
					if (BaseRomajiMapper.translator.containsKey(needle)) {
						output.append(BaseRomajiMapper.translator.get(needle));
						index += testlength;
						//we've found the match, continue with the next bit of input
						continue nextstringbit;
					}
				}
				testlength --;
			}
			index++;
		}
		return output.toString();
	}

	protected abstract void addSpecificMappings();
}
