package week06WAR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck { //Deck class to represent a deck of card
	
	//instance variable
    private List<Card> cards = new ArrayList<>();

    
    //constructor to populate the deck with standard 52 cards
    public Deck() {
    	 cards = new ArrayList<>(); //create new ArrayList to store the cards
         for (int value = 2; value <= 14; value++) { //outer loop iterates over each card value from 2-14 
             for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) { //inner loop iterates over each suit
                 Card card = new Card(); //create a new Card object for the current value and suit 
                 card.setValue(value); //set value of the card
                 card.setName(getCardName(value, suit)); //set the name of the card using getCardName method
                 cards.add(card); //add the created card to the ArrayList of cards
             }
         }
    }

    //methods
    public void shuffle() { //shuffle method to randomize the order of cards in the deck
        Random random = new Random(); //create new Random object to generate random numbers
        for (int i = cards.size() - 1; i > 0; i--) { //loop through cards in reverse order
            int j = random.nextInt(i + 1); //generate a random index between 0 (inclusive) and i+1 (exclusive)
            Card temp = cards.get(i); //swap the card at index i with the card at index j
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card draw() { //draw method to remove and return the top card from the deck
        return cards.remove(0);
    }
    
    private String getCardName(int value, String suit) { //method to generate card name based on value and suit
        String cardName = "";
        if (value >= 2 && value <= 10) {
            cardName = Integer.toString(value);
        } else {
            switch (value) {
                case 11:
                    cardName = "Jack";
                    break;
                case 12:
                    cardName = "Queen";
                    break;
                case 13:
                    cardName = "King";
                    break;
                case 14:
                    cardName = "Ace";
                    break;
            }
        }
        return cardName + " of " + suit;
    }
}