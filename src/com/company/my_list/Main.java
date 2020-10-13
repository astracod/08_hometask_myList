package com.company.my_list;


import java.util.Iterator;

public class Main {


    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println("<-------------------------| Изначальный список : |--------------------------->");
        list.addListItem(10);
        list.addListItem(20);
        list.addListItem(30);
        list.addListItem(40);

        for (Integer elem : list) {
            System.out.println(elem);
        }
        System.out.println("<-------------------------| Удаление элемента : |---------------------------->");
        list.remoteElem(3);
        for (Integer elem : list) {
            System.out.println(elem);
        }
        System.out.println("<----------------| Добавление элемента после удаления : |-------------------->");
        list.addListItem(50);
        for (Integer elem : list) {
            System.out.println(elem);
        }

        System.out.println("<-----------------| Добавление элемента по индексу : |----------------------->");
        list.addByIndex(60, 4);
        for (Integer elem : list) {
            System.out.println(elem);
        }

        System.out.println("<-----------------| Обратный вывод : |----------------------->");
        Iterator iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("<-------------| Замена значения по индексу : |---------------->");
        list.replaceValueByIndex(40,8);
        for (Integer elem : list){
            System.out.println(elem);
        }
    }
}
