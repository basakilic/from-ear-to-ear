/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

public class DoubleNode<T> {

    DoubleNode<T> next;
    DoubleNode<T> previous;
    T data;

    public DoubleNode(T data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public String toString() {
        return data.toString();
    }
}