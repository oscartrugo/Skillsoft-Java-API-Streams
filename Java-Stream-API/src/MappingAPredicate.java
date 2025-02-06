import java.util.ArrayList;
import java.util.Collection;

public class MappingAPredicate {
    public static void main(String[] args) {
        Collection<Person> collection = new ArrayList<>();

        collection.add(new Person("Austin", Person.Gender.MALE, 26, "Seattle"));
        collection.add(new Person("Bert", Person.Gender.MALE, 42, "New York"));
        collection.add(new Person("Carla", Person.Gender.FEMALE, 35, "San Francisco"));
        collection.add(new Person("Desmond", Person.Gender.MALE, 32, "San Jose"));
        collection.add(new Person("Emily", Person.Gender.FEMALE, 24, "Salt Lake City"));
        collection.add(new Person("Fred", Person.Gender.MALE, 45, "Boston"));

        collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .map(p -> p.getName() + ", " + p.getCity())
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Stream of Integers
        collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                //.mapToInt(Person::getAge)
                //.mapToDouble(Person::getAge)
                .mapToLong(Person::getAge)
                .forEach(System.out::println);
    }
}
