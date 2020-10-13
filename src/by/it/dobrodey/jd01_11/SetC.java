package by.it.dobrodey.jd01_11;
/*
TaskC. Свой SetC. Напишите класс SetC<T>, который реализует toString()как в HashSet и 8 методов add(T e),
remove(Object o), contains(Object o),  size(), isEmpty(), addAll(List<?> c),
containsAll(Collection<?> c), removeAll(Collection<?> c) интерфейса Set<T> (реализация остальных –фиктивная).
 */

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[0];
    private int size = 0;


    @Override
    public String toString() {

        StringBuilder h = new StringBuilder();
        h.append("[ ");
        String delimiter = "";
        if(size>0){
        for (int i = 0; i < size; i++) {
            h.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }}
        h.append("]");
        return h.toString();
    }


    @Override
    public boolean add(T t) {
        if(!contains(t)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = t;
            return true;}

        return false;
    }


    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i]==o){
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        Object[] element = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            contains(element[i]);

        }
        return true;
        }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);}

    return false;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if(contains(o)){remove(o);}

        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {

        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for (T t : elements) {if(t==o){return true;}

        }
        return false;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements,0);
        size=0;

    }
// not reals
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}

