package Codementor;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static Long[] getPrefixSumArray(Long[] A) {

        Long[] prefixSum = new Long[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        return prefixSum;
    }

    public static List<Long> arrayChallenge(List<Long> arr) {
        // Write your code here

        List<Long> ans = new ArrayList<>();

        Long[] intArray = new Long[arr.size()];
        intArray = arr.toArray(intArray);
        Long[] prefixSum = getPrefixSumArray(intArray);

        ans.add(0l);
        for (int i = 1; i < arr.size(); i++) {
            Long counter = 0l;
            counter += (arr.get(i) * i - (prefixSum[i-1]));
            ans.add(counter);
        }

        return ans;
    }
}
