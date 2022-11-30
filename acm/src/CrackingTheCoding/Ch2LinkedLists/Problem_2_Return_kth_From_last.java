package CrackingTheCoding.Ch2LinkedLists;

import java.util.Arrays;

public class Problem_2_Return_kth_From_last {

    public static void main(String[] args) {

        SinglyList list = new SinglyList(Arrays.asList(5,6,7,8,9,10,11,12,13));

        Node a;

        a = list.getNthNodeFromFront(1);
        a = list.getNthNodeFromFront(9);
        a = list.getNthNodeFromFront(10);

        a = list.getNthNodeFromBack(1);
        a = list.getNthNodeFromBack(9);
        a = list.getNthNodeFromBack(10);

        System.out.println();
    }
}
