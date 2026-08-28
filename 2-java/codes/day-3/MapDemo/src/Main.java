import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> values = List.of(1,2,3,4);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(1);
        numbers.add(13);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        for (int num : numbers) {
            System.out.println(num);
        }

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(12);
        numberSet.add(12);
        numberSet.add(1);

        for (int num : numberSet) {
            System.out.println(num);
        }

        Iterator<Integer> setIterator = numberSet.iterator();
        while (setIterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Map<Integer, String> keyValuePairs = new HashMap<>();
        //Map<Integer, String> keyValluePairs = new TreeMap<>();
        keyValluePairs.put(1, "oracle");
        keyValluePairs.put(0, "bengaluru");
        keyValluePairs.put(3, "marathalli");

        keyValluePairs.put(3, "Karnataka");
        keyValluePairs.remove(3);
        //keyValluePairs.remove(0,"joy");

        Set<Map.Entry<Integer, String>> entries = keyValluePairs.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Iterator<Map.Entry<Integer, String>> mapIterator = keyValluePairs.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<Integer, String> keyValuePair = mapIterator.next();
            System.out.println(keyValuePair.getKey() + ":" + keyValuePair.getValue());
        }
    }
}