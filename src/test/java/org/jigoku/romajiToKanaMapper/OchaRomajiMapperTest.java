package org.jigoku.romajiToKanaMapper;

import junit.framework.Assert;

import org.jigoku.romajiToKanaMapper.impl.OchaRomajiMapper;
import org.junit.Test;

public class OchaRomajiMapperTest {

	@Test
	public void translateFromRomaji() {
		String input = "kakkoisannosukke";

		OchaRomajiMapper mapper = new OchaRomajiMapper();

		String output = mapper.map(input);

		Assert.assertEquals("かっこいさんのすっけ", output);
	}

}
