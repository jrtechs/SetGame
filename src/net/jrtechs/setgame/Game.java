/*
jeffery r
12-26-15
Game class keeps track of the score hand and deck
*/

package net.jrtechs.setgame;

import java.awt.Color;
import java.util.ArrayList;

public class Game 
{
    //properties
    private Deck deck;
    private Hand hand;
    private int sets;
    private int score;
    private int setsLeft;
    private int currentDisplay = 12;
    private int time;
    private int timeOnSet;
    
    //constructor
    Game()
    {
        deck = new Deck();
        deck.shuffle();
        hand = new Hand(deck.dealMany(12));
        setsLeft = hand.setsLeft();
        sets = 0;
        time = 0;
        score = 0;
        currentDisplay = 12;
        timeOnSet =  0;
    }
    public void timerTic()
    {        
        time++;
        timeOnSet++;
    }
    public Card[] getHand()
    {
        return hand.getHand();
    }
    public void clicked(SetButton[] cards)
    {
        ArrayList<Card> sel;
        sel = selected(cards);
        if(sel.size() == 3)
        {
            //there is a set selected
            if(Card.isSet(sel.get(0),sel.get(1), sel.get(2)))
            {
                sets++;
                //calculates score to be given baised on time took and cards on board
                if(currentDisplay ==12)
                {
                    int temp = 100 - timeOnSet;
                    if(temp > 0)
                    {
                        score +=temp;
                    }
                }
                score += 50; //base score
                timeOnSet = 0;
                Card[] remove = {sel.get(0),sel.get(1), sel.get(2)};
                if(deck.cardsLeft() > 2)
                {
                    hand.removePair(remove, deck);
                    if(currentDisplay > 12)
                    {
                        currentDisplay -= 3;
                        hand.resize(currentDisplay, deck);
                        for(int i = 12; i < 15; i ++)
                        {
                          cards[i].setVisible(false);
                        }
                    }
                    updateBoard(cards);
                }
                else
                {
                    for(SetButton elem : cards)
                    {
                      if(elem.getPressed())
                      {
                          hand.disableCard(elem.getCard());
                          elem.setEnabled(false);
                          elem.setBackground(Color.black);
                      }
                    }
                    
                }
                if(deck.cardsLeft() < 3)
                {
                    setsLeft = 0;
                }
                else
                {
                    setsLeft= hand.setsLeft();
                }
            }
            diselectCards(cards);
        }
    }
    public void openThree(SetButton[] cards)
    {
        if(currentDisplay == 12)
        {
            currentDisplay += 3;
            hand.resize(currentDisplay, deck);
            //hand.display();
            
            for(int i = 12; i < cards.length; i++)
            {
                cards[i].setVisible(true);
            }
            this.updateBoard(cards);
        }
        else
        {
            
        }
        
    }
    public void updateBoard(SetButton[] cards)
    {
        int count = 0;
        for(Card elem : hand.getHand())
        {
            if(count >= currentDisplay)
            {

            }
            else
            {
                cards[count].setCard(elem);
                count ++;
            }
        }
        for(SetButton elem : cards)
        {
            elem.update();
            elem.setBackground(Color.white);
            elem.setSelected(false);
            elem.setEnabled(true);
        }
    }
    public void findSet(SetButton[] cards)
    {
        Card[] set = hand.findSet();
        for(Card elem : set)
        {
            int loc = hand.location(elem);
            //row * (4) + col
            cards[loc].setBackground(Color.PINK);
        }
    }
    public int getTime()
    {
        return time;
    }
    public int getNumSets()
    {
        return sets;
    }
    public int getScore()
    {
        return score;
    }
    public int modScore(int change)
    {
        score +=change;
        return score;
    }
    public Deck getDeck()
    {
        return deck;
    }
    public int getSetsLeft()
    {
        setsLeft = hand.setsLeft();
        return setsLeft;
    }
    public void setScore(int newScore)
    {
        score = newScore;
    }
    private void diselectCards(SetButton[] cards)
    {
        for(SetButton elem : cards)
        {
            if(elem.getPressed())
            {
                elem.setBackground(Color.white);
                elem.setPressed(false);
            }
        }
    }
    private ArrayList<Card> selected(SetButton[] cards)
    {
        ArrayList<Card> selectedCards = new ArrayList<Card>(); 
        for(SetButton elem : cards)
        {
            if(elem.getPressed())
            {
                selectedCards.add(elem.getCard());
            }
        }
        return selectedCards;
    }
}
