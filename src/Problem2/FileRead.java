/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FileRead <T> {
    
    public FileRead(){
    
    }

    public void readNamesFromFile(DoublyLinkedList<Name> names) throws FileNotFoundException {
        File text = new File("names.txt");
        Scanner input = new Scanner(text);
        final int players = 30;
        boolean isRepeated;
        int[] indexOfNames = new int[players]; // create an array for random players' indexes
        for (int i = 0; i < players; ) {
            isRepeated = false;
            int random = (int) (Math.random() * players); //23
            for (int j = 0; j < i; j++) {
                if (indexOfNames[j] == random) { // namelerin indexi ile // nameler ile atanan randomı // atanan random hub
                    isRepeated = true;
                    break;
                }
            }
            if (!isRepeated) { // if isRepeated is not true, and repeating numbers
                indexOfNames[i] = random;
                i++; // a random number (index) added to array
            }
        }

        LinkedList<Name> tempAllNames = new LinkedList<>(); //read all names from the file and add them to a temp linked list
        while (input.hasNextLine()) {
            tempAllNames.add(new Name(input.nextLine()));
        }

        for (int i = 0; i < players; i++) {
            names.insertLast(tempAllNames.get(indexOfNames[i])); //take the names (the index numbers in array) from tempAllNames to names
//            System.out.println(tempAllNames.get(indexOfNames[i])); see from file
        }

        input.close();

    }


    public void chooseHubStudents(int k, DoublyLinkedList<Name> names) {
        boolean isRepeated;
        String [] hubNames = new String[k];
        for (int i = 0; i < k; ) {
            isRepeated = false;
            int random = (int) (Math.random() * 30); //23
            for (int j = 0; j < i; j++) {
                if (hubNames[j].equals(names.get(random).name)) {
                    isRepeated = true;
                    break;
                }
            }
                if (!isRepeated) { // if isRepeated is not true, and repeating numbers
                    hubNames[i] = names.get(random).signAsHub();
                    String newName = hubNames[i];
                    // bu hubları bi sekilde isaretle
                    i++; // a random number (index) added to array
                    names.get(random).name = names.get(random).signAsHub();
                }
            }
                    System.out.println(Arrays.toString(hubNames));

        names.print();
    }

     // create an array for random players' indexes
/*

 int random = (int) (Math.random() * players); //23
        for (int j = 0; j < i; j++) {
            if (indexOfNames[j] == random) {
                isRepeated = true;
                break;
            }
        }
        if (!isRepeated) { // if isRepeated is not true, and repeating numbers
            indexOfNames[i] = random;
            i++; // a random number (index) added to array
        }
    }

 */

    public boolean checkContains(Name nm, String hn){
        String tempNm = nm.name; // to make it short
        int count = 0;
        String lowerNm = tempNm.toLowerCase();
        String lowerHn = hn.toLowerCase();
        if (hn.length() < 2){
            return false;
        }
        for (int i = 0; i < hn.length() ; i++) {
            for (int j = 0; j < tempNm.length() ; j++) {
                if(lowerHn.charAt(i) == lowerNm.charAt(j)){
                    count++;
                }
            }
        }
        return count >= 4;
    }
}
//
//
//        boolean isRepeated;
//        int[] indexOfHubStudent = new int[k]; // create an array for random players' indexes
//        for (int i = 0; i < k; ) {
//            isRepeated = false;
//            int random = (int) (Math.random() * 30); //23
//            for (int j = 0; j < i; j++) {
//                if (indexOfHubStudent[j] == random) {
//                    isRepeated = true;
//                    break;
//                }
//            }
//            if (!isRepeated) { // if isRepeated is not true, and repeating numbers
//                indexOfHubStudent[i] = random;
//                i++; // a random number (index) added to array
//            }
//            System.out.print("*");
//        }
//
//    }
//}
//
