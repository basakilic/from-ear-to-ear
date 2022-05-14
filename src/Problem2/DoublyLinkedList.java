/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;
public class DoublyLinkedList<T> {
    DoubleNode<T> first;
    DoubleNode<T> last;
    int size;

    public DoublyLinkedList(){
    first = null;
    last = null;
    size = 0;
    }
    public boolean isEmpty(){
        return size ==0;
    }

    void insertLast(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    public void print() {
        DoubleNode<T> tmp = this.first;
        while (tmp != null) {
            System.out.print(tmp.data+" <-> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T get(int random){
        DoubleNode<T> temp = first;
        for (int i = 0; i < random; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public T search(T data){
        DoubleNode<T> tmp = first;
        System.out.println(tmp);
        System.out.println(data);
        while(tmp!=null){
            if(tmp.data == data){
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return null;
    }
}