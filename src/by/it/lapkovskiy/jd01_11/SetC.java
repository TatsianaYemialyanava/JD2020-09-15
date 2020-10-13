package by.it.lapkovskiy.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[0];

    private int size = 0;

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
        for (int i = 0; i < size; i++) {
            if(elements[i]!=null?elements[i].equals(o):elements[i]==o) return true;
        }
        return false;
    }

    @Override
    public boolean add(T e) {
        if(contains(e)) return true;
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        int index = 0;
        if(e!=null)
        for (int i = 0; i < size; i++) {
            if(elements[i]!=null)
            if(e.hashCode()>elements[i].hashCode()) index = i+1;
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if(elements[i]!=null?elements[i].equals(o):elements[i]==o) index = i;
        }
        if(index == -1) return false;
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (T e : (Collection<T>) c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        for (T element: c) {
            add(element);
        }
        return true;

    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for (T element:(Collection<T>) c) {
            try{
                remove(element);
            }
            catch (Exception e)
            {
                System.out.println("rem()"+e.toString());
            }
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            if(elements[i]!=null)
            out.append(delimiter).append(elements[i]);
            else out.append(delimiter).append("null");
            delimiter = ", ";
        }
        out.append("]");
        return out.toString();
    }
    @Override
    public void clear()
    {
        elements = (T[]) new Object[0];
        size = 0;
    }
    //----------------------------------------------------------
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
}
