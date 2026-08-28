import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface Logic<TInput> {
    boolean apply(TInput value);
}

public class Main {
    static <E> List<E> filter(List<E> input, Logic<E> logic) {
        List<E> result = new ArrayList<>();
        for (E value : input) {
            if (logic.apply(value))
                result.add(value);
        }
        return List.copyOf(result);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 4, 2, 8, 5, 7, 0, 9, 3, 6);
        Logic<Integer> evenLogic = new Logic<Integer>() {
            @Override
            public boolean apply(Integer num) {
                return num % 2 == 0;
            }
        };

        Logic<Integer> oddLogic = (num) -> num % 2 != 0;
        var result = filter(numbers, oddLogic);
        for (var value : result) {
            System.out.println(value);
        }
    }
}