package com.skilldistillery.cards.common.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.*;

public class BlackjackHand extends Hand {
	
	public BlackjackHand() {
			
		}
	
	public int getHandValue(List<Card> cardsInHand) {
		int totalHandValue = 0;
		for (Card card : cardsInHand) {
			totalHandValue += card.getValue();
		}
		return totalHandValue;
	}

	public void printHand(List<Card> cardsInHand) {
		for (int i = 0; i < cardsInHand.size(); i++) {
			if (i < (cardsInHand.size() - 1)) {
				System.out.print(cardsInHand.get(i) + ", ");
			}
			else {
				System.out.println(cardsInHand.get(i));
			}
		}
	}
}
