import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        Integer[] array = new Integer[]{23, 34, 56, 21, 78, 82, 48, 100, 165, 934, 23, 78};

        Collection<Integer> collection = Arrays.asList(array);

        Stream<Integer> stream = collection.stream();

        //NOTE: Stream operations can return results - such operations are known as terminal
        //operations. Count is the simplest terminal operation.
        System.out.println("\nCount the elements in a stream: " + stream.count());

        //NOTE: Stream operations can return other streams
        Stream<Integer> distinctStream = collection.stream().distinct();
        System.out.println("\nDistinct elements in a stream: " + distinctStream.count());

        Stream<Integer> limitStream = collection.stream().limit(5);
        System.out.println("\nCount elements in a limit stream: " + limitStream.count());

        Stream<Integer> skipStream = collection.stream().skip(10);
        System.out.println("\nCount elements are skipped in a stream: " + skipStream.count());

        Stream<Integer> sortedStream = collection.stream().sorted();
        System.out.println("\nCount elements are sorted in a stream: " + Arrays.toString(sortedStream.toArray()));
    }
}