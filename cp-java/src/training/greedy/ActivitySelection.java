package training.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {

        var solution = new ActivitySelection();

        var start = new int[]{10, 12, 20};
        var finish = new int[]{20, 25, 30};
        solution.solve(start, finish);


        start = new int[]{1, 3, 0, 5, 8, 5};
        finish = new int[]{2, 4, 6, 7, 9, 9};
        solution.solve(start, finish);
    }

    void solve(int[] start, int[] finish) {

        var ar = getTasks(start, finish);
        ar.sort(Comparator.comparingInt(task -> task.endTime));

        System.out.print("Activity: " + 0 + ", ");
        var lastFinish = ar.get(0).endTime;

        for (int i = 1; i < ar.size(); i++) {
            if (ar.get(i).startTime >= lastFinish) {
                lastFinish = ar.get(i).endTime;
                System.out.print(i + ", ");
            }
        }

        System.out.println();
    }

    private ArrayList<Task> getTasks(int[] start, int[] finish) {
        var ar = new ArrayList<Task>();
        for (int i = 0; i < finish.length; i++) {
            ar.add(new Task(start[i], finish[i]));
        }
        return ar;
    }

    static class Task {
        int startTime, endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
