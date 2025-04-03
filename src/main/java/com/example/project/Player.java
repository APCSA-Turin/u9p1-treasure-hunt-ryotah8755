package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 1;
        win = false;
    }


    public int getTreasureCount(){
        return treasureCount;
    }

    public int getLives(){
        return numLives;
    }

    public boolean getWin(){
        return win;
    }

  
    //move method should override parent class, sprite
    @Override
    public void move(String direction) { 
        super.move(direction);
    }

    public boolean didInteract(Sprite obj) { //checks if the object and player collides 
        if(obj.getX() == getX()) { 
            if(obj.getY() == getY()){ 
                return true;
            }
        }
        return false;
    }

    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        if (obj instanceof Treasure) { //if statement to differentiate between interacting with each object type
            treasureCount++; //increment
        } else if (obj instanceof Enemy) {
            numLives--; 
        } else if (obj instanceof Trophy) {
            if (treasureCount == numTreasures) {   
            }
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        return false;
    }

    @Override
    public String toString() {
        return "🦄";
    }
    
    public String getCoords() { 
        return "Player:" + super.getCoords();
    }


    public String getRowCol(int size) { 
        return "Player:" + super.getRowCol(size);
    }
}
   




