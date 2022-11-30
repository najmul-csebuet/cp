package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P874 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P874 o = new P874();

        l.add(o.robotSim(new int[]{1, 2, -2, 5, -1, -2, -1, 8, 3, -1, 9, 4, -2, 3, 2, 4, 3, 9, 2, -1, -1, -2, 1, 3, -2, 4, 1, 4, -1, 1, 9, -1, -2, 5, -1, 5, 5, -2, 6, 6, 7, 7, 2, 8, 9, -1, 7, 4, 6, 9, 9, 9, -1, 5, 1, 3, 3, -1, 5, 9, 7, 4, 8, -1, -2, 1, 3, 2, 9, 3, -1, -2, 8, 8, 7, 5, -2, 6, 8, 4, 6, 2, 7, 2, -1, 7, -2, 3, 3, 2, -2, 6, 9, 8, 1, -2, -1, 1, 4, 7}, new int[][]{{-57, -58}, {-72, 91}, {-55, 35}, {-20, 29}, {51, 70}, {-61, 88}, {-62, 99}, {52, 17}, {-75, -32}, {91, -22}, {54, 33}, {-45, -59}, {47, -48}, {53, -98}, {-91, 83}, {81, 12}, {-34, -90}, {-79, -82}, {-15, -86}, {-24, 66}, {-35, 35}, {3, 31}, {87, 93}, {2, -19}, {87, -93}, {24, -10}, {84, -53}, {86, 87}, {-88, -18}, {-51, 89}, {96, 66}, {-77, -94}, {-39, -1}, {89, 51}, {-23, -72}, {27, 24}, {53, -80}, {52, -33}, {32, 4}, {78, -55}, {-25, 18}, {-23, 47}, {79, -5}, {-23, -22}, {14, -25}, {-11, 69}, {63, 36}, {35, -99}, {-24, 82}, {-29, -98}, {-50, -70}, {72, 95}, {80, 80}, {-68, -40}, {65, 70}, {-92, 78}, {-45, -63}, {1, 34}, {81, 50}, {14, 91}, {-77, -54}, {13, -88}, {24, 37}, {-12, 59}, {-48, -62}, {57, -22}, {-8, 85}, {48, 71}, {12, 1}, {-20, 36}, {-32, -14}, {39, 46}, {-41, 75}, {13, -23}, {98, 10}, {-88, 64}, {50, 37}, {-95, -32}, {46, -91}, {10, 79}, {-11, 43}, {-94, 98}, {79, 42}, {51, 71}, {4, -30}, {2, 74}, {4, 10}, {61, 98}, {57, 98}, {46, 43}, {-16, 72}, {53, -69}, {54, -96}, {22, 0}, {-7, 92}, {-69, 80}, {68, -73}, {-24, -92}, {-21, 82}, {32, -1}, {-6, 16}, {15, -29}, {70, -66}, {-85, 80}, {50, -3}, {6, 13}, {-30, -98}, {-30, 59}, {-67, 40}, {17, 72}, {79, 82}, {89, -100}, {2, 79}, {-95, -46}, {17, 68}, {-46, 81}, {-5, -57}, {7, 58}, {-42, 68}, {19, -95}, {-17, -76}, {81, -86}, {79, 78}, {-82, -67}, {6, 0}, {35, -16}, {98, 83}, {-81, 100}, {-11, 46}, {-21, -38}, {-30, -41}, {86, 18}, {-68, 6}, {80, 75}, {-96, -44}, {-19, 66}, {21, 84}, {-56, -64}, {39, -15}, {0, 45}, {-81, -54}, {-66, -93}, {-4, 2}, {-42, -67}, {-15, -33}, {1, -32}, {-74, -24}, {7, 18}, {-62, 84}, {19, 61}, {39, 79}, {60, -98}, {-76, 45}, {58, -98}, {33, 26}, {-74, -95}, {22, 30}, {-68, -62}, {-59, 4}, {-62, 35}, {-78, 80}, {-82, 54}, {-42, 81}, {56, -15}, {32, -19}, {34, 93}, {57, -100}, {-1, -87}, {68, -26}, {18, 86}, {-55, -19}, {-68, -99}, {-9, 47}, {24, 94}, {92, 97}, {5, 67}, {97, -71}, {63, -57}, {-52, -14}, {-86, -78}, {-17, 92}, {-61, -83}, {-84, -10}, {20, 13}, {-68, -47}, {7, 28}, {66, 89}, {-41, -17}, {-14, -46}, {-72, -91}, {4, 52}, {-17, -59}, {-85, -46}, {-94, -23}, {-48, -3}, {-64, -37}, {2, 26}, {76, 88}, {-8, -46}, {-19, -68}}) == 5140);

        l.add(o.robotSim(new int[]{-2, -1, -2, 3, 7}, new int[][]{{1, -3}, {2, -3}, {4, 0}, {-2, 5}, {-5, 2}, {0, 0}, {4, -4}, {-2, -5}, {-1, -2}, {0, 2}}) == 100);

        l.add(o.robotSim(new int[]{-2, -1, -2, 3, 7}, new int[][]{{1, -3}, {2, -3}, {4, 0}, {-2, 5}, {-5, 2}, {0, 0}, {4, -4}, {-2, -5}, {-1, -2}, {0, 2}}) == 100);

        //l.add(o.robotSim(new int[]{-2, 8, 3, 7, -1}, new int[][]{{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}}) == 0);

        l.add(o.robotSim(new int[]{7, -2, -2, 7, 5}, new int[][]{{-3, 2}, {-2, 1}, {0, 1}, {-2, 4}, {-1, 0}, {-2, -3}, {0, -3}, {4, 4}, {-3, 3},
                {2, 2}}) == 4);

        l.add(o.robotSim(new int[]{}, new int[][]{}) == 0);
        l.add(o.robotSim(new int[]{}, new int[][]{{2, 4}}) == 0);
        l.add(o.robotSim(new int[]{4, -1, 3}, new int[][]{}) == 25);
        l.add(o.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}) == 65);

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": " + l.get(i));
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        Map<Integer, ArrayList<Integer>> colBlocksMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> rowBlocksMap = new HashMap<>();

        createCache(obstacles, colBlocksMap, rowBlocksMap);
        sortCache(colBlocksMap);
        sortCache(rowBlocksMap);

        int currentAngle = 90;
        int currentX = 0;
        int currentY = 0;
        int xMultiplier = 0;
        int yMultiplier = 1;
        int res = 0;

        for (int command : commands) {

            if (command < 0) {
                currentAngle += (command == -1) ? -90 : 90;
                xMultiplier = (int) Math.cos(Math.toRadians(currentAngle));
                yMultiplier = (int) Math.sin(Math.toRadians(currentAngle));
                continue;
            }

            res = Math.max(res, currentX * currentX + currentY * currentY);

            if (xMultiplier != 0) {
                ArrayList<Integer> list = rowBlocksMap.getOrDefault(currentY, new ArrayList<>());
                int binarySearch = Collections.binarySearch(list, currentX);
                if (binarySearch >= 0) {
                    if (xMultiplier > 0) {
                        if (binarySearch == list.size() - 1) {
                            currentX += xMultiplier * command;
                            continue;
                        }
                        currentX += xMultiplier * Math.min(command, Math.abs(list.get(binarySearch + 1) - currentX - 1));
                    }
                    else {
                        if (binarySearch == 0) {
                            currentX += xMultiplier * command;
                            continue;
                        }
                        currentX += xMultiplier * Math.min(command, Math.abs(currentX - list.get(binarySearch - 1) - 1));
                    }
                    continue;
                }

                binarySearch = -binarySearch - 1;

                if (xMultiplier > 0) {
                    if (binarySearch == list.size()) {
                        currentX += xMultiplier * command;
                        continue;
                    }
                    currentX += xMultiplier * Math.min(command, Math.abs(list.get(binarySearch) - currentX - 1));
                } else {
                    if (binarySearch == 0) {
                        currentX += xMultiplier * command;
                        continue;
                    }
                    currentX += xMultiplier * Math.min(command, Math.abs(currentX - list.get(binarySearch - 1) - 1));
                }
                continue;
            }

            if (yMultiplier != 0) {
                ArrayList<Integer> list = colBlocksMap.getOrDefault(currentX, new ArrayList<>());
                int binarySearch = Collections.binarySearch(list, currentY);

                if (binarySearch >= 0) {
                    if (yMultiplier > 0) {
                        if (binarySearch == list.size() - 1) {
                            currentY += yMultiplier * command;
                            continue;
                        }
                        currentY += yMultiplier * Math.min(command, Math.abs(list.get(binarySearch + 1) - currentY - 1));
                    }
                    else {
                        if (binarySearch == 0) {
                            currentY += yMultiplier * command;
                            continue;
                        }
                        currentY += yMultiplier * Math.min(command, Math.abs(currentY - list.get(binarySearch - 1) - 1));
                    }
                    continue;
                }

                binarySearch = -binarySearch - 1;

                if (yMultiplier > 0) {
                    if (binarySearch == list.size()) {
                        currentY += yMultiplier * command;
                        continue;
                    }
                    currentY += yMultiplier * Math.min(command, Math.abs(list.get(binarySearch) - currentY - 1));
                } else {
                    if (binarySearch == 0) {
                        currentY += yMultiplier * command;
                        continue;
                    }
                    currentY += yMultiplier * Math.min(command, Math.abs(currentY - list.get(binarySearch - 1) - 1));
                }
            }
        }

        res = Math.max(res, currentX * currentX + currentY * currentY);
        return res;
    }

    private void createCache(int[][] obstacles, Map<Integer, ArrayList<Integer>> colBlocksMap, Map<Integer, ArrayList<Integer>> rowBlocksMap) {
        for (int[] a : obstacles) {
            ArrayList<Integer> list = colBlocksMap.getOrDefault(a[0], new ArrayList<>());
            list.add(a[1]);
            colBlocksMap.put(a[0], list);

            list = rowBlocksMap.getOrDefault(a[1], new ArrayList<>());
            list.add(a[0]);
            rowBlocksMap.put(a[1], list);
        }
    }

    private void sortCache(Map<Integer, ArrayList<Integer>> listMap) {
        for (int key : listMap.keySet()) {
            ArrayList<Integer> list = listMap.get(key);
            list.sort(Comparator.naturalOrder());
            listMap.put(key, list);
        }
    }
}