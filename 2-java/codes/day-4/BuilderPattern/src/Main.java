import java.nio.Buffer;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        HouseBuiilder houseBuiilder = new HouseBuiilder();
        House simpleHouse = houseBuiilder.Build();

        simpleHouse = houseBuiilder
                .AddGarden()
                .Build();

        simpleHouse = houseBuiilder
                .AddPool()
                .AddBalcony()
                .Build();

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        Stream<Integer> numberStream = numbers.stream();
        Stream<Integer> evenNumberStream = numberStream.filter(num -> num % 2 == 0);
        Stream<Integer> sortedEvenNumberStream = evenNumberStream.sorted((a, b) -> a - b);
        //sortedEvenNumberStream.forEach(System.out::println);
        sortedEvenNumberStream.forEach(num -> System.out.println(num));

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .sorted((a, b) -> a - b)
                .forEach(num -> System.out.println(num));

    }
}