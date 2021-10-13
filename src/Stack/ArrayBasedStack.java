package Stack;

import java.util.ArrayList;

public class ArrayListStack<E> implements Stack<E>{
    private ArrayList<E> elements;
    private int topOfStack;

    public ArrayListStack(){
        elements = new ArrayList<>();
        topOfStack = - 1; //The first position will be 0
    }

    @Override
    public void push(E element){
        elements.add(element);
        topOfStack++;
    }

    @Override
    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = elements.get(topOfStack);
        elements.remove(topOfStack);
        topOfStack--;
        return res;
    }

    @Override
    public E top(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = elements.get(topOfStack);
        return res;
    }

    @Override
    public int size(){
        return elements.size();
    }

    @Override
    public boolean isEmpty(){
        return elements.isEmpty();
    }
}
