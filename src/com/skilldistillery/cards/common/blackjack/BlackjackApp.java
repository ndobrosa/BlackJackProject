package com.skilldistillery.cards.common.blackjack;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.launch();

	}

	public void launch() {
		System.out.println(
				"We promote gambling as an enjoyable leisure activity and we believe that gambling can only remain this way if you stay in control and gamble responsibly.\nEnjoy playing Blackjack! \n");
		startGame();

	}

	private void startGame() {

		Deck deck = new Deck();
		BlackjackHand dh = new BlackjackHand();
		BlackjackHand ph = new BlackjackHand();
		deck.shuffle();

		String playAgain = "";
		String hitStay = "";

		while (!playAgain.toLowerCase().equals("no") && !playAgain.toLowerCase().equals("n")) {
			Card playerCard = deck.dealCards();
			Card dealerCard = deck.dealCards();
			List<Card> playerHand = ph.addCard(playerCard);
			List<Card> dealerHand = dh.addCard(dealerCard);
			System.out.println("You were dealt: " + playerCard + ".");
			System.out.println("The value of that card is " + ph.getHandValue(playerHand) + ".\n");
			System.out.println("Dealer was dealt a secret card. \n");

			playerCard = deck.dealCards();
			playerHand = ph.addCard(playerCard);
			System.out.print("You were dealt: " + playerCard + ".");
			System.out.print("You are currently holding: ");
			ph.printHand(playerHand);
			System.out.println("The total value of your hand is " + ph.getHandValue(playerHand) + ".\n");
			dealerCard = deck.dealCards();
			dealerHand = dh.addCard(dealerCard);
			System.out.print("Dealer was dealt: " + dealerCard);
			System.out.println(". The value of that card is " + dealerCard.getValue() + ".\n");

//			do {
//				playerCard = deck.dealCards();
//				dealerCard = deck.dealCards();
//
//				playerHand = ph.addCard(playerCard);
//				dealerHand = dh.addCard(dealerCard);
//
//				System.out.print("You were dealt: " + playerCard + ".");
//				System.out.print("You are currently holding: ");
//				ph.printHand(playerHand);
//				System.out.println("The total value of your hand is " + ph.getHandValue(playerHand) + ".\n");
//
//				if (dealerHand.size() == 1) {
//					System.out.println("Dealer was dealt a secret card.\n");
//				} else if (dealerHand.size() == 2) {
//					System.out.print("Dealer was dealt: " + dealerCard);
//					System.out.println(". The value of that card is " + dealerCard.getValue() + ".\n");
////					(dealerHand.size() == 3)
//				} else {
//					System.out.print("The dealer has the following cards: ");
//					dh.printHand(dealerHand);
//					System.out.println();
//				}
//
//				System.out.print("would you to [h]it or [s]tay? ");
//				try {
//					hitStay = sc.nextLine();
//				} catch (NoSuchElementException e) {
//					e.getStackTrace();
//				} catch (IllegalStateException e) {
//					e.getStackTrace();
//				}
//			} while (hitStay.toLowerCase().equals("hit") || hitStay.toLowerCase().equals("h"));

			System.out.println("would you like to play again? ('yes'/'no')");
			try {
				playAgain = sc.nextLine();
			} catch (NoSuchElementException e) {
				e.getStackTrace();
			} catch (IllegalStateException e) {
				e.getStackTrace();
			}

			while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")
					&& !playAgain.toLowerCase().equals("y") && !playAgain.toLowerCase().equals("n")) {
				System.out.println("Wrong choice. Please chose whether you would like to play again! ('yes'/'no')");
				playAgain = sc.nextLine();
			}

		}

	}

}
