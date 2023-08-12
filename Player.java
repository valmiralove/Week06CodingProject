package week06WAR;

import java.util.ArrayList;
import java.util.List;

public class Player { //Player class to represent a player in the card game
	
	//instance variables
    private List<Card> hand;
    private int score;
    private String name;

    //constructor to initialize a player name, hand, and score
    public Player(String name) {
        hand = new ArrayList<>();
        score = 0;
        this.name = name;
    }

    //methods
    public void describe() { //describe method to print the player's hand
        System.out.println("\n\t" + name + "'s Hand:");
        for (Card card : hand) {
            card.describe();
        }
    }

    public Card flip() { //flip method to remove and return the top card from player's hand
        return hand.remove(0);
    }

    public void draw(Deck deck) { //draw method to add a card to player's hand from deck
        Card newCard = deck.draw();
        hand.add(newCard);//possibly change
    }

    public void incrementScore() { //method to increment player's score
        score++;
    }

    //setters & getters
    public int getScore() { //getter for player's score
        return score;
    }
    
    public void setName(String name) { //setter for player's name
    	this.name = name;
    }
    public String getName() { //getter for player's name
    	return name;
    }
}