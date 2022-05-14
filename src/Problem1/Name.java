/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

public class Name {
    String name;
    final String firstForm;

    public Name(String name){
        this.name = name;
        firstForm = name;
    }

    public void deleteLastLetter(){
        name = name.substring(0,name.length()-1);
    }


    public boolean isEmpty(){
        return name.isEmpty();
    }

    public String toString(){
        return name;
    }

    public String getFirstForm(){
        return firstForm;
    }
}
