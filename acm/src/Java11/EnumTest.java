package Java11;

enum Size {

    A, M, C;
    int a;

    Size() {

    }

    Size(int a) {
        this.a = a;
    }

    boolean isTrue() {
        return true;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        var s = Size.A;
        System.out.println(s);
        System.out.println(s.isTrue());
    }
}
