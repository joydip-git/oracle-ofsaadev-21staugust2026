import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("sunil", "anil", "mahesh");

        names.stream()
                .filter((name) -> name.toLowerCase().contains("n"))
                .sorted((name1, name2) ->
                        name1.toLowerCase().compareTo(name2.toLowerCase()))
                .forEach(System.out::println);
        /*
        Stream<String> sourceStream = names.stream();
        //1. filter
        Predicate<String> isEven = (name) -> name.toLowerCase().contains("n");
        Stream<String> filteredNames = sourceStream.filter(isEven);

        //2. sort
        Comparator<String> comp = (name1, name2) ->
                name1.toLowerCase().compareTo(name2.toLowerCase());
        Stream<String> sortedNames = filteredNames.sorted(comp);

        //3. print
        Consumer<String> printRef = (name) -> System.out.println(name);
        sortedNames.forEach(printRef);
    */

//        List<String> filteredNames = new ArrayList<>();
//        for (var name : names) {
//            if (name.toLowerCase().contains("n")) {
//                filteredNames.add(name);
//            }
//        }
//
//        for (int i = 0; i < filteredNames.size(); i++) {
//            for (int j = i + 1; j < filteredNames.size(); j++) {
//                if (filteredNames.get(i).compareTo(filteredNames.get(j)) > 0) {
//                    String temp = filteredNames.get(i);
//                    filteredNames.set(i, filteredNames.get(j));
//                    filteredNames.set(j, temp);
//                }
//            }
//        }
//
//        for (var name : filteredNames) {
//            System.out.println(name);
//        }
    }
}