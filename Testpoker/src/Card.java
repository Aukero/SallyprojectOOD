
/**
 * Card.java
 *
 * A Card represents a single letter in Poker.
 *    Created by Sally Goldin, 2 October 2017
 */
public class Card
{
    /**
     * Static counter so we can create unique sequence numbers
     */
    //private static int counter = 0;

    /** Letter associated with this Card. */
    private String CardLetter = "";

    /**Suit of this card */
     private String CardSuit = "";
    
    /** Order of this card */
    private int CardOrder = 0;


    /** Sequence number so we can distinguish different instances of the
     *   same letter.
     */
    //private int sequence;


    /**
     * Constructor sets the Card letter suit and order.
     * @param  letter   card letter
     * @param  suit     card suit
     * @param  order    card order
     */
    public Card(String letter,String suit,int order)
    {
        CardLetter = letter;
        CardSuit = suit;
        CardOrder = order;
        //counter++;
        //sequence = counter;
    }
    /**
     * Getter for letter
     * @return card letter
     */
    public String getCardLetter()
    {
        return CardLetter;
    }
    /**
     * Getter for suit
     * @return card suit
     */
    public String getCardSuit()
    {
        return CardSuit;
    }
    /**
     * Getter for score
     * @return tile score
     */
    public int getCardOrder()
    {
        return CardOrder;
    }
    /**
     * Getter for sequence
     * @return sequence for this tile
     */
    /*public int getSequence()
    {
        return sequence;
    }*/

    /**
     * Override toString so we can easily print a tile
     * @return String to print
     */
    public String toString()
    {
        return new String(CardLetter + "(" + CardSuit + ")");
    }

    /**
     * Override equals() so we can distinguish different tiles with
     * the same letter.
     * @param otherTile   Tile we are checking
     * @return true if current instance equals otherTile else false
     */
    /*public boolean equals(Tile otherTile)
    {
        if ((otherTile.getTileLetter().compareTo(tileLetter) == 0) &&
                (otherTile.getSequence() == sequence) &&
                (otherTile.getTileValue() == tileValue))
            return true;
        else
            return false;
    }*/

}
