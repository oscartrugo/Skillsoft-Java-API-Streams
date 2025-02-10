import java.util.ArrayList;
import java.util.Collection;

public class TerminalOperationsUsingPredicate {
    public static void main(String[] args) {
        Collection<Person> collection = new ArrayList<>();

        collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
        collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
        collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
        collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
        collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
        collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));
        collection.add(new Person("Greg", Person.Gender.MALE, 39, "New York"));
        collection.add(new Person("Harold", Person.Gender.MALE, 25, "Seattle"));
        collection.add(new Person("Irene", Person.Gender.FEMALE, 43, "Boston"));
        collection.add(new Person("Julie", Person.Gender.FEMALE, 29, "New York"));

        double averageAgeOfMales = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();

        System.out.println("averageAgeOfMales = " + averageAgeOfMales);

        int maxFemaleAge = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .mapToInt(Person::getAge)
                .max()
                .getAsInt();

        System.out.println("maxFemaleAge = " + maxFemaleAge);

        int sumFemaleAge = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .mapToInt(Person::getAge)
                .sum();

        System.out.println("sumFemaleAge = " + sumFemaleAge);

        int minMaleAge = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .mapToInt(Person::getAge)
                .reduce(Integer.MAX_VALUE, ((left, right) -> left <= right ? left : right));

        System.out.println("minMaleAge = " + minMaleAge);

        sumFemaleAge = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .mapToInt(Person::getAge)
                .reduce(0, (left, right) -> left + right);

        System.out.println("sumFemaleAge (reduce) = " + sumFemaleAge);
    }
}