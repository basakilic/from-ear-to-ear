/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    // en az 4 harfli isimler olmak zorunda
    public static DoublyLinkedList<Name> names = new DoublyLinkedList<Name>();
    public static FileRead<Name> readNames = new FileRead<>(); // we created an object from FileRead to reach the method(readNamesFromFile),

    public static void main(String[] args) throws FileNotFoundException {
        intro();


//        Name name = new Name("ezgis");
//        Scanner scanner = new Scanner(System.in);
//       String input = scanner.next();
//        Message message = new Message("sSE");
//        if (message.checkContains(new Name("ayse"))) {
//             System.out.println("the message contains 2 or more letters of name");
//        } else
//            System.out.println("the message does not match with letters of name");
    }

    public static void intro() throws FileNotFoundException {
        System.out.println("-------------------------\n"
                + "Welcome to Message Transfer Game !\n"
                + "You can choose max 10 Hub Students \n"
                + "------------------------- \n");
        menu();
    }

    public static void menu() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------\n"
                + "-> Choose 1 to start game.\n"
                + "-> Choose 2 to restart game.\n"
                + "-> Choose 3 to quit game.\n");

        int option = input.nextInt();

        while (true) {
            if (option == 3) {

                System.out.println("You choose to quit, GOODBYE.");
                break;
            }
            if (option == 1) {

                System.out.println("You choose to start 1 ");
                // start the game
                startGame();
                String source = input.next();
                System.out.println(source);
                
                Name x = new Name(source);
                System.out.println(x);
                transferMessageRight(names.search(x),5);
                //
//                String sourceName = input.next();
//                Name sourceN = new Name(sourceName);
//                leftOrRight(sourceN, 5);

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
        // check and read hub students if the number of hub students is less than 10
        Scanner scan = new Scanner(System.in);
        int numOfHubStudent;

        do {
            System.out.println("Enter the number of Hub Student (less than 10)");
            numOfHubStudent = scan.nextInt();

        } while (numOfHubStudent > 10);

        try {
            readNames.readNamesFromFile(names);
            System.out.println("---------------------------------------");
            readNames.chooseHubStudents(numOfHubStudent, names);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void leftOrRight(Name source, int k) {
        int random = 1 + (int) (Math.random() * 2);
        System.out.println(random);
        if (random == 1) {
            transferMessageLeft(source, k);
        } else { //if random number is equal to 2
            transferMessageRight(source, k);
        }
    }

    public static void transferMessageLeft(Name source, int k){
       //temp=temp.previous;


    }

        public static void transferMessageRight(Name source, int k){
        Name x = names.first.data;
        names.first.data = names.search(source); 
      
        while(k==0){
            
            names.first.data = names.first.next.data;
                  x= names.first.next.data;
                  System.out.println(x);

                    
        k--;
        }
           System.out.println(x + ": first student");
           for (int i = 0; i < k ; i++) {
                
            }
            System.out.println(x);
           



    }
}


      


