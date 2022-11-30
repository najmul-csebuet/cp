package codingInterview.tts;

public class A {
    public static void main(String[] args) {
        //numberOfCarryOperations(65, 55);

        //numberOfCarryOperations(145, 55);

        //numberOfCarryOperations(1, 99999);

        //numberOfCarryOperations(101, 809);

        numberOfCarryOperations(123, 456); // 0
        numberOfCarryOperations(555, 555); // 3
        numberOfCarryOperations(900, 11); // 0
        numberOfCarryOperations(145, 55); // 2
        numberOfCarryOperations(0, 0); // 0
        numberOfCarryOperations(1, 99999); // 5
        numberOfCarryOperations(999045, 1055); // 5
        numberOfCarryOperations(101, 809); // 1
        numberOfCarryOperations(189, 209); // 1
    }

    private static void numberOfCarryOperations(int a, int b) {

        int t;
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }

        String A = a + "";
        String B = b + "";

        int count = 0;

        int cc = A.length() - B.length();

        for (int i = 0; i < cc; i++) {
            B = "0" + B;
        }

        //System.out.println(A);
        //System.out.println(B);

        int carry = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            int c1 = A.charAt(i) - '0';
            int c2 = B.charAt(i) - '0';
            if (carry + c1 + c2 > 9) {
                ++count;
                carry = 1;
            }
            else carry = 0;
        }

        //if (carry > 0)++count;
        System.out.println(count);
    }
}
