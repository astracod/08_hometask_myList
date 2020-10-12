package com.company.my_list;


import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>, DescendingIterator<T> {

    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private int len = 0;


    /**
     * Метод добавления элемента списка
     *
     * @param value
     */
    public void addListItem(T value) {
        ListItem<T> elem = new ListItem<>(value);
        len++;
        if (head == null) {
            head = tail = elem;
        } else {
            tail.setNext(elem);
            elem.prev = tail;
            tail = elem;
        }
    }

    /**
     * Метод добавления элемента по индексу
     */

    public void addByIndex(T value, int index) {
        ListItem<T> elem = head;
        int c = 0;

        while (elem != null && c != index) {
            elem = elem.getNext();
            c++;
        }
        ListItem<T> current = new ListItem<>(value);
        if (c == 0) {
            head.setPrev(current);
            current.setNext(head);
            head = current;
        } else if (c == len - 1) {
            tail.setNext(current);
            current.setPrev(tail);
            tail = current;
        } else {
            elem.getPrev().setNext(current);
            current.setPrev(elem.getPrev());
            elem.setPrev(current);
            current.setNext(elem);
        }
    }

    /**
     * Метод удаления элемента списка
     *
     * @param index
     */
    public void remoteElem(int index) {
        ListItem<T> current = head;
        for (int i = 0; i <= index && current != null; i++, current = current.getNext()) {
            if (index == 0) head = current.getNext();
            if (i == index - 1) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    tail = current;
                }
            }
        }
    }

    /**
     * Метод изьятия отдельного элемента списка
     *
     * @param index
     * @return
     */
    public T getElem(int index) {
        ListItem<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return current.getValue();
    }

    public int size() {
        return len;
    }


    /**
     * класс-обект List
     *
     * @param <T>
     */
    private static class ListItem<T> {
        private T value;
        private ListItem<T> next = null;
        private ListItem<T> prev = null;


        public ListItem(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }


        public ListItem getNext() {
            return next;
        }

        public void setNext(ListItem<T> next) {
            this.next = next;
        }


        public ListItem getPrev() {
            return prev;
        }

        public void setPrev(ListItem<T> prev) {
            this.prev = prev;
        }
    }

    /**
     * класс реализующий Iterator<T> для использования в переопределенном методе iterator() , интерфейса Iterable
     *
     * @param <T>
     */
    private static class ListIterator<T> implements Iterator<T> {

        private ListItem<T> current;

        public ListIterator(ListItem<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            ListItem<T> elem = current;
            current = current.getNext();
            return elem.getValue();
        }
    }


    /**
     * переопределенный метод iterator() , интерфейса Iterable
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    /**
     * класс реализации обратного вывода
     *
     * @param <T>
     */
    private static class ListDescendingIterator<T> implements Iterator<T> {

        private ListItem<T> current;

        public ListDescendingIterator(ListItem<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            ListItem<T> elem = current;
            current = current.getPrev();
            return elem.getValue();
        }
    }

    /**
     * метод обратного вывода
     *
     * @return
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new ListDescendingIterator<>(tail);
    }

}


