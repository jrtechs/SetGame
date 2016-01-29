package net.jrtechs.setgame;

public class Card 
{
    //color,number, shape, shading
    private final int number; //0,1,2
    private final int color; //0-red,1-blue,2-green
    private final int shape; //0-square,1-triangle,2-circle
    private final int shading; //0-solid, 1-striped, 2-clear
    private boolean inUse = true;
    //constructor
    Card(int num, int col, int shap, int shad)
    {
        number = num;
        color = col;
        shape = shap;
        shading = shad;
    }
    public int getNumber()
    {
        return number;
    }
    public int getColor()
    {
        return color;
    }
    public int getShape()
    {
        return shape;
    }
    public int getShading()
    {
        return shading;
    }
    public boolean getInUse()
    {
        return inUse;
    }
    public void setInUse(boolean change)
    {
        inUse = change;
    }
    public String toString()
    {
        String dis = new String();
        switch(number)
        {
            case 0: dis = "1";
                        break;
            case 1: dis = "2";
                        break;
            case 2: dis = "3";
        }
        switch(color)
        {
            case 0: dis += " red";
                        break;
            case 1: dis += " blue";
                        break;
            case 2: dis += " green";
        }
         switch(shape)
        {
            case 0: dis += " square";
                        break;
            case 1: dis += " triangle";
                        break;
            case 2: dis += " circle";
        }
        switch(shading)
        {
            case 0: dis += " solid";
                        break;
            case 1: dis += " striped";
                        break;
            case 2: dis += " clear";
        }
                   
        return dis;
    }
    public boolean equals(Card check)
    {
        if(check.shape == this.shape && check.color == this.color && check.number == this.number && check.shading == this.shading)
        {
            return true;
        }
        return false;
    }
    public static boolean equals(Card one, Card two, Card three)
    {
        if(one.equals(two) || one.equals(three) || two.equals(three))
        {
            return false;
        }
        return true;
    }
    //compares the colors of three cards
    public static boolean compare_color(Card one, Card two, Card three)
    {
        if(one.color == two.color && one.color == three.color)
        {
            return true;
        }
        else if(one.color != two.color && one.color != three.color && two.color != three.color)
        {
            return true;
        }
        return false;
    }
    //compares the number of three cards
    public static boolean compare_number(Card one, Card two, Card three)
    {
        if(one.number == two.number && one.number == three.number)
        {
            return true;
        }
        else if(one.number != two.number && one.number != three.number && two.number != three.number)
        {
            return true;
        }
        return false;
    }
    //compares the shading of the three cards
    public static boolean compare_shading(Card one, Card two, Card three)
    {
        if(one.shading == two.shading && one.shading == three.shading)
        {
            return true;
        }
        else if(one.shading != two.shading && one.shading != three.shading && two.shading != three.shading)
        {
            return true;
        }
        return false;
    }
    //checks to see if three cards have the same shale
    public static boolean compare_shape(Card one, Card two, Card three)
    {
        if(one.shape == two.shape && one.shape == three.shape)
        {
            return true;
        }
        else if(one.shape != two.shape && one.shape != three.shape && two.shape != three.shape)
        {
            return true;
        }
        return false;
    }
    //checks to see if three cards are a set
    public static boolean isSet(Card one, Card two, Card three)
    {
        if(Card.compare_color(one, two, three) && Card.compare_number(one, two, three) && Card.compare_shading(one, two, three) && Card.compare_shape(one, two, three))
        {
            return true;
        }
        return false;
    }
}
