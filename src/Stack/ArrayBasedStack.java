package Stack;

import java.util.ArrayList;

public class ArrayListStack<E> implements Stack<E>{
    private ArrayList<E> elements;

    public ArrayListStack(){
        elements = new ArrayList<>();
    }

    @Override
    public void push(E element){
        elements.add(element);
    }

    @Override
    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        int last = size() - 1;
        E res = elements.get(last);
        elements.remove(last);
        return res;
    }

    @Override
    public E top(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = elements.get(size() - 1);
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
