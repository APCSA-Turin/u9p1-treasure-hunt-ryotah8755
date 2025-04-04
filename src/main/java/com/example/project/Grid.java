package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Dot(i, j); // Initialize with Dot objects
            }
        }
    }

    public Sprite getGridCord(int x, int y) { 
        int col = x;
        int row = (size - y) - 1 ;
       return grid[row][col]; 
    }
    public Sprite[][] getGrid(){
        return grid;
    }

    public int getSize() { 
        return size;
    }



    public void placeSprite(Sprite s){ //place sprite in new spot
        int x = s.getX();
        int y = s.getY();
        if (isValidPosition(x, y)) { //calls the valid method and checks if the sprite can be placed there
            grid[size - (y+1)][x] = s;
        }
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        int x = s.getX();
        int y = s.getY();
        //depending on the direction, place a dot 
        if(direction.equals("w")) { 
            grid[size - y][x] = new Dot(size - y,x);
        }
        if(direction.equals("a")) { 
            grid[size - y - 1][x + 1] = new Dot(size - y - 1,x + 1);
        }
        if(direction.equals("s")) { 
            grid[size - y - 2][x] = new Dot(size - y - 2,x);
        }
        if(direction.equals("d")) {    
            grid[size - y - 1][x - 1] = new Dot(size - y - 1,x - 1);    
        }

        if (isValidPosition(x, y)) { //calls the valid method and checks if the sprite can be placed there
            grid[size - (y+1)][x] = s;
        }
    }


    public void display() { 
        for (int i = 0; i < size; i++) { //loop thru all of the code and print each content of the grid out
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayResult(Player s) { 
        if(s.getWin() == false) { 
            gameover();
        }
        else { 
            win();
        }
    }
    
    public void gameover(){
        System.out.println("Game Over! You lost."); //use this method to display a loss
    }

    public void win(){ 
        System.out.println("You win!");//use this method to display a win 
    }

    public void clearSprite(int x, int y) { //used to clear sprites once interacted or after the player moves
        grid[size - (y+1)][x] = new Dot(x,y); 
    }

    private boolean isValidPosition(int x, int y) //used to regulate the movement of the player, to make sure no out of bounds
    {
        return x >= 0 && x < size && y >= 0 && y < size;
    }



}