package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cardsInHand = new ArrayList();
	
	public Hand() {
		
	}
	
	public abstract int getHandValue();
	
	public void addCard(Card c) {
		cardsInHand.add(c);
	}

	
	public List<Card> getCards() {
		return cardsInHand;
	}

	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		for (Card card : cardsInHand) {
//			sb.append(" | ").append(card).append(" | ");
//		}
//		return sb.toString();
		return cardsInHand.toString();
	}
	
	
	
	

}
