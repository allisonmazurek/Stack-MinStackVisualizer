public class MyStack {

    Node head;
    int size = 0;
    int min;
    int minStackSize = 0;
    MyStack minStack;

    public MyStack() {  //Implement a stack using a SLinkedList
    }


    public void push(int element){ //Add Element to the top of the stack. Equivalent to AddFirst() for Linked List
        if (head == null){
            head = new Node(element);
            if (this != minStack) size++;
            if (this != minStack) min(head.data);
        }
        else {
            Node temp = new Node(element);
            temp.next = head;
            head = temp;
            if (this != minStack) size++;
            if (this != minStack) min(temp.data);
        }
        if (this.equals(minStack))minStackSize++;
    }

    public void pop(){ //Remove element at the top of the stack. Equivalent to RemoveFirst() for Linked List
        if (size <= 0) throw new NullPointerException("Stack is Empty!");
        if (minStack.peek() == min){
            minStack.pop();
            minStackSize--;
        }
        head = head.next();
        size--;
    }

    public int peek(){ //Returns element at the top of the Stack --> the first element of the list
        return head.data;
    }

    public int min(int current){
       if (head == null) throw new NullPointerException("Stack is Empty!");
       if (size == 1){
           minStack = new MyStack();
           minStack.head = new Node(current);
           min = current;
           return minStack.peek();
       }
       if (current <= min){
           min = current;
           minStack.push(current);
       }
        return minStack.peek();
    }

    public String toString(){
        Node temp = head;
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        while (temp != null){
            builder.append(temp.data).append(" ");
            temp = temp.next;
        }
        return String.valueOf(builder);
    }

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

    int getData() {
        return data;
    }

}

