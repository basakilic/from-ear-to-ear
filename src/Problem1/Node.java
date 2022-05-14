/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

public class Node<T> {

    Node<T> previous;
    Node<T> next;
    T data;

    public Node(T data){
        this.data = data;
        next = null;
        previous = null;
    }

    public String toString(){
        return data.toString();
    }
}
