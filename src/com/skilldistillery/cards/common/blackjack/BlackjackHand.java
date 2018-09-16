package com.skilldistillery.cards.common.blackjack;

import java.util.List;

import javax.swing.AbstractCellEditor;

import com.skilldistillery.cards.common.*;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}
	
	public int getHandValue() {
		int totalHandValue = 0;
		for (Card card : cardsInHand) {
			totalHandValue += card.getValue();
		}
		if (totalHandValue > 21) {
			for (Card card : cardsInHand) {
				if (totalHandValue > 21 && card.getValue() == 11) {
					totalHandValue -= 10;
				}
			}
		}
		return totalHandValue;
		}

	public void printHand(List<Card> cardsInHand) {
		for (int i = 0; i < cardsInHand.size(); i++) {
			if (i < (cardsInHand.size() - 1)) {
				System.out.print(cardsInHand.get(i) + ", ");
			} else {
				System.out.println(cardsInHand.get(i));
			}
		}
	}
}
