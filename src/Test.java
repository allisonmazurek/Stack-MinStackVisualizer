public class Test {


    public static void main(String[] args){

        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println(myStack.toString());

        myStack.push(3);
        System.out.println(myStack.toString());


        myStack.push(7);
        System.out.println(myStack.toString());


        myStack.push(5);
        System.out.println(myStack.toString());

        myStack.push(367);
        System.out.println(myStack.toString());

        myStack.push(2);
        System.out.println(myStack.toString());


        myStack.push(3);
        System.out.println(myStack.toString());

        myStack.push(1);
        System.out.println(myStack.toString());

        myStack.pop();
        System.out.println(myStack.toString());

        myStack.pop();
        System.out.println(myStack.toString());

        myStack.pop();
        System.out.println(myStack.toString());


        myStack.pop();
        System.out.println(myStack.toString());


        myStack.pop();
        System.out.println(myStack.toString());

        myStack.pop();
        System.out.println(myStack.toString());

        myStack.pop();
        System.out.println(myStack.toString());

    }


}
