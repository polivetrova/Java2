package lesson1;

public class Main {
    public static void main(String[] args) {
        Shape sh1 = new Circle();
        Shape sh2 = new Square();

        System.out.println(sh1.isPrintable());
        System.out.println(sh2.isPrintable());
    }
}
