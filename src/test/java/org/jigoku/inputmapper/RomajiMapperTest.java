package org.jigoku.inputmapper;
import junit.framework.Assert;

import org.junit.Test;

public class RomajiMapperTest {
	@Test
	public void translateFromRomaji() {

		String input = "kakkoisannosukke";

		RomajiMapper mapper = new RomajiMapper();

		String output = mapper.map(input);

		Assert.assertEquals("かこいさんのすけ", output);
	}
}
