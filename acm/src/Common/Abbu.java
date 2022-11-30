package Common;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.out;

public class Abbu {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        Abbu s = new Abbu();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new int[]{}) == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public double solution(int[] A) {

        double[][] input = {
                {19.5, 14, 1},
                {9, 5, 1},
                {23, 6.5, 1},
                {16, 2.5, 1},
                {14, 13.5, 1},
                {6.5, 5, 1},
                {14, 13.5, 1},
                {14, 6.5, 0},
                {14, 10, 1},
                {10, 6.5, 1},
                {14, 2.5, 0},
                {10, 1, 0}};

        double cost = 0;
        double totalArea = 0;
        double perUnitCost = 12.0;

        for (double[] items : input) {

            double base = items[0] * items[1];
            double side = items[2] * 2 * (items[0] + items[1]);
            double area = base + side;
            totalArea += area;
            cost = cost + area * perUnitCost;
        }

        out.println("Total area: " + totalArea);
        out.println(cost);

        return cost;
    }
}