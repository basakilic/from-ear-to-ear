/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public final static int MAX_PLAYERS = 80;
    public static CircularLinkedList<Name> names;

    public static void main(String[] args) throws FileNotFoundException {
        intro();
    }

    public static void intro() throws FileNotFoundException {
        System.out.println("-------------------------\n"
                + "Welcome to Name Game !\n"
                + "------------------------- \n"
                + "In our name game played with as many people as you want (maximum " + MAX_PLAYERS + " people)\n"
                + "The last letter of the name, corresponding to the randomly assigned number, is deleted.\n"
                + "The person whose name does not contain any letters is eliminated.\n"
                + "The last person in the table is winner.");
        menu();
    }

    public static void menu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------\n"
                + "-> Choose 1 to start game.\n"
                + "-> Choose 2 to restart game.\n"
                + "-> Choose 3 to quit game.");

        int option = input.nextInt();

        while (true) {
            if (option == 3) {
                System.out.println("You choose to quit, GOODBYE.");
                break;
            }
            if (option == 1) {
                System.out.println("You choose to start 1, please press to continue");
                // start the game
                startGame();

                menu();
                break;
            } else if (option == 2) {
                startGame();
                System.out.println("You choose to restart 2");
                // restart the game
                menu();
                break;
            } else {
                System.out.println("Invalid option! Please enter a valid option :(");
                option = input.nextInt();
            }
        }
    }


    public static void startGame() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int players;
        do {
            System.out.print("Enter the number of players: ");
            players = scan.nextInt();
        } while (players > MAX_PLAYERS);
        readFile(players);

        while (names.size != 1) { // will return until 1 player left
            scan.nextLine();
            deleteLastLetter();
        }
        System.out.println("End of the game, winner is " + names.current.data.firstForm.toUpperCase());
        names.deleteCurrent(0);
    }


    public static void readFile(int players) throws FileNotFoundException {
        names =  new CircularLinkedList<>();
        File text = new File("names.txt");
        Scanner input = new Scanner(text);

        boolean isRepeated;
        int[] indexOfNames = new int[players];
        for (int i = 0; i < players; ) {
            isRepeated = true;

            int random = (int) (Math.random() * MAX_PLAYERS);
            for (int j = 0; j < i; j++) {
                if (indexOfNames[j] == random) {
                    isRepeated = false;
                    break;
                }
            }
            if (isRepeated) { // if isRepeated is true, and repeating numbers
                indexOfNames[i] = random;
                i++;
            }
        }

        LinkedList<Name> tempAllNames = new LinkedList<>(); //read all names> from the file and add them to a temp linked list
        while (input.hasNextLine()) {
            tempAllNames.add(new Name(input.nextLine()));
        }

        for (int i = 0; i < players; i++) {
            names.insertAfterCurrent(tempAllNames.get(indexOfNames[i]));
//            System.out.println(tempAllNames.get(indexOfNames[i])); see from file
        }
        input.close();
        names.print();
    }



    public static void deleteLastLetter() {
        int random = (int) (Math.random() * names.size);
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("Generated random number: " + random + "    |||   Number of players:" + names.size + "    |||    " + "Randomly chosen player is: " + names.goXTimes(random).firstForm);
        names.goXTimes(random).deleteLastLetter();
        if (names.goXTimes(random).isEmpty()) { // if there is no letter in the name, remove this name from circular linked list
             names.deleteCurrent(random);
        }
        names.print();
    }
}