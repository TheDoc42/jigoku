package org.jigoku.inputmapper;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OchaRomajiMapper extends BaseRomajiMapper {
	public OchaRomajiMapper() {
		super();
		addSpecificMappings();
	}

	@Override
	protected void addSpecificMappings() {
		OchaRomajiMapper.translator.put("chi", "ち");
		OchaRomajiMapper.translator.put("tsu", "つ");
		OchaRomajiMapper.translator.put("fu", "ふ");

		OchaRomajiMapper.translator.put("ji", "じ");
		OchaRomajiMapper.translator.put("ji", "じ");

		OchaRomajiMapper.translator.put("kka", "っか");
		OchaRomajiMapper.translator.put("kki", "っき");
		OchaRomajiMapper.translator.put("kku", "っく");
		OchaRomajiMapper.translator.put("kke", "っけ");
		OchaRomajiMapper.translator.put("kko", "っこ");
		OchaRomajiMapper.translator.put("ssa", "っさ");
		OchaRomajiMapper.translator.put("sshi", "っし");
		OchaRomajiMapper.translator.put("ssu", "っす");
		OchaRomajiMapper.translator.put("sse", "っせ");
		OchaRomajiMapper.translator.put("sso", "っそ");
		OchaRomajiMapper.translator.put("tta", "った");
		OchaRomajiMapper.translator.put("cchi", "っち");
		OchaRomajiMapper.translator.put("ttsu", "っつ");
		OchaRomajiMapper.translator.put("tte", "って");
		OchaRomajiMapper.translator.put("tto", "っと");

		// modified characters

		OchaRomajiMapper.translator.put("gga", "っが");
		OchaRomajiMapper.translator.put("ggi", "っぎ");
		OchaRomajiMapper.translator.put("ggu", "っぐ");
		OchaRomajiMapper.translator.put("gge", "っげ");
		OchaRomajiMapper.translator.put("ggo", "っご");
		OchaRomajiMapper.translator.put("zza", "っざ");
		OchaRomajiMapper.translator.put("jji", "っじ");
		OchaRomajiMapper.translator.put("zzu", "っず");
		OchaRomajiMapper.translator.put("zze", "っぜ");
		OchaRomajiMapper.translator.put("zzo", "っぞ");
		OchaRomajiMapper.translator.put("dda", "っだ");
		OchaRomajiMapper.translator.put("jji", "っじ");
		OchaRomajiMapper.translator.put("zzu", "っず");
		OchaRomajiMapper.translator.put("zze", "っぜ");
		OchaRomajiMapper.translator.put("zzo", "っぞ");
		OchaRomajiMapper.translator.put("bba", "っば");
		OchaRomajiMapper.translator.put("bbi", "っび");
		OchaRomajiMapper.translator.put("bbu", "っぶ");
		OchaRomajiMapper.translator.put("bbe", "っべ");
		OchaRomajiMapper.translator.put("bbo", "っぼ");
		OchaRomajiMapper.translator.put("ppa", "っぱ");
		OchaRomajiMapper.translator.put("ppi", "っぴ");
		OchaRomajiMapper.translator.put("ppu", "っぷ");
		OchaRomajiMapper.translator.put("ppe", "っぺ");
		OchaRomajiMapper.translator.put("ppo", "っぽ");

		// composites

		OchaRomajiMapper.translator.put("kkya", "っきゃ");
		OchaRomajiMapper.translator.put("ssha", "っしゃ");
		OchaRomajiMapper.translator.put("ccha", "っちゃ");
		OchaRomajiMapper.translator.put("nnya", "っにゃ");
		OchaRomajiMapper.translator.put("ggya", "っぎゃ");
		OchaRomajiMapper.translator.put("jja", "っじゃ");
		OchaRomajiMapper.translator.put("ccha", "っぢゃ");
		OchaRomajiMapper.translator.put("bbya", "っびゃ");
		OchaRomajiMapper.translator.put("ppya", "っぴゃ");
		OchaRomajiMapper.translator.put("kkyu", "っきゅ");
		OchaRomajiMapper.translator.put("sshu", "っしゅ");
		OchaRomajiMapper.translator.put("cchu", "っちゅ");
		OchaRomajiMapper.translator.put("ggyu", "っぎゅ");
		OchaRomajiMapper.translator.put("jju", "っじゅ");
		OchaRomajiMapper.translator.put("cchu", "っぢゅ");
		OchaRomajiMapper.translator.put("bbyu", "っびゅ");
		OchaRomajiMapper.translator.put("ppyu", "っぴゅ");
		OchaRomajiMapper.translator.put("kkyo", "っきょ");
		OchaRomajiMapper.translator.put("ssho", "っしょ");
		OchaRomajiMapper.translator.put("ccho", "っちょ");
		OchaRomajiMapper.translator.put("nnyo", "っにょ");
		OchaRomajiMapper.translator.put("hhyo", "っひょ");
		OchaRomajiMapper.translator.put("mmyo", "っみょ");
		OchaRomajiMapper.translator.put("rryo", "っりょ");
		OchaRomajiMapper.translator.put("ggyo", "っぎょ");
		OchaRomajiMapper.translator.put("jjo", "っじょ");
		OchaRomajiMapper.translator.put("ccho", "っぢょ");
		OchaRomajiMapper.translator.put("bbyo", "っびょ");
		OchaRomajiMapper.translator.put("ppyo", "っぴょ");
	}
}
