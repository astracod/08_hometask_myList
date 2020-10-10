package com.company.my_list;


public class Main {




    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addListItem(10);
        list.addListItem(20);
        list.addListItem(30);
        list.addListItem(40);

        for (Integer elem : list) {
            System.out.println(elem);
        }
        System.out.println("<----------------------------------------------------->");
        list.remoteElem(3);

        for (Integer elem : list) {
            System.out.println(elem);
        }
        System.out.println("<----------------------------------------------------->");

        list.addListItem(50);

        for (Integer elem : list) {
            System.out.println(elem);
        }

    }
}
