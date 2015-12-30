package org.jigoku;

import org.apache.commons.lang3.StringUtils;
import org.jigoku.romajiToKanaMapper.RomajiToKanaMapper;
import org.jigoku.romajiToKanaMapper.impl.OchaRomajiMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yves on 30.12.2015.
 */
public class FlashCardTest {
	private ArrayList<FlashCard> flashCards;
	private RomajiToKanaMapper mapper;

	@Before
	public void initResources() {
		ResourcePool resourcePool = new ResourcePool();
		flashCards = resourcePool.getFlashCards();
		mapper = new OchaRomajiMapper();
	}

	@Test
	public void testFirstCard() {
		assertTrue(flashCards.get(0).checkSolution("jin", mapper));
		assertFalse(flashCards.get(0).checkSolution("jinn", mapper));
		assertFalse(flashCards.get(0).checkSolution(StringUtils.EMPTY, mapper));
	}

	@Test
	public void testTenthCard() {
		assertTrue(flashCards.get(10).checkSolution("ichinichi", mapper));
	}

	@Test
	public void testTwentiethCard() {
		assertTrue(flashCards.get(20).checkSolution("mittsu", mapper));
		assertFalse(flashCards.get(20).checkSolution("mitsu", mapper));
		assertFalse(flashCards.get(20).checkSolution("san", mapper));
	}

}