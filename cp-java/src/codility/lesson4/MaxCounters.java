package codility.lesson4;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class MaxCounters {

    public static void main(String[] args) {

        var l = new ArrayList<Boolean>();
        var s = new MaxCounters();

        // for array compare
        l.add(Arrays.equals(s.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}), new int[]{3, 2, 2, 4, 2}));
        l.add(Arrays.equals(s.solution(1, new int[]{2}), new int[]{0}));
        l.add(Arrays.equals(s.solution(1, new int[]{2, 1, 1, 2, 1}), new int[]{3}));
        l.add(Arrays.equals(s.solution(5, new int[]{6, 6, 6, 6, 6, 6}), new int[]{0, 0, 0, 0, 0}));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int[] solution(int N, int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        //var pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

        int base = 0;
        int maxLocal = 0;

        for (int a : A) {
            if (a <= N) {
                map.put(a - 1, map.getOrDefault(a - 1, 0) + 1);
                //ans[a - 1]++;
                maxLocal = Math.max(maxLocal, map.get(a - 1));
                //pq.add(ans[a - 1]);
            } else {
                // Max counter
                base += maxLocal;
                //base = pq.size() > 0 ? pq.poll() : 0;
                map = new HashMap<>();
                maxLocal = 0;
                //pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            }
        }

        var ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] += (base + map.getOrDefault(i, 0));
        }

        return ans;
    }
}