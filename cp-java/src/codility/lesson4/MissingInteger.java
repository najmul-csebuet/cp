package codility.lesson4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class MissingInteger {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new MissingInteger();

        l.add(s.solution(new int[]{1, 3, 6, 4, 1, 2}) == 5);
        l.add(s.solution(new int[]{1, 2, 3}) == 4);
        l.add(s.solution(new int[]{-1, -3}) == 1);
        l.add(s.solution(new int[]{100}) == 1);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{ }));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] A) {

        /*
        // 100% Passed
        Arrays.sort(A);
        int a = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < 1) continue;
            if (A[i] == A[i + 1]) continue;
            if (A[i] == a) {
                ++a;
                continue;
            }
            break;
        }
        int last = A[A.length - 1];
        if(a < last) return a;
        if(last < 1) return 1;
        return last + 1;*/


        // 100% Passed

        int[] sorted = Arrays.stream(A).filter(a -> a > 0).distinct().sorted().toArray();
        int ans = 1;
        for (int a : sorted) {
            if (ans != a) break;
            ans++;
        }
        return ans;

        /*
        // 90% Passed, 1 large input failed.
        var list = new ArrayList<Integer>();
        for (int a : A) {
            if (a > 0) {
                list.add(a);
            }
        }

        if (list.isEmpty()) {
            return 1;
        }

        List<Integer> collect = list.stream().distinct().sorted(Comparator.comparingInt(a -> a)).collect(Collectors.toList());
        int ans = 1;
        for (int a : collect) {
            if (ans != a) return ans;
            ans++;
        }
        return ans;*/
    }
}