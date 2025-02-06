import java.util.Arrays;
import java.util.Collection;

public class StreamPredicates {
    public static void main(String[] args) {

        Integer[] array = new Integer[]{23, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78};

        Collection<Integer> collection = Arrays.asList(array);
        boolean greaterThan50 = collection.stream()
                .allMatch(n -> n > 50);
        System.out.println("Are all numbers > 50: " + greaterThan50);

        boolean greaterThan0 = collection.stream()
                .allMatch(n -> n > 0);
        System.out.println("Are all numbers > 0: " + greaterThan0);

        boolean anyLessThan0 = collection.stream()
                .anyMatch(number -> number < 0);
        System.out.println("Is any number < 0: " + anyLessThan0);

        boolean anyGreaterThan100 = collection.stream()
                .anyMatch(number -> number > 100);
        System.out.println("Is any number > 100: " + anyGreaterThan100);

        boolean noneLessThan0 = collection.stream()
                .noneMatch(number -> number < 0);
        System.out.println("Are no numbers < 0: " + noneLessThan0);
    }
}


/*
*
* Predicate: Boolean-value function applied to every element of the stream, either return true or false
*
* */