package week06WAR;

public class App { //Main application class
    public static void main(String[] args) {
        
    	//instantiate new deck, and two players
        Deck deck = new Deck();
        Player player1 = new Player("Player One");
        Player player2 = new Player("Player Two");
        
        //using setter method to change player1 & player2 names
        player1.setName("Bunny");
        player2.setName("Turtle");


    	//shuffle the deck
        deck.shuffle();
        
        //deal cards to players
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck);
            } else {
                player2.draw(deck);
            }
        }
        
        //print players' hands
        System.out.println("--- Hands for each player ---");
        player1.describe();
        player2.describe();

        System.out.println("\n--- " + player1.getName() + " and " + player2.getName() + " flipping cards ---\n");
        
        //simulate the game by flipping cards and determining the winner of each flip
        for (int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            System.out.println(player1.getName() + " flips: " + card1.getName());
            System.out.println(player2.getName() + " flips: " + card2.getName());

            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println("\t" + player1.getName() + " earns 1 point.");
            } else if (card2.getValue() > card1.getValue()) {
                player2.incrementScore();
                System.out.println("\t" + player2.getName() + " earns 1 point.");
            } else {
                System.out.println("\tIt's a tie! No points awarded.");
            }
        }

        
        //get players scores
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        //prints final score for each player
        System.out.println("\n" + player1.getName() + "'s score: " + player1Score);
        System.out.println(player2.getName() + "'s score: " + player2Score);
        
        
        if (player1Score > player2Score) { //determine the winner or a draw
            System.out.println("\t" + player1.getName() + " WINS!");
        } else if (player2Score > player1Score) {
            System.out.println("\t" + player2.getName() + " WINS!");
        } else {
            System.out.println("\tIt's a draw!");
        }
    }
}
