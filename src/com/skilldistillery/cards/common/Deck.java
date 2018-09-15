package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOfCards;

	public Deck() {
		deckOfCards = new ArrayList<Card>();

		for (int suit = 0; suit < Suit.values().length; suit++) {
			for (int rank = 0; rank < Rank.values().length; rank++) {
				Card newCard = new Card(Suit.values()[suit], Rank.values()[rank]);
				deckOfCards.add(newCard);

			}

		}

	}

	public List<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(List<Card> deckOfCards) {
		this.deckOfCards = deckOfCards;
	}

	public int checkDeckSize() {
		int cardsRemaining = deckOfCards.size();
		return cardsRemaining;
	}
	
	public Card dealCard() {
		Card drawnCard = deckOfCards.remove(0);
		return drawnCard;
		
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}

}
