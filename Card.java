package week06WAR;

public class Card { //Card class to represent individual playing cards
	
	//instance variables
    private int value;
    private String name;

    
    //constructors
    public Card() {} //default constructor
    
    public Card(int value, String name) { //constructor with int and String parameters
        this.value = value;
        this.name = name;
    }

    //method
    public void describe() { //describe method to print card info
        System.out.println(name + " (Value: " + value + ")");
    }
    
    //setters & getters for value and name
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}