import java.io.*;
import java.util.LinkedList;

public class ShallowList {

    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("First Linked List:" + list);

        LinkedList shallow_list = new LinkedList();
        shallow_list = (LinkedList) list.clone();

        System.out.println("Second Linked List is:" + shallow_list);
    }
}