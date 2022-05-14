/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

public class CircularLinkedList<T> {

    Node<T> current;
    int size = 0;

    public CircularLinkedList() {
        current = null;
    }


    public void insertAfterCurrent(T data) {
        Node<T> newNode = new Node<>(data);
        if (current == null) {
            current = newNode;
            current.next = current;
            current.previous = current;
        } else {
            newNode.previous = current;
            newNode.next = current.next;
            current.next.previous = newNode;
            current.next = newNode;
            current = newNode;
        }
        size++;
    }


    // if there is no letter in the word, delete node from circular linked list
//    public T deleteCurrent(int index){
//        Node<T> temp = current;
//        if (current == null){
//            return null;
//        }
//        for (int i = 0; i < index; i++) {
//            current = current.next;
//        }
//        Node<T> deleted = current;
//        current.previous.next = current.next;
//        current.next.previous = current.previous;
//        current = current.next;
//        size--;
//        current = temp;
//        return deleted.data;
//    }
//


        public T deleteCurrent(int index){
            if (current == null){
                return null;
            }
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current = current.next;
            size--;
            return current.data;
    }





        public T goXTimes(int random){
        Node<T> temp = current;
        for (int i = 0; i < random; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void print() {
        Node<T> tmp = this.current;
        int tempSize = size;
        while (tempSize != 0) {
            if (tmp.data != null)
                System.out.print(tmp.data + " --> ");
            tmp = tmp.next;
            tempSize--;
        }
        System.out.println();
    }
}
