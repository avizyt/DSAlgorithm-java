package fundamentals;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        System.out.println(people);
        Collections.sort(people);
        for (Person p: people){
            System.out.println(p.name() +" : "+ p.age());
        }
    }
}
