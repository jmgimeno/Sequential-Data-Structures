package Stack;

import java.util.ArrayList;

public class ArrayBasedStack<E> implements BaseStack<E>{
    private ArrayList<E> stackArray;
    private int topOfStack;

    public ArrayBasedStack(){
        stackArray = new ArrayList<>();
        topOfStack = - 1; //The first position will be 0
    }

    @Override
    public void push(E element){
        stackArray.add(element);
        topOfStack++;
    }

    @Override
    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = stackArray.get(topOfStack);
        stackArray.remove(topOfStack);
        topOfStack--;
        return res;
    }

    @Override
    public E top(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = stackArray.get(topOfStack);
        return res;
    }

    @Override
    public int size(){
        return stackArray.size();
    }

    @Override
    public boolean isEmpty(){
        return stackArray.isEmpty();
    }
}
