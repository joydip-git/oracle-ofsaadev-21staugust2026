public class Calculation {
    public static <TInput extends Number> void add(TInput a, TInput b) {
        System.out.println("called");
    }

    public static <TInput1, TInput2> void add(TInput1 a, TInput2 b) {
        System.out.println("called");
    }
}
