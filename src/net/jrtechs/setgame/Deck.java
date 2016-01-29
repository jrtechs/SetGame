package net.jrtechs.setgame;

import java.util.ArrayList;

public class Deck 
{
    private ArrayList<Card> deck;
    
    //constructor
    Deck()
    {
        deck=new ArrayList<Card>(81);
        //color,number, shape, shading
        for(int c = 0; c < 3; c++)
            for(int n = 0; n < 3; n++)
                for(int s = 0; s < 3; s++)
                    for(int sa = 0; sa < 3; sa++)
                        deck.add(new Card(c,n,s,sa));
    }
    public void shuffle()
    {
	int elem1, elem2;
	for (int i=0; i<300; i++)
	{
            elem1=(int)(Math.random()*deck.size());
            elem2=(int)(Math.random()*deck.size());	
            Card temp=deck.get(elem1);
            deck.set(elem1, deck.get(elem2));
            deck.set(elem2, temp);
	}
    }
    public void display()
    {
        System.out.println(deck.size());
        for(int i = 0; i < deck.size(); i++)
        {
            System.out.println(deck.get(i));
        }
        
    }
    public Card[] dealMany(int num)
    {
	Card[] temp=new Card[num];
	for (int i=0; i<num; i++)
	{
            temp[i]=deck.remove(0);
	}	
	return temp;
    }
    public Card deal()
    {
        return deck.remove(0);
    }
    public int cardsLeft()
    {
        return deck.size();
    }
}
