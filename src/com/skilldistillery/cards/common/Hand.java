package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cardsInHand = new ArrayList();
	
	public Hand() {
		
	}
	
	public abstract int getHandValue(List<Card> cardsInHand);
	
	public List<Card> addCard(Card c) {
		cardsInHand.add(c);
		return cardsInHand;
	}

	
	public List<Card> getCards() {
		
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : cardsInHand) {
			sb.append(card).append(" | ");
		}
		return sb.toString();
	}
	
	
	
	

}
