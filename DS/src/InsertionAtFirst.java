import java.io.*;
import java.util.LinkedList;

public class InsertionAtFirst
{
    public static void main(String args[])
    {

        LinkedList<String> list = new LinkedList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println("LinkedList:" + list);

        list.addFirst("0");

        System.out.println("Final LinkedList:" + list);
    }
}