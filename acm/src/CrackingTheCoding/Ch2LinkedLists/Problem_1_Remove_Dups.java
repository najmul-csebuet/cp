package CrackingTheCoding.Ch2LinkedLists;

import java.util.Arrays;
import java.util.List;

public class Problem_1_Remove_Dups {

    public static void main(String[] args) {

        removeDups(Arrays.asList(5,6,5,7));
        removeDups(Arrays.asList(1,2,2,3,2,3,4));
    }

    private static void removeDups(List<Integer> list) {

        SinglyList singlyList = new SinglyList(list);
        singlyList.removeDuplicates();
        singlyList.printAll();
    }
}
