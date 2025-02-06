import java.util.ArrayList;
import java.util.Collection;


public class PredicatesThaReturnStreams {

    public static void main(String[] args) {

        Collection<Person> collection = new ArrayList<>();

        collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
        collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
        collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
        collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
        collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
        collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));

        long numMales = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .count();
        System.out.println("\nNumber of males: " + numMales);

        long numUnder30 = collection.stream()
                .filter(p -> p.getAge() < 30)
                .count();
        System.out.println("\nNumber of under 30: " + numUnder30);

        System.out.println("\nMales: ");
        collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .forEach(System.out::println);

        System.out.println("\nFemales: ");
        collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .forEach(System.out::println);
    }
}
