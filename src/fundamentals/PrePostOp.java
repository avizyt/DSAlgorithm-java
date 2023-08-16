package fundamentals;

public class PrePostOp {
    public static void main(String[] args) {
        int c = 10;
        System.out.println("C before post: " + c);
        System.out.println(" postincre: " + c++);
        System.out.println("C after post: " + c);

        System.out.println("C before pre: " + c);
        System.out.println(" preincre: " + ++c);
        System.out.println("C after post: " + c);
    }
}
