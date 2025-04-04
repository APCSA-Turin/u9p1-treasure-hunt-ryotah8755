package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        win = false;
    }
    //utility 
    public void incrementTreasureCount() { 
        treasureCount++;
    }

    public int getTreasureCount(){
        return treasureCount;
    }

    public int getLives(){
        return numLives;
    }

    public void incrementLives() { 
        numLives--;
    }


    public boolean getWin(){
        return win;
    }

    public void setWin(boolean status) { 
        win = status;
    }

  
    //move method should override parent class, sprite
    public void move(int gridSize, String direction) {
        if (isValid(gridSize, direction)) {
            super.move(direction);
        }
        
    }

    public boolean didInteract(Sprite obj) { //checks if the object and player collides 
        if(obj.getX() == getX()) { 
            if(obj.getY() == getY()){ 
                return true;
            }
        }
        return false;
    }

    public void interact(int size, String direction, int numTreasures, Object obj) {
        if (obj instanceof Trophy) {
            if (treasureCount == numTreasures) {
                setWin(true); // set player to win when they collect enough treasures and reach the trophy
            }
        } else if (obj instanceof Enemy) {
            incrementLives();
        } else if (obj instanceof Treasure) {
            incrementTreasureCount();
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        return super.isValid(size, direction);
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
   




