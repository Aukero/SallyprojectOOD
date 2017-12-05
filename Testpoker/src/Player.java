/**
 * Player.java
 *
 * This class represents a single player in the Poker game.
 * Currently this class is incomplete. All it can do is draw random
 * card.
 *
 */
public class Player
{

    /**
     * The player's tiles for making words
     */
    protected CardCollection playerCard = new CardCollection(0,5);

    /* each player has a maximum of 7 tiles at any one time */

    /**
     * Player's name
     */
    private String name;

    /**
     * Player's current balance
     */
    private double balance = 1000;

    /**
    * Player's bet balance in the game
    */
    private double betbalance = 0;

    /**
    * Player card on hand status
    */

    /**
    * Player on hand weight
    */
    private int onhandweight = 0;

    /**
    * Player status
    */
    private boolean status;

    /**
    * Score of the card on hand
    */
    private int score = 0;

    public int pair1 = 0;

    public int pair2 = 0;

    private int pair = 0;

    /**
     * Contructor sets the name
     * @param playerName   Name of this player
     */
    public Player(String playerName)
    {
        name = playerName;
    }

    public int getOnhandweight()
    {
        return onhandweight;
    }
    /**
    * Return the name
    * @return player's name
    */
    public String getName()
    {
        return name;
    }

    /**
     * Return the score
     * @return player's score
     */
    public int getScore()
    {
        return score;
    }

    public int getpair()
    {
        return pair;
    }
    /**
     * Select tiles randomly from the TileManager
     * @param  howMany  How many tiles to select
     * @return true if successful, false if error
     *         Error could involve there are not enough tiles
     *            left, or the user asking for too many tiles
     */
    public boolean selectCard(int howMany)
    {
        boolean bOk = true;
        if ((playerCard.getCardCount() + howMany) > playerCard.getMaxCard())
        {
            System.out.println("Error - Too many tiles requested");
            bOk = false;
        }
        else
        {
            int i = 0;
            Card card = null;
            for (i = 0; (i < howMany) && bOk; i++)
            {
                card = CardManager.selectRandomCard();
                if (card == null)
                    bOk = false;
                else
                    bOk = playerCard.addCards(card);
            }
        }
        return bOk;
    }

    /**
     * Print the tiles the player currently holds
     */
    public void printCard()
    {
        System.out.println("Card for Player " + name);
        playerCard.printCard();
    }

