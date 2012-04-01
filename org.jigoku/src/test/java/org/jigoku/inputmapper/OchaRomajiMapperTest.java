package org.jigoku.inputmapper;

import junit.framework.Assert;

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
