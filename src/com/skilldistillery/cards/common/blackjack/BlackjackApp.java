package com.skilldistillery.cards.common.blackjack;

import java.util.List;
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
				"We promote gambling as an enjoyable leisure activity and we believe that gambling can only remain this way if you stay in control and gamble responsibly.\nEnjoy playing Blackjack!");
		startGame();

	}

	private void startGame() {
		
		Deck dd = new Deck();
		BlackjackHand dh = new BlackjackHand();
		BlackjackHand ph = new BlackjackHand();
		dd.shuffle();

		String playAgain = "a";

		while (!playAgain.toLowerCase().equals("no") && !playAgain.toLowerCase().equals("n")) {
			Card player = dd.dealCards();
			List<Card> playerHand = ph.addCard(player);
			Card dealer = dd.dealCards();
			List<Card> dealerHand = dh.addCard(dealer);

			for (int i = 0; i < 4; i++) {
				System.out.println("You were dealt the following card: " + player);
				System.out.println("The total value of your hand is " + ph.getHandValue(playerHand));

				if (dealerHand.size() == 1) {
					System.out.println("Dealer was dealt a secret card.");
				} else if (dealerHand.size() == 2) {
					System.out.print("Dealer was dealt the following card: " + dealer);
					System.out.println(". The value of that card is " + dealer.getValue() + ".");
				}
				else if (dealerHand.size() == 3) {
					System.out.print("The dealer has the following cards: ");
					dh.printHand(dealerHand);
					System.out.println();
				}
				
				
				
				player = dd.dealCards();
				dealer = dd.dealCards();

				playerHand = ph.addCard(player);
				dealerHand = dh.addCard(dealer);
			}

			System.out.println("would you like to play again? ('yes'/'no')");
			playAgain = sc.nextLine();

			while (!playAgain.toLowerCase().equals("yes") && !playAgain.toLowerCase().equals("no")
					&& !playAgain.toLowerCase().equals("y") && !playAgain.toLowerCase().equals("n")) {
				System.out.println("Wrong choice. Please chose whether you would like to play again! ('yes'/'no')");
				playAgain = sc.nextLine();
			}

		}

	}

}
