package org.jigoku.utils;

import java.util.List;

import org.jigoku.FlashCard;

/**
 * Randomizes the order of a list.
 */
public final class Randomizer {

	private Randomizer() {
	}

	/**
	 * Randomizes the order of a list..
	 * 
	 * @param list
	 *            list to be randomized
	 * @return randomized list
	 */
	public static List<FlashCard> shuffle(final List<FlashCard> list) {
		// TODO: don't modify order or listed passed as parameter
		// TODO: Replace Falshcard with generics parameter
		int j;
		int k = list.size();
		for (int i = 0; i < k - 1; i++) {
			j = ((int) (((k - i)) * Math.random())) + i;
			FlashCard temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		return list;
	}
}
