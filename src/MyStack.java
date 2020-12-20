import RuntimeTester.*;

import java.util.Date;
import java.util.Random;

/*
Presentation exercise 2
        Implement a stack data structure that in addition to the push() and pop() operations,
        also has a method min() which returns the minimum element in the stack. All three methods (pop(), push(), min())
        should run in O(1), that is their running time should be independent of the number of elements in the stack.
        Please note that you can decide to implement this data structure however you want, you can call this new type MyStack.
*/



public class MyStack {

    Node head; //Only head needed. We are creating a Stack. No need to have information about the last element.
    int size = 0;
    int min;
    int minStackSize = 0;
    MyStack minStack;
    //Create a STACK to keep track of all minimum elements in the list as we add Nodes to the Stack in real time.
    //This allows to get the MINIMUM int in the list in O(1) time. NO NEED TO TRAVERSE THE LIST

    @benchmark(name = "Stack", expectedEfficiency = "O(1)", category = "Java Builtin")
    public static long arraysSort(long size) {
        MyStack stack = new MyStack();
        Random ran = new Random();

        for (long i = 0; i < size; i++) {
            stack.push(ran.nextInt());
        }

        long startTime = System.nanoTime();       //This indicates when the timer on the method starts
        stack.push(ran.nextInt());
        long endTime = System.nanoTime();         //This indicates where the timer on the method ends
        return endTime - startTime;
    }

    public MyStack() {  //Implement a stack using a SLinkedList
    }


    public void push(int element){ //Add Element to the top of the stack. Equivalent to AddFirst() for Linked List
        if (head == null){
            head = new Node(element); //If head is null, create Node Object and set element of Node
            size++;
            min(head.data);
        }

        else {
            Node temp = new Node(element);
            temp.next = head;                   //TEMP -> HEAD -> REST OF LIST
            head = temp;
            size++;
            min(temp.data);
        }
    }


    public void pop(){ //Remove element at the top of the stack. Equivalent to RemoveFirst() for Linked List

        if (minStackSize > 0 && minStack.peek() == this.peek()){ //when you remove an element in the STACK, adjust the minSTACK accordingly
            minStack.head = minStack.head.next(); //assign head of minStack to next element in list
            min = minStack.peek(); //Don't forget to reassign the min value.
            minStackSize--;
        }

        //order of these two if statements matter!!

        if (size <= 0) throw new NullPointerException("Stack is Empty!"); //Cannot remove an element if the list is empty
        head = head.next(); //assign head to next element
        size--;
    }

    public int peek(){ //Returns element at the top of the Stack --> the first element of the list
        if (head == null) throw new NullPointerException("Stack is Empty!");
        return head.data;
    }

    public int min(int current){
       if (head == null) throw new NullPointerException("Stack is Empty!");
       if (size == 1){
           minStack = new MyStack(); //initialize a minStack as a MyStack Object;
           min = current; //First element added to the stack, at one point, is always a minimum element in the list.
           minStack.head = new Node(min); //i didn't use a push here because the size index of the minStack would not increase using a (if this.equals(minStack) minStackSize++)
           minStackSize++;
           return minStack.peek();
       }
       if (current <= min){ //NEED THE = here. Otherwise repetition of ints will not be accounted for in the minStack
           min = current;
           Node temp = new Node(min); //add new minimum element to the stack. TODO: WHY DON'T WE USE PUSH() HERE?? BECAUSE STACK OVERFLOW.
           temp.next = minStack.head;
           minStack.head = temp;
           minStackSize++;
       }
        return minStack.peek();
    }

    public String toString(){
        Node temp1 = head;
        StringBuilder builder1 = new StringBuilder();
        builder1.append(" ");
        while (temp1 != null){
            builder1.append(temp1.data).append(" ");
            temp1 = temp1.next;
        }

        Node temp2 = minStack.head;
        StringBuilder builder2 = new StringBuilder();
        builder2.append(" ");
        while (temp2 != null){
            builder2.append(temp2.data).append(" ");
            temp2 = temp2.next;
        }

        return "STACK: " + String.valueOf(builder1) + "\nMINIMUM STACK: " + String.valueOf(builder2) + "\nMIMIMUM: " + this.min + "\n" ;
    }


///////////////FOR VISUALIZER ONLY//////////////////////////
    public int[] getStackArray(){
        Node temp = head;
        int[] array = new int[size];
        int i = 0;
        while (temp != null){
            array[i] = temp.data;
            temp = temp.next;
            i++;
        }
        return array;
    }

    public int[] getMinStackArray(){
        Node temp = minStack.head;
        int[] array = new int[minStackSize];
        int i = 0;
        while (temp != null){
            array[i] = temp.data;
            temp = temp.next;
            i++;
        }
        return array;
    }
//////////////////////////////////////////////////////////////


}

class Node {

    Node next;
    int data;

    Node(int s) {
        data = s;
    }

    Node next() {
        return next;
    }

}

