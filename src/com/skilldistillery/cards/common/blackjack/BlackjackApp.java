package com.skilldistillery.cards.common.blackjack;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

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
		deck.shuffle();

		String playAgain = "";
		String hitStay = "";

		while (!playAgain.toLowerCase().equals("no") && !playAgain.toLowerCase().equals("n")) {
			BlackjackHand dh = new BlackjackHand();
			BlackjackHand ph = new BlackjackHand();

			Card playerCard = deck.dealCard();
			List<Card> playerColl = ph.addCard(playerCard);
			System.out.println("You were dealt: " + playerCard + ".");
			System.out.println("The value of that card is " + ph.getHandValue(playerColl) + ".\n");

			Card dealerCard = deck.dealCard();
			List<Card> dealerColl = dh.addCard(dealerCard);
			System.out.println("Dealer was dealt a secret card. \n");

			playerCard = deck.dealCard();
			playerColl = ph.addCard(playerCard);
			System.out.print("You were dealt: " + playerCard + ".");
			System.out.print("You are currently holding: ");
			ph.printHand(playerColl);
			System.out.println("The total value of your hand is " + ph.getHandValue(playerColl) + ".\n");
//			givePlayerCard(deck, ph);

			dealerCard = deck.dealCard();
			dealerColl = dh.addCard(dealerCard);
			System.out.print("Dealer was dealt: " + dealerCard);
			System.out.println(". The value of that card is " + dealerCard.getValue() + ".\n");

			do {
				System.out.println("would you to [h]it or [s]tay? ");
				try {
					hitStay = sc.nextLine();
				} catch (NoSuchElementException e) {
					e.getStackTrace();
				} catch (IllegalStateException e) {
					e.getStackTrace();
				}

				if (hitStay.toLowerCase().equals("hit") || hitStay.toLowerCase().equals("h")) {
					playerCard = deck.dealCard();
					playerColl = ph.addCard(playerCard);
					System.out.print("You were dealt: " + playerCard + ".");
					System.out.print("You are currently holding: ");
					ph.printHand(playerColl);
					System.out.println("The total value of your hand is " + ph.getHandValue(playerColl) + ".\n");
				}

			} while ((hitStay.toLowerCase().equals("hit") || hitStay.toLowerCase().equals("h"))
					&& ph.getHandValue(playerColl) <= 21);

			// Dealer is deciding if he should hold or stay
			 if (ph.getHandValue(playerColl) <= 21) {
				if (dh.getHandValue(dealerColl) < 17) {
					while (dh.getHandValue(dealerColl) < 17) {
						System.out.println("The total value of dealer's hand is " + dh.getHandValue(dealerColl));
						System.out.println("Dealer hits.");
						dealerCard = deck.dealCard();
						dealerColl = dh.addCard(dealerCard);
						System.out.print("Dealer was dealt: " + dealerCard + ". ");
						System.out.print("Dealer is currently holding: ");
						dh.printHand(dealerColl);
						System.out.println();
					}
					System.out.println("Dealer stays.");
				} else if (dh.getHandValue(dealerColl) >= 17 && dh.getHandValue(dealerColl) <= 21) {
					System.out.print("Dealer is currently holding: ");
					dh.printHand(dealerColl);
					
					System.out.println("The total value of dealer's hand is " + dh.getHandValue(dealerColl) + ".\n");
					System.out.println("Dealer stays.");
				}
			}
			
			//Final results printed
			if (ph.getHandValue(playerColl) > 21) {
				System.out.print("\nYou did not win that one, but that was so close! ");
			}
			else if (dh.getHandValue(dealerColl) > 21 || (dh.getHandValue(dealerColl) < dh.getHandValue(playerColl))) {
				System.out.println("\nYOU WON! Here is the final score!");
				System.out.print("DEALER: " + dh.getHandValue(dealerColl) + "- with the hand: ");
				dh.printHand(dealerColl);
				System.out.print("YOU: " + ph.getHandValue(playerColl) + "- with the hand: ");
				ph.printHand(playerColl);
			} 
			
			else if (dh.getHandValue(dealerColl) <= 21
					&& (dh.getHandValue(dealerColl) > dh.getHandValue(playerColl))) {
				System.out.println("\nBetter luck next time! Here is the final score!");
				System.out.print("DEALER: " + dh.getHandValue(dealerColl) + " - with the hand: ");
				dh.printHand(dealerColl);
				System.out.print("YOU: " + ph.getHandValue(playerColl) + " - with the hand: ");
				ph.printHand(playerColl);
			} else {
				System.out.println("The bet is a push. Nobody wins the game.");
			}

		System.out.println("Would you like to play again? ('yes'/'no')");
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

//	private void givePlayerCard(Deck deck, Hand hand) {
//		Card c = deck.dealCard();
//		hand.addCard(c);
//		System.out.print("You were dealt: " + c + ".");
//		System.out.print("You are currently holding: ");
//		System.out.println(hand.toString());
//		System.out.println("The total value of your hand is " + hand.getHandValue() + ".\n");		
//	}
