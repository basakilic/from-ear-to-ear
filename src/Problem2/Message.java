/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

public class Message {
    String message;

    public Message(String message){
        this.message = message;
    }

    public String toString(){
        return message;
    }

    public boolean checkContains(Name checkName){
        int count = 0;
        String tempName = checkName.name; // to make it short
        String lowerName = tempName.toLowerCase();
        String lowerMessage = message.toLowerCase();
        if (message.length() < 2){
            return false;
        }
        for (int i = 0; i < message.length() ; i++) {
            for (int j = 0; j < tempName.length() ; j++) {
                if(lowerMessage.charAt(i) == lowerName.charAt(j)){
                    count++;
                }
            }
        }
        return count >= 2;
    }
}