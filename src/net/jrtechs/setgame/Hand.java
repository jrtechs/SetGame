package net.jrtechs.setgame;

public class Hand 
{
    private Card[] hand;

    Hand(Card[] temp)
    {
        hand= temp;
    }
    public void resize(int newSize, Deck deckT)
    {
        
        Card[] transfer = new Card[newSize];
        int count = 0;
        for(Card c: hand)
        {
            if(c != null)
            {
                transfer[count] = c;
                count++;
            }
        }
        for(int i = count; i < newSize; i++)
        {
            transfer[i] = deckT.deal();
        }
        hand = transfer;
    }
    public Card getCard(int e)
    {
        return hand[e];
    }
    public void display()
    {

        for(Card elem : hand)
             System.out.print(elem + "  ");
        System.out.println("");
    }
    public Card[] getHand()
    {
        return hand;
    }
    public Card[] findSet()
    {
        Card[] match = new Card[3];
        //checks each possible combination of three on the hand to find a set
        for(Card one: hand)
            for(Card two: hand)
                for(Card three : hand)
                    if(Card.isSet(one, two, three) && Card.equals(one, two, three))
                        if(one.getInUse() && two.getInUse() && three.getInUse())
                        {
                            match[0] = one;
                            match[1] = two;
                            match[2] = three;
                            return match;
                        }
        return match;

    }
    public int setsLeft()
    {
        int count = 0;
        for(Card one: hand)
            for(Card two: hand)
                for(Card three : hand)
                    if(Card.isSet(one, two, three) && Card.equals(one, two, three))
                        if(one.getInUse() && two.getInUse() && three.getInUse())
                            count++;

        //gets rid of all permutations
        return count/6;
    }
    public int location(Card find)
    {
        for(int i = 0; i < hand.length; i++)
        {
            if(hand[i] == null)
            {
                
            }
            else if(find.equals(hand[i]))
            {
                return i;
            }
        }
        return -1;
    }
    public void removePair(Card[] remove, Deck deckT)
    {
        if(deckT.cardsLeft() < 2)
        {
            //not enough cards in deck to replace w/ new cards
            
            for(Card c : remove)
            {
                hand[this.location(c)] = null;
            }
        }
        else if(hand.length > 12)
        {
            for(Card c : remove)
            {
                hand[location(c)] = null;
            }
            //condense the deck
            this.resize(hand.length -3, deckT);
        }
        else
        {
            //removes a set and replaces it with new cards
            int i = 0;
            Card[] replace = deckT.dealMany(remove.length);
            for(Card c : remove)
            {
                hand[this.location(c)] = replace[i];
                i++;
            }
        }
        
    }
    public void disableCard(Card c)
    {
        hand[this.location(c)].setInUse(false);
    }
}
