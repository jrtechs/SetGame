package net.jrtechs.setgame;

import java.awt.Color;
import javax.swing.JButton;

public class SetButton extends JButton
{
    private boolean pressed;
    private Card card;
    private int loc;
    SetButton()
    {
        pressed = false;
    }
    SetButton(int x)
    {
        pressed = false;
        loc = x;
    }
    public void clicked()
    {
        if(pressed)
        {
            pressed = false;
            this.setBackground(Color.WHITE);
        }
        else
        {
            this.setBackground(Color.gray);
            pressed = true;
        }
        
    }
    public void update()
    {
        if(card != null)
        {
            //sets the image of the button baised on its properties
            //images located in the /src folder, file are named as a 4 digit number
            //each digit represents a property of the image(shape, number, color, shading)
            String src = "/net/jrtechs/setgame/img/" + card.getShape() + card.getNumber() + card.getColor() + card.getShading() + ".png";
            //this.setText(card.toString());
            this.setIcon(new javax.swing.ImageIcon(getClass().getResource(src)));
        }
    }
    public Card getCard()
    {
        return card;
    }
    public void setCard(Card newCard)
    {
        card = newCard;
    }
    public int getLoc()
    {
        return loc;
    }
    public boolean getPressed()
    {
        return pressed;
    }
    public void setPressed(boolean sel)
    {
        pressed = sel;
    }
}