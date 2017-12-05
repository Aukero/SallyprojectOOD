import java.util.*;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
/**
 *  CardCollection.java
 * 
 *  A CardCollection is a group of Poker card with constraints
 *  on the number of card it can contain. CardCollection encapsulates
 *  access to groups of cards.
 */
public class CardCollection
{
    /**
     * Collection of card 
     */
    protected ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * minimum number of cards in this collection
     */
    protected int minCard=0;


    /**
     * maximum number of cards in this collection
     */
    protected int maxCard=52;

    /**
     * Constructor sets the min and max to something other than
     * the default.
     * @param  min      minimum number of cards allowed
     * @param  max      maximum number of cards allowed
     */
    public CardCollection(int min, int max)
    {
	minCard = min;
	maxCard = max;
    }
    
    public void sortCard()
    {
        Collections.sort(this.cards, new Comparator<Card>(){
            public int compare(Card c1, Card c2) 
            {
                return c2.getCardOrder() - c1.getCardOrder();
            }
        });
    } 
    /**
     * Print all the cards in the collection
     */
    public void printCard()
    {
	 for(int i = 0;i < cards.size();i++)
        {
        System.out.println(""+cards.get(i).getCardLetter() + " " +cards.get(i).getCardSuit());
        }
    }


    /**
     * Return the maximum number of cards
     * @return  max number of cards
     */
    public int getMaxCard()
    {
	return maxCard;
    }

    /**
     * Return the minimum number of cards
     * @return  min number of cards
     */
    public int getMinCard()
    {
	return minCard;
    }


    /**
     * Return the current number of tiles
     * @return  current size of the tiles collection
     */
    public int getCardCount()
    {
	return cards.size();
    }

    /**
     * Add a card to the collection, preserving the constraints
     * @param newcard   Card to add
     * @return true if successful, false if would violate the max constraint
     *         returns false if tile already in the set as well
     */
    public boolean addCards(Card newcard)
    {
	if (cards.size() == maxCard)
	{
	    return false;
	}
	else
	{
	    return cards.add(newcard);
	}
    }

    /**
     * Removes a card from the collection
     * @param card   Card to remove
     * @return true for success, false if tile not in the collection
     *         or if this would violate the minimum constraing
     */
    public boolean removeCard(Card card)
    {
	if (cards.contains(card))
	{
	    if ((cards.size() - 1) >=  minCard)
	    {
	        cards.remove(card);
	        return true;
	    }
	    else
	    {
		return false;
	    }
	}
	else
	{
	    return false;
	}
    }

    /**
     * Delete all Card in the collection 
     */
    public void clear()
    {
	cards.clear();
    }
    
    public int getorder(int card)
    {
        return cards.get(card).getCardOrder();
    }
    /**
     * Get the tile with the highest score 
     * Note this just gets a reference; it does not change the
     * contents of the collection
     * @return tile with highest score or null if collection is empty
     */
    /*public Card getHighest()
    {
	if (cards.isEmpty())
	    return null;
	else 
	    return cards.last();  /* treeset is in ascending order */
    //}

    /**
     * Get the tile with the lowest score 
     * Note this just gets a reference; it does not change the
     * contents of the collection
     * @return tile with highest score or null if collection is empty
     */
   /* public Card getLowest()
    {
	if (cards.isEmpty())
	    return null;
	else 
	    return cards.first();  /* treeset is in ascending order */
   // }

     /**
    * get the random card from card collection
    */
    public Card getRandom()
    {    
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(cards.size());
        Card random = cards.get(index);
        return random;
    }

    /**
     * Test driver main
     */
    /*public static void main(String args[])
    {
	int i;
	boolean result;
	TileCollection c = new TileCollection(0,7);
	Tile[] tileArray = new Tile[10];
	tileArray[0] = new Tile("A",1);
	tileArray[1] = new Tile("A",1);
	tileArray[2] = new Tile("Q",10);
	tileArray[3] = new Tile("T",1);
	tileArray[4] = new Tile("X",9);
	tileArray[5] = new Tile("B",2);
	tileArray[6] = new Tile("P",3);
	tileArray[7] = new Tile("E",1);
	tileArray[8] = new Tile("E",1);
	tileArray[9] = new Tile("U",1);
	for (i = 0; i < 10; i++)
	{
	    result = c.addTile(tileArray[i]);
	    System.out.println("Tried to add " + tileArray[i] + " result " +
			       result);
	}
	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getRandom();
	    System.out.println("Got random tile " + t);
	}

	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getLowest();
	    System.out.println("Got lowest " + t);
	    if (t != null)
	    {
		result = c.removeTile(t);
		System.out.println("removed result is " + result +
				   " current count is " + c.getTileCount());
	    }
	}
	for (i = 0; i < 4; i++)
        {
	    Tile t = c.getHighest();
	    System.out.println("Got highest " + t);
	    if (t != null)
	    {
		result = c.removeTile(t);
		System.out.println("removed result is " + result +
				   " current count is " + c.getTileCount());
	    }
	}

    }*/

}
