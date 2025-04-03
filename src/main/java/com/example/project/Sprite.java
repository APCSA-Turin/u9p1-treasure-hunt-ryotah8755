package com.example.project;

public class Sprite {
    private int x, y;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setX(int newx){
        x = newx;
    }
    public void setY(int newy){
        y = newy;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "(" + x + "," + getY() + ")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        int col = x;
        int row = (size - y) - 1 ;
        return "["+row+"]["+col+"]";
    }

    public void setRow() { 

    }

    public void SetCol() { 
 
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
        if(direction.equals("w")) { 
            int temp = getY();
            temp++;
            setY(temp);
        }
        if(direction.equals("a")) { 
            int temp = getX();
            temp--;
            setX(temp);
        }
        if(direction.equals("s")) { 
            int temp = getY();
            temp--;
            setY(temp);
        }
        if(direction.equals("d")) { 
            int temp = getX();
            temp++;
            setX(temp);
            
        }
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
