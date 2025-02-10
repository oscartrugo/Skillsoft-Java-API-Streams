import java.util.*;
import java.util.stream.Collectors;

public class UseOfCollectors {
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

        List<String> citiesList = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .map(Person::getCity)
                .toList();
        System.out.println("\nList of cities (males) = " + citiesList);

        Set<String> citiesSet = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .map(Person::getCity)
                .collect(Collectors.toSet());
        System.out.println("\nSet of cities (males) = " + citiesSet);

        Set<String> citiesTreeSet = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .map(Person::getCity)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("\nTreeSet of cities (males) = " + citiesTreeSet);

        String nameString = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\nComma-separated names (females) = " + nameString);

        double averageAge = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .collect(Collectors.averagingInt(Person::getAge));
        System.out.println("\nAverage age for females = " + averageAge);

        IntSummaryStatistics summaryStatistics = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.FEMALE)
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("\nSummary statistics for females = " + summaryStatistics);

        citiesList = collection.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .map(Person::getCity)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); //Useful for parallel streams
        System.out.println("\nList of cities (males) = " + citiesList);
    }
}
