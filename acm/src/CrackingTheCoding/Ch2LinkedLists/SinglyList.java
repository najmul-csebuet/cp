package CrackingTheCoding.Ch2LinkedLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SinglyList {

    Node head;
    int size = 0;

    public SinglyList() {

    }
    public SinglyList(List<Integer> list) {
        for (int a : list) {
            addToBack(a);
        }
    }

    public void addToFront(int data) {

        ++size;

        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void addToBack(int data) {

        ++size;

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(data);
    }

    public Node removeFirst(int data) {

        if (head == null)return null;

        if (head.data == data) {
            Node temp = head;
            head = head.next;
            --size;
            return temp;
        }

        Node p = head;
        while (p.next != null) {
            Node candidate = p.next;
            if (candidate.data == data) {
                p.next = candidate.next;
                --size;
                return candidate;
            }
            else {
                p = candidate;
            }
        }

        return null;
    }

    public List<Node> removeAll(int data) {

        List<Node> deletedNodes = new ArrayList<>();

        if (head == null) {
            return deletedNodes;
        }

        if (head.data == data) {
            --size;
            deletedNodes.add(head);
            head = head.next;
            return deletedNodes;
        }

        Node p = head;
        while (p.next != null) {
            Node candidate = p.next;
            if (candidate.data == data) {
                --size;
                deletedNodes.add(candidate);
                candidate = candidate.next;
            }
            p = candidate;
        }

        return deletedNodes;
    }

    public void removeDuplicates() {

        if (head == null || head.next == null)return;

        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        hashMap.put(head.data, true);

        Node p = head;
        while (p.next != null) {
            if (hashMap.getOrDefault(p.next.data, false)) {
                //delete this duplicate node
                --size;
                p.next = p.next.next;
            }
            else {
                hashMap.put(p.next.data, true);
                p = p.next;
            }
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            if (p.next != null)
                System.out.print(p.data + " --> ");
            else
                System.out.print(p.data);
            p = p.next;
        }
        System.out.println();
    }

    public Node getNthNodeFromFront(int n) {
        if (n < 1 || n > size)return null;
        Node p = head;
        while (p != null) {
            --n;
            if (n == 0) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public Node getNthNodeFromBack(int n) {
        int target = size + 1 - n;
        return getNthNodeFromFront(target);
    }

    public boolean remove(Node nthNodeFromFront) {
        if (nthNodeFromFront == null || nthNodeFromFront.next == null)return false;
        nthNodeFromFront.data = nthNodeFromFront.next.data;
        nthNodeFromFront.next = nthNodeFromFront.next.next;
        return true;
    }

    public SinglyList partitionBy(int x) {

        SinglyList listLeft = new SinglyList();
        SinglyList listRight = new SinglyList();

        Node p = head;
        while (p != null) {
            if(p.data < x) {
                listLeft.addToBack(p.data);
            }
            else {
                listRight.addToBack(p.data);
            }
            p = p.next;
        }

        listLeft.concatenate(listRight);
        return listLeft;
    }

    private void concatenate(SinglyList listRight) {
        Node p = listRight.head;
        while (p != null) {
            addToBack(p.data);
            p = p.next;
        }
    }

    public SinglyList sumListsAndGetResult(SinglyList second) {

        int carry = 0;
        SinglyList result = new SinglyList();

        Node p = head;
        Node q = second.head;

        while (p != null && q != null) {
            int r = carry + p.data + q.data;
            carry = r / 10;
            result.addToBack(r % 10);
            p = p.next;
            q = q.next;
        }

        p = p != null ? p : q;
        while (p != null) {
            int r = carry + p.data;
            carry = r / 10;
            result.addToBack(r % 10);
            p = p.next;
        }

        if (carry > 0) {
            result.addToBack(carry);
        }

        return result;
    }

    public SinglyList getReversed() {
        return getReversed(head);
    }

    public SinglyList getReversed(Node p) {
        if (p == null)
            return null;
        if (p.next == null) {
            SinglyList list = new SinglyList();
            list.addToBack(p.data);
            return list;
        }

        SinglyList reverse = getReversed(p.next);
        reverse.addToBack(p.data);
        return reverse;
    }
}

