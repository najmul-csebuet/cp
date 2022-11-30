package training.greedy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class TaskWithDeadlines {

    public static void main(String[] args) throws IOException {
        var l = new ArrayList<Boolean>();
        var s = new TaskWithDeadlines();

        l.add(s.solution(new int[]{4, 3, 2, 4}, new int[]{2, 5, 7, 5}) == -10);

        // for array compare
        // l.add(Arrays.equals(s.solution(), new int[]{));

        // for list compare
        // l.add(s.solution().equals(List.of(1, 2, 3.0)));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++)
            if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int solution(int[] duration, int[] deadline) {
        var l = new ArrayList<Task>();
        for (int i = 0; i < duration.length; i++) {
            l.add(new Task(duration[i], deadline[i]));
        }
        l.sort(Comparator.comparingInt(t -> t.duration));
        int points = 0;
        int lastFinish = 0;
        for (var t : l) {
            lastFinish = lastFinish + t.duration;
            points += (t.deadline - lastFinish);
        }
        return points;
    }

    static class Task {
        int duration, deadline;

        public Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }
}