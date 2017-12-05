/**
 *  CardManager.java
 *
 *  This class represents the deck of poker game
 *
 *  All methods are static because this is a singleton class.
 *
 */
public class CardManager
{
    private static final String deckFileName = "Deck.txt";

    /**
     * collection of card in the deck
     */
    private static CardCollection deck = new CardCollection(0,52);

    /**
     * Set up all the card necessary for a new game
     * This could be done via reading from a file or
     * by hardcoding the data
     */
    public static void initialize()
    {
	deck.clear();  /* get rid of any old tiles */
	CardFileReader reader = new CardFileReader();
	if (!reader.open(deckFileName))
	{
	    System.out.println("Error opening tile file " + 
			       deckFileName + " in CardManager:initialize()");
	    System.exit(0);
	}
        deck = reader.readCard();
        reader.close();
    }

    /**
     * Get a random card from the deck and return it to the
     * user, deleting it from the collection.
     * @return random card or null if the deck is empty
     */
    public static Card selectRandomCard()
    {
	Card thecard = deck.getRandom();
	if (thecard != null)
	{
	    deck.removeCard(thecard);
	}
	return thecard;
    }

    /**
     * Get current number of cards in the deck
     * @return current size of tile collection
     */
    public static int getCardsRemaining()
    {
	return deck.getCardCount();
    }

    /** Main function for testing */
    /*public static void main(String args[])
    {
        TileManager.initialize();
	for (int i = 0; i < 5; i++)
	{
	    Tile t = selectRandomTile();
	    if (t != null)
		System.out.println("Selected " + t);
	}
	System.out.println(TileManager.getTilesRemaining() + " tiles remain in pool");
    }*/

}
