package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy enemy;
    private Enemy enemy2;
    private Treasure treasure;
    private Treasure treasure2;
    private Trophy trophy;
    private int size; 
    private Scanner scanner = new Scanner(System.in);
    private int numTreasures;

    public Game(int size){ //the constructor should call initialize() and play()
        grid = new Grid(size);
        player = new Player(0, 0);
        enemy = new Enemy(5, 5);
        enemy2 = new Enemy(7,8);
        treasure = new Treasure(2, 2);
        treasure2 = new Treasure(1,7);
        trophy = new Trophy(9, 9);
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        boolean play = true;
        boolean over = false;
        int size = grid.getSize();
        while(play){

            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            grid.display();
            System.out.println("Enter move (w/a/s/d): "); //ask for input, and scan next line
            System.out.println("Treasures collected: "  + player.getTreasureCount());
            System.out.println("Lives remaining: " + player.getLives());
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            String move = scanner.nextLine();
            grid.clearSprite(player.getX(), player.getY()); //have to clear the previous location of the player before the X and Y values change         
            if (move.equals("exit")) { 
                break;
            }
            if(over) { 
                break;
            }  
            player.move(move);
            grid.placeSprite(player); //place the updated location on grid 
            grid.display();
            System.out.println("Enter move (w/a/s/d): "); 
            System.out.println("Treasures collected: "  + player.getTreasureCount());
            System.out.println("Lives remaining: " + player.getLives());
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            //for each interact, there are two for each, must account for both
            if(player.didInteract(treasure)) { 
                player.interact(size, move, player.getTreasureCount(), treasure);
            }
            else if(player.didInteract(treasure2)){ 
                player.interact(size, move, player.getTreasureCount(), treasure2);
            }
            else if(player.didInteract(enemy)) { 
                player.interact(size, move, 2, enemy);
                if(player.getLives() == 0) { 
                    over = true;
                }
            }
            else if(player.didInteract(enemy2)){  
                player.interact(size, move, 2, enemy2);
                if(player.getLives() == 0) { 
                    over = true;
                }
            }
             else if(player.didInteract(trophy)) { //check all of the posssibilites of the interactions
                player.interact(size, move, 2, trophy);
                if(player.getTreasureCount() == 2) { 
                    over = true;
                }
            }

        }  
            
        if(player.getLives() == 0)  { //when the game ends, has to check if the player won or lost
            grid.gameover();
        }
        else { 
            grid.win();
        }
    }

    public void initialize(){ //place everything down
        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
        
    }

    public static void main(String[] args) {
        new Game(10);
    }
}