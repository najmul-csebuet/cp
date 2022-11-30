package CrackingTheCoding.Ch2LinkedLists;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class LinkedList {

    Node head;

    public void appendData(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
    }
}

public class Problem_5_SumLists {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Problem_5_SumLists.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Problem_5_SumLists.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            String mode = sc.next();

            LinkedList firstList = new LinkedList();
            firstList.appendData(sc.nextInt());
            firstList.appendData(sc.nextInt());
            firstList.appendData(sc.nextInt());

            LinkedList secondList = new LinkedList();
            secondList.appendData(sc.nextInt());
            secondList.appendData(sc.nextInt());
            secondList.appendData(sc.nextInt());

            new Problem_5_SumLists().solve(mode, firstList, secondList);
        }

        if (fileInOut) {
            verify(Problem_5_SumLists.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solve(String mode, LinkedList firstList, LinkedList secondList) {

    }
}
