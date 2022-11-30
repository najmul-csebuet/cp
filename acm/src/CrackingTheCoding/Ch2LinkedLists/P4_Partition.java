package CrackingTheCoding.Ch2LinkedLists;

import java.util.Arrays;

public class P4_Partition {
    public static void main(String[] args) {
        SinglyList list = new SinglyList(Arrays.asList(3,5,8,5,10,2,1));
        SinglyList list1 = list.partitionBy(5);
        list1.printAll();
    }
}
