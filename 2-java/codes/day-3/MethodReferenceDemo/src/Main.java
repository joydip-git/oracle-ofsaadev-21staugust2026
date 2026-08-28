import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface Logic<TInput> {
    boolean apply(TInput value);
}

class Another {
    public boolean isGreater(Integer num) {
        return num > 5;
    }
}

class LogicImpl implements Logic<Integer> {

    @Override
    public boolean apply(Integer value) {
        return value > 5;
    }
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

        //Logic<Integer> greaterLogic = new LogicImpl();
        Logic<Integer> greaterLogic = new Another()::isGreater;
        Logic<Integer> evenLogic = new Logic<Integer>() {
            @Override
            public boolean apply(Integer num) {
                return num % 2 == 0;
            }
        };

        //Logic<Integer> oddLogic = (num) -> num % 2 != 0;
        var result = filter(numbers, (num) -> num % 2 != 0);
        result.forEach(System.out::println);
//        Consumer<Integer> print = (num) -> System.out.println(num);
//        result.forEach(print);
//        for (var value : result) {
//            System.out.println(value);
//        }
    }
}