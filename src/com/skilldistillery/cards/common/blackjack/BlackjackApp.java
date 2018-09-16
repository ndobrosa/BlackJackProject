package com.skilldistillery.cards.common.blackjack;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Rank;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp ba = new BlackjackApp();
		ba.launch();

	}

	public void launch() {
		System.out.println("We promote gambling as an enjoyable leisure activity and we believe that gambling can only remain this way if you stay in control and gamble responsibly.\nEnjoy playing Blackjack! \n");
		runGame();

	}

	private void runGame() {

		Deck deck = new Deck();
		deck.shuffle();
		int count = 0;

		boolean playMore = isAnotherRound(count);
		count++;

		while (playMore == true) {
			BlackjackHand dh = new BlackjackHand();
			BlackjackHand ph = new BlackjackHand();

			givePlayerCard(deck, ph);
			giveDealerCard(deck, dh);
			givePlayerCard(deck, ph);
			giveDealerCard(deck, dh);

			// user decides if they want to get hit or stay
			hitOrStayPlayer(deck, ph);

			// Dealer decides if they should hold or stay
			if (ph.getHandValue() <= 21) {
				hitOrStayDealer(deck, dh);
			}

			// Print the winner of the game
			printResults(ph, dh);
			playMore = isAnotherRound(count);
		}
		sc.close();

	}

	private boolean isAnotherRound(int count) {

		if (count == 0) {
			System.out.print("Would you like to play ('yes'/'no') ");
		} else {
			System.out.print("\nWould you like to play again? ('yes'/'no') ");
		}
		String wannnaPlay = "";

		try {
			wannnaPlay = sc.nextLine();
			System.out.println();
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		} catch (IllegalStateException e) {
			e.getStackTrace();
		}

		while (!wannnaPlay.toLowerCase().equals("yes") && !wannnaPlay.toLowerCase().equals("no")
				&& !wannnaPlay.toLowerCase().equals("y") && !wannnaPlay.toLowerCase().equals("n")) {
			System.out.println("Wrong choice. Please chose whether you would like to play again! ('yes'/'no')");
			wannnaPlay = sc.nextLine();
		}

		if (!wannnaPlay.toLowerCase().equals("no") && !wannnaPlay.toLowerCase().equals("n")) {
			return true;
		} else {
			return false;
		}
	}

	private void printResults(BlackjackHand ph, BlackjackHand dh) {
		// if player went over the limit, computer wins
		if (ph.getHandValue() > 21) {
			System.out.print("\nYou did not win that one, but that was so close! ");
		}
		/*
		 * if dealer went over the limit, or if dealer ended with less points than
		 * player, player wins. - Else if statement is used to ensure that the player's
		 * final score is in bounds.
		 */
		else if ((dh.getHandValue() > 21 || dh.getHandValue() < ph.getHandValue())) {
			System.out.println("\nYOU WON! Here is the final score!");
			resultString(ph, dh);
		}
		// if dealer is inbounds and has a higher score than the player who is also
		// inbounds, dealer wins.
		else if (dh.getHandValue() <= 21 && (dh.getHandValue() > dh.getHandValue())) {
			System.out.println("\nBetter luck next time! Here is the final score!");
			resultString(ph, dh);
		} // if the result is even, nobody wins
		else {
			System.out.println("The bet is a push. Nobody wins the game. Here is the final score!");
			resultString(ph, dh);
		}
	}

	private void resultString(BlackjackHand ph, BlackjackHand dh) {
		System.out.println("DEALER: " + dh.getHandValue() + "- with the hand: " + dh.toString());
		System.out.println("YOU: " + ph.getHandValue() + "- with the hand: " + ph.toString());
	}

	private void givePlayerCard(Deck deck, BlackjackHand hand) {
		Card c = deck.dealCard();
		hand.addCard(c);
		System.out.print("You were dealt: " + c + ".");
		if (hand.getCards().size() > 1) {
			System.out.print("You are currently holding: ");
			System.out.println(hand.toString());
		}
		System.out.println("The total value of your hand is " + hand.getHandValue() + ".\n");
	}

	private void giveDealerCard(Deck deck, BlackjackHand hand) {
		Card c = deck.dealCard();
		hand.addCard(c);
		if (hand.getCards().size() == 1) {
			System.out.println("Dealer was dealt a secret card.\n");
		} else if (hand.getCards().size() == 2) {
			System.out.print("Dealer was dealt: " + c + ". The value of that card is ");
			System.out.println(c.getValue() + ".\n");
		} else {
			System.out.print("Dealer was dealt: " + c + ". The dealer is currently holding: ");
			System.out.println(hand.toString());
			System.out.println("The total value of dealer's hand is " + hand.getHandValue() + ".\n");
		}

	}

	private void hitOrStayPlayer(Deck deck, BlackjackHand hand) {
		String hitStay = "";
		do {
			System.out.print("Would you like to [h]it or [s]tay? ");
			try {
				hitStay = sc.nextLine();
				System.out.println();
			} catch (NoSuchElementException e) {
				e.getStackTrace();
			} catch (IllegalStateException e) {
				e.getStackTrace();
			}

			if ((hitStay.toLowerCase().equals("hit") || hitStay.toLowerCase().equals("h"))
					&& (!hitStay.toLowerCase().equals("s") && !hitStay.toLowerCase().equals("stay"))) {
				givePlayerCard(deck, hand);
			}
		} while ((hitStay.toLowerCase().equals("hit") || hitStay.toLowerCase().equals("h"))
				&& hand.getHandValue() <= 21);
	}

	private void hitOrStayDealer(Deck deck, BlackjackHand hand) {
		System.out.println("\nDealer is currently holding " + hand.toString());
		while (hand.getHandValue() < 17) {
			System.out.println("Dealer hits.");
			giveDealerCard(deck, hand);
		}
		System.out.println("Dealer Stays.\n");

	}

}
