package org.jigoku.utils;

import java.util.List;

import org.jigoku.FlashCard;

public class Randomizer {
	static public List<FlashCard> shuffle(List<FlashCard> list) {
		int j;
		int k = list.size();
		for (int i = 0; i < k - 1; i++) {
			j = ((int) (((double) (k - i)) * Math.random())) + i;
			FlashCard temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		return list;
	}
}
