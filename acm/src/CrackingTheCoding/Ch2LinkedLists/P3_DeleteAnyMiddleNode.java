package CrackingTheCoding.Ch2LinkedLists;

import java.util.Arrays;

public class P3_DeleteAnyMiddleNode {
    public static void main(String[] args) {
        SinglyList list = new SinglyList(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Node nthNodeFromFront = list.getNthNodeFromFront(5);
        list.remove(nthNodeFromFront);
        list.printAll();
    }
}
