import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.net.URI;
public class main
{
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<Player> winners = new ArrayList<Player>();

    public static void main(String args[])
    {
        CardManager.initialize();
        Player player1 = new Player("1");
        player1.selectCard(5);
        Player player2 = new Player("2");
        player2.selectCard(5);
        Player player9 = new Player("3");
        player9.selectCard(5);
        Player player10 = new Player("4");
        player10.selectCard(5);
        Player player11 = new Player("5");
        player11.selectCard(5);
        Player player3 = new Player("6");
        Player player4 = new Player("7");

        Player player5 = new Player("8");
        Player player6 = new Player("9");

        Player player7 = new Player("10");
        Player player8 = new Player("11");

        Card a = new Card("A","diamond",13);
        Card b = new Card("K","heart",12);
        Card c = new Card("Q","diamond",11);
        Card d = new Card("J","heart",10);
        Card e = new Card("10","heart",9);
        Card f = new Card("9","heart",8);
        Card g = new Card("8","heart",7);
        Card h = new Card("7","heart",6);
        Card k = new Card("6","heart",5);
        Card l = new Card("5","heart",4);
        Card m = new Card("5","diamond",4);
        Card o = new Card("4","heart",3);

        player3.playerCard.addCards(a);
        player3.playerCard.addCards(a);
        player3.playerCard.addCards(b);
        player3.playerCard.addCards(f);
        player3.playerCard.addCards(o);

        player4.playerCard.addCards(a);
        player4.playerCard.addCards(a);
        player4.playerCard.addCards(b);
        player4.playerCard.addCards(f);
        player4.playerCard.addCards(o);

        player5.playerCard.addCards(a);
        player5.playerCard.addCards(a);
        player5.playerCard.addCards(f);
        player5.playerCard.addCards(h);
        player5.playerCard.addCards(m);

        player6.playerCard.addCards(b);
        player6.playerCard.addCards(b);
        player6.playerCard.addCards(b);
        player6.playerCard.addCards(b);
        player6.playerCard.addCards(h);

        player7.playerCard.addCards(b);
        player7.playerCard.addCards(c);
        player7.playerCard.addCards(d);
        player7.playerCard.addCards(e);
        player7.playerCard.addCards(g);

        player8.playerCard.addCards(b);
        player8.playerCard.addCards(c);
        player8.playerCard.addCards(d);
        player8.playerCard.addCards(e);
        player8.playerCard.addCards(h);


         players.add(player1);
         players.add(player2);

        //players.add(player3);
        //players.add(player4);
        players.add(player9);
        players.add(player10);
        players.add(player11);
        
        /*for(int i = 0;i<players.size();i++)
        {
           players.get(i).selectCard(5);
        }*/

        for(int i = 0; i<players.size(); i++)
        {
            players.get(i).playerCard.sortCard();
            players.get(i).printCard();
        }
        /*System.out.println("Hello "+players.get(0).playerCard.getorder(0));*/


        for(int i = 0; i<players.size(); i++)
        {
            players.get(i).patternOnhand();
        }

        int maxweight = -1;
        for(int i = 0; i<players.size(); i++)
        {
            if(players.get(i).getOnhandweight() > maxweight)
            {
                maxweight = players.get(i).getOnhandweight();
            }
        }
        System.out.println("weight : "+maxweight);
        for(int i = 0; i<players.size(); i++)
        {
            if(players.get(i).getOnhandweight() == maxweight)
            {
                winners.add(players.get(i));
            }
        }
        if(maxweight == 10 || maxweight == 5)//Straight flush , Straight fixed
        {
            int Startcard = -1;
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).playerCard.getorder(0) > Startcard)
                {
                    Startcard = winners.get(i).playerCard.getorder(0);
                }
            }
            for(int i = winners.size()-1; i >=0 ; i--)
            {
                if(winners.get(i).playerCard.getorder(0) < Startcard)
                {
                    winners.remove(i);
                }
            }
        }
        else if(maxweight == 8)//4 of kind fixed
        {
            int Startcard = -1;
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).playerCard.getorder(1) > Startcard)
                {
                    Startcard = winners.get(i).playerCard.getorder(1);
                }
            }
            for(int i = winners.size()-1; i >=0 ; i--)
            {
                if(winners.get(i).playerCard.getorder(1) < Startcard)
                {
                    winners.remove(i);
                }
            }
        }
        else if(maxweight == 7 || maxweight == 3)//Full house & 3 of kind fixed
        {
            //System.out.println("Before "+winners.size());
            int Startcard = 0;
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).playerCard.getorder(2) > Startcard)
                {
                    Startcard = winners.get(i).playerCard.getorder(2);
                }
            }
            for(int i = winners.size()-1; i >=0 ; i--)
            {
                if(winners.get(i).playerCard.getorder(2) < Startcard)
                {
                    winners.remove(i);
                }
            }
            //System.out.println("After "+winners.size());
        }
        else if(maxweight == 0 || maxweight == 6)//flush or nothing fixed
        {
            //System.out.println("Before "+winners.size());

            for(int i = 0; i<5; i++)
            {
                int card = -1;
                for(int j = winners.size()-1 ; j >=0; j--)
                {
                    if(winners.get(j).playerCard.getorder(i) > card)
                    {
                        card = winners.get(j).playerCard.getorder(i);
                        //System.out.println("card order : " +card);
                    }
                }
                for(int j = winners.size()-1 ; j >=0; j--)
                {
                    if(winners.get(j).playerCard.getorder(i) < card)
                    {
                        winners.remove(j);
                    }
                }
            }
            //System.out.println("After "+winners.size());
        }
        else if(maxweight == 2)//two pair fixed
        {
            int firstpair = -1;
            int secondpair = -1;
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).pair1 > firstpair)
                {
                    firstpair = winners.get(i).pair1;
                }
            }
            for(int i = winners.size()-1; i >=0 ; i--)
            {
                if(winners.get(i).pair1 < firstpair)
                {
                    winners.remove(i);
                }
            }
            if(winners.size()>1)
            {
                for(int i = 0; i < winners.size(); i++)
                {
                    if(winners.get(i).pair2 > secondpair)
                    {
                        secondpair = winners.get(i).pair2;
                    }
                }
                for(int i = winners.size()-1; i >=0 ; i--)
                {
                    if(winners.get(i).pair2 < secondpair)
                    {
                        winners.remove(i);
                    }
                }
                if(winners.size()>1)
                {
                    int lastcard = -1;
                    for(int i = 0; i<5; i++)
                    {
                        for(int j = 0; j < winners.size(); j++)
                        {
                            if(winners.get(j).playerCard.getorder(i) != firstpair && winners.get(j).playerCard.getorder(i) != secondpair)
                            {
                                if(winners.get(j).playerCard.getorder(i) > lastcard)
                                {
                                    lastcard = winners.get(j).playerCard.getorder(i);
                                }
                            }
                        }
                    }
                    for(int i = 0; i<5; i++)
                    {
                        for(int j = winners.size()-1; j >=0 ; j--)
                        {
                            if(winners.get(j).playerCard.getorder(i) != firstpair && winners.get(j).playerCard.getorder(i) != secondpair)
                            {
                                if(winners.get(j).playerCard.getorder(i) < lastcard)
                                {
                                    winners.remove(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        else if(maxweight == 1)//pair fixed
        {

            //System.out.println("Winner size before is : "+winners.size());

            int pair = -1;
            for(int i = 0; i < winners.size(); i++)
            {
                if(winners.get(i).getpair() > pair)
                {
                    pair = winners.get(i).getpair();
                }
            }
            for(int i = winners.size()-1; i >=0 ; i--)
            {
                if(winners.get(i).getpair() < pair)
                {
                    winners.remove(i);
                }
            }
            if(winners.size() > 1)
            {
                for(int i = 0;i<5;i++)
                {
                    int lastcard = -1;
                    for(int j = winners.size()-1; j >=0 ; j--)
                        {
                            if(winners.get(j).playerCard.getorder(i) != pair)
                            {
                                if(winners.get(j).playerCard.getorder(i) > lastcard)
                                {
                                    lastcard = winners.get(j).playerCard.getorder(i);
                                }
                            }
                        }
                    for(int j = winners.size()-1; j >=0 ; j--)
                        {
                            if(winners.get(j).playerCard.getorder(i) != pair)
                            {
                                if(winners.get(j).playerCard.getorder(i) < lastcard)
                                {
                                    winners.remove(j);
                                }
                            }
                        }
                }
            }
        }
        for (Player winner : winners) {
            System.out.println("Winner is : " + winner.getName());
        }
        /*player.printCard();
        player.patternOnhand();
        System.out.println(""+player.onHandStatus);*/
    }
}