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
        if(empty()){
            throw new IllegalStateException("Empty Stack");
        }
        int last = elements.size() - 1;
        E res = elements.get(last);
        elements.remove(last);
        return res;
    }

    @Override
    public E peek(){
        if(empty()){
            throw new IllegalStateException("Empty Stack");
        }
        E res = elements.get(elements.size() - 1);
        return res;
    }

    @Override
    public boolean empty(){
        return elements.isEmpty();
    }

    @Override
    public int search(Object o){
        int i = lastIndexOf(o);

        if(i >= 0) {
            return elements.size() - 1 - i;
        }
        return -1;
    }

    private int lastIndexOf(Object o){
        if (o == null) {
            for (int i = elements.size() - 1; i >=  0; i--) {
                if (elements.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = elements.size() - 1; i >=  0; i--) {
                if (o.equals(elements.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
}
