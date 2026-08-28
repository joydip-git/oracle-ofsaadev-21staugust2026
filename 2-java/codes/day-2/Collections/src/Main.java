import com.sun.jdi.IntegerValue;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        /*
        MyCollection<Integer> numbers = new MyCollection<>();
        numbers.add(12); //create unique hash value
        numbers.add(1); //crate unique has code and compare with the previous ones
        numbers.add(13);
        numbers.add(23);
        numbers.add(23);
        numbers.add(23);
        numbers.add(34);

        System.out.println("capacity: " + numbers.capacity());
        System.out.println("size: " + numbers.size());
        for (var num : numbers) {
            System.out.println(num);
        }

//        Iterator<Integer> iterator = numbers.iterator();
//        while( iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        List<Integer> values = new ArrayList<>();
        */
        Set<Integer> sets = new TreeSet<>();
        sets.add(12);
        sets.add(12);
        sets.add(1);

        for (var e : sets) {
            System.out.println(e);
        }

    }
}