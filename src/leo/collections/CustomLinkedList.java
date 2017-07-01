package leo.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<T> implements List<T> {
    private class Node<T> {
        T element;
        Node<T> next;
    }

    private Node<T> first;
    private Node<T> last;
    private int count = 0;

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<>();
        node.element = t;
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        count++;
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first;
        for (int i = 0; current != null; i++, current = current.next) {
            if (i == index) {
                return current.element;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[count];
        Node<T> current = first;
        for (int i = 0; current != null; i++, current = current.next) {
            array[i] = current.element;
        }
        return array;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (T e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (first == null) {
            return false;
        }

        if (first.element.equals(o)) {
            if (last == first) {
                last = first.next;
            }
            first = first.next;
            count--;
            return true;
        }

        Node<T> current = first;
        while (current.next != null) {
            if (current.next.element.equals(o)) {
                if (last == current.next) {
                    last = current;
                }
                current.next = current.next.next;
                count--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int countBeforeLoop = count;
        for(Object e : c){
            remove(e);
        }
        return countBeforeLoop != count;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<T> current = first;

        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
