public class CardFileReader extends TextFileReader
{
    /**
    * Read file from the text file and create Card
    * then add to the Card collection
    */
    public CardCollection readCard()
    {
        CardCollection deck = new CardCollection(0,52);
        String line;
        do
	    {
	        line = getNextLine();
	        
	        if (line != null)
	        {   
	            String fields[] = line.split(" "); 
		        Card currentcard = new Card(fields[0],fields[1],Integer.parseInt(fields[2]));
		        //System.out.println(currentcard.toString());
		        deck.addCards(currentcard);
	        }	        	        
	    } 
	    while (line != null);
	    return deck;
    }
 
}
