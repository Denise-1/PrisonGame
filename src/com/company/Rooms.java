package com.company;

import java.util.Scanner;

// Creating our room class
public class Rooms {
    int roomNumber;

    // default constructor
    public Rooms() {
        roomNumber = 4;
    }

    // overloaded constructor
    Rooms(int newRoomNumber) {
        roomNumber = newRoomNumber;
    }

    // A get method to keep track of how many rooms are in the game
    public int getRoomNumber() {
        return roomNumber;
    }

    // Our first void method used to start the user
    public void welcomePage() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to Prison Breakout! Make the correct choices to escape the prison and gain your freedom!");
        // Giving the user the total number of rooms in the game
        System.out.println("You have a total of " + roomNumber + " rooms to go through to escape. Good Luck!");
        System.out.println("---------------------------------------------------------------------------------------------------");
        // Once this method finishes printing the user is taken to the cell room method
        this.cellRoom();
    }

    // Cell room method
    public void cellRoom() {
        int lives = 2; // creating an integer for live count, each room will have 2 lives.

        System.out.println("Lives: " + lives); // a print statement to make sure users know their current live count

        while (lives != 0) { // While loop to take user input to pick their choice
            Scanner cellInput = new Scanner(System.in);
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("CELL: ");
            System.out.println("1) There is a high window in your cell. [window]");
            System.out.println("2) Your cell door seems to be loose. [door]");
            System.out.println("3) There seems to be a weak wall in your cell. [wall]");
            System.out.println("---------------------------------------------------------------------------------");

            System.out.println("How do you wish to proceed? Enter one of the words to proceed " +
                    "\nwindow - door - wall: ");
            String user = cellInput.nextLine();
            // Using a swtich statement to print out different statements depending on the users choice.
            switch (user) {
                case "window":      // typing "window" will subtract 1 life
                    System.out.println("You use a chair to reach the window and " +
                            "discover that it’s a steel window and you slip.");
                    System.out.println("You lose a life, you have " + --lives + " lives");
                    break;
                case "door":        // correct option will make player move on
//                    escape = true;
                    System.out.println("Wow no heard you, you've made it into the hallway.");
                    this.hallway();     //moves player to hallway method
                    break;
                case "wall":    // typing "wall" will subtract 1 life
                    System.out.println("Your neighboring cellmate was using restroom and you faint from the smell.");
                    System.out.println("you lose a life, you have " + --lives + " lives.");
                    break;
                // Input validation so that if the user doesn't type one of the correct options they can try again.
                default:
                    System.out.println("Invalid input. Enter one of the choices.");
            }
        }
        // A loop to end the program by running the gameOver method if the user loses all their lives
        if (lives == 0) {     // when lives are 0 the while loop ends
            System.out.println("You have lost all your lives. You are dead.");
            this.gameOver();
        }
    }

    // Hallway method
    public void hallway() {
        int lives = 2;
        System.out.println("Lives: " + lives);
        while (lives != 0) {
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("HALLWAY: ");
            System.out.println("You escape from your cell and are greeted by a hallway.");
            System.out.println("You hear a guard approaching making his rounds.");

            Scanner scan = new Scanner(System.in);
            System.out.println("1) You can try to run away from the guard. [run]");
            System.out.println("2) There is a vent to your right that you can hide in. [vent]");
            System.out.println("3) You can fight the guard if you're man (or woman) enough to try. [fight]");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("How do you wish to proceed? Enter one of the words to proceed: \n" +
                    "run - vent - fight");
            String room2choice = scan.nextLine();
            // Using if and else if statements to determine user input and print appropriate output
            if (room2choice.equals("run")) {
                System.out.println("While avoiding the guard, you slip on a banana peel and are back to square one.");
                System.out.println("you lose a life, you have " + --lives + " lives.");
            } else if (room2choice.equals("vent")) {
                System.out.println("You manage to find a vent in the wall and escape without detection.");
                this.mysteryRoom();     //moves player to mystery room method
                break;
            } else if (room2choice.equals("fight")) {
                System.out.println("The guard spots you and hands you a knuckle sandwich then leaves you on the floor.");
                System.out.println("you lose a life, you have " + --lives + " lives.");
            } else {
                System.out.println("Invalid input. Enter one of the choices.");
            }
        }
        if (lives == 0) {
            System.out.println("You have lost all your lives. You are dead.");
            this.gameOver();
        }
    }

    // Mystery room method
    public void mysteryRoom() {
        int lives = 2;

        Scanner choiceInput = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("MYSTERY ROOM: ");
        System.out.println("You notice a sleeping guard next to the Warden's Office.");
        System.out.println("You see a Snickers bar sticking out of his shirt pocket,");
        System.out.println("You can attempt to steal the Snickers bar but you know it's a gamble or you can proceed " +
                "into the Warden's Office!");
        System.out.println("(Player can attempt to steal the Snickers bar to live or lose the game.) ");
        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("Willing to risk it? (yes/no)");
        String decision = choiceInput.nextLine();

        if (decision.equals("yes")) {

            int c = (int) Math.round(Math.random() * 1);
            // Depending on the random output the guard could wake up or could stay sleeping.
            if (c == 0) {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("You maliciously eat the Snickers bar.You proceed to sneak into the Warden's Office.");
                System.out.println("---------------------------------------------------------------------------------");
                this.wardensOffice();   //moves player to Warden's Office method

            } else {
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("The guard woke up and noticed you trying to steal his Snickers bar,");
                System.out.println("He proceeds to eat it in front of you and you die of disbelief.");
                System.out.println("You have lost all your lives. You are dead.");
                this.gameOver();
            }

        } else if (decision.equals("no")) {            // if player says no go to Warden method
            this.wardensOffice();
        } else {
            System.out.println("Invalid Input");
            this.mysteryRoom();
        }
    }

    // Warden Office method
    public void wardensOffice() {
        String wardenOffice;
        int lives = 2;

        while (lives != 0) {

            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("WARDEN'S OFFICE: ");
            System.out.println("When you enter the Warden's Office, you notice it is big and no one is inside" +
                    "\nexcept for a sleeping dog next to the desk in the middle of the room.");
            System.out.println("1) You can try to sneak past the dog. [sneak]");
            System.out.println("2) Throw the desk at the dog. [throw]");
            System.out.println("3) Throw something from warden's desk to distract dog. [distract]");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("How do you wish to proceed? Enter one of the words to proceed: \n" +
                    "sneak - throw - distract");

            String wardenOfficeOption = input.nextLine();

            switch (wardenOfficeOption) {
                case "sneak":
                    System.out.println("You are too loud, the dog wakes up and barks to attract Warden, game over! ");
                    lives -= 2;
                    break;
                case "throw":
                    System.out.println("The desk is bolted to the floor and the dog barks and attracts Warden, game over!");
                    lives -= 2;
                    break;
                case "distract":
                    System.out.println("You find a chew toy on the ground and throw it across the room." +
                            "\nThe dog wakes up to go play with the toy and you get the key from the desk. " +
                            "\nYou successfully escape! Good job you won!");
                    this.gameOver();
                    break;
                default:
                    System.out.println("Invalid input. Enter one of the choices.");
            }
        }
        if (lives == 0) {     // when lives are 0 the while loop ends
            System.out.println("You have lost all your lives. You are dead.");
            this.gameOver();
        }
    }

    // Finally, the code loops so that user's can play the game again to see other options.
    public void gameOver() {
        System.out.println("Thanks for Playing");
        this.welcomePage();
    }
}