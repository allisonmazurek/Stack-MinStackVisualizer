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
            size++;
            min(head.data);
        }
        else {
            Node temp = new Node(element);
            temp.next = head;
            head = temp;
            size++;
            min(temp.data);
        }
    }

    public void pop(){ //Remove element at the top of the stack. Equivalent to RemoveFirst() for Linked List
        if (minStackSize > 0 && minStack.peek() == peek()){
            minStack.head = minStack.head.next();
            min = minStack.peek();
            minStackSize--;
        }
        //order of these two if statements matter

        if (size <= 0) throw new NullPointerException("Stack is Empty!");
        head = head.next();
        size--;
    }

    public int peek(){ //Returns element at the top of the Stack --> the first element of the list
        if (head == null) throw new NullPointerException("Stack is Empty!");
        return head.data;
    }

    public int min(int current){
       if (head == null) throw new NullPointerException("Stack is Empty!");
       if (size == 1){
           minStack = new MyStack();
           min = current;
           minStack.head = new Node(min); //i didn't use a push here because the size index of the minStack would not increase using a (if this.equals(minStack) minStackSize++)
           minStackSize++;
           return minStack.peek();
       }
       if (current <= min){
           min = current;
           Node temp = new Node(min);
           temp.next = minStack.head;
           minStack.head = temp;
           minStackSize++;
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

    public String getMinStack(){
        Node temp = minStack.head;
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        while (temp != null){
            builder.append(temp.data).append(" ");
            temp = temp.next;
        }
        return String.valueOf(builder);
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