    /**
    *   Check Straight on hand
    */
    public int checkStraight()
    {
        int i = 0;
        int countcheck = 0;
        for(i = 1; i<=4; i++)
        {
            if(playerCard.cards.get(i-1).getCardOrder() - playerCard.cards.get(i).getCardOrder() == 1)
            {
                countcheck++;
            }
        }
        if(countcheck == 4)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
    *   Check flush on hand
    */
    public int checkflush()
    {
        int i = 0;
        int check = 0;
        String firstsuit = playerCard.cards.get(0).getCardSuit();
        for(i = 1; i<=4; i++)
        {
            if(playerCard.cards.get(i).getCardSuit() == firstsuit)
            {
                check++;
            }
        }
        if(check == 4)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    /**
    *   Check fullhouse
    */
    public int checkfullhouse()
    {
        int countnumcard = 0;
        int countnumcard2 = 0;
        int i = 0;
        int j = 0;
        for(i = 1; i<=4; i++)
        {
            if(playerCard.cards.get(i-1).getCardOrder() == playerCard.cards.get(i).getCardOrder())
            {
                countnumcard++;
            }
            else
            {

                break;
            }
        }
        if(countnumcard > 0)
        {
            for(j = i; j<=4; j++)
            {
                if(playerCard.cards.get(j-1).getCardOrder() == playerCard.cards.get(j).getCardOrder())
                {
                    countnumcard2++;
                }

            }
        }
        if(countnumcard == 2 && countnumcard2 == 1)
        {
            return 1;
        }
        else if(countnumcard == 1 && countnumcard2 == 2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
    *   Check card on hand
    */
    public int checknofkind()
    {
        int i = 0;
        int countnumcard = 0;
        int sameorder = 0;
        for(i = 1; i<=4; i++)
        {
            if(countnumcard == 0)
            {
                if(playerCard.cards.get(i-1).getCardOrder() == playerCard.cards.get(i).getCardOrder())
                {
                    sameorder = playerCard.cards.get(i).getCardOrder();
                    pair = sameorder;
                    countnumcard++;
                }
            }
            else
            {
                //System.out.println("Hello");
                if(playerCard.cards.get(i).getCardOrder() == sameorder)
                {
                    countnumcard++;
                }
            }


        }
        return countnumcard;
    }

    /**
    *   Check two pair
    */
    public int checktwopair()
    {
        int i = 0;
        int j = 0;
        int sameorder = 0;
        int sameorder2 = 0;
        int countnumcard = 0;
        int countnumcard2 = 0;
        for(i = 1; i<=4; i++)
        {
            if(countnumcard == 0)
            {
                if(playerCard.cards.get(i-1).getCardOrder() == playerCard.cards.get(i).getCardOrder())
                {

                    sameorder = playerCard.cards.get(i).getCardOrder();
                    countnumcard++;
                }
            }
            else
            {
                if(playerCard.cards.get(i).getCardOrder() == sameorder)
                {
                    countnumcard++;
                }
                else
                {
                    break;
                }
            }
        }
        if(countnumcard > 0)
        {
            for(j = i; j<=4; j++)
            {
                if(countnumcard2 == 0)
                {
                    if(playerCard.cards.get(j-1).getCardOrder() == playerCard.cards.get(j).getCardOrder())
                    {
                        sameorder2 = playerCard.cards.get(j).getCardOrder();
                        countnumcard2++;
                    }
                }
                else
                {
                    if(playerCard.cards.get(j).getCardOrder() == sameorder2)
                    {
                        countnumcard2++;
                    }
                }
            }
        }
        if(countnumcard == 1 && countnumcard2 == 1)
        {
            pair1 = sameorder;
            pair2 = sameorder2;
            return 1;
        }
        else
        {
            return 0;
        }
    }

    /**
    *   Check lowStraight
    */
    public int checklowStraight()
    {
        int i = 0;
        int countcheck = 0;
        for(i = 2; i<=4; i++)
        {
            if(playerCard.cards.get(i-1).getCardOrder() - playerCard.cards.get(i).getCardOrder() == 1)
            {
                countcheck++;
            }
        }
        if(countcheck == 3)
        {
            if(playerCard.cards.get(0).getCardOrder() == 13)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
    /**
    * Check pattern of the card on player hand
    */
    public void patternOnhand()
    {
        int straight = 0;
        int flush = 0;
        int fullhouse = 0;
        int Nkind = 0;
        int lowstraight = 0;
        int twopair = 0;
        straight = checkStraight();
        flush = checkflush();
        fullhouse = checkfullhouse();
        Nkind = checknofkind();
        //System.out.println(""+Nkind);
        lowstraight = checklowStraight();
        twopair = checktwopair();
        if(straight == 1 && flush == 1)
        {
            onhandweight = 10;
        }
        else if(lowstraight == 1 && flush == 1)
        {
            onhandweight = 9;
        }
        else if(Nkind+1 == 4)
        {
            onhandweight = 8;
        }
        else if(fullhouse == 1)
        {
            onhandweight = 7;
        }
        else if(flush == 1)
        {
            onhandweight = 6;
        }
        else if(straight == 1)
        {
            onhandweight = 5;
        }
        else if(lowstraight == 1)
        {
            onhandweight = 4;
        }
        else if(Nkind+1 == 3)
        {
            onhandweight = 3;
        }
        else if(twopair == 1)
        {
            onhandweight = 2;
        }
        else if(Nkind+1 == 2)
        {
            onhandweight = 1;
        }
        else
        {
            onhandweight = 0;
        }
    
    }

}
