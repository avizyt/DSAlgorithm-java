package fundamentals;

public record Person(String name, int age) implements Comparable<Person> {

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }
}
