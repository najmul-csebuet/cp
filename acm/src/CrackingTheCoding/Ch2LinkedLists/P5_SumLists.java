package CrackingTheCoding.Ch2LinkedLists;

import java.util.Arrays;

public class P5_SumLists {

    public static void main(String[] args) {

        SinglyList first = new SinglyList(Arrays.asList(0,2));
        SinglyList second = new SinglyList(Arrays.asList(0,0,0,5,5));

        SinglyList result = first.sumListsAndGetResult(second);

        result.printAll();

        SinglyList reverse = first.getReversed();
        reverse.printAll();
    }
}
